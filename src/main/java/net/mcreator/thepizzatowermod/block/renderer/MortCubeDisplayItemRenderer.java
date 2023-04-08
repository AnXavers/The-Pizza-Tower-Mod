package net.mcreator.thepizzatowermod.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.thepizzatowermod.block.model.MortCubeDisplayModel;
import net.mcreator.thepizzatowermod.block.display.MortCubeDisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class MortCubeDisplayItemRenderer extends GeoItemRenderer<MortCubeDisplayItem> {
	public MortCubeDisplayItemRenderer() {
		super(new MortCubeDisplayModel());
	}

	@Override
	public RenderType getRenderType(MortCubeDisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
