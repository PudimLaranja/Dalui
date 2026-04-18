package com.dalui.command

import com.mojang.brigadier.arguments.DoubleArgumentType
import com.mojang.brigadier.arguments.IntegerArgumentType
import com.mojang.brigadier.arguments.StringArgumentType
import net.minecraft.network.chat.Component


object CommandInit {

    fun register() {
        DaluiCommand.register()
    }



}