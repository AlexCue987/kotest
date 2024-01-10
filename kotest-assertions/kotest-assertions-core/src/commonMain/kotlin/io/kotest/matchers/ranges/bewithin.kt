package io.kotest.matchers.ranges

import io.kotest.assertions.print.print
import io.kotest.matchers.Matcher
import io.kotest.matchers.MatcherResult
import io.kotest.matchers.should
import io.kotest.matchers.shouldNot

/**
 * Verifies that this [ClosedRange] beWithin with another [ClosedRange].
 *
 * Assertion to check that this [ClosedRange] beWithin with another [ClosedRange].
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
 * Verifies that this [OpenEndRange] beWithins with a [ClosedRange].
 *
 * Assertion to check that this [OpenEndRange] beWithins with a [ClosedRange].
 *
 * An empty range will always fail. If you need to check for empty range, use [ClosedRange.shouldBeEmpty]
 *
 * @see [shouldbeWithin]
 * @see [beWithin]
 */
@OptIn(ExperimentalStdlibApi::class)
inline infix fun <reified T: Comparable<T>> OpenEndRange<T>.shouldBeWithin(range: ClosedRange<T>): OpenEndRange<T> {
   when(T::class) {
      Int::class -> //throw NotImplementedError("")
         (this as OpenEndRange<Int>).should(beWithinClosedRangeOfInt(range as ClosedRange<Int>))
      else -> Range.of(this) should beWithin(Range.of(range))
   }
   return this
}

/**
 * Verifies that this [ClosedRange] beWithins with an [OpenEndRange].
 *
 * Assertion to check that this [ClosedRange] beWithins with an [OpenEndRange].
 *
 * @see [shouldbeWithin]
 * @see [beWithin]
 */
@OptIn(ExperimentalStdlibApi::class)
infix fun <T: Comparable<T>> ClosedRange<T>.shouldBeWithin(range: OpenEndRange<T>): ClosedRange<T> {
   Range.of(this) should beWithin(Range.of(range))
   return this
}

/**
 * Verifies that this [OpenEndRange] beWithins with another [OpenEndRange].
 *
 * Assertion to check that this [OpenEndRange] beWithins with another [OpenEndRange].
 *
 * @see [shouldbeWithin]
 * @see [beWithin]
 */
@OptIn(ExperimentalStdlibApi::class)
infix fun <T: Comparable<T>> OpenEndRange<T>.shouldBeWithin(range: OpenEndRange<T>): OpenEndRange<T> {
   Range.of(this) should beWithin(Range.of(range))
   return this
}

/**
 * Verifies that this [ClosedRange] does not beWithin with another [ClosedRange].
 *
 * Assertion to check that this [ClosedRange] does not beWithin with another [ClosedRange].
 *
 * An empty range will always fail. If you need to check for empty range, use [Iterable.shouldBeEmpty]
 *
 * @see [shouldNotbeWithin]
 * @see [beWithin]
 */
infix fun <T: Comparable<T>> ClosedRange<T>.shouldNotBeWithin(range: ClosedRange<T>): ClosedRange<T> {
   Range.of(this) shouldNot beWithin(Range.of(range))
   return this
}

/**
 * Verifies that this [ClosedRange] does not beWithin with an [OpenEndRange].
 *
 * Assertion to check that this [ClosedRange] does not beWithin with an [OpenEndRange].
 *
 * @see [shouldNotbeWithin]
 * @see [beWithin]
 */
@OptIn(ExperimentalStdlibApi::class)
infix fun <T: Comparable<T>> ClosedRange<T>.shouldNotBeWithin(range: OpenEndRange<T>): ClosedRange<T> {
   Range.of(this) shouldNot beWithin(Range.of(range))
   return this
}

/**
 * Verifies that this [OpenEndRange] does not beWithin with a [ClosedRange].
 *
 * Assertion to check that this [OpenEndRange] does not beWithin with a [ClosedRange].
 *
 * An empty range will always fail. If you need to check for empty range, use [ClosedRange.shouldBeEmpty]
 *
 * @see [shouldNotbeWithin]
 * @see [beWithin]
 */
@OptIn(ExperimentalStdlibApi::class)
infix fun <T: Comparable<T>> OpenEndRange<T>.shouldNotBeWithin(range: ClosedRange<T>): OpenEndRange<T> {
   Range.of(this) shouldNot beWithin(Range.of(range))
   return this
}

/**
 * Verifies that this [OpenEndRange] does not beWithin with another [OpenEndRange].
 *
 * Assertion to check that this [OpenEndRange] does not beWithin with another [OpenEndRange].
 *
 * @see [shouldNotbeWithin]
 * @see [beWithin]
 */
@OptIn(ExperimentalStdlibApi::class)
infix fun <T: Comparable<T>> OpenEndRange<T>.shouldNotBeWithin(range: OpenEndRange<T>): OpenEndRange<T> {
   Range.of(this) shouldNot beWithin(Range.of(range))
   return this
}

/**
 *  Matcher that verifies that this [range] beWithins with another [range]
 *
 * Assertion to check that this [range] beWithins with another [range].
 *
 * An empty range will always fail. If you need to check for empty range, use [Iterable.shouldBeEmpty]
 *
 */
fun <T: Comparable<T>> beWithin(range: Range<T>) = object : Matcher<Range<T>> {
   override fun test(value: Range<T>): MatcherResult {
      if (range.isEmpty()) throw AssertionError("Asserting content on empty range. Use Iterable.shouldBeEmpty() instead.")

      val match = range.contains(value)

      return MatcherResult(
         match,
         { "Range ${value.print().value} should be within ${range.print().value}, but it isn't" },
         { "Range ${value.print().value} should not be within ${range.print().value}, but it is" }
      )
   }
}

@OptIn(ExperimentalStdlibApi::class)
fun beWithinClosedRangeOfInt(range: ClosedRange<Int>) = object : Matcher<OpenEndRange<Int>> {
   override fun test(value: OpenEndRange<Int>): MatcherResult {
      if (range.isEmpty()) throw AssertionError("Asserting content on empty range. Use Iterable.shouldBeEmpty() instead.")

      val match = withinClosedRangeOfInt(range, value)

      return resultForWithin(range, value, match)
   }
}

@OptIn(ExperimentalStdlibApi::class)
internal fun withinClosedRangeOfInt(range: ClosedRange<Int>, value: OpenEndRange<Int>) =
   (value.start until value.endExclusive).all { range.contains(it) }

@OptIn(ExperimentalStdlibApi::class)
internal fun<T: Comparable<T>> resultForWithin(range: ClosedRange<T>, value: OpenEndRange<T>, match: Boolean): MatcherResult {
   val valueStr = "[${value.start}, ${value.endExclusive})"
   val rangeStr = "[${range.start}, ${range.endInclusive}]"
   return MatcherResult(
      match,
      { "Range $valueStr should be within $rangeStr, but it isn't" },
      { "Range $valueStr should not be within $rangeStr, but it is" }
   )
}
