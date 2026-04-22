package com.dalui.client.gui

import com.dalui.Dalui
import net.minecraft.client.gui.GuiGraphicsExtractor
import net.minecraft.client.gui.screens.Screen
import net.minecraft.client.renderer.RenderPipelines
import net.minecraft.network.chat.Component

class LogsGui: Screen(Component.literal("Logs")) {

    override fun shouldCloseOnEsc() = true
    override fun isPauseScreen() = false

    override fun init() {

        super.init()
    }

    override fun tick() {
        super.tick()
    }

    override fun extractRenderState(graphics: GuiGraphicsExtractor, mouseX: Int, mouseY: Int, delta: Float) {
        super.extractRenderState(graphics, mouseX, mouseY, delta)

        with(graphics) {
            //texture is in /src/main/resources/assets/dalui/textures/gui/backgrounds/log_panel_full.png
            val texture = Dalui.id("backgrounds/log_panel_full")

            val spriteWidth = 280
            val spriteHeight = 200
            val xPosition = this.guiWidth() / 2 - spriteWidth / 2
            val yPosition = this.guiHeight() / 2 - spriteHeight / 2

            blitSprite(
                RenderPipelines.GUI_TEXTURED,
                texture,
                spriteWidth,spriteHeight,
                0,0,
                xPosition,yPosition,
                spriteWidth,spriteHeight
                )
        }
    }


}