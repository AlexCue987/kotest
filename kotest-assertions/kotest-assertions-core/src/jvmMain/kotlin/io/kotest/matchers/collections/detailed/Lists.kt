package io.kotest.matchers.collections.detailed

import io.kotest.matchers.collections.detailed.distance.possibleMatchDescription


fun<T> matchLists(expected: List<T>,
                     actual: List<T>,
                     matcher: (left: T, right: T) -> Boolean = {left, right -> left == right}
) {
    val assertionResult = compareLists(expected, actual, matcher)
    assertionResult.assertSuccess()
}

fun <T> compareLists(expected: List<T>, actual: List<T>,
                     matcher: (left: T, right: T) -> Boolean = {left, right -> left == right}
): AssertionResult {
    val listMatcher = ListMatcher()
    val results = listMatcher.match(expected, actual, matcher)
    return if (results.size == 1 && results[0].match) {
        AssertionResult(true)
    } else {
        val mismatchDescription = printMatches(expected, actual, results)
        val possibleMatches = findClosestMatchesForLists(expected, actual, results)
        val possibleMatchDescription = if(possibleMatches.isEmpty()) ""
        else "\nPossible matches:\n${possibleMatches.joinToString("\n\n") { possibleMatchDescription(it) }}"
        AssertionResult(false, "$mismatchDescription$possibleMatchDescription")
    }
}


data class TailOfList<T>(val items: List<T>, val offset: Int = 0){
   init {
      require(0 <= offset && offset <= items.size) {
         "Offset should be between 0 and ${items.size}, was $offset"
      }
   }

    fun tail(): TailOfList<T> {
        return if(offset < items.size) TailOfList(items, offset+1)
        else this
    }

    fun isOver() = (offset == items.size)

    fun onLastItem() = (offset == (items.size-1))

    fun rangeOfIndexes() = offset until items.size

    fun currentElement(): T = if(isOver()) throw IllegalStateException("IsOver, no current item") else items[offset]
}

enum class BranchDirection{ALL, LEFT, MIDDLE, RIGHT}

class ListMatcher {
    fun <T> match(expected: List<T>,
                     actual: List<T>,
                     matcher: (left: T, right: T) -> Boolean = {left, right -> left == right}): List<RangeMatch> {
        val matches = matches(TailOfList(expected), TailOfList(actual), matcher= matcher)
        return bestMatch(matches)
    }

    fun <T> matches(expected: TailOfList<T>,
                    actual: TailOfList<T>,
                    branchDirection: BranchDirection = BranchDirection.ALL,
                    matcher: (left: T, right: T) -> Boolean):
            List<List<RangeMatch>> {
        return when {
            (expected.onLastItem() && actual.onLastItem()) ->
                getNewTailOffLastItems(expected, actual, matcher = matcher)

            (expected.isOver() || actual.isOver()) ->
                getMismatchedTails(expected, actual)

            matcher(expected.currentElement(), actual.currentElement()) ->
                matchCurrentItemsAndCompareTails(MATCH, expected, actual, matcher = matcher)

            else -> branchOnMismatch(expected, actual, branchDirection, matcher = matcher)
        }
    }

    private val branchLeftOn = listOf(BranchDirection.ALL, BranchDirection.LEFT)

    private val branchRightOn = listOf(BranchDirection.ALL, BranchDirection.RIGHT)

    private fun <T> branchOnMismatch(expected: TailOfList<T>, actual: TailOfList<T>,
                                     branchDirection: BranchDirection,
                                     matcher: (left: T, right: T) -> Boolean): List<List<RangeMatch>> {
        val allTails: MutableList<List<RangeMatch>> = mutableListOf()
        if(branchDirection in branchLeftOn) {
            allTails.addAll(nextOnLeftAndCompareTails(expected, actual, matcher = matcher))
        }
        allTails.addAll(matchCurrentItemsAndCompareTails(MISMATCH, expected, actual, matcher = matcher))
        if(branchDirection in branchRightOn) {
            allTails.addAll(nextOnRightAndCompareTails(expected, actual, matcher = matcher))
        }
        return bestTwoMatches(allTails)
    }

    private fun <T> matchCurrentItemsAndCompareTails(itemsMatch: ItemsMatch,
                                                     expected: TailOfList<T>,
                                                     actual: TailOfList<T>,
                                                     matcher: (left: T, right: T) -> Boolean): List<List<RangeMatch>> {
        val branchType = if(itemsMatch.match) BranchDirection.ALL else BranchDirection.MIDDLE
        val matchesForTail = matches(expected.tail(), actual.tail(), branchType, matcher = matcher)
        return addItemsMatchToMatchesForTail(itemsMatch, matchesForTail)
    }

    private fun <T> nextOnLeftAndCompareTails(expected: TailOfList<T>,
                                              actual: TailOfList<T>,
                                              matcher: (left: T, right: T) -> Boolean): List<List<RangeMatch>> {
        val matchesForTail = matches(expected.tail(), actual, BranchDirection.LEFT, matcher = matcher)
        return addItemsMatchToMatchesForTail(LEFT_ITEM_ONLY, matchesForTail)
    }

    private fun <T> nextOnRightAndCompareTails(expected: TailOfList<T>,
                                               actual: TailOfList<T>,
                                               matcher: (left: T, right: T) -> Boolean): List<List<RangeMatch>> {
        val matchesForTail = matches(expected, actual.tail(), BranchDirection.RIGHT, matcher = matcher)
        return addItemsMatchToMatchesForTail(RIGHT_ITEM_ONLY, matchesForTail)
    }

    private fun <T> getMismatchedTails(expected: TailOfList<T>, actual: TailOfList<T>) =
            listOf(mutableListOf(RangeMatch(false, expected.rangeOfIndexes(), actual.rangeOfIndexes())))

    private fun <T> getNewTailOffLastItems(expected: TailOfList<T>, actual: TailOfList<T>,
                                           matcher: (left: T, right: T) -> Boolean): List<List<RangeMatch>> {
        val matched = matcher(expected.currentElement(), actual.currentElement())
        return listOf(mutableListOf(RangeMatch(matched, expected.rangeOfIndexes(), actual.rangeOfIndexes())))
    }

    fun addItemsMatchToMatchesForTail(itemsMatch: ItemsMatch, matchesForTail: List<List<RangeMatch>>):
            List<List<RangeMatch>> = matchesForTail.map { addItemsMatchToOneTail(itemsMatch, it) }

    fun addItemsMatchToOneTail(itemsMatch: ItemsMatch, matchesForTail: List<RangeMatch>):
            List<RangeMatch>{
        require(matchesForTail.isNotEmpty()) { "matchesForTail cannot be empty" }
        return when{
            matchesForTail[0].match == itemsMatch.match -> {
                val extendedFirstRange = when(itemsMatch.matchType){
                    MatchType.LEFT -> matchesForTail[0].extendLeftRangeBack()
                    MatchType.RIGHT -> matchesForTail[0].extendRightRangeBack()
                    MatchType.BOTH -> matchesForTail[0].extendBothRangesBack()
                }
                listOf(extendedFirstRange, *matchesForTail.drop(1).toTypedArray())
            }
            else -> {
                val newRangeMatch = matchesForTail[0].spawnNewRange(itemsMatch)
                listOf(newRangeMatch, *matchesForTail.toTypedArray())
            }
        }
    }
}

data class AssertionResult(val success: Boolean, val message: String = ""){
   fun assertSuccess(){
      if (!success) {
         throw AssertionError(message)
      }
   }
}
