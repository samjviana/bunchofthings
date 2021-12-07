package net.ddns.samjviana.bunchofthings.block;

import net.ddns.samjviana.bunchofthings.BunchOfThings;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.SlimeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.ddns.samjviana.bunchofthings.block.ColoredStickyPistonHeadBlock;

public class ColoredSlimeBlock extends SlimeBlock {
	public ColoredSlimeBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	public boolean isStickyBlock(BlockState state) {
		return true;
	}

	@Override
	public boolean skipRendering(BlockState state, BlockState adjacent, Direction side) {
		return adjacent.is(this) ? true : super.skipRendering(state, adjacent, side);
	}
}
