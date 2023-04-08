package net.mcreator.thepizzatowermod.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.thepizzatowermod.block.model.PineappleToppingDisplayModel;
import net.mcreator.thepizzatowermod.block.display.PineappleToppingDisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class PineappleToppingDisplayItemRenderer extends GeoItemRenderer<PineappleToppingDisplayItem> {
	public PineappleToppingDisplayItemRenderer() {
		super(new PineappleToppingDisplayModel());
	}

	@Override
	public RenderType getRenderType(PineappleToppingDisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
