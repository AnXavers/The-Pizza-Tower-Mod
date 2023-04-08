package net.mcreator.thepizzatowermod.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thepizzatowermod.block.display.CheeseToppingDisplayItem;

public class CheeseToppingDisplayModel extends AnimatedGeoModel<CheeseToppingDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(CheeseToppingDisplayItem animatable) {
		return new ResourceLocation("the_pizza_tower_mod", "animations/cheese_topping.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CheeseToppingDisplayItem animatable) {
		return new ResourceLocation("the_pizza_tower_mod", "geo/cheese_topping.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CheeseToppingDisplayItem entity) {
		return new ResourceLocation("the_pizza_tower_mod", "textures/blocks/ct_texture.png");
	}
}
