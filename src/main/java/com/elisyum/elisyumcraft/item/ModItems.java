package com.elisyum.elisyumcraft.item;

import com.elisyum.elisyumcraft.ElisyumCraft;
import com.elisyum.elisyumcraft.item.custom.ElisyumCustomItem;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ElisyumCraft.MOD_ID);

    public static final RegistryObject<Item> DefreezyIngot = ITEMS.register("defreezy_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ELISYUM_TAB)));


    public static final RegistryObject<Item> DefreezyAxe = ITEMS.register("defreezy_axe",
    () -> new ElisyumCustomItem(new Item.Properties().tab(ModCreativeModeTab.ELISYUM_TAB)));
    
  

        



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}