
package net.mcreator.thepizzatowermod.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.thepizzatowermod.entity.model.MushroomToppinModel;
import net.mcreator.thepizzatowermod.entity.MushroomToppinEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class MushroomToppinRenderer extends GeoEntityRenderer<MushroomToppinEntity> {
	public MushroomToppinRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new MushroomToppinModel());
		this.shadowRadius = 0.5f;
	}

	@Override
	public RenderType getRenderType(MushroomToppinEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}

	@Override
	protected float getDeathMaxRotation(MushroomToppinEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
