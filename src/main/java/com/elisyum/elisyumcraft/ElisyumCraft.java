package com.elisyum.elisyumcraft;

import com.elisyum.elisyumcraft.item.ModItems;
import com.elisyum.elisyumcraft.item.ModCreativeModeTabs;
import com.elisyum.elisyumcraft.block.ModBlocks;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(ElisyumCraft.MODID)
public class ElisyumCraft
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "elisyumcraft";

    public ElisyumCraft()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if(event.getTab() == ModCreativeModeTabs.ELISYUM_TAB) {
            event.accept(ModItems.CaioLittleSword);
        }
    }
   
}
