package net.mcreator.thepizzatowermod.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thepizzatowermod.block.display.MushroomToppingDisplayItem;

public class MushroomToppingDisplayModel extends AnimatedGeoModel<MushroomToppingDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(MushroomToppingDisplayItem animatable) {
		return new ResourceLocation("the_pizza_tower_mod", "animations/mushroom_topping.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MushroomToppingDisplayItem animatable) {
		return new ResourceLocation("the_pizza_tower_mod", "geo/mushroom_topping.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MushroomToppingDisplayItem entity) {
		return new ResourceLocation("the_pizza_tower_mod", "textures/blocks/mt_texture.png");
	}
}
