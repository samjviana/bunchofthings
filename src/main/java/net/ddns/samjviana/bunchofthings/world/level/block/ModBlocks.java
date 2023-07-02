package net.ddns.samjviana.bunchofthings.world.level.block;

import net.ddns.samjviana.bunchofthings.BunchOfThings;
import net.ddns.samjviana.bunchofthings.block.ColoredStickyPistonHeadBlock;
import net.ddns.samjviana.bunchofthings.state.properties.Colors;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.piston.PistonBaseBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BunchOfThings.MODID);

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

	public static final RegistryObject<Block> YELLOW_MUSHROOM = BLOCKS.register("yellow_mushroom", () -> {
		return new YellowMushroomBlock(BlockBehaviour.Properties.of(
			Material.PLANT, MaterialColor.COLOR_YELLOW
		).noCollission().randomTicks().instabreak().sound(SoundType.GRASS));
	});

	public static final RegistryObject<Block> WHITE_STICKY_PISTON = BLOCKS.register("white_sticky_piston", () -> {
		return new ColoredStickyPiston(
			BlockBehaviour.Properties.of(Material.PISTON).strength(1.5f).isRedstoneConductor(
				(blockState, level, blockPos) -> false
			).isSuffocating(
				(blockState, level, blockPos) -> !blockState.getValue(PistonBaseBlock.EXTENDED)
			).isViewBlocking(
				(blockState, level, blockPos) -> !blockState.getValue(PistonBaseBlock.EXTENDED)
			),
			Colors.WHITE
		);
	});
	public static final RegistryObject<Block> ORANGE_STICKY_PISTON = BLOCKS.register("orange_sticky_piston", () -> {
		return new ColoredStickyPiston(
			BlockBehaviour.Properties.of(Material.PISTON).strength(1.5f).isRedstoneConductor(
				(blockState, level, blockPos) -> false
			).isSuffocating(
				(blockState, level, blockPos) -> !blockState.getValue(PistonBaseBlock.EXTENDED)
			).isViewBlocking(
				(blockState, level, blockPos) -> !blockState.getValue(PistonBaseBlock.EXTENDED)
			),
			Colors.ORANGE
		);
	});
	public static final RegistryObject<Block> MAGENTA_STICKY_PISTON = BLOCKS.register("magenta_sticky_piston", () -> {
		return new ColoredStickyPiston(
			BlockBehaviour.Properties.of(Material.PISTON).strength(1.5f).isRedstoneConductor(
				(blockState, level, blockPos) -> false
			).isSuffocating(
				(blockState, level, blockPos) -> !blockState.getValue(PistonBaseBlock.EXTENDED)
			).isViewBlocking(
				(blockState, level, blockPos) -> !blockState.getValue(PistonBaseBlock.EXTENDED)
			),
			Colors.MAGENTA
		);
	});
	public static final RegistryObject<Block> LIGHT_BLUE_STICKY_PISTON = BLOCKS.register("light_blue_sticky_piston", () -> {
		return new ColoredStickyPiston(
			BlockBehaviour.Properties.of(Material.PISTON).strength(1.5f).isRedstoneConductor(
				(blockState, level, blockPos) -> false
			).isSuffocating(
				(blockState, level, blockPos) -> !blockState.getValue(PistonBaseBlock.EXTENDED)
			).isViewBlocking(
				(blockState, level, blockPos) -> !blockState.getValue(PistonBaseBlock.EXTENDED)
			),
			Colors.LIGHT_BLUE
		);
	});
	public static final RegistryObject<Block> YELLOW_STICKY_PISTON = BLOCKS.register("yellow_sticky_piston", () -> {
		return new ColoredStickyPiston(
			BlockBehaviour.Properties.of(Material.PISTON).strength(1.5f).isRedstoneConductor(
				(blockState, level, blockPos) -> false
			).isSuffocating(
				(blockState, level, blockPos) -> !blockState.getValue(PistonBaseBlock.EXTENDED)
			).isViewBlocking(
				(blockState, level, blockPos) -> !blockState.getValue(PistonBaseBlock.EXTENDED)
			),
			Colors.YELLOW
		);
	});
	public static final RegistryObject<Block> LIME_STICKY_PISTON = BLOCKS.register("lime_sticky_piston", () -> {
		return new ColoredStickyPiston(
			BlockBehaviour.Properties.of(Material.PISTON).strength(1.5f).isRedstoneConductor(
				(blockState, level, blockPos) -> false
			).isSuffocating(
				(blockState, level, blockPos) -> !blockState.getValue(PistonBaseBlock.EXTENDED)
			).isViewBlocking(
				(blockState, level, blockPos) -> !blockState.getValue(PistonBaseBlock.EXTENDED)
			),
			Colors.LIME
		);
	});
	public static final RegistryObject<Block> PINK_STICKY_PISTON = BLOCKS.register("pink_sticky_piston", () -> {
		return new ColoredStickyPiston(
			BlockBehaviour.Properties.of(Material.PISTON).strength(1.5f).isRedstoneConductor(
				(blockState, level, blockPos) -> false
			).isSuffocating(
				(blockState, level, blockPos) -> !blockState.getValue(PistonBaseBlock.EXTENDED)
			).isViewBlocking(
				(blockState, level, blockPos) -> !blockState.getValue(PistonBaseBlock.EXTENDED)
			),
			Colors.PINK
		);
	});
	public static final RegistryObject<Block> GRAY_STICKY_PISTON = BLOCKS.register("gray_sticky_piston", () -> {
		return new ColoredStickyPiston(
			BlockBehaviour.Properties.of(Material.PISTON).strength(1.5f).isRedstoneConductor(
				(blockState, level, blockPos) -> false
			).isSuffocating(
				(blockState, level, blockPos) -> !blockState.getValue(PistonBaseBlock.EXTENDED)
			).isViewBlocking(
				(blockState, level, blockPos) -> !blockState.getValue(PistonBaseBlock.EXTENDED)
			),
			Colors.GRAY
		);
	});
	public static final RegistryObject<Block> LIGHT_GRAY_STICKY_PISTON = BLOCKS.register("light_gray_sticky_piston", () -> {
		return new ColoredStickyPiston(
			BlockBehaviour.Properties.of(Material.PISTON).strength(1.5f).sound(SoundType.STONE).isRedstoneConductor(
				(blockState, level, blockPos) -> false
			).isSuffocating(
				(blockState, level, blockPos) -> !blockState.getValue(PistonBaseBlock.EXTENDED)
			),
			Colors.LIGHT_GRAY
		);
	});
	public static final RegistryObject<Block> CYAN_STICKY_PISTON = BLOCKS.register("cyan_sticky_piston", () -> {
		return new ColoredStickyPiston(
			BlockBehaviour.Properties.of(Material.PISTON).strength(1.5f).sound(SoundType.STONE).isRedstoneConductor(
				(blockState, level, blockPos) -> false
			).isSuffocating(
				(blockState, level, blockPos) -> !blockState.getValue(PistonBaseBlock.EXTENDED) 
			),
			Colors.CYAN
		);
	});
	public static final RegistryObject<Block> PURPLE_STICKY_PISTON = BLOCKS.register("purple_sticky_piston", () -> {
		return new ColoredStickyPiston(
			BlockBehaviour.Properties.of(Material.PISTON).strength(1.5f).sound(SoundType.STONE).isRedstoneConductor(
				(blockState, level, blockPos) -> false
			).isSuffocating(
				(blockState, level, blockPos) -> !blockState.getValue(PistonBaseBlock.EXTENDED) 
			),
			Colors.PURPLE
		);
	});
	public static final RegistryObject<Block> BLUE_STICKY_PISTON = BLOCKS.register("blue_sticky_piston", () -> {
		return new ColoredStickyPiston(
			BlockBehaviour.Properties.of(Material.PISTON).strength(1.5f).sound(SoundType.STONE).isRedstoneConductor(
				(blockState, level, blockPos) -> false
			).isSuffocating(
				(blockState, level, blockPos) -> !blockState.getValue(PistonBaseBlock.EXTENDED) 
			),
			Colors.BLUE
		);
	});
	public static final RegistryObject<Block> BROWN_STICKY_PISTON = BLOCKS.register("brown_sticky_piston", () -> {
		return new ColoredStickyPiston(
			BlockBehaviour.Properties.of(Material.PISTON).strength(1.5f).sound(SoundType.STONE).isRedstoneConductor(
				(blockState, level, blockPos) -> false
			).isSuffocating(
				(blockState, level, blockPos) -> !blockState.getValue(PistonBaseBlock.EXTENDED) 
			),
			Colors.BROWN
		);
	});
	public static final RegistryObject<Block> GREEN_STICKY_PISTON = BLOCKS.register("green_sticky_piston", () -> {
		return new ColoredStickyPiston(
			BlockBehaviour.Properties.of(Material.PISTON).strength(1.5f).sound(SoundType.STONE).isRedstoneConductor(
				(blockState, level, blockPos) -> false
			).isSuffocating(
				(blockState, level, blockPos) -> !blockState.getValue(PistonBaseBlock.EXTENDED) 
			),
			Colors.GREEN
		);
	});
	public static final RegistryObject<Block> RED_STICKY_PISTON = BLOCKS.register("red_sticky_piston", () -> {
		return new ColoredStickyPiston(
			BlockBehaviour.Properties.of(Material.PISTON).strength(1.5f).sound(SoundType.STONE).isRedstoneConductor(
				(blockState, level, blockPos) -> false
			).isSuffocating(
				(blockState, level, blockPos) -> !blockState.getValue(PistonBaseBlock.EXTENDED) 
			),
			Colors.RED
		);
	});
	public static final RegistryObject<Block> BLACK_STICKY_PISTON = BLOCKS.register("black_sticky_piston", () -> {
		return new ColoredStickyPiston(
			BlockBehaviour.Properties.of(Material.PISTON).strength(1.5f).sound(SoundType.STONE).isRedstoneConductor(
				(blockState, level, blockPos) -> false
			).isSuffocating(
				(blockState, level, blockPos) -> !blockState.getValue(PistonBaseBlock.EXTENDED) 
			),
			Colors.BLACK
		);
	});

	public static final RegistryObject<Block> COLORED_STICKY_PISTON_HEAD = BLOCKS.register("colored_sticky_piston_head", () -> {
		return new ColoredStickyPistonHeadBlock(BlockBehaviour.Properties.of(Material.PISTON).strength(1.5f).noLootTable());
	});
}
