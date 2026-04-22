package com.dalui.client

import com.dalui.client.gui.GuiInit
import com.dalui.client.payload.PayloadInit
import com.dalui.client.payload.ReceivePayloads
import net.fabricmc.api.ClientModInitializer
import net.minecraft.client.player.LocalPlayer
import net.minecraft.network.chat.Component

fun LocalPlayer.msg(message: String) {
	this.sendSystemMessage(Component.literal(message))
}
object DaluiClient : ClientModInitializer {
	override fun onInitializeClient() {
		GuiInit.register()
		ReceivePayloads.receive()
		PayloadInit.register()
	}
}