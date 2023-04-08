package net.mcreator.thepizzatowermod.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thepizzatowermod.block.display.MortCubeDisplayItem;

public class MortCubeDisplayModel extends AnimatedGeoModel<MortCubeDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(MortCubeDisplayItem animatable) {
		return new ResourceLocation("the_pizza_tower_mod", "animations/mort_cube.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MortCubeDisplayItem animatable) {
		return new ResourceLocation("the_pizza_tower_mod", "geo/mort_cube.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MortCubeDisplayItem entity) {
		return new ResourceLocation("the_pizza_tower_mod", "textures/blocks/mort_cube.png");
	}
}
