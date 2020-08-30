package net.ddns.samjviana.morethings.item;

import net.ddns.samjviana.morethings.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {
    public static final ItemGroup BLOCKS = new ItemGroup(ItemGroup.getGroupCountSafe(), "blocks") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.BLACK_SLIME_BLOCK.get());
        }
    };
    public static final ItemGroup ITEMS = new ItemGroup(ItemGroup.getGroupCountSafe(), "items") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.BLACK_SLIME_BALL.get());
        }
    };
}