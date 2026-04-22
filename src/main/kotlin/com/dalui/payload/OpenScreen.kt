package com.dalui.payload

import com.dalui.Dalui
import net.minecraft.network.codec.ByteBufCodecs
import net.minecraft.network.codec.StreamCodec
import net.minecraft.network.protocol.common.custom.CustomPacketPayload

data class OpenScreenPayload(val screen: String,val doOpen:Int): CustomPacketPayload {

    //0 -> close
    //1 -> open
    //2.. -> toggle

    companion object Static {
        val OPEN_SCREEN_PAYLOAD_ID = Dalui.id("open_screen")
        val TYPE = CustomPacketPayload.Type<OpenScreenPayload>(OPEN_SCREEN_PAYLOAD_ID)
        val CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, OpenScreenPayload::screen,
            ByteBufCodecs.INT, OpenScreenPayload::doOpen,
            ::OpenScreenPayload)
    }

    override fun type() = TYPE
}
