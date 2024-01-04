package com.sksamuel.kotest.matchers.ranges

import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.WordSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.ranges.shouldBeIn
import io.kotest.matchers.ranges.shouldBeWithin
import io.kotest.matchers.ranges.shouldNotBeIn
import io.kotest.matchers.shouldBe

class ShouldBeWithinTest : WordSpec() {
   private val smallClosedRange = 1..3
   private val smallOpenEndRange = 1 until 3
   private val bigClosedRange = 0..4
   private val bigOpenEndRange = 0 until 4

   init {
      "shouldBeWithin" should {
         "fail" {
            forAll(
               row(bigClosedRange, smallClosedRange, "Range [0, 4] should be within [1, 3], but is isn't")
            ) {
               expectedInner, expectedOuter, message ->
               shouldThrowAny {
                  expectedInner shouldBeWithin expectedOuter
               }.message shouldBe message
            }
         }

         "succeed" {
            forAll(
               row(smallClosedRange, bigClosedRange)
            ) {
                  expectedInner, expectedOuter ->
               expectedInner shouldBeWithin expectedOuter
            }
         }
       }

      "shouldNotBeWithin" should {
         "succeed before left end of closed range" {
            0 shouldNotBeIn smallClosedRange
         }

         "succeed before left end of open end range" {
            0 shouldNotBeIn smallOpenEndRange
         }

         "fail on left end of closed range" {
            shouldThrowAny {
               1 shouldNotBeIn smallClosedRange
            }.message shouldBe "Range should not contain 1, but does. Forbidden values: 1..3"
         }

         "fail on left end of open end range" {
            shouldThrowAny {
               1 shouldNotBeIn smallOpenEndRange
            }.message shouldBe "Range should not contain 1, but does. Forbidden values: 1..2"
         }

         "fail inside closed range" {
            shouldThrowAny {
               2 shouldNotBeIn smallClosedRange
            }.message shouldBe "Range should not contain 2, but does. Forbidden values: 1..3"
         }

         "fail inside open end range" {
            shouldThrowAny {
               2 shouldNotBeIn smallOpenEndRange
            }.message shouldBe "Range should not contain 2, but does. Forbidden values: 1..2"
         }

         "fail on right end of closed range" {
            shouldThrowAny {
               3 shouldNotBeIn smallClosedRange
            }.message shouldBe "Range should not contain 3, but does. Forbidden values: 1..3"
         }

         "succeed on right end of open end range" {
            3 shouldNotBeIn smallOpenEndRange
         }

         "succeed after right end of closed range" {
            3 shouldNotBeIn smallOpenEndRange
         }

         "succeed after right end of open end range" {
            3 shouldNotBeIn smallOpenEndRange
         }
      }
   }
}
