package net.ddns.samjviana.bunchofthings.item;

import java.rmi.registry.RegistryHandler;

import net.ddns.samjviana.bunchofthings.BunchOfThings;
import net.ddns.samjviana.bunchofthings.block.ModBlocks;
import net.ddns.samjviana.bunchofthings.enchantment.ModEnchantments;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;
import net.minecraftforge.registries.RegistryManager;

public class ModItemGroup {
    public static final ItemGroup BLOCKS = new ItemGroup(ItemGroup.getGroupCountSafe(), "blocks") {
        @Override
        public ItemStack createIcon() {
            Block block = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(BunchOfThings.MODID, "black_slime_block"));
            return new ItemStack(block);
        }
    };
    public static final ItemGroup ITEMS = new ItemGroup(ItemGroup.getGroupCountSafe(), "items") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.BLACK_SLIME_BALL.get());
        }
    };
    public static final ItemGroup ENCHANTMENTS = new ItemGroup(ItemGroup.getGroupCountSafe(), "enchantments") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Items.ENCHANTED_BOOK);
        }

        @Override
        public void fill(NonNullList<ItemStack> items) {
            for(int i = ModEnchantments.GRASS_WALKER.get().getMinLevel(); i <= ModEnchantments.GRASS_WALKER.get().getMaxLevel(); ++i) {
                items.add(EnchantedBookItem.getEnchantedItemStack(new EnchantmentData(ModEnchantments.GRASS_WALKER.get(), i)));
            }
            super.fill(items);
        };
    };
    public static final ItemGroup ENTITIES = new ItemGroup(ItemGroup.getGroupCountSafe(), "entities") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.COLORED_SLIME_SPAWN_EGG.get());
        }
    };
}