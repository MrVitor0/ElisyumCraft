package com.elisyum.elisyumcraft.events;

import com.elisyum.elisyumcraft.ElisyumCraft;
import com.elisyum.elisyumcraft.entity.ElisyumEntityTypes;
import com.elisyum.elisyumcraft.entity.custom.NurtleEntity;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = ElisyumCraft.MOD_ID)
    public static class ForgeEvents{

    }

    @Mod.EventBusSubscriber(modid = ElisyumCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {

        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event){
            event.put(ElisyumEntityTypes.NURTLE.get(), NurtleEntity.setAttributes());
        }

    }
}
