package net.ddns.samjviana.bunchofthings.tags;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ITagCollectionSupplier;
import net.minecraft.tags.TagRegistry;
import net.minecraft.tags.TagRegistryManager;
import net.minecraft.tags.ITag.INamedTag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlockTags {
    public static final TagRegistry<Block> BLOCK_TAGS = TagRegistryManager.create(new ResourceLocation("block"), ITagCollectionSupplier::getBlockTags);
    public static final TagRegistry<Item> ITEM_TAGS = TagRegistryManager.create(new ResourceLocation("item"), ITagCollectionSupplier::getItemTags);

    public static final INamedTag<Block> COLORED_SLIME_BLOCK = BLOCK_TAGS.createTag("colored_slime_block");
    public static final INamedTag<Block> COLORED_STICKY_PISTON_BLOCK = BLOCK_TAGS.createTag("colored_sticky_piston_block");
    public static final INamedTag<Item> MUSHROOMS = ITEM_TAGS.createTag("mushrooms");
}