package com.elisyum.elisyumcraft.item.custom;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class ElisyumAxeItem extends AxeItem  {
    public ElisyumAxeItem(Tier tier, float attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
       
        if (!level.isClientSide && hand == InteractionHand.MAIN_HAND) {
          outputRandomNumber(player);
          player.getCooldowns().addCooldown(this, 20);
        }
       
        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> list, TooltipFlag flag) {
        
        if(Screen.hasShiftDown()){
            list.add(Component.literal("Banana de Pijamas de 0 a 25!").withStyle(ChatFormatting.AQUA));
        }else{
            list.add(Component.literal("Segure SHIFT para mais informações").withStyle(ChatFormatting.YELLOW));
        }

        super.appendHoverText(stack, level, list, flag);
    }

    private void outputRandomNumber(Player player) {
        int min = 1;
        int max = 25;
        int random = getRandomNumberInRange(min, max);
        player.sendSystemMessage( Component.literal("Your random number is: " + random));
    }

    private int getRandomNumberInRange(int min, int max) {
        return (int) ((Math.random() * ((max - min) + 1)) + min);
    }
}
