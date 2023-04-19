package com.elisyum.elisyumcraft.entity;

import com.elisyum.elisyumcraft.ElisyumCraft;
import com.elisyum.elisyumcraft.entity.custom.NurtleEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ElisyumEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = 
        DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ElisyumCraft.MOD_ID);

    public static final RegistryObject<EntityType<NurtleEntity>> NURTLE = ENTITY_TYPES.register("nurtle_entity", 
        () -> EntityType.Builder.of(NurtleEntity::new, MobCategory.MONSTER)
            .sized(0.4f, 1.5f)
            .build(new ResourceLocation(ElisyumCraft.MOD_ID, "nurtle_entity").toString()));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
