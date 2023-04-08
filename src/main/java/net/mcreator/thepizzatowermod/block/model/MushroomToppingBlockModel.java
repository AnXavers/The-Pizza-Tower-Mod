package net.mcreator.thepizzatowermod.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thepizzatowermod.block.entity.MushroomToppingTileEntity;

public class MushroomToppingBlockModel extends AnimatedGeoModel<MushroomToppingTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(MushroomToppingTileEntity animatable) {
		return new ResourceLocation("the_pizza_tower_mod", "animations/mushroom_topping.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MushroomToppingTileEntity animatable) {
		return new ResourceLocation("the_pizza_tower_mod", "geo/mushroom_topping.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MushroomToppingTileEntity entity) {
		return new ResourceLocation("the_pizza_tower_mod", "textures/blocks/mt_texture.png");
	}
}
