package com.sksamuel.kotest.engine.test.timeout

import io.kotest.core.annotation.Isolate
import io.kotest.core.spec.style.FunSpec
import io.kotest.core.test.testCoroutineScheduler
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import kotlinx.coroutines.withContext
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.minutes

// Issue: https://github.com/kotest/kotest/issues/3703
@Isolate
@OptIn(ExperimentalCoroutinesApi::class)
class ContainerTimeoutOverriddenMainDispatcherTest : FunSpec({

   coroutineTestScope = true

   val dispatcher = StandardTestDispatcher()

   beforeSpec { Dispatchers.setMain(dispatcher) }
   afterSpec { Dispatchers.resetMain() }

   context("container with timeout").config(timeout = 2000.milliseconds) {
      test("test with delay") {
         // It will crash if the Main dispatcher wasn't set before
         withContext(Dispatchers.Main) {
            delay(100.hours) // Virtual time shouldn't exceed timeout
         }

         dispatcher.scheduler shouldBe testCoroutineScheduler
      }

      xtest("test exceeding invocation timeout").config(
         invocationTimeout = 1000.milliseconds,
         extensions = listOf(ExpectFailureExtension),
      ) {
         realTimeDelay(1.minutes)
      }
   }
})
