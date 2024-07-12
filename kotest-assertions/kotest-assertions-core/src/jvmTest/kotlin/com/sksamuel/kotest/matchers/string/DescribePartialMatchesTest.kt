package com.sksamuel.kotest.matchers.string

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.describeMatchedSubstrings
import io.kotest.submatching.MatchedCollectionElement
import io.kotest.submatching.PartialCollectionMatch

class DescribePartialMatchesTest: WordSpec() {
   init {
       "describeMatchedSubstrings" should {
          "handle empty list of matches" {
             describeMatchedSubstrings("apple", listOf()) shouldBe ""
          }
          "work with several matches" {
             describeMatchedSubstrings("workload", listOf(
                PartialCollectionMatch(
                   MatchedCollectionElement(indexInValue = 0, indexInTarget = 5),
                   length = 4,
                   value = "workload".toList()
                ),
                PartialCollectionMatch(
                   MatchedCollectionElement(indexInValue = 4, indexInTarget = 0),
                   length = 4,
                   value = "workload".toList()
                )
             )) shouldBe "Substring <\"work\"> at indexes [0..3] matches at indexes [5..8]\nSubstring <\"load\"> at indexes [4..7] matches at indexes [0..3]"
          }
       }
   }
}
