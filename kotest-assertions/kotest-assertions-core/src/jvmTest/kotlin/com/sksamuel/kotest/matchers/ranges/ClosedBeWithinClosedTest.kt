package com.sksamuel.kotest.matchers.ranges

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.ranges.Range
import io.kotest.matchers.ranges.shouldIntersect
import io.kotest.matchers.ranges.shouldNotIntersect
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.forAll

class ClosedBeWithinClosedTest: WordSpec() {
   private val oneThree: ClosedRange<Int> = (1..3)
   private val twoFour: ClosedRange<Int> = (2..4)
   private val threeFour: ClosedRange<Int> = (3..4)
   private val threeFive: ClosedRange<Int> = (3..5)
   private val fourSix: ClosedRange<Int> = (4..6)
   init {
      "should" should {
         "work" {
            forAll(
               Arb.int(1..5), Arb.int(1..5), Arb.int(1..5), Arb.int(1..5)
            ) { rangeStart, rangeLength, otherStart, otherLength ->
               Range.closedClosed(rangeStart, rangeStart + rangeLength).contains(Range.openClosed(1, 2))
            }
         }
      }
   }
}
