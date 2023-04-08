
package net.mcreator.thepizzatowermod.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.thepizzatowermod.entity.model.JohnPillarModel;
import net.mcreator.thepizzatowermod.entity.JohnPillarEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class JohnPillarRenderer extends GeoEntityRenderer<JohnPillarEntity> {
	public JohnPillarRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new JohnPillarModel());
		this.shadowRadius = 3f;
	}

	@Override
	public RenderType getRenderType(JohnPillarEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}

	@Override
	protected float getDeathMaxRotation(JohnPillarEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
