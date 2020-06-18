package me.steven.indrev

import me.steven.indrev.blockentities.cables.CableBlockEntity
import me.steven.indrev.blockentities.cables.CableBlockEntityRenderer
import me.steven.indrev.blockentities.farms.AOEMachineBlockEntity
import me.steven.indrev.blockentities.farms.AOEMachineBlockEntityRenderer
import me.steven.indrev.gui.IRInventoryScreen
import me.steven.indrev.gui.controllers.*
import me.steven.indrev.registry.MachineRegistry
import me.steven.indrev.registry.ModRegistry
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry
import net.fabricmc.fabric.api.client.screen.ScreenProviderRegistry
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.client.render.RenderLayer
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.network.PacketByteBuf
import net.minecraft.screen.ScreenHandlerContext
import net.minecraft.util.Identifier

class IndustrialRevolutionClient : ClientModInitializer {
    override fun onInitializeClient() {
        ScreenProviderRegistry.INSTANCE.registerFactory(
            CoalGeneratorController.SCREEN_ID
        ) { syncId: Int, _: Identifier?, player: PlayerEntity, buf: PacketByteBuf ->
            IRInventoryScreen(
                CoalGeneratorController(
                    syncId,
                    player.inventory,
                    ScreenHandlerContext.create(player.world, buf.readBlockPos())
                ), player
            )
        }

        ScreenProviderRegistry.INSTANCE.registerFactory(
            SolarGeneratorController.SCREEN_ID
        ) { syncId: Int, _: Identifier?, player: PlayerEntity, buf: PacketByteBuf ->
            IRInventoryScreen(
                SolarGeneratorController(
                    syncId,
                    player.inventory,
                    ScreenHandlerContext.create(player.world, buf.readBlockPos())
                ), player
            )
        }

        ScreenProviderRegistry.INSTANCE.registerFactory(
            ElectricFurnaceController.SCREEN_ID
        ) { syncId: Int, _: Identifier?, player: PlayerEntity, buf: PacketByteBuf ->
            IRInventoryScreen(
                ElectricFurnaceController(
                    syncId,
                    player.inventory,
                    ScreenHandlerContext.create(player.world, buf.readBlockPos())
                ), player
            )
        }

        ScreenProviderRegistry.INSTANCE.registerFactory(
            PulverizerController.SCREEN_ID
        ) { syncId: Int, _: Identifier?, player: PlayerEntity, buf: PacketByteBuf ->
            IRInventoryScreen(
                PulverizerController(
                    syncId,
                    player.inventory,
                    ScreenHandlerContext.create(player.world, buf.readBlockPos())
                ), player
            )
        }

        ScreenProviderRegistry.INSTANCE.registerFactory(
            CompressorController.SCREEN_ID
        ) { syncId: Int, _: Identifier?, player: PlayerEntity, buf: PacketByteBuf ->
            IRInventoryScreen(
                CompressorController(
                    syncId,
                    player.inventory,
                    ScreenHandlerContext.create(player.world, buf.readBlockPos())
                ),
                player
            )
        }

        ScreenProviderRegistry.INSTANCE.registerFactory(
            BatteryController.SCREEN_ID
        ) { syncId: Int, _: Identifier?, player: PlayerEntity, buf: PacketByteBuf ->
            IRInventoryScreen(
                BatteryController(
                    syncId,
                    player.inventory,
                    ScreenHandlerContext.create(player.world, buf.readBlockPos())
                ),
                player
            )
        }

        ScreenProviderRegistry.INSTANCE.registerFactory(
            InfuserController.SCREEN_ID
        ) { syncId: Int, _: Identifier?, player: PlayerEntity, buf: PacketByteBuf ->
            IRInventoryScreen(
                InfuserController(
                    syncId,
                    player.inventory,
                    ScreenHandlerContext.create(player.world, buf.readBlockPos())
                ),
                player
            )
        }

        ScreenProviderRegistry.INSTANCE.registerFactory(
            MinerController.SCREEN_ID
        ) { syncId: Int, _: Identifier?, player: PlayerEntity, buf: PacketByteBuf ->
            IRInventoryScreen(
                MinerController(
                    syncId,
                    player.inventory,
                    ScreenHandlerContext.create(player.world, buf.readBlockPos())
                ),
                player
            )
        }

        ScreenProviderRegistry.INSTANCE.registerFactory(
            NuclearReactorController.SCREEN_ID
        ) { syncId: Int, _: Identifier?, player: PlayerEntity, buf: PacketByteBuf ->
            IRInventoryScreen(
                NuclearReactorController(
                    syncId,
                    player.inventory,
                    ScreenHandlerContext.create(player.world, buf.readBlockPos())
                ),
                player
            )
        }

        ScreenProviderRegistry.INSTANCE.registerFactory(
            RecyclerController.SCREEN_ID
        ) { syncId: Int, _: Identifier?, player: PlayerEntity, buf: PacketByteBuf ->
            IRInventoryScreen(
                RecyclerController(
                    syncId,
                    player.inventory,
                    ScreenHandlerContext.create(player.world, buf.readBlockPos())
                ),
                player
            )
        }

        ScreenProviderRegistry.INSTANCE.registerFactory(
            BiomassGeneratorController.SCREEN_ID
        ) { syncId: Int, _: Identifier?, player: PlayerEntity, buf: PacketByteBuf ->
            IRInventoryScreen(
                BiomassGeneratorController(
                    syncId,
                    player.inventory,
                    ScreenHandlerContext.create(player.world, buf.readBlockPos())
                ),
                player
            )
        }

        ScreenProviderRegistry.INSTANCE.registerFactory(
            ChopperController.SCREEN_ID
        ) { syncId: Int, _: Identifier?, player: PlayerEntity, buf: PacketByteBuf ->
            IRInventoryScreen(
                ChopperController(
                    syncId,
                    player.inventory,
                    ScreenHandlerContext.create(player.world, buf.readBlockPos())
                ),
                player
            )
        }

        ScreenProviderRegistry.INSTANCE.registerFactory(
            RancherController.SCREEN_ID
        ) { syncId: Int, _: Identifier?, player: PlayerEntity, buf: PacketByteBuf ->
            IRInventoryScreen(
                RancherController(
                    syncId,
                    player.inventory,
                    ScreenHandlerContext.create(player.world, buf.readBlockPos())
                ),
                player
            )
        }


        MachineRegistry.CABLE_REGISTRY.forEach { _, blockEntity ->
            BlockEntityRendererRegistry.INSTANCE.register(blockEntity as BlockEntityType<CableBlockEntity>) {
                CableBlockEntityRenderer(it)
            }
        }

        MachineRegistry.CHOPPER_REGISTRY.forEach { _, blockEntity ->
            BlockEntityRendererRegistry.INSTANCE.register(blockEntity as BlockEntityType<AOEMachineBlockEntity>) {
                AOEMachineBlockEntityRenderer(it)
            }
        }

        MachineRegistry.RANCHER_REGISTRY.forEach { _, blockEntity ->
            BlockEntityRendererRegistry.INSTANCE.register(blockEntity as BlockEntityType<AOEMachineBlockEntity>) {
                AOEMachineBlockEntityRenderer(it)
            }
        }

        BlockRenderLayerMap.INSTANCE.putBlock(ModRegistry.AREA_INDICATOR, RenderLayer.getTranslucent())
    }
}