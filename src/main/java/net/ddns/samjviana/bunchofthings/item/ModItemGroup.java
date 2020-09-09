package net.ddns.samjviana.bunchofthings.item;

import java.rmi.registry.RegistryHandler;

import net.ddns.samjviana.bunchofthings.BunchOfThings;
import net.ddns.samjviana.bunchofthings.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
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
}