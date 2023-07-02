package net.ddns.samjviana.bunchofthings.tags;

import net.ddns.samjviana.bunchofthings.BunchOfThings;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModBlockTags {
	public static final TagKey<Block> COLORED_SLIME_BLOCK = BlockTags.create(new ResourceLocation(BunchOfThings.MODID, "colored_slime_block"));
	public static final TagKey<Item> MUSHROOMS = ItemTags.create(new ResourceLocation(BunchOfThings.MODID, "mushrooms"));
}
