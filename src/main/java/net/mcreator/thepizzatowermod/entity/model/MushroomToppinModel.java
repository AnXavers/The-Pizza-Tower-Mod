package net.mcreator.thepizzatowermod.entity.model;

import software.bernie.geckolib3.model.provider.data.EntityModelData;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.thepizzatowermod.entity.MushroomToppinEntity;

public class MushroomToppinModel extends AnimatedGeoModel<MushroomToppinEntity> {
	@Override
	public ResourceLocation getAnimationResource(MushroomToppinEntity entity) {
		return new ResourceLocation("the_pizza_tower_mod", "animations/mushroom_toppin.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MushroomToppinEntity entity) {
		return new ResourceLocation("the_pizza_tower_mod", "geo/mushroom_toppin.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MushroomToppinEntity entity) {
		return new ResourceLocation("the_pizza_tower_mod", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(MushroomToppinEntity animatable, int instanceId, AnimationEvent animationEvent) {
		super.setCustomAnimations(animatable, instanceId, animationEvent);
		IBone head = this.getAnimationProcessor().getBone("Core");
		EntityModelData extraData = (EntityModelData) animationEvent.getExtraDataOfType(EntityModelData.class).get(0);
		AnimationData manager = animatable.getFactory().getOrCreateAnimationData(instanceId);
		int unpausedMultiplier = !Minecraft.getInstance().isPaused() || manager.shouldPlayWhilePaused ? 1 : 0;
		head.setRotationX(head.getRotationX() + extraData.headPitch * ((float) Math.PI / 180F) * unpausedMultiplier);
		head.setRotationY(head.getRotationY() + extraData.netHeadYaw * ((float) Math.PI / 180F) * unpausedMultiplier);
	}
}
