package com.sksamuel.kotest.matchers.date

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.date.LocalTimeToleranceMatcher
import io.kotest.matchers.date.and
import io.kotest.matchers.shouldBe
import java.time.LocalTime
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes

class LocalTimeToleranceMatcherTest: WordSpec() {
   private val oneAm = LocalTime.of(1, 0, 0)
   private val onePm = LocalTime.of(13, 0, 0)
   private val sixPm = LocalTime.of(18, 0, 0)
   init {
      "should" should {
         "wrap around midnight forward" {
            LocalTime.of(23, 55, 0).plusMinutes(10) shouldBe LocalTime.of(0, 5, 0)
         }

         "wrap around midnight backward" {
            LocalTime.of(0, 5, 0).minusMinutes(10) shouldBe LocalTime.of(23, 55, 0)
         }
      }

      "rangeDescription" should {
          "works when interval is within day" {
             LocalTimeToleranceMatcher.rangeDescription(oneAm, sixPm) shouldBe "between 01:00 and 18:00"
          }

         "works when interval is spans two days" {
            LocalTimeToleranceMatcher.rangeDescription(sixPm, oneAm) shouldBe "between 18:00 and 01:00 next day"
         }
      }

      "validateTolerance" should {
          "pass when less than 12 hours" {
             shouldNotThrowAny {
                LocalTimeToleranceMatcher.validateTolerance(11.hours and 59.minutes)
             }
          }

         "pass when 12 hours" {
            shouldThrowAny {
               LocalTimeToleranceMatcher.validateTolerance(12.hours)
            }
         }
      }
   }
}
