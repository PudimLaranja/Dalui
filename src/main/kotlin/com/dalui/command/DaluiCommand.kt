package com.dalui.command

import com.dalui.msg
import com.dalui.payload.OpenScreenPayload
import com.mojang.brigadier.arguments.StringArgumentType
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking
import net.minecraft.commands.Commands
import net.minecraft.server.level.ServerPlayer
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

                                player.msg("display command called")

                                return@executes 0
                            })


                            .then(Commands.literal("logs").executes {
                                val player = it.source.entity as? Player ?: return@executes -1

                                player.msg("logs command called")

                                val payload = OpenScreenPayload("logs",2)

                                if (player is ServerPlayer) {
                                    ServerPlayNetworking.send(player,payload)
                                }


                                return@executes 0
                            })
                    )
                .then(
                    Commands.literal("pack")


                        .then(Commands.argument("pack", StringArgumentType.string())


                            .then(Commands.literal("enable").executes {
                                val player = it.source.entity as? Player ?: return@executes -1

                                val pack = StringArgumentType.getString(it,"pack")

                                player.msg("enabled pack: $pack")

                                return@executes 0
                            })


                            .then(Commands.literal("disable").executes {
                                val player = it.source.entity as? Player ?: return@executes -1

                                val pack = StringArgumentType.getString(it,"pack")

                                player.msg("enable pack: $pack")

                                return@executes 0
                            })
                    )
                )
            )
        }
    }
}