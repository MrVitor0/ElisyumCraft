package com.elisyum.elisyumcraft.entity.client;

import com.elisyum.elisyumcraft.ElisyumCraft;
import com.elisyum.elisyumcraft.entity.custom.NurtleEntity;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class NurtleModel extends AnimatedGeoModel<NurtleEntity> {


    @Override
    public ResourceLocation getAnimationResource(NurtleEntity animatable) {
        return new ResourceLocation(ElisyumCraft.MOD_ID, "animations/nurtle.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(NurtleEntity object) {
        return new ResourceLocation(ElisyumCraft.MOD_ID, "geo/nurtle.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NurtleEntity object) {
        return new ResourceLocation(ElisyumCraft.MOD_ID, "textures/entity/nurtle_texture.png");
    }
    
}
