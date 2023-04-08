package net.mcreator.thepizzatowermod.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thepizzatowermod.block.display.TomatoToppingDisplayItem;

public class TomatoToppingDisplayModel extends AnimatedGeoModel<TomatoToppingDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(TomatoToppingDisplayItem animatable) {
		return new ResourceLocation("the_pizza_tower_mod", "animations/tomato_topping.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(TomatoToppingDisplayItem animatable) {
		return new ResourceLocation("the_pizza_tower_mod", "geo/tomato_topping.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TomatoToppingDisplayItem entity) {
		return new ResourceLocation("the_pizza_tower_mod", "textures/blocks/tot_texture.png");
	}
}
