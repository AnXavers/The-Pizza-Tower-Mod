package net.mcreator.thepizzatowermod.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.thepizzatowermod.entity.JohnPillarEntity;

public class JohnPillarModel extends AnimatedGeoModel<JohnPillarEntity> {
	@Override
	public ResourceLocation getAnimationResource(JohnPillarEntity entity) {
		return new ResourceLocation("the_pizza_tower_mod", "animations/john_pillar.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(JohnPillarEntity entity) {
		return new ResourceLocation("the_pizza_tower_mod", "geo/john_pillar.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(JohnPillarEntity entity) {
		return new ResourceLocation("the_pizza_tower_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

}
