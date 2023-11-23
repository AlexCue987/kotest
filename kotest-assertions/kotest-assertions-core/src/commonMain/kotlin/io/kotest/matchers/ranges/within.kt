package io.kotest.matchers.ranges

import io.kotest.assertions.print.print
import io.kotest.matchers.Matcher
import io.kotest.matchers.MatcherResult
import io.kotest.matchers.should
import io.kotest.matchers.shouldNot

/**
 * Verifies that this [ClosedRange] is within another [ClosedRange].
 *
 * Assertion to check that this [ClosedRange] is within another [ClosedRange].
 *
 * An empty range will always fail. If you need to check for empty range, use [ClosedRange.shouldBeEmpty]
 *
 * @see [shouldBeWithin]
 * @see [beWithin]
 */
infix fun <T: Comparable<T>> ClosedRange<T>.shouldBeWithin(range: ClosedRange<T>): ClosedRange<T> {
   Range.of(this) should beWithin(Range.of(range))
   return this
}

/**
 * Verifies that this [OpenEndRange] is within a [ClosedRange].
 *
 * Assertion to check that this [OpenEndRange] is within a [ClosedRange].
 *
 * An empty range will always fail. If you need to check for empty range, use [ClosedRange.shouldBeEmpty]
 *
 * @see [shouldBeWithin]
 * @see [beWithin]
 */
@OptIn(ExperimentalStdlibApi::class)
infix fun <T: Comparable<T>> OpenEndRange<T>.shouldBeWithin(range: ClosedRange<T>): OpenEndRange<T> {
   Range.of(this) should beWithin(Range.of(range))
   return this
}

/**
 * Verifies that this [ClosedRange] is within an [OpenEndRange].
 *
 * Assertion to check that this [ClosedRange] is within an [OpenEndRange].
 *
 * @see [shouldBeWithin]
 * @see [beWithin]
 */
@OptIn(ExperimentalStdlibApi::class)
infix fun <T: Comparable<T>> ClosedRange<T>.shouldBeWithin(range: OpenEndRange<T>): ClosedRange<T> {
   Range.of(this) should beWithin(Range.of(range))
   return this
}

/**
 * Verifies that this [OpenEndRange] is within another [OpenEndRange].
 *
 * Assertion to check that this [OpenEndRange] is within another [OpenEndRange].
 *
 * @see [shouldBeWithin]
 * @see [beWithin]
 */
@OptIn(ExperimentalStdlibApi::class)
infix fun <T: Comparable<T>> OpenEndRange<T>.shouldBeWithin(range: OpenEndRange<T>): OpenEndRange<T> {
   Range.of(this) should beWithin(Range.of(range))
   return this
}

/**
 * Verifies that this [ClosedRange] is not within another [ClosedRange].
 *
 * Assertion to check that this [ClosedRange] is not within another [ClosedRange].
 *
 * An empty range will always fail. If you need to check for empty range, use [Iterable.shouldBeEmpty]
 *
 * @see [shouldNotBeWithin]
 * @see [beWithin]
 */
infix fun <T: Comparable<T>> ClosedRange<T>.shouldNotBeWithin(range: ClosedRange<T>): ClosedRange<T> {
   Range.of(this) shouldNot beWithin(Range.of(range))
   return this
}

@OptIn(ExperimentalStdlibApi::class)
infix fun <T: Comparable<T>> ClosedRange<T>.shouldNotBeWithin(range: OpenEndRange<T>): ClosedRange<T> {
   Range.of(this) shouldNot beWithin(Range.of(range))
   return this
}

@OptIn(ExperimentalStdlibApi::class)
infix fun <T: Comparable<T>> OpenEndRange<T>.shouldNotBeWithin(range: ClosedRange<T>): OpenEndRange<T> {
   Range.of(this) shouldNot beWithin(Range.of(range))
   return this
}

@OptIn(ExperimentalStdlibApi::class)
infix fun <T: Comparable<T>> OpenEndRange<T>.shouldNotBeWithin(range: OpenEndRange<T>): OpenEndRange<T> {
   Range.of(this) shouldNot beWithin(Range.of(range))
   return this
}

/**
 *  Matcher that verifies that this [range] is within another [range]
 *
 * Assertion to check that this [range] is within another [range].
 *
 * An empty range will always succeed.
 *
 */
fun <T: Comparable<T>> beWithin(range: Range<T>) = object : Matcher<Range<T>> {
   override fun test(value: Range<T>): MatcherResult {
      if (range.isEmpty()) throw AssertionError("Asserting content on empty range. Use Iterable.shouldBeEmpty() instead.")

      val match = !range.lessThan(value) && !value.lessThan(range)

      return MatcherResult(
         match,
         { "Range ${value.print().value} should within ${range.print().value}, but doesn't" },
         { "Range ${value.print().value} should not within ${range.print().value}, but does" }
      )
   }
}

