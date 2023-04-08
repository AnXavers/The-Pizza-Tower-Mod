package net.mcreator.thepizzatowermod.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.thepizzatowermod.block.model.CheeseToppingBlockModel;
import net.mcreator.thepizzatowermod.block.entity.CheeseToppingTileEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class CheeseToppingTileRenderer extends GeoBlockRenderer<CheeseToppingTileEntity> {
	public CheeseToppingTileRenderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
		super(rendererDispatcherIn, new CheeseToppingBlockModel());
	}

	@Override
	public RenderType getRenderType(CheeseToppingTileEntity animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
