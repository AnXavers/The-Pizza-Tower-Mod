
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thepizzatowermod.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class ThePizzaTowerModModTabs {
	public static CreativeModeTab TAB_PIZZA_TOWER_BLOCKS;
	public static CreativeModeTab TAB_PIZZA_TOWER_ITEMS;
	public static CreativeModeTab TAB_PIZZA_TOWER_MOBS;

	public static void load() {
		TAB_PIZZA_TOWER_BLOCKS = new CreativeModeTab("tabpizza_tower_blocks") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(ThePizzaTowerModModBlocks.TRAPPED_TOPPIN.get());
			}

			@Override
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
		TAB_PIZZA_TOWER_ITEMS = new CreativeModeTab("tabpizza_tower_items") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(ThePizzaTowerModModItems.PIZZA_DELUXE.get());
			}

			@Override
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
		TAB_PIZZA_TOWER_MOBS = new CreativeModeTab("tabpizza_tower_mobs") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(ThePizzaTowerModModItems.MUSHROOM_TOPPIN_SPAWN_EGG.get());
			}

			@Override
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
	}
}
