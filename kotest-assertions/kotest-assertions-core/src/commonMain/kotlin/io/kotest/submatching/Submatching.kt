package io.kotest.submatching


internal fun<T> toCharIndex(value: Collection<T>): Map<T, List<Int>> {
   return value.mapIndexed { index, element ->
      index to element
   }.groupBy(keySelector = { it.second }, valueTransform = { it.first })
}

internal fun findPartialMatches(value: String, target: String, minLength: Int) =
   findPartialMatches(value.toList(), target.toList(), minLength)

internal fun<T> findPartialMatches(value: List<T>, target: List<T>, minLength: Int): List<PartialMatch<T>> {
    val indexes = toCharIndex(target)
    val matches = value.asSequence().mapIndexed { index, char ->
        index to char
    }.filter { pair -> pair.first + minLength <= value.size }
       .flatMap { pair -> indexes[pair.second]?.map { index -> MatchedElement(
            indexInValue = pair.first,
            indexInTarget = index
        )
       } ?: listOf()
       }.mapNotNull { matchedCharacter ->
          extendPartialMatchToRequiredLength(value, target, matchedCharacter, minLength)
       }.toList()
   return removeShorterMatchesWithSameEnd(matches)
}

internal fun <T> extendPartialMatchToRequiredLength(
   value: List<T>,
   target: List<T>,
   matchedElement: MatchedElement,
   minLength: Int
): PartialMatch<T>? {
   val lengthOfMatch = lengthOfMatch(value, target, matchedElement)
   return if (lengthOfMatch >= minLength) {
      PartialMatch(
         matchedElement,
         lengthOfMatch,
         value
      )
   } else null
}

internal fun<T> removeShorterMatchesWithSameEnd(
   matches: List<PartialMatch<T>>
): List<PartialMatch<T>> {
   val matchesGroupedByEnd = matches.groupBy {
      it.endOfMatchAtTarget
   }
   return matchesGroupedByEnd.values.map { matchesWithSameEnd ->
      matchesWithSameEnd.maxBy { it.length }
   }
}

internal fun<T> lengthOfMatch(
   value: List<T>, target: List<T>, matchedElement: MatchedElement
): Int {
   val maxLengthOfMatch = minOf(value.size - matchedElement.indexInValue, target.size - matchedElement.indexInTarget)
   return (1..maxLengthOfMatch).takeWhile { offset ->
      value[matchedElement.indexInValue + offset - 1] == target[matchedElement.indexInTarget + offset - 1]
   }.lastOrNull() ?: 0
}

internal data class MatchedElement(
   val indexInValue: Int,
   val indexInTarget: Int
)

internal data class PartialMatch<T>(
   val matchedElement: MatchedElement,
   val length: Int,
   val value: List<T>
) {
   val endOfMatchAtTarget: Int
      get() = matchedElement.indexInTarget + length - 1
   val partOfValue: List<T>
       get() = value.subList(matchedElement.indexInValue, matchedElement.indexInValue + length - 1)
}
