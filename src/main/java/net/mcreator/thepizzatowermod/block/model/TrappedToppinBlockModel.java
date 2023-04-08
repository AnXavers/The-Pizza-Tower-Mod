package net.mcreator.thepizzatowermod.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thepizzatowermod.block.entity.TrappedToppinTileEntity;

public class TrappedToppinBlockModel extends AnimatedGeoModel<TrappedToppinTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(TrappedToppinTileEntity animatable) {
		return new ResourceLocation("the_pizza_tower_mod", "animations/trapped_toppin.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(TrappedToppinTileEntity animatable) {
		return new ResourceLocation("the_pizza_tower_mod", "geo/trapped_toppin.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TrappedToppinTileEntity entity) {
		return new ResourceLocation("the_pizza_tower_mod", "textures/blocks/tt_texture.png");
	}
}
