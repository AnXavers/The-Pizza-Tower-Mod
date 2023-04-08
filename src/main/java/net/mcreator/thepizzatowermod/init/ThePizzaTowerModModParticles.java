
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thepizzatowermod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.thepizzatowermod.client.particle.ToppinCageBrokenParticle;
import net.mcreator.thepizzatowermod.client.particle.TauntParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ThePizzaTowerModModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.register(ThePizzaTowerModModParticleTypes.TOPPIN_CAGE_BROKEN.get(), ToppinCageBrokenParticle::provider);
		event.register(ThePizzaTowerModModParticleTypes.TAUNT.get(), TauntParticle::provider);
	}
}
