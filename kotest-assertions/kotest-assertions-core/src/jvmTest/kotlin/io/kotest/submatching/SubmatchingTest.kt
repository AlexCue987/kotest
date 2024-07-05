package io.kotest.submatching

import io.kotest.assertions.withClue
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.shouldBe

class SubmatchingTest: WordSpec() {
   init {
      "findPartialMatches" should {
         "find nothing" {
            findPartialMatches("apple", "orange", minLength = 3).shouldBeEmpty()
         }
         "match end of one string to beginning of another" {
            findPartialMatches("broom", "roommate", minLength = 4) shouldBe listOf(
               PartialMatch(MatchedCharacter(1, 0), 4, "room"))
         }
         "match two middles" {
            findPartialMatches("room", "boot", minLength = 2) shouldBe listOf(
               PartialMatch(MatchedCharacter(1, 1), 2, "oo"))
         }
         "find common end" {
            findPartialMatches("river", "driver", minLength = 5) shouldBe listOf(
               PartialMatch(MatchedCharacter(0, 1), 5, "river"))
         }
         "find two common substrings in same order" {
            findPartialMatches("roommate", "room-mate", minLength = 4) shouldBe listOf(
               PartialMatch(MatchedCharacter(0, 0), 4, "room"),
               PartialMatch(MatchedCharacter(4, 5), 4, "mate"),
            )
         }
         "find two common substrings in opposite order" {
            findPartialMatches("downsize", "size down", minLength = 4) shouldBe listOf(
               PartialMatch(MatchedCharacter(0, 5), 4, "down"),
               PartialMatch(MatchedCharacter(4, 0), 4, "size"),
            )
         }
      }
      "toCharIndex" should {
         "count" {
            toCharIndex("apple") shouldBe mapOf(
               'a' to listOf(0),
               'p' to listOf(1, 2),
               'l' to listOf(3),
               'e' to listOf(4)
            )
         }
      }
      "lengthOfMatch" should {
         "return 0 at mismatch" {
            (0..3).forEach { start ->
               withClue("Matching target at index $start") {
                  lengthOfMatch(
                     value = "bug",
                     target = "feature",
                     matchedCharacter = MatchedCharacter(0, start)
                  ) shouldBe 0
               }
            }
         }
         "mismatch on first char" {
            lengthOfMatch(
               value = "prone",
               target = "drone",
               matchedCharacter = MatchedCharacter(0, 0)
            ) shouldBe 0
         }
         "skip some chars at start" {
            lengthOfMatch(
               value = "prone",
               target = "drone",
               matchedCharacter = MatchedCharacter(1, 1)
            ) shouldBe 4
         }
         "find common start" {
            lengthOfMatch(
               value = "car",
               target = "cartoon",
               matchedCharacter = MatchedCharacter(0, 0)
            ) shouldBe 3
         }
         "stop at shorter substring in the middle of a loger one" {
            lengthOfMatch(
               value = "rip",
               target = "tripod",
               matchedCharacter = MatchedCharacter(0, 1)
            ) shouldBe 3
         }
         "find common end" {
            lengthOfMatch(
               value = "come",
               target = "outcome",
               matchedCharacter = MatchedCharacter(0, 3)
            ) shouldBe 4
         }
      }
   }
}
