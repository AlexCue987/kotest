plugins {
   id("kotest-jvm-conventions")
   id("kotest-publishing-conventions")
}

kotlin {
   sourceSets {

      @Suppress("UNUSED_VARIABLE")
      val jvmMain by getting {
         dependencies {
            implementation(projects.kotestFramework.kotestFrameworkEngine)
            implementation(projects.kotestFramework.kotestFrameworkApi)
            implementation(libs.blockhound)
            implementation(libs.kotlinx.coroutines.debug)
         }
      }
   }
}