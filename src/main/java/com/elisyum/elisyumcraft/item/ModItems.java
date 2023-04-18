package com.elisyum.elisyumcraft.item;

import com.elisyum.elisyumcraft.ElisyumCraft;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ElisyumCraft.MODID);

    public static final RegistryObject<Item> CaioLittleSword = ITEMS.register("caio_little_sword",
            () -> new Item(new Item.Properties()));
 

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}