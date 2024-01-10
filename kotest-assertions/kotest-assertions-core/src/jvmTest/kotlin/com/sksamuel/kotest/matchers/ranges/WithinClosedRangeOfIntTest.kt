package com.sksamuel.kotest.matchers.ranges

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ranges.withinClosedRangeOfInt
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.forAll

@OptIn(ExperimentalStdlibApi::class)
class WithinClosedRangeOfIntTest: StringSpec() {
   init {
      "works" {
         forAll(
            Arb.int(1..4), Arb.int(1..3), Arb.int(0..5), Arb.int(1..3)
         ) { rangeStart, rangeLength, otherStart, otherLength ->
            val rangeEnd = rangeStart + rangeLength
            val otherEnd = otherStart + otherLength
            val maybeOuter = rangeStart..rangeEnd
            val maybeInner = otherStart..<otherEnd
            withinClosedRangeOfInt(maybeOuter, maybeInner) ==
               (maybeOuter.toSet().intersect(maybeInner.toSet()) == maybeInner.toSet())
         }

      }
   }
}
