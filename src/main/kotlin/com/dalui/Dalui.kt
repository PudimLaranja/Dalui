package com.dalui

import com.dalui.command.CommandInit
import net.fabricmc.api.ModInitializer
import net.minecraft.resources.Identifier
import org.slf4j.LoggerFactory

object Dalui : ModInitializer {
	const val MOD_ID = "dalui"

	private val logger = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		CommandInit.register()
		logger.info("Hello Dalui world! >:]")
	}

	fun id(namespace: String,path: String) = Identifier.fromNamespaceAndPath(namespace,path)
	fun id(path: String): Identifier = id(MOD_ID,path)
}