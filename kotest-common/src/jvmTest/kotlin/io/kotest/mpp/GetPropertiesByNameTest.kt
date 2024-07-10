package io.kotest.mpp

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.shouldBe

class GetPropertiesByNameTest: WordSpec() {
   init {
       "getPropertiesByName" should {
          "return properties when there are no functions with same name" {
             JvmReflection.getPropertiesByName(Fruit::class).keys shouldBe setOf("name" , "weight")
          }
          "handle case when field and function have the same name" {
             val actual = JvmReflection.getPropertiesByName(FruitWithCollision::class)["weight"]
             actual!!.call(FruitWithCollision("apple", 12)) shouldBe 12
          }
       }
      "primaryConstructorMembers" should {
         "return properties when there are no functions with same name" {
            val fruit = Fruit("apple", 12)
            JvmReflection.primaryConstructorMembers(Fruit::class).map {
               it.call(fruit)
            } shouldContainExactlyInAnyOrder listOf("apple", 12)
         }
         "handle case when field and function have the same name" {
            val actual = JvmReflection.primaryConstructorMembers(FruitWithCollision::class)
            val fruitWithCollision = FruitWithCollision("apple", 12)
            actual.map {
               it.call(fruitWithCollision)
            } shouldContainExactlyInAnyOrder listOf("apple", 12)
         }
      }
   }

   data class Fruit(
      val name: String,
      val weight: Int
   )
   data class FruitWithCollision(
      val name: String,
      val weight: Int
   ) {
      fun weight() = 42
   }
}
