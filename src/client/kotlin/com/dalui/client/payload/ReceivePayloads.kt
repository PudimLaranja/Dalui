package com.dalui.client.payload

import com.dalui.client.gui.LogsGui
import com.dalui.msg
import com.dalui.payload.OpenScreenPayload
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.screens.Screen

object ReceivePayloads {
    private fun handleScreen(screen: Screen, doOpen: Int) {
        val mc = Minecraft.getInstance()
        when (doOpen) {
            0 -> if (mc.screen is LogsGui) mc.setScreen(null)
            1 -> if (mc.screen == null) mc.setScreen(screen)
            else -> {
                if (mc.screen == null) {
                    mc.setScreen(screen)
                } else if (mc.screen is LogsGui) {
                    mc.setScreen(null)
                }
            }
        }
    }

    fun receive() {
        ClientPlayNetworking.registerGlobalReceiver(OpenScreenPayload.TYPE) { payload, context ->
            val screenName = payload.screen
            val doOpen = payload.doOpen

            when (screenName) {
                "logs" -> handleScreen(LogsGui(), doOpen)
                else -> context.player().msg("Server Tried to open a invalid gui")
            }
        }
    }
}