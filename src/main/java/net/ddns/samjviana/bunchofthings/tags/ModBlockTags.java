package net.ddns.samjviana.bunchofthings.tags;

import net.minecraft.core.Registry;
import net.minecraft.tags.StaticTagHelper;
import net.minecraft.tags.StaticTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModBlockTags {
	public static final StaticTagHelper<Block> BLOCK_TAGS = StaticTags.create(Registry.BLOCK_REGISTRY, "tags/blocks");
	public static final StaticTagHelper<Item> ITEM_TAGS = StaticTags.create(Registry.ITEM_REGISTRY, "tags/items");

	public static final Tag.Named<Block> COLORED_SLIME_BLOCK = BLOCK_TAGS.bind("colored_slime_block");

	public static final Tag.Named<Item> MUSHROOMS = ITEM_TAGS.bind("mushrooms");
}
