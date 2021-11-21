package net.ddns.samjviana.bunchofthings.item;

import net.ddns.samjviana.bunchofthings.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTab {
	public static final CreativeModeTab BLOCKS = new CreativeModeTab(CreativeModeTab.getGroupCountSafe(), "blocks") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ModBlocks.YELLOW_MUSHROOM.get());
		}
	};
	public static final CreativeModeTab ITEMS = new CreativeModeTab(CreativeModeTab.getGroupCountSafe(), "items") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ModBlocks.YELLOW_MUSHROOM.get());
		}
	};
}
