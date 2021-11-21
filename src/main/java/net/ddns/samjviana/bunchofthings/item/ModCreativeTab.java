package net.ddns.samjviana.bunchofthings.item;

import net.ddns.samjviana.bunchofthings.block.ModBlocks;
import net.ddns.samjviana.bunchofthings.enchantment.ModEnchantments;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentInstance;

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

	public static final CreativeModeTab ENCHANTMENTS = new CreativeModeTab(CreativeModeTab.getGroupCountSafe(), "enchantments") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(Items.ENCHANTED_BOOK);
		}

        @Override
		public void fillItemList(NonNullList<ItemStack> items) {
			for (int i = ModEnchantments.GRASS_WALKER.get().getMinLevel(); i <= ModEnchantments.GRASS_WALKER.get().getMaxLevel(); i++) {
				items.add(EnchantedBookItem.createForEnchantment(new EnchantmentInstance(ModEnchantments.GRASS_WALKER.get(), i)));
			}
			super.fillItemList(items);
		};
	};
}
