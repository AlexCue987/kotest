package com.sksamuel.kotest.matchers.ranges

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.assertions.withClue
import io.kotest.core.spec.style.WordSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.ranges.Range
import io.kotest.matchers.ranges.RangeEdge
import io.kotest.matchers.ranges.RangeEdgeType
import io.kotest.matchers.shouldBe

class RangeTest: WordSpec() {
   private val openOpenRange = Range.openOpen(1, 2)
   private val openClosedRange = Range.openClosed(2, 3)
   private val closedOpenRange = Range.closedOpen(3, 4)
   private val closedClosedRange = Range.closedClosed(4, 5)

   init {
       "create" should {
          "openOpen" {
             openOpenRange.toString() shouldBe "(1, 2)"
          }

          "openClosed" {
             openClosedRange.toString() shouldBe "(2, 3]"
          }

          "closedOpen" {
             closedOpenRange.toString() shouldBe "[3, 4)"
          }

          "closedClosed" {
             closedClosedRange.toString() shouldBe "[4, 5]"
          }

          "cannot create if end less than start" {
             shouldThrowAny {
                Range.closedClosed(4, 3)
             }.message shouldBe "4 cannot be after 3"
          }
       }

      "isEmpty" should {
         "false if start less than end" {
            openOpenRange.isEmpty().shouldBeFalse()
         }

         "true if start equals end and closed-closed" {
            Range.closedClosed(1, 1).isEmpty().shouldBeFalse()
         }

         "false if start equals end and not closed-closed" {
            Range.openClosed(1, 1).isEmpty().shouldBeTrue()
            Range.closedOpen(1, 1).isEmpty().shouldBeTrue()
            Range.openOpen(1, 1).isEmpty().shouldBeTrue()
         }
      }

      "lessThan" should {
            "true if gap" {
               openOpenRange.lessThan(closedOpenRange).shouldBeTrue()
               closedOpenRange.greaterThan(openOpenRange).shouldBeTrue()
            }

            "true if common edge but not both are inclusive" {
               forAll(
                  row(Range.openOpen(1, 2), Range.openOpen(2, 3), "both ends exclusive"),
                  row(Range.openClosed(1, 2), Range.openOpen(2, 3), "left inclusive, right exclusive"),
                  row(Range.openOpen(1, 2), Range.closedOpen(2, 3), "left exclusive, right inclusive"),
               ) { left, right, description ->
                  withClue(description) {
                     assertSoftly {
                        left.lessThan(right).shouldBeTrue()
                        right.greaterThan(left).shouldBeTrue()
                     }
                  }
               }
            }

         "false if common edge and both ends are inclusive" {
            Range.openClosed(1, 2).lessThan(Range.closedOpen(2, 3)).shouldBeFalse()
         }
      }

      "contains" should {
         "false if edge before start" {
            openOpenRange.contains(openOpenRange.start.copy(value = openOpenRange.start.value - 1)).shouldBeFalse()
         }

         "edge with same value as start" {
            val rangeStart = 1
            forAll(
               row(RangeEdgeType.INCLUSIVE, RangeEdgeType.INCLUSIVE, true),
               row(RangeEdgeType.EXCLUSIVE, RangeEdgeType.INCLUSIVE, false),
               row(RangeEdgeType.INCLUSIVE, RangeEdgeType.EXCLUSIVE, true),
               row(RangeEdgeType.EXCLUSIVE, RangeEdgeType.EXCLUSIVE, true),
            ) { rangeStartType, edgeType, expected ->
               Range<Int>(
                  start = RangeEdge(rangeStart, rangeStartType),
                  end = RangeEdge(rangeStart + 1, RangeEdgeType.INCLUSIVE)
               ).contains(RangeEdge(rangeStart, edgeType)) shouldBe expected
            }
         }

         "edge inside range" {
            RangeEdgeType.values().forEach { rangeEdgeType ->
               Range.openOpen(1, 3).contains(RangeEdge(2, rangeEdgeType)) shouldBe true
            }
         }

         "edge with same value as end" {
            val rangeEnd = 1
            forAll(
               row(RangeEdgeType.INCLUSIVE, RangeEdgeType.INCLUSIVE, true),
               row(RangeEdgeType.EXCLUSIVE, RangeEdgeType.INCLUSIVE, false),
               row(RangeEdgeType.INCLUSIVE, RangeEdgeType.EXCLUSIVE, true),
               row(RangeEdgeType.EXCLUSIVE, RangeEdgeType.EXCLUSIVE, true),
            ) { rangeEndType, edgeType, expected ->
               Range<Int>(
                  start = RangeEdge(rangeEnd - 1, RangeEdgeType.INCLUSIVE),
                  end = RangeEdge(rangeEnd, rangeEndType)
               ).contains(RangeEdge(rangeEnd, edgeType)) shouldBe expected
            }
         }

         "false if edge after end" {
            openOpenRange.contains(openOpenRange.end.copy(value = openOpenRange.end.value + 1)).shouldBeFalse()
         }
      }
   }
}
