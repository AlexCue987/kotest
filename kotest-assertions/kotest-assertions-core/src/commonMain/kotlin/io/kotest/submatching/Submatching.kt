package io.kotest.submatching


internal fun toCharIndex(value: String): Map<Char, List<Int>> {
   return value.mapIndexed { index, char ->
      index to char
   }.groupBy(keySelector = { it.second }, valueTransform = { it.first })
}

internal fun findPartialMatches(value: String, target: String, minLength: Int): List<PartialMatch> {
    val indexes = toCharIndex(target)
    val matches = value.asSequence().mapIndexed { index, char ->
        index to char
    }.filter { pair -> pair.first + minLength <= value.length }
       .flatMap { pair -> indexes[pair.second]?.map { index -> MatchedCharacter(
            indexInValue = pair.first,
            indexInTarget = index
        )
       } ?: listOf()
       }.mapNotNull { matchedCharacter ->
          val lengthOfMatch = lengthOfMatch(value, target, matchedCharacter)
          if(lengthOfMatch >= minLength) {
             PartialMatch(
                matchedCharacter,
                lengthOfMatch,
                value.substring(matchedCharacter.indexInValue, matchedCharacter.indexInValue + lengthOfMatch)
             )
          } else null
       }.toList()
   return removeShorterMatchesWithSameEnd(matches)
}

internal fun removeShorterMatchesWithSameEnd(
   matches: List<PartialMatch>
): List<PartialMatch> {
   val matchesGroupedByEnd = matches.groupBy {
      it.endOfMatchAtTarget
   }
   return matchesGroupedByEnd.values.map { matchesWithSameEnd ->
      matchesWithSameEnd.maxBy { it.length }
   }
}

internal fun lengthOfMatch(
   value: String, target: String, matchedCharacter: MatchedCharacter
): Int {
   val maxLengthOfMatch = minOf(value.length - matchedCharacter.indexInValue, target.length - matchedCharacter.indexInTarget)
   return (1..maxLengthOfMatch).takeWhile { offset ->
      value[matchedCharacter.indexInValue + offset - 1] == target[matchedCharacter.indexInTarget + offset - 1]
   }.lastOrNull() ?: 0
}

internal data class MatchedCharacter(
   val indexInValue: Int,
   val indexInTarget: Int
)

internal data class PartialMatch(
   val matchedCharacter: MatchedCharacter,
   val length: Int,
   val partOfValue: String
) {
   val endOfMatchAtTarget: Int
      get() = matchedCharacter.indexInTarget + length - 1
}
