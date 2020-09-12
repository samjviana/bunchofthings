package net.ddns.samjviana.bunchofthings.tags;

import net.minecraft.block.Block;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ITagCollectionSupplier;
import net.minecraft.tags.TagRegistry;
import net.minecraft.tags.TagRegistryManager;
import net.minecraft.tags.ITag.INamedTag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlockTags {
    public static final TagRegistry<Block> BLOCK_TAGS = TagRegistryManager.func_242196_a(new ResourceLocation("block"), ITagCollectionSupplier::func_241835_a);

    public static final INamedTag<Block> COLORED_SLIME_BLOCK = BLOCK_TAGS.func_232937_a_("colored_slime_block");
    public static final INamedTag<Block> COLORED_STICKY_PISTON_BLOCK = BLOCK_TAGS.func_232937_a_("colored_sticky_piston_block");
}