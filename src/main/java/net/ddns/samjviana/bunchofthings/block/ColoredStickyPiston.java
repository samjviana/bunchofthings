package net.ddns.samjviana.bunchofthings.block;

import net.ddns.samjviana.bunchofthings.state.properties.Colors;
import net.ddns.samjviana.bunchofthings.state.properties.ModBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WoolCarpetBlock;
import net.minecraft.world.level.block.piston.PistonBaseBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class ColoredStickyPiston extends PistonBaseBlock {
	public static final EnumProperty<Colors> COLOR = ModBlockStateProperties.COLOR;
	private final boolean isSticky = true;

	public ColoredStickyPiston(Properties properties, Colors color) {
		super(true, properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(
			FACING, Direction.NORTH
		).setValue(
			EXTENDED,
			Boolean.valueOf(false)
		).setValue(
			COLOR,
			color
		));
	}

	private boolean moveBlocks(Level worldIn, BlockPos pos, Direction directionIn, boolean extending) {
		BlockPos blockPos = pos.relative(directionIn);
		if (!extending && worldIn.getBlockState(blockPos).is(ModBlocks.COLORED_STICKY_PISTON_HEAD.get())) {
			
		}

		return false;
	}

	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
		builder.add(COLOR);
		super.createBlockStateDefinition(builder);
	}
}
