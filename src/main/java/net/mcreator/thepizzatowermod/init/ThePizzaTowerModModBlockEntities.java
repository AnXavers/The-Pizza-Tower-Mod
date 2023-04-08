
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thepizzatowermod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.thepizzatowermod.block.entity.TrappedToppinTileEntity;
import net.mcreator.thepizzatowermod.block.entity.TomatoToppingTileEntity;
import net.mcreator.thepizzatowermod.block.entity.PineappleToppingTileEntity;
import net.mcreator.thepizzatowermod.block.entity.PepperoniToppingTileEntity;
import net.mcreator.thepizzatowermod.block.entity.MushroomToppingTileEntity;
import net.mcreator.thepizzatowermod.block.entity.MortCubeTileEntity;
import net.mcreator.thepizzatowermod.block.entity.CheeseToppingTileEntity;
import net.mcreator.thepizzatowermod.ThePizzaTowerModMod;

public class ThePizzaTowerModModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ThePizzaTowerModMod.MODID);
	public static final RegistryObject<BlockEntityType<TrappedToppinTileEntity>> TRAPPED_TOPPIN = REGISTRY.register("trapped_toppin",
			() -> BlockEntityType.Builder.of(TrappedToppinTileEntity::new, ThePizzaTowerModModBlocks.TRAPPED_TOPPIN.get()).build(null));
	public static final RegistryObject<BlockEntityType<MortCubeTileEntity>> MORT_CUBE = REGISTRY.register("mort_cube", () -> BlockEntityType.Builder.of(MortCubeTileEntity::new, ThePizzaTowerModModBlocks.MORT_CUBE.get()).build(null));
	public static final RegistryObject<BlockEntityType<TomatoToppingTileEntity>> TOMATO_TOPPING = REGISTRY.register("tomato_topping",
			() -> BlockEntityType.Builder.of(TomatoToppingTileEntity::new, ThePizzaTowerModModBlocks.TOMATO_TOPPING.get()).build(null));
	public static final RegistryObject<BlockEntityType<PineappleToppingTileEntity>> PINEAPPLE_TOPPING = REGISTRY.register("pineapple_topping",
			() -> BlockEntityType.Builder.of(PineappleToppingTileEntity::new, ThePizzaTowerModModBlocks.PINEAPPLE_TOPPING.get()).build(null));
	public static final RegistryObject<BlockEntityType<CheeseToppingTileEntity>> CHEESE_TOPPING = REGISTRY.register("cheese_topping",
			() -> BlockEntityType.Builder.of(CheeseToppingTileEntity::new, ThePizzaTowerModModBlocks.CHEESE_TOPPING.get()).build(null));
	public static final RegistryObject<BlockEntityType<PepperoniToppingTileEntity>> PEPPERONI_TOPPING = REGISTRY.register("pepperoni_topping",
			() -> BlockEntityType.Builder.of(PepperoniToppingTileEntity::new, ThePizzaTowerModModBlocks.PEPPERONI_TOPPING.get()).build(null));
	public static final RegistryObject<BlockEntityType<MushroomToppingTileEntity>> MUSHROOM_TOPPING = REGISTRY.register("mushroom_topping",
			() -> BlockEntityType.Builder.of(MushroomToppingTileEntity::new, ThePizzaTowerModModBlocks.MUSHROOM_TOPPING.get()).build(null));

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
