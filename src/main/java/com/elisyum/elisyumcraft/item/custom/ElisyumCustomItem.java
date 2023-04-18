package com.elisyum.elisyumcraft.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ElisyumCustomItem extends  Item {
    public ElisyumCustomItem(Properties properties) {
        super(properties);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
       
        if (!level.isClientSide && hand == InteractionHand.MAIN_HAND) {
          outputRandomNumber(player);
          player.getCooldowns().addCooldown(this, 20);
        }
       
        return super.use(level, player, hand);
    }

    private void outputRandomNumber(Player player) {
        int min = 1;
        int max = 100;
        int random = getRandomNumberInRange(min, max);
        player.sendSystemMessage( Component.literal("Your random number is: " + random));
    }

    private int getRandomNumberInRange(int min, int max) {
        return (int) ((Math.random() * ((max - min) + 1)) + min);
    }
}
