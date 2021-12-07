package net.ddns.samjviana.bunchofthings.block;

import net.ddns.samjviana.bunchofthings.BunchOfThings;
import net.ddns.samjviana.bunchofthings.state.properties.Colors;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.level.block.piston.PistonBaseBlock;
import net.ddns.samjviana.bunchofthings.block.ColoredStickyPistonHeadBlock;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BunchOfThings.MODID);

	public static final RegistryObject<Block> YELLOW_MUSHROOM = BLOCKS.register("yellow_mushroom", () -> {
		return new YellowMushroomBlock(BlockBehaviour.Properties.of(
			Material.PLANT, MaterialColor.COLOR_YELLOW
		).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).lightLevel((state) -> {
			if (state.getValue(YellowMushroomBlock.LIT)) {
				return 4 * state.getValue(YellowMushroomBlock.MUSHROOMS);
			}
			return 0;
		}));
	});
	public static final RegistryObject<Block> COLORED_STICKY_PISTON = BLOCKS.register("red_sticky_piston", () -> {
		return new ColoredStickyPiston(
			BlockBehaviour.Properties.of(Material.PISTON).strength(1.5f).isRedstoneConductor(
				(blockState, level, blockPos) -> false
			).isSuffocating(
				(blockState, level, blockPos) -> !blockState.getValue(PistonBaseBlock.EXTENDED)
			).isViewBlocking(
				(blockState, level, blockPos) -> !blockState.getValue(PistonBaseBlock.EXTENDED)
			),
			Colors.RED
		);
	});
	public static final RegistryObject<Block> COLORED_STICKY_PISTON_HEAD = BLOCKS.register("colored_sticky_piston_head", () -> {
		return new ColoredStickyPistonHeadBlock(BlockBehaviour.Properties.of(Material.PISTON).strength(1.5f).noDrops());
	});
	public static final RegistryObject<Block> WHITE_SLIME_BLOCK = BLOCKS.register("white_slime_block", () -> { 
		return new ColoredSlimeBlock(BlockBehaviour.Properties.of(Material.CLAY).friction(0.8f).sound(SoundType.SLIME_BLOCK).noOcclusion());
	});
	public static final RegistryObject<Block> ORANGE_SLIME_BLOCK = BLOCKS.register("orange_slime_block", () -> { 
		return new ColoredSlimeBlock(BlockBehaviour.Properties.of(Material.CLAY).friction(0.8f).sound(SoundType.SLIME_BLOCK).noOcclusion());
	});
	public static final RegistryObject<Block> MAGENTA_SLIME_BLOCK = BLOCKS.register("magenta_slime_block", () -> { 
		return new ColoredSlimeBlock(BlockBehaviour.Properties.of(Material.CLAY).friction(0.8f).sound(SoundType.SLIME_BLOCK).noOcclusion());
	});
	public static final RegistryObject<Block> LIGHT_BLUE_SLIME_BLOCK = BLOCKS.register("light_blue_slime_block", () -> { 
		return new ColoredSlimeBlock(BlockBehaviour.Properties.of(Material.CLAY).friction(0.8f).sound(SoundType.SLIME_BLOCK).noOcclusion());
	});
	public static final RegistryObject<Block> YELLOW_SLIME_BLOCK = BLOCKS.register("yellow_slime_block", () -> { 
		return new ColoredSlimeBlock(BlockBehaviour.Properties.of(Material.CLAY).friction(0.8f).sound(SoundType.SLIME_BLOCK).noOcclusion());
	});
	public static final RegistryObject<Block> LIME_SLIME_BLOCK = BLOCKS.register("lime_slime_block", () -> { 
		return new ColoredSlimeBlock(BlockBehaviour.Properties.of(Material.CLAY).friction(0.8f).sound(SoundType.SLIME_BLOCK).noOcclusion());
	});
	public static final RegistryObject<Block> PINK_SLIME_BLOCK = BLOCKS.register("pink_slime_block", () -> { 
		return new ColoredSlimeBlock(BlockBehaviour.Properties.of(Material.CLAY).friction(0.8f).sound(SoundType.SLIME_BLOCK).noOcclusion());
	});
	public static final RegistryObject<Block> GRAY_SLIME_BLOCK = BLOCKS.register("gray_slime_block", () -> { 
		return new ColoredSlimeBlock(BlockBehaviour.Properties.of(Material.CLAY).friction(0.8f).sound(SoundType.SLIME_BLOCK).noOcclusion());
	});
	public static final RegistryObject<Block> LIGHT_GRAY_SLIME_BLOCK = BLOCKS.register("light_gray_slime_block", () -> { 
		return new ColoredSlimeBlock(BlockBehaviour.Properties.of(Material.CLAY).friction(0.8f).sound(SoundType.SLIME_BLOCK).noOcclusion());
	});
	public static final RegistryObject<Block> CYAN_SLIME_BLOCK = BLOCKS.register("cyan_slime_block", () -> { 
		return new ColoredSlimeBlock(BlockBehaviour.Properties.of(Material.CLAY).friction(0.8f).sound(SoundType.SLIME_BLOCK).noOcclusion());
	});
	public static final RegistryObject<Block> PURPLE_SLIME_BLOCK = BLOCKS.register("purple_slime_block", () -> { 
		return new ColoredSlimeBlock(BlockBehaviour.Properties.of(Material.CLAY).friction(0.8f).sound(SoundType.SLIME_BLOCK).noOcclusion());
	});
	public static final RegistryObject<Block> BLUE_SLIME_BLOCK = BLOCKS.register("blue_slime_block", () -> { 
		return new ColoredSlimeBlock(BlockBehaviour.Properties.of(Material.CLAY).friction(0.8f).sound(SoundType.SLIME_BLOCK).noOcclusion());
	});
	public static final RegistryObject<Block> BROWN_SLIME_BLOCK = BLOCKS.register("brown_slime_block", () -> { 
		return new ColoredSlimeBlock(BlockBehaviour.Properties.of(Material.CLAY).friction(0.8f).sound(SoundType.SLIME_BLOCK).noOcclusion());
	});
	public static final RegistryObject<Block> GREEN_SLIME_BLOCK = BLOCKS.register("green_slime_block", () -> { 
		return new ColoredSlimeBlock(BlockBehaviour.Properties.of(Material.CLAY).friction(0.8f).sound(SoundType.SLIME_BLOCK).noOcclusion());
	});
	public static final RegistryObject<Block> RED_SLIME_BLOCK = BLOCKS.register("red_slime_block", () -> { 
		return new ColoredSlimeBlock(BlockBehaviour.Properties.of(Material.CLAY).friction(0.8f).sound(SoundType.SLIME_BLOCK).noOcclusion());
	});
	public static final RegistryObject<Block> BLACK_SLIME_BLOCK = BLOCKS.register("black_slime_block", () -> { 
		return new ColoredSlimeBlock(BlockBehaviour.Properties.of(Material.CLAY).friction(0.8f).sound(SoundType.SLIME_BLOCK).noOcclusion());
	});

	

	/*public static final RegistryObject<Block> COLORED_STICKY_PISTON_HEAD = BLOCKS.register("colored_sticky_piston_head", () -> new ColoredStickyPistonHeadBlock(AbstractBlock.Properties.create(Material.PISTON).hardnessAndResistance(1.5f).noDrops()));
    public static final RegistryObject<Block> YELLOW_MUSHROOM = BLOCKS.register("yellow_mushroom", () -> new YellowMushroomBlock(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().zeroHardnessAndResistance().notSolid().sound(SoundType.PLANT)));

    private static ColoredStickyPistonBlock createColoredStickyPiston(Colors color) {
        AbstractBlock.IPositionPredicate abstractblock$ipositionpredicate = (p_235440_0_, p_235440_1_, p_235440_2_) -> {
            return !p_235440_0_.get(ColoredStickyPistonBlock.EXTENDED);
        };
        return new ColoredStickyPistonBlock(color, true, AbstractBlock.Properties.create(Material.PISTON).hardnessAndResistance(1.5F).setOpaque(ModBlocks::isntSolid).setSuffocates(abstractblock$ipositionpredicate).setBlocksVision(abstractblock$ipositionpredicate));
    }

    private static boolean isntSolid(BlockState state, IBlockReader reader, BlockPos pos) {
        return false;
    }

    public static void registerStickyPistons() {
        for (int i = 0; i < Colors.values().length; i++) {
            Colors color = Colors.values()[i];
            BLOCKS.register(color.toString() + "_sticky_piston", () -> createColoredStickyPiston(color));
        }
    }*/
}
