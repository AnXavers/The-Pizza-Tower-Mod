package net.mcreator.thepizzatowermod.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thepizzatowermod.block.display.PineappleToppingDisplayItem;

public class PineappleToppingDisplayModel extends AnimatedGeoModel<PineappleToppingDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(PineappleToppingDisplayItem animatable) {
		return new ResourceLocation("the_pizza_tower_mod", "animations/pineapple_topping.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PineappleToppingDisplayItem animatable) {
		return new ResourceLocation("the_pizza_tower_mod", "geo/pineapple_topping.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PineappleToppingDisplayItem entity) {
		return new ResourceLocation("the_pizza_tower_mod", "textures/blocks/pat_texture.png");
	}
}
