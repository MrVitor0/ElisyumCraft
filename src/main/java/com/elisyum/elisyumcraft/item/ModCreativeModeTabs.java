package com.elisyum.elisyumcraft.item;

import com.elisyum.elisyumcraft.ElisyumCraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ElisyumCraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab ELISYUM_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        ELISYUM_TAB = event.registerCreativeModeTab(new ResourceLocation(ElisyumCraft.MODID, "elisyumtab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.CaioLittleSword.get()))
                        .title(Component.translatable("creativemodetab.elisyumtab")));
    }
}