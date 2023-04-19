package com.elisyum.elisyumcraft.entity.client;

import javax.annotation.Nullable;

import com.elisyum.elisyumcraft.ElisyumCraft;
import com.elisyum.elisyumcraft.entity.custom.ChamperEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ChamperRenderer extends GeoEntityRenderer<ChamperEntity> {

    public ChamperRenderer( EntityRendererProvider.Context renderManager) {
      super(renderManager, new ChamperModel());
      this.shadowRadius = 0.3f;
    }


    @Override
    public ResourceLocation getTextureLocation(ChamperEntity instance) {
        return new ResourceLocation(ElisyumCraft.MOD_ID, "textures/entity/champer_texture.png");
    }

    @Override
    public RenderType getRenderType(ChamperEntity animatable, float partialTicks, PoseStack stack,
            @Nullable MultiBufferSource renderTypeBuffer,
            @Nullable VertexConsumer vertexBuilder,
            int packedLightIn,
            ResourceLocation textureLocation) {
                


            stack.scale(0.8f, 0.8f, 0.8f);

            return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }


    
}
