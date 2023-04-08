
package net.mcreator.thepizzatowermod.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.thepizzatowermod.init.ThePizzaTowerModModTabs;

public class UnexpectancyPart2Item extends RecordItem {
	public UnexpectancyPart2Item() {
		super(2, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_pizza_tower_mod:unexpectancy_part_2")), new Item.Properties().tab(ThePizzaTowerModModTabs.TAB_PIZZA_TOWER_ITEMS).stacksTo(1).rarity(Rarity.RARE), 100);
	}
}
