package com.sksamuel.kotest.matchers.ranges

import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.ranges.Range
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
   }
}
