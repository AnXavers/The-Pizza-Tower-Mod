
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thepizzatowermod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.thepizzatowermod.ThePizzaTowerModMod;

public class ThePizzaTowerModModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, ThePizzaTowerModMod.MODID);
	public static final RegistryObject<SimpleParticleType> TOPPIN_CAGE_BROKEN = REGISTRY.register("toppin_cage_broken", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> TAUNT = REGISTRY.register("taunt", () -> new SimpleParticleType(false));
}
