package com.elisyum.elisyumcraft.entity.client;

import com.elisyum.elisyumcraft.ElisyumCraft;
import com.elisyum.elisyumcraft.entity.custom.ChamperEntity;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ChamperModel extends AnimatedGeoModel<ChamperEntity> {


    @Override
    public ResourceLocation getAnimationResource(ChamperEntity animatable) {
        return new ResourceLocation(ElisyumCraft.MOD_ID, "animations/champer.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(ChamperEntity object) {
        return new ResourceLocation(ElisyumCraft.MOD_ID, "geo/champer.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ChamperEntity object) {
        return new ResourceLocation(ElisyumCraft.MOD_ID, "textures/entity/champer_texture.png");
    }
    
}
