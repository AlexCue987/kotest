package io.kotest.matchers.collections

import io.kotest.assertions.print.print
import io.kotest.matchers.Matcher
import io.kotest.matchers.MatcherResult
import io.kotest.matchers.should
import io.kotest.matchers.shouldNot

fun BooleanArray.shouldContainDuplicates(): BooleanArray {
   asList() should ContainDuplicatesMatcher("BooleanArray")
   return this
}

fun BooleanArray.shouldNotContainDuplicates(): BooleanArray {
   asList() shouldNot ContainDuplicatesMatcher("BooleanArray")
   return this
}

fun ByteArray.shouldContainDuplicates(): ByteArray {
   asList() should ContainDuplicatesMatcher("ByteArray")
   return this
}

fun ByteArray.shouldNotContainDuplicates(): ByteArray {
   asList() shouldNot ContainDuplicatesMatcher("ByteArray")
   return this
}

fun ShortArray.shouldContainDuplicates(): ShortArray {
   asList() should ContainDuplicatesMatcher("ShortArray")
   return this
}

fun ShortArray.shouldNotContainDuplicates(): ShortArray {
   asList() shouldNot ContainDuplicatesMatcher("ShortArray")
   return this
}

fun CharArray.shouldContainDuplicates(): CharArray {
   asList() should ContainDuplicatesMatcher("CharArray")
   return this
}

fun CharArray.shouldNotContainDuplicates(): CharArray {
   asList() shouldNot ContainDuplicatesMatcher("CharArray")
   return this
}

fun IntArray.shouldContainDuplicates(): IntArray {
   asList() should ContainDuplicatesMatcher("IntArray")
   return this
}

fun IntArray.shouldNotContainDuplicates(): IntArray {
   asList() shouldNot ContainDuplicatesMatcher("IntArray")
   return this
}

fun LongArray.shouldContainDuplicates(): LongArray {
   asList() should ContainDuplicatesMatcher("LongArray")
   return this
}

fun LongArray.shouldNotContainDuplicates(): LongArray {
   asList() shouldNot ContainDuplicatesMatcher("LongArray")
   return this
}

fun FloatArray.shouldContainDuplicates(): FloatArray {
   asList() should ContainDuplicatesMatcher("FloatArray")
   return this
}

fun FloatArray.shouldNotContainDuplicates(): FloatArray {
   asList() shouldNot ContainDuplicatesMatcher("FloatArray")
   return this
}

fun DoubleArray.shouldContainDuplicates(): DoubleArray {
   asList() should ContainDuplicatesMatcher("DoubleArray")
   return this
}

fun DoubleArray.shouldNotContainDuplicates(): DoubleArray {
   asList() shouldNot ContainDuplicatesMatcher("DoubleArray")
   return this
}

fun <T> Array<T>.shouldContainDuplicates(): Array<T> {
   asList() should ContainDuplicatesMatcher("Array")
   return this
}

fun <T> Array<T>.shouldNotContainDuplicates(): Array<T> {
   asList() shouldNot ContainDuplicatesMatcher("Array")
   return this
}

fun <T, I : Iterable<T>> I.shouldContainDuplicates(): I {
   this should ContainDuplicatesMatcher(null)
   return this
}

fun <T, I : Iterable<T>> I.shouldNotContainDuplicates(): I {
   this shouldNot ContainDuplicatesMatcher(null)
   return this
}

fun <T> containDuplicates(): Matcher<Iterable<T>> = ContainDuplicatesMatcher(null)

internal class ContainDuplicatesMatcher<T>(private val name: String?) : Matcher<Iterable<T>> {
   override fun test(value: Iterable<T>): MatcherResult {
      val name = name ?: value.containerName()
      val report = value.duplicationByEqualsReport()
      return MatcherResult(
         report.hasDuplicates(),
         { "$name should contain duplicates" },
         { "$name should not contain duplicates, but has:\n${report.standardMessage()}" }
      )
   }
}

internal fun <T> Iterable<T>.duplicationByEqualsReport(): DuplicationByEqualsReport<T> = DuplicationByEqualsReport(this)

internal fun <T> Iterable<T>.duplicationByCompareReportWith(comparator: Comparator<T>): DuplicationByCompareReport<T> =
   DuplicationByCompareReport(this, comparator)

internal class DuplicationByEqualsReport<T>(iterable: Iterable<T>) {
   val duplicates: Map<T, List<Int>> = iterable.withIndex()
      .groupingBy { it.value }
      .fold<IndexedValue<T>, T, MutableList<Int>>({ _, _ -> mutableListOf() }) { _, acc, indexedValue ->
         acc.apply { add(indexedValue.index) }
      }
      .filter { (_, indexes) -> indexes.size > 1 }

   fun hasDuplicates(): Boolean = duplicates.isNotEmpty()

   fun standardMessage(): String {
      return duplicates.entries.joinToString(separator = "\n") { dupe ->
         "${dupe.key.print().value} at indexes: ${dupe.value}"
      }
   }
}

internal class DuplicationByCompareReport<T>(iterable: Iterable<T>, comparator: Comparator<T>) {
   val duplicates: List<Pair<T, List<Int>>>

   init {
      val dupes = mutableListOf<Pair<T, List<Int>>>()
      val sorted = iterable.withIndex()
         .sortedWith { aIndexed, bIndexed -> comparator.compare(aIndexed.value, bIndexed.value) }
      if (sorted.isNotEmpty()) {
         var currentPair = sorted.first().value to mutableListOf<Int>()
         for ((index, element) in sorted) {
            if (comparator.compare(element, currentPair.first) != 0) {
               dupes.add(currentPair)
               currentPair = element to mutableListOf()
            }
            currentPair.second.add(index)
         }
         dupes.add(currentPair)
      }

      duplicates = dupes.filter { (_, indexes) -> indexes.size > 1 }
   }

   fun hasDuplicates(): Boolean = duplicates.isNotEmpty()

   fun standardMessage(): String {
      return duplicates.joinToString(separator = "\n") { dupe ->
         "${dupe.first.print().value} at indexes: ${dupe.second}"
      }
   }
}
