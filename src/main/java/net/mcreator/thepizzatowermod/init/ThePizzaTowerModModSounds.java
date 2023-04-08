
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thepizzatowermod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.thepizzatowermod.ThePizzaTowerModMod;

public class ThePizzaTowerModModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ThePizzaTowerModMod.MODID);
	public static final RegistryObject<SoundEvent> TOPPIN_COLLECT = REGISTRY.register("toppin_collect", () -> new SoundEvent(new ResourceLocation("the_pizza_tower_mod", "toppin_collect")));
	public static final RegistryObject<SoundEvent> COLD_SPAGGHETI = REGISTRY.register("cold_spaggheti", () -> new SoundEvent(new ResourceLocation("the_pizza_tower_mod", "cold_spaggheti")));
	public static final RegistryObject<SoundEvent> PIZZA_DELUXE = REGISTRY.register("pizza_deluxe", () -> new SoundEvent(new ResourceLocation("the_pizza_tower_mod", "pizza_deluxe")));
	public static final RegistryObject<SoundEvent> TIME_FOR_A_SMACKDOWN = REGISTRY.register("time_for_a_smackdown", () -> new SoundEvent(new ResourceLocation("the_pizza_tower_mod", "time_for_a_smackdown")));
	public static final RegistryObject<SoundEvent> TOMBSTONE_ARIZONA = REGISTRY.register("tombstone_arizona", () -> new SoundEvent(new ResourceLocation("the_pizza_tower_mod", "tombstone_arizona")));
	public static final RegistryObject<SoundEvent> UNEXPECTANCY_PART_1 = REGISTRY.register("unexpectancy_part_1", () -> new SoundEvent(new ResourceLocation("the_pizza_tower_mod", "unexpectancy_part_1")));
	public static final RegistryObject<SoundEvent> UNEXPECTANCY_PART_2 = REGISTRY.register("unexpectancy_part_2", () -> new SoundEvent(new ResourceLocation("the_pizza_tower_mod", "unexpectancy_part_2")));
	public static final RegistryObject<SoundEvent> UNEXPECTANCY_PART_3 = REGISTRY.register("unexpectancy_part_3", () -> new SoundEvent(new ResourceLocation("the_pizza_tower_mod", "unexpectancy_part_3")));
	public static final RegistryObject<SoundEvent> PIZZA_TIME = REGISTRY.register("pizza_time", () -> new SoundEvent(new ResourceLocation("the_pizza_tower_mod", "pizza_time")));
	public static final RegistryObject<SoundEvent> PIZZA_TIME_GLOBAL = REGISTRY.register("pizza_time_global", () -> new SoundEvent(new ResourceLocation("the_pizza_tower_mod", "pizza_time_global")));
	public static final RegistryObject<SoundEvent> TOPPING_COLLECT = REGISTRY.register("topping_collect", () -> new SoundEvent(new ResourceLocation("the_pizza_tower_mod", "topping_collect")));
	public static final RegistryObject<SoundEvent> SILENCE = REGISTRY.register("silence", () -> new SoundEvent(new ResourceLocation("the_pizza_tower_mod", "silence")));
}
