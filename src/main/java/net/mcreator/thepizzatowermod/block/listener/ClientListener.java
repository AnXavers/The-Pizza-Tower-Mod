package net.mcreator.thepizzatowermod.block.listener;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.thepizzatowermod.init.ThePizzaTowerModModBlockEntities;
import net.mcreator.thepizzatowermod.block.renderer.TrappedToppinTileRenderer;
import net.mcreator.thepizzatowermod.block.renderer.TomatoToppingTileRenderer;
import net.mcreator.thepizzatowermod.block.renderer.PineappleToppingTileRenderer;
import net.mcreator.thepizzatowermod.block.renderer.PepperoniToppingTileRenderer;
import net.mcreator.thepizzatowermod.block.renderer.MushroomToppingTileRenderer;
import net.mcreator.thepizzatowermod.block.renderer.MortCubeTileRenderer;
import net.mcreator.thepizzatowermod.block.renderer.CheeseToppingTileRenderer;
import net.mcreator.thepizzatowermod.ThePizzaTowerModMod;

@Mod.EventBusSubscriber(modid = ThePizzaTowerModMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientListener {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(ThePizzaTowerModModBlockEntities.TRAPPED_TOPPIN.get(), TrappedToppinTileRenderer::new);
		event.registerBlockEntityRenderer(ThePizzaTowerModModBlockEntities.MORT_CUBE.get(), MortCubeTileRenderer::new);
		event.registerBlockEntityRenderer(ThePizzaTowerModModBlockEntities.TOMATO_TOPPING.get(), TomatoToppingTileRenderer::new);
		event.registerBlockEntityRenderer(ThePizzaTowerModModBlockEntities.PINEAPPLE_TOPPING.get(), PineappleToppingTileRenderer::new);
		event.registerBlockEntityRenderer(ThePizzaTowerModModBlockEntities.CHEESE_TOPPING.get(), CheeseToppingTileRenderer::new);
		event.registerBlockEntityRenderer(ThePizzaTowerModModBlockEntities.PEPPERONI_TOPPING.get(), PepperoniToppingTileRenderer::new);
		event.registerBlockEntityRenderer(ThePizzaTowerModModBlockEntities.MUSHROOM_TOPPING.get(), MushroomToppingTileRenderer::new);
	}
}
