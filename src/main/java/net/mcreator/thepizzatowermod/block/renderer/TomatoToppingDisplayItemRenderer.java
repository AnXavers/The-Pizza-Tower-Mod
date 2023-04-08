package net.mcreator.thepizzatowermod.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.thepizzatowermod.block.model.TomatoToppingDisplayModel;
import net.mcreator.thepizzatowermod.block.display.TomatoToppingDisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class TomatoToppingDisplayItemRenderer extends GeoItemRenderer<TomatoToppingDisplayItem> {
	public TomatoToppingDisplayItemRenderer() {
		super(new TomatoToppingDisplayModel());
	}

	@Override
	public RenderType getRenderType(TomatoToppingDisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
