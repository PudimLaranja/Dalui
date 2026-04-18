package com.dalui.client.gui

import com.dalui.Dalui
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElement
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry
import kotlin.math.sin

object TestGui {
    var totalTickProgress: Float = 0.0f

    fun register() {
        HudElementRegistry.addLast(Dalui.id("test_element"), hudLayer())
    }

    fun hudLayer(): HudElement = {
        graphics,deltaTracker -> with(graphics.pose()) {

            totalTickProgress += deltaTracker.getGameTimeDeltaPartialTick(true)

            pushMatrix()

            val scaleAmount = sin(totalTickProgress / 10f) / 2f + 1.5f

            scale(scaleAmount)

            scale(1 / scaleAmount)
            translate(60f,60f)

            val rotationAmount = totalTickProgress / 50F % 360
            rotate(rotationAmount)
            translate(-20f,-20f)

            popMatrix()
        }
    }
}