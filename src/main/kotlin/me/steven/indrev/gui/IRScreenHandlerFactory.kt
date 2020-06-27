package me.steven.indrev.gui

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.network.PacketByteBuf
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.ScreenHandlerContext
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.text.Text
import net.minecraft.util.math.BlockPos

class IRScreenHandlerFactory(private val handlerFactory: (Int, PlayerInventory, ScreenHandlerContext) -> ScreenHandler, val pos: BlockPos) : ExtendedScreenHandlerFactory {
    override fun createMenu(syncId: Int, inv: PlayerInventory?, player: PlayerEntity?): ScreenHandler? {
        return handlerFactory(syncId, inv!!, ScreenHandlerContext.create(inv.player.world, pos))
    }

    override fun writeScreenOpeningData(p0: ServerPlayerEntity?, p1: PacketByteBuf?) {
        p1?.writeBlockPos(pos)
    }

    override fun getDisplayName(): Text? = null

}