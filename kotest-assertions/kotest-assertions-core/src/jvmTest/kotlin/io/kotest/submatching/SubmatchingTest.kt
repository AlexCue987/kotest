package io.kotest.submatching

import io.kotest.assertions.withClue
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.shouldBe
import kotlin.time.Duration.Companion.seconds

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
            findPartialMatches("river", "driver", minLength = 3) shouldBe listOf(
               PartialMatch(MatchedCharacter(0, 1), 5, "river"))
         }
         "find two common substrings in same order" {
            findPartialMatches("roommate", "room-mate", minLength = 3) shouldBe listOf(
               PartialMatch(MatchedCharacter(0, 0), 4, "room"),
               PartialMatch(MatchedCharacter(4, 5), 4, "mate"),
            )
         }
         "find two common substrings in opposite order" {
            findPartialMatches("downsize", "size down", minLength = 3) shouldBe listOf(
               PartialMatch(MatchedCharacter(0, 5), 4, "down"),
               PartialMatch(MatchedCharacter(4, 0), 4, "size"),
            )
         }
         "maintain performance".config(timeout = 1.seconds) {
            val target = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
            val value = target.substring(5, target.length - 10)
            val partialMatches = findPartialMatches(value, target, target.length / 2)
            partialMatches.size shouldBe 1
            partialMatches[0].length shouldBe target.length - 15
         }
      }
      "removeShorterMatchesWithSameEnd" should {
          "leave matches as is when there is nothing to remove" {
              val matches = listOf(
                 PartialMatch(MatchedCharacter(0, 5), 4, "down"),
                 PartialMatch(MatchedCharacter(4, 0), 4, "size"),
              )
             removeShorterMatchesWithSameEnd(matches) shouldBe matches
          }
         "remove shorter matches that are inside longer ones" {
            val matches = listOf(
               PartialMatch(MatchedCharacter(0, 5), 4, "down"),
               PartialMatch(MatchedCharacter(4, 0), 4, "size"),
               PartialMatch(MatchedCharacter(1, 6), 3, "own"),
               PartialMatch(MatchedCharacter(5, 1), 3, "ize"),
            )
            removeShorterMatchesWithSameEnd(matches) shouldBe matches.filter { it.length == 4}
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
