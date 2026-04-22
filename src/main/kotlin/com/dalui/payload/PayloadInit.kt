package com.dalui.payload

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry

object PayloadInit {
    fun register() {
        PayloadTypeRegistry.clientboundPlay().register(OpenScreenPayload.TYPE, OpenScreenPayload.CODEC)
    }
}