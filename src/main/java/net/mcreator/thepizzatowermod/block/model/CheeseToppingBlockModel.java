package net.mcreator.thepizzatowermod.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thepizzatowermod.block.entity.CheeseToppingTileEntity;

public class CheeseToppingBlockModel extends AnimatedGeoModel<CheeseToppingTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(CheeseToppingTileEntity animatable) {
		return new ResourceLocation("the_pizza_tower_mod", "animations/cheese_topping.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CheeseToppingTileEntity animatable) {
		return new ResourceLocation("the_pizza_tower_mod", "geo/cheese_topping.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CheeseToppingTileEntity entity) {
		return new ResourceLocation("the_pizza_tower_mod", "textures/blocks/ct_texture.png");
	}
}
