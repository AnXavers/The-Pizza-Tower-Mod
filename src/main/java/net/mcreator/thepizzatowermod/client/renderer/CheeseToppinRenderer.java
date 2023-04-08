
package net.mcreator.thepizzatowermod.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.thepizzatowermod.entity.model.CheeseToppinModel;
import net.mcreator.thepizzatowermod.entity.CheeseToppinEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class CheeseToppinRenderer extends GeoEntityRenderer<CheeseToppinEntity> {
	public CheeseToppinRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new CheeseToppinModel());
		this.shadowRadius = 0.5f;
	}

	@Override
	public RenderType getRenderType(CheeseToppinEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}

	@Override
	protected float getDeathMaxRotation(CheeseToppinEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
