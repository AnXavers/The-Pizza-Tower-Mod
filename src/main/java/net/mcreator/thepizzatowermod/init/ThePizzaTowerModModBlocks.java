
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thepizzatowermod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.thepizzatowermod.block.TrappedToppinBlock;
import net.mcreator.thepizzatowermod.block.TomatoToppingBlock;
import net.mcreator.thepizzatowermod.block.PineappleToppingBlock;
import net.mcreator.thepizzatowermod.block.PepperoniToppingBlock;
import net.mcreator.thepizzatowermod.block.MushroomToppingBlock;
import net.mcreator.thepizzatowermod.block.MortCubeBlock;
import net.mcreator.thepizzatowermod.block.CheeseToppingBlock;
import net.mcreator.thepizzatowermod.ThePizzaTowerModMod;

public class ThePizzaTowerModModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, ThePizzaTowerModMod.MODID);
	public static final RegistryObject<Block> TRAPPED_TOPPIN = REGISTRY.register("trapped_toppin", () -> new TrappedToppinBlock());
	public static final RegistryObject<Block> MORT_CUBE = REGISTRY.register("mort_cube", () -> new MortCubeBlock());
	public static final RegistryObject<Block> TOMATO_TOPPING = REGISTRY.register("tomato_topping", () -> new TomatoToppingBlock());
	public static final RegistryObject<Block> PINEAPPLE_TOPPING = REGISTRY.register("pineapple_topping", () -> new PineappleToppingBlock());
	public static final RegistryObject<Block> CHEESE_TOPPING = REGISTRY.register("cheese_topping", () -> new CheeseToppingBlock());
	public static final RegistryObject<Block> PEPPERONI_TOPPING = REGISTRY.register("pepperoni_topping", () -> new PepperoniToppingBlock());
	public static final RegistryObject<Block> MUSHROOM_TOPPING = REGISTRY.register("mushroom_topping", () -> new MushroomToppingBlock());
}
