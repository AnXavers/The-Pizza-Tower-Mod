package net.mcreator.thepizzatowermod.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thepizzatowermod.block.entity.TomatoToppingTileEntity;

public class TomatoToppingBlockModel extends AnimatedGeoModel<TomatoToppingTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(TomatoToppingTileEntity animatable) {
		return new ResourceLocation("the_pizza_tower_mod", "animations/tomato_topping.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(TomatoToppingTileEntity animatable) {
		return new ResourceLocation("the_pizza_tower_mod", "geo/tomato_topping.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TomatoToppingTileEntity entity) {
		return new ResourceLocation("the_pizza_tower_mod", "textures/blocks/tot_texture.png");
	}
}
