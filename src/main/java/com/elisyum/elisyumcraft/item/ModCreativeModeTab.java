package com.elisyum.elisyumcraft.item;


import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab ELISYUM_TAB = new CreativeModeTab("elisyumtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.DefreezyIngot.get());
        }
    };
}