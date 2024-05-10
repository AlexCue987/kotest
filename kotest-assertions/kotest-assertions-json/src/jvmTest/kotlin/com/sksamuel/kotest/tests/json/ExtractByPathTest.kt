package com.sksamuel.kotest.tests.json

import io.kotest.assertions.json.ExtractedValue
import io.kotest.assertions.json.JsonPathNotFound
import io.kotest.assertions.json.extractByPath
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.intellij.lang.annotations.Language

class ExtractByPathTest: StringSpec() {
   @Language("JSON")
   private val json = """
      {
          "ingredients": ["Rice", "Water", "Salt"],
          "appliance": {
             "type": "Stove",
             "kind": "Electric"
          },
          "regime": {
            "temperature": {
                "degrees": 320,
                "unit": "F"
            }
          }
      }
   """.trimIndent()

   init {
      "find by valid path" {
         extractByPath<String>(json, "$.regime.temperature.unit") shouldBe ExtractedValue("F")
      }

      "path not found" {
         extractByPath<String>(json, "$.regime.temperature.unit.name") shouldBe JsonPathNotFound
      }
   }
}
