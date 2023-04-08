package net.mcreator.thepizzatowermod.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thepizzatowermod.entity.CheeseToppinEntity;

public class CheeseToppinModel extends AnimatedGeoModel<CheeseToppinEntity> {
	@Override
	public ResourceLocation getAnimationResource(CheeseToppinEntity entity) {
		return new ResourceLocation("the_pizza_tower_mod", "animations/cheese_toppin.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CheeseToppinEntity entity) {
		return new ResourceLocation("the_pizza_tower_mod", "geo/cheese_toppin.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CheeseToppinEntity entity) {
		return new ResourceLocation("the_pizza_tower_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

}
