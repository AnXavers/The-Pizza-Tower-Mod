
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thepizzatowermod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.item.Item;

import net.mcreator.thepizzatowermod.item.UnexpectancyPart3Item;
import net.mcreator.thepizzatowermod.item.UnexpectancyPart2Item;
import net.mcreator.thepizzatowermod.item.UnexpectancyPart1Item;
import net.mcreator.thepizzatowermod.item.TombstoneArizonaItem;
import net.mcreator.thepizzatowermod.item.TimeForASmackdownItem;
import net.mcreator.thepizzatowermod.item.PizzaTimeItem;
import net.mcreator.thepizzatowermod.item.PizzaDeluxeItem;
import net.mcreator.thepizzatowermod.item.ColdSpagghetiItem;
import net.mcreator.thepizzatowermod.block.display.TrappedToppinDisplayItem;
import net.mcreator.thepizzatowermod.block.display.TomatoToppingDisplayItem;
import net.mcreator.thepizzatowermod.block.display.PineappleToppingDisplayItem;
import net.mcreator.thepizzatowermod.block.display.PepperoniToppingDisplayItem;
import net.mcreator.thepizzatowermod.block.display.MushroomToppingDisplayItem;
import net.mcreator.thepizzatowermod.block.display.MortCubeDisplayItem;
import net.mcreator.thepizzatowermod.block.display.CheeseToppingDisplayItem;
import net.mcreator.thepizzatowermod.ThePizzaTowerModMod;

public class ThePizzaTowerModModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, ThePizzaTowerModMod.MODID);
	public static final RegistryObject<Item> PIZZA_DELUXE = REGISTRY.register("pizza_deluxe", () -> new PizzaDeluxeItem());
	public static final RegistryObject<Item> TRAPPED_TOPPIN = REGISTRY.register(ThePizzaTowerModModBlocks.TRAPPED_TOPPIN.getId().getPath(),
			() -> new TrappedToppinDisplayItem(ThePizzaTowerModModBlocks.TRAPPED_TOPPIN.get(), new Item.Properties().tab(ThePizzaTowerModModTabs.TAB_PIZZA_TOWER_BLOCKS)));
	public static final RegistryObject<Item> MUSHROOM_TOPPIN_SPAWN_EGG = REGISTRY.register("mushroom_toppin_spawn_egg",
			() -> new ForgeSpawnEggItem(ThePizzaTowerModModEntities.MUSHROOM_TOPPIN, -8232383, -2893077, new Item.Properties().tab(ThePizzaTowerModModTabs.TAB_PIZZA_TOWER_MOBS)));
	public static final RegistryObject<Item> COLD_SPAGGHETI = REGISTRY.register("cold_spaggheti", () -> new ColdSpagghetiItem());
	public static final RegistryObject<Item> TOMBSTONE_ARIZONA = REGISTRY.register("tombstone_arizona", () -> new TombstoneArizonaItem());
	public static final RegistryObject<Item> UNEXPECTANCY_PART_1 = REGISTRY.register("unexpectancy_part_1", () -> new UnexpectancyPart1Item());
	public static final RegistryObject<Item> UNEXPECTANCY_PART_2 = REGISTRY.register("unexpectancy_part_2", () -> new UnexpectancyPart2Item());
	public static final RegistryObject<Item> UNEXPECTANCY_PART_3 = REGISTRY.register("unexpectancy_part_3", () -> new UnexpectancyPart3Item());
	public static final RegistryObject<Item> TIME_FOR_A_SMACKDOWN = REGISTRY.register("time_for_a_smackdown", () -> new TimeForASmackdownItem());
	public static final RegistryObject<Item> CHEESE_TOPPIN_SPAWN_EGG = REGISTRY.register("cheese_toppin_spawn_egg",
			() -> new ForgeSpawnEggItem(ThePizzaTowerModModEntities.CHEESE_TOPPIN, -1061529, -2893077, new Item.Properties().tab(ThePizzaTowerModModTabs.TAB_PIZZA_TOWER_MOBS)));
	public static final RegistryObject<Item> JOHN_PILLAR_SPAWN_EGG = REGISTRY.register("john_pillar_spawn_egg",
			() -> new ForgeSpawnEggItem(ThePizzaTowerModModEntities.JOHN_PILLAR, -12962237, -7567718, new Item.Properties().tab(ThePizzaTowerModModTabs.TAB_PIZZA_TOWER_MOBS)));
	public static final RegistryObject<Item> PIZZA_TIME = REGISTRY.register("pizza_time", () -> new PizzaTimeItem());
	public static final RegistryObject<Item> MORT_CUBE = REGISTRY.register(ThePizzaTowerModModBlocks.MORT_CUBE.getId().getPath(),
			() -> new MortCubeDisplayItem(ThePizzaTowerModModBlocks.MORT_CUBE.get(), new Item.Properties().tab(ThePizzaTowerModModTabs.TAB_PIZZA_TOWER_BLOCKS)));
	public static final RegistryObject<Item> TOMATO_TOPPING = REGISTRY.register(ThePizzaTowerModModBlocks.TOMATO_TOPPING.getId().getPath(),
			() -> new TomatoToppingDisplayItem(ThePizzaTowerModModBlocks.TOMATO_TOPPING.get(), new Item.Properties().tab(ThePizzaTowerModModTabs.TAB_PIZZA_TOWER_BLOCKS)));
	public static final RegistryObject<Item> PINEAPPLE_TOPPING = REGISTRY.register(ThePizzaTowerModModBlocks.PINEAPPLE_TOPPING.getId().getPath(),
			() -> new PineappleToppingDisplayItem(ThePizzaTowerModModBlocks.PINEAPPLE_TOPPING.get(), new Item.Properties().tab(ThePizzaTowerModModTabs.TAB_PIZZA_TOWER_BLOCKS)));
	public static final RegistryObject<Item> CHEESE_TOPPING = REGISTRY.register(ThePizzaTowerModModBlocks.CHEESE_TOPPING.getId().getPath(),
			() -> new CheeseToppingDisplayItem(ThePizzaTowerModModBlocks.CHEESE_TOPPING.get(), new Item.Properties().tab(ThePizzaTowerModModTabs.TAB_PIZZA_TOWER_BLOCKS)));
	public static final RegistryObject<Item> PEPPERONI_TOPPING = REGISTRY.register(ThePizzaTowerModModBlocks.PEPPERONI_TOPPING.getId().getPath(),
			() -> new PepperoniToppingDisplayItem(ThePizzaTowerModModBlocks.PEPPERONI_TOPPING.get(), new Item.Properties().tab(ThePizzaTowerModModTabs.TAB_PIZZA_TOWER_BLOCKS)));
	public static final RegistryObject<Item> MUSHROOM_TOPPING = REGISTRY.register(ThePizzaTowerModModBlocks.MUSHROOM_TOPPING.getId().getPath(),
			() -> new MushroomToppingDisplayItem(ThePizzaTowerModModBlocks.MUSHROOM_TOPPING.get(), new Item.Properties().tab(ThePizzaTowerModModTabs.TAB_PIZZA_TOWER_BLOCKS)));
}
