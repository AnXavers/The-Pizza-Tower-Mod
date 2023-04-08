package net.mcreator.thepizzatowermod.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thepizzatowermod.block.display.PepperoniToppingDisplayItem;

public class PepperoniToppingDisplayModel extends AnimatedGeoModel<PepperoniToppingDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(PepperoniToppingDisplayItem animatable) {
		return new ResourceLocation("the_pizza_tower_mod", "animations/pepperoni_topping.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PepperoniToppingDisplayItem animatable) {
		return new ResourceLocation("the_pizza_tower_mod", "geo/pepperoni_topping.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PepperoniToppingDisplayItem entity) {
		return new ResourceLocation("the_pizza_tower_mod", "textures/blocks/pt_texture.png");
	}
}
