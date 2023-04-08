package net.mcreator.thepizzatowermod.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.thepizzatowermod.block.model.TrappedToppinDisplayModel;
import net.mcreator.thepizzatowermod.block.display.TrappedToppinDisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class TrappedToppinDisplayItemRenderer extends GeoItemRenderer<TrappedToppinDisplayItem> {
	public TrappedToppinDisplayItemRenderer() {
		super(new TrappedToppinDisplayModel());
	}

	@Override
	public RenderType getRenderType(TrappedToppinDisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
