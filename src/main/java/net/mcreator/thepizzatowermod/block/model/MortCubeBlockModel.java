package net.mcreator.thepizzatowermod.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thepizzatowermod.block.entity.MortCubeTileEntity;

public class MortCubeBlockModel extends AnimatedGeoModel<MortCubeTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(MortCubeTileEntity animatable) {
		return new ResourceLocation("the_pizza_tower_mod", "animations/mort_cube.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MortCubeTileEntity animatable) {
		return new ResourceLocation("the_pizza_tower_mod", "geo/mort_cube.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MortCubeTileEntity entity) {
		return new ResourceLocation("the_pizza_tower_mod", "textures/blocks/mort_cube.png");
	}
}
