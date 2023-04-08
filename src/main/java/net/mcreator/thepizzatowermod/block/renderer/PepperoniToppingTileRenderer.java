package net.mcreator.thepizzatowermod.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.thepizzatowermod.block.model.PepperoniToppingBlockModel;
import net.mcreator.thepizzatowermod.block.entity.PepperoniToppingTileEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class PepperoniToppingTileRenderer extends GeoBlockRenderer<PepperoniToppingTileEntity> {
	public PepperoniToppingTileRenderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
		super(rendererDispatcherIn, new PepperoniToppingBlockModel());
	}

	@Override
	public RenderType getRenderType(PepperoniToppingTileEntity animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
