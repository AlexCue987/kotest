package io.kotest.matchers.string


internal fun conflateSubMatchWithMapping(submatchWithMargin: String, rangeWithMarginMapping: String): String {
   require(submatchWithMargin.length == rangeWithMarginMapping.length) {
      "Both arguments should have same length, were respectively: ${submatchWithMargin.length} and ${rangeWithMarginMapping.length}"
   }
   val submatchLines = submatchWithMargin.split("\n")
   return submatchLines.flatMapIndexed { index, line ->
      val offsetForMapping: Int = submatchLines.filterIndexed { lineIndex, _ -> lineIndex < index }.sumOf { it.length }
      listOf(rangeWithMarginMapping.substring(offsetForMapping, offsetForMapping + line.length), line)
   }.joinToString("\n")
}

internal fun rangeWithMarginMapping(range: IntRange, rangeWithMargin: IntRange): String =
   rangeWithMargin.joinToString("") { index ->
      when {
         index < range.first -> ">"
         index in range -> "+"
         else -> "<"
      }
   }

internal fun rangeWithMargin(range: IntRange, margin: Int, maxIndex: Int): IntRange =
   maxOf(0, range.first - margin)..minOf(range.last + margin, maxIndex)
