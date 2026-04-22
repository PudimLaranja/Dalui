package com.dalui

import com.dalui.command.CommandInit
import com.dalui.payload.PayloadInit
import net.fabricmc.api.ModInitializer
import net.minecraft.network.chat.Component
import net.minecraft.resources.Identifier
import net.minecraft.server.level.ServerPlayer
import net.minecraft.world.entity.player.Player
import org.slf4j.LoggerFactory

fun Player.msg(message: String) {
	this.sendSystemMessage(Component.literal(message))
}

fun ServerPlayer.msg(message: String) {
	this.sendSystemMessage(Component.literal(message))
}

object Dalui : ModInitializer {
	const val MOD_ID = "dalui"

	private val logger = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		CommandInit.register()
		PayloadInit.register()

		logger.info("Hello Dalui world! >:]")
	}

	fun id(namespace: String,path: String) = Identifier.fromNamespaceAndPath(namespace,path)
	fun id(path: String): Identifier = id(MOD_ID,path)
}