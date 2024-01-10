package com.sksamuel.kotest.matchers.ranges

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.ranges.shouldBeWithin
import io.kotest.matchers.ranges.shouldNotBeWithin
import io.kotest.matchers.shouldBe

@OptIn(ExperimentalStdlibApi::class)
class ShouldBeWithinTest : WordSpec() {
   private val smallClosedRange: ClosedRange<Int> = 1..3
   private val smallOpenEndRange: OpenEndRange<Int> = 1 until 3
   private val bigClosedRange: ClosedRange<Int> = 0..4
   private val bigOpenEndRange: OpenEndRange<Int> = 0 until 4

   init {
      "shouldBeWithin" should {
         "fail" {
               shouldThrowAny {
                  bigClosedRange shouldBeWithin smallClosedRange
               }.message shouldBe "Range [0, 4] should be within [1, 3], but it isn't"
               shouldThrowAny {
                  bigClosedRange shouldBeWithin smallOpenEndRange
               }.message shouldBe "Range [0, 4] should be within [1, 3), but it isn't"
               shouldThrowAny {
                  bigOpenEndRange shouldBeWithin smallClosedRange
               }.message shouldBe "Range [0, 4) should be within [1, 3], but it isn't"
               shouldThrowAny {
                  bigOpenEndRange shouldBeWithin smallOpenEndRange
               }.message shouldBe "Range [0, 4) should be within [1, 3), but it isn't"
         }

         "succeed" {
            assertSoftly {
               smallClosedRange shouldBeWithin bigClosedRange
               smallClosedRange shouldBeWithin bigOpenEndRange
               smallOpenEndRange shouldBeWithin bigClosedRange
               smallOpenEndRange shouldBeWithin bigOpenEndRange
            }
         }

         "handle edge case of OpenEndRange inside ClosedRange for discrete numeric" {
            val closedRangeInt: ClosedRange<Int> = 1..2
            val openEndRangeInt: OpenEndRange<Int> = 1 until 3
            openEndRangeInt shouldBeWithin closedRangeInt
         }
       }

      "shouldNotBeWithin" should {
         "fail" {
            shouldThrowAny {
               smallClosedRange shouldNotBeWithin bigClosedRange
            }.message shouldBe "Range [1, 3] should not be within [0, 4], but it is"
            shouldThrowAny {
               smallClosedRange shouldNotBeWithin bigOpenEndRange
            }.message shouldBe "Range [1, 3] should not be within [0, 4), but it is"
            shouldThrowAny {
               smallOpenEndRange shouldNotBeWithin bigClosedRange
            }.message shouldBe "Range [1, 3) should not be within [0, 4], but it is"
            shouldThrowAny {
               smallOpenEndRange shouldNotBeWithin bigOpenEndRange
            }.message shouldBe "Range [1, 3) should not be within [0, 4), but it is"
         }

         "succeed" {
            assertSoftly {
               bigClosedRange shouldNotBeWithin smallClosedRange
               bigClosedRange shouldNotBeWithin smallOpenEndRange
               bigOpenEndRange shouldNotBeWithin smallClosedRange
               bigOpenEndRange shouldNotBeWithin smallOpenEndRange
            }
         }
      }
   }
}
