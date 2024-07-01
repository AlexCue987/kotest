package com.sksamuel.kotest.matchers.equality

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.equality.FieldComparison
import io.kotest.matchers.equality.comparisonToUse
import io.kotest.matchers.shouldBe
import java.math.BigDecimal
import java.time.DayOfWeek

class EqualityOfFieldsTest: WordSpec() {
   init {
      "comparisonToUse" should {
         "handle nulls" {
            comparisonToUse(null, "Apple", listOf()) shouldBe FieldComparison.DEFAULT
            comparisonToUse("Apple", null, listOf()) shouldBe FieldComparison.DEFAULT
         }
         "handle enums" {
            comparisonToUse(DayOfWeek.MONDAY, Mug("blue", 11), listOf()) shouldBe FieldComparison.DEFAULT
            comparisonToUse(Mug("blue", 11), DayOfWeek.MONDAY, listOf()) shouldBe FieldComparison.DEFAULT
         }
         "handle built-in type" {
            comparisonToUse(BigDecimal.ONE, Mug("blue", 11), listOf()) shouldBe FieldComparison.DEFAULT
            comparisonToUse(Mug("blue", 11), BigDecimal.ONE, listOf()) shouldBe FieldComparison.DEFAULT
         }
         "override with custom list of types" {
            val className = "com.sksamuel.kotest.matchers.equality.Mug"
            comparisonToUse(Mug("blue", 12), Mug("blue", 11), listOf(className)) shouldBe FieldComparison.DEFAULT
            comparisonToUse(Mug("blue", 11), Mug("blue", 12), listOf(className)) shouldBe FieldComparison.DEFAULT
         }
      }
   }
}

data class Mug(
   val color: String,
   val capacity: Int
)
