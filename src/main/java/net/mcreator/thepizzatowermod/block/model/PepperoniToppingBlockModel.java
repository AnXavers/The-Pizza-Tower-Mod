package net.mcreator.thepizzatowermod.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thepizzatowermod.block.entity.PepperoniToppingTileEntity;

public class PepperoniToppingBlockModel extends AnimatedGeoModel<PepperoniToppingTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(PepperoniToppingTileEntity animatable) {
		return new ResourceLocation("the_pizza_tower_mod", "animations/pepperoni_topping.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PepperoniToppingTileEntity animatable) {
		return new ResourceLocation("the_pizza_tower_mod", "geo/pepperoni_topping.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PepperoniToppingTileEntity entity) {
		return new ResourceLocation("the_pizza_tower_mod", "textures/blocks/pt_texture.png");
	}
}
