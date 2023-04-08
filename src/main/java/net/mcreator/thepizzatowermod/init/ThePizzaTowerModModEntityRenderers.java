
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thepizzatowermod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.thepizzatowermod.client.renderer.MushroomToppinRenderer;
import net.mcreator.thepizzatowermod.client.renderer.JohnPillarRenderer;
import net.mcreator.thepizzatowermod.client.renderer.CheeseToppinRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ThePizzaTowerModModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(ThePizzaTowerModModEntities.MUSHROOM_TOPPIN.get(), MushroomToppinRenderer::new);
		event.registerEntityRenderer(ThePizzaTowerModModEntities.CHEESE_TOPPIN.get(), CheeseToppinRenderer::new);
		event.registerEntityRenderer(ThePizzaTowerModModEntities.JOHN_PILLAR.get(), JohnPillarRenderer::new);
	}
}
