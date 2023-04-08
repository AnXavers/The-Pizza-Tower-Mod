package net.mcreator.thepizzatowermod.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.thepizzatowermod.block.model.PepperoniToppingDisplayModel;
import net.mcreator.thepizzatowermod.block.display.PepperoniToppingDisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class PepperoniToppingDisplayItemRenderer extends GeoItemRenderer<PepperoniToppingDisplayItem> {
	public PepperoniToppingDisplayItemRenderer() {
		super(new PepperoniToppingDisplayModel());
	}

	@Override
	public RenderType getRenderType(PepperoniToppingDisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
