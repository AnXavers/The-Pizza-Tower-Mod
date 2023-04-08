package net.mcreator.thepizzatowermod.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.thepizzatowermod.block.model.CheeseToppingDisplayModel;
import net.mcreator.thepizzatowermod.block.display.CheeseToppingDisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class CheeseToppingDisplayItemRenderer extends GeoItemRenderer<CheeseToppingDisplayItem> {
	public CheeseToppingDisplayItemRenderer() {
		super(new CheeseToppingDisplayModel());
	}

	@Override
	public RenderType getRenderType(CheeseToppingDisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
