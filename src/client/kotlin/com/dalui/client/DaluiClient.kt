package com.dalui.client

import com.dalui.client.gui.GuiInit
import net.fabricmc.api.ClientModInitializer

object DaluiClient : ClientModInitializer {
	override fun onInitializeClient() {
		GuiInit.register()
	}
}