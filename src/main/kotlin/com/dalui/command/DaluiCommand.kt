package com.dalui.command

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback
import net.minecraft.commands.Commands
import net.minecraft.network.chat.Component
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.player.Player

object DaluiCommand {

    fun register() {
        CommandRegistrationCallback.EVENT.register { dispatcher, _, _ ->
            dispatcher.register(
                Commands.literal("dalui")
                    .then(
                        Commands.literal("debug")
                            .then(Commands.literal("display").executes {
                                val player = it.source.entity as? Player ?: return@executes -1

                                player.sendSystemMessage(Component.literal("display command"))

                                return@executes 0
                            })
                            .then(Commands.literal("logs").executes {
                                val player = it.source.entity as? Player ?: return@executes -1

                                player.sendSystemMessage(Component.literal("logs command"))

                                return@executes 0
                            })
                    )

            )
        }
    }
}