package com.cewko.depositclick;

import java.util.function.Predicate;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemCarrotOnAStick;
import net.minecraft.item.ItemFishingRod;
import net.minecraft.item.ItemFlintAndSteel;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;

public final class NonEquipmentDepositPolicy implements Predicate<ItemStack> {

    @Override
    public boolean test(ItemStack stack) {
        if (stack == null || stack.stackSize <= 0) {
            return false;
        }

        Item item = stack.getItem();

        return !(
            item instanceof ItemTool ||
            item instanceof ItemHoe ||
            item instanceof ItemShears ||
            item instanceof ItemFishingRod ||
            item instanceof ItemFlintAndSteel ||
            item instanceof ItemCarrotOnAStick ||
            item instanceof ItemSword ||
            item instanceof ItemBow ||
            item instanceof ItemArmor
        );
    }
}
