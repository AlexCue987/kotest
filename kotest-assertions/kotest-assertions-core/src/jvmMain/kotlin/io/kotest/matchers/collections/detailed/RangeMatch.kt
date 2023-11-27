package io.kotest.matchers.collections.detailed

data class RangeMatch(val match: Boolean, val leftRange: ClosedRange<Int>, val rightRange: ClosedRange<Int>){
    init{
        require(!match || (leftRange.length() == rightRange.length())){
            "For a match, both ranges must have same length: $this"
        }
        require(leftRange.length() >= 0){
            "Invalid left range: $this"
        }
        require(rightRange.length() >= 0){
            "Invalid right range: $this"
        }
    }

    fun spawnNewRange(itemsMatch: ItemsMatch) =
            RangeMatch(itemsMatch.match,
                    leftRange.spawnRangeOnLeft(!itemsMatch.leftItemPresent()),
                    rightRange.spawnRangeOnLeft(!itemsMatch.rightItemPresent())
            )

    fun extendLeftRangeBack() = RangeMatch(match, extendIndexRangeBack(leftRange), rightRange)

    fun extendRightRangeBack() = RangeMatch(match, leftRange, extendIndexRangeBack(rightRange))

    fun extendBothRangesBack() = RangeMatch(match, extendIndexRangeBack(leftRange), extendIndexRangeBack(rightRange))

    private fun extendIndexRangeBack(range: ClosedRange<Int>) = range.start - 1 .. range.endInclusive

    val leftIndexes: List<Int>
        get() = leftRange.toSequence().toList()

    val rightIndexes: List<Int>
        get() = rightRange.toSequence().toList()
}

fun ClosedRange<Int>.toSequence(): Sequence<Int> {
    var next = this.start
    val end = this.endInclusive
    return sequence {
        while (next <= end) {
            yield(next++)
        }
    }
}

enum class MatchResultType(val leftItemPresent: Boolean, val rightItemPresent: Boolean){
    LEFT_ELEMENT_ONLY(true, false),
    RIGHT_ELEMENT_ONLY(false, true),
    BOTH_ELEMENTS_PRESENT(true, true)
}

data class ItemsMatch(val match: Boolean, val matchType: MatchResultType) {
    init {
        require (!match || (matchType == MatchResultType.BOTH_ELEMENTS_PRESENT)) {
            "Both sides must be present for a match: $this"
        }
    }

    fun leftItemPresent() = matchType.leftItemPresent

    fun rightItemPresent() = matchType.rightItemPresent
}

val MATCH = ItemsMatch(true, MatchResultType.BOTH_ELEMENTS_PRESENT)
val MISMATCH = ItemsMatch(false, MatchResultType.BOTH_ELEMENTS_PRESENT)
val LEFT_ITEM_ONLY = ItemsMatch(false, MatchResultType.LEFT_ELEMENT_ONLY)
val RIGHT_ITEM_ONLY = ItemsMatch(false, MatchResultType.RIGHT_ELEMENT_ONLY)

internal fun ClosedRange<Int>.isNotEmpty() = this.start <= this.endInclusive

internal fun ClosedRange<Int>.extendLeft(): ClosedRange<Int> = this.start-1 .. this.endInclusive

internal fun ClosedRange<Int>.spawnRangeOnLeft(empty: Boolean): ClosedRange<Int> =
   (if(empty) this.start until this.start else this.start-1 until this.start)

internal fun ClosedRange<Int>.length() = this.endInclusive - this.start + 1
