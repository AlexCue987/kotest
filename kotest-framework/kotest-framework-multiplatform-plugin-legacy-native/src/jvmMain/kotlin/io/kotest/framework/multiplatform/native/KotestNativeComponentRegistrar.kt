package io.kotest.framework.multiplatform.native

import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.backend.common.toLogger
import org.jetbrains.kotlin.cli.common.messages.MessageCollector
import org.jetbrains.kotlin.compiler.plugin.CompilerPluginRegistrar
import org.jetbrains.kotlin.compiler.plugin.ExperimentalCompilerApi
import org.jetbrains.kotlin.config.CommonConfigurationKeys
import org.jetbrains.kotlin.config.CompilerConfiguration

@OptIn(ExperimentalCompilerApi::class)
class KotestNativeComponentRegistrar : CompilerPluginRegistrar() {

   override val supportsK2: Boolean = true
   override fun ExtensionStorage.registerExtensions(configuration: CompilerConfiguration) {
      val messageCollector = configuration.get(CommonConfigurationKeys.MESSAGE_COLLECTOR_KEY, MessageCollector.NONE)
      messageCollector.toLogger().log("Installing Kotest SpecIrGenerationExtension")
      IrGenerationExtension.registerExtension(SpecIrGenerationExtension(messageCollector))
   }
}
