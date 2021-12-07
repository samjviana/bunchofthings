package net.ddns.samjviana.bunchofthings.block;

import net.ddns.samjviana.bunchofthings.state.properties.Colors;
import net.ddns.samjviana.bunchofthings.state.properties.ModBlockStateProperties;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.piston.PistonHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.PistonType;

public class ColoredStickyPistonHeadBlock extends PistonHeadBlock {
	public static final EnumProperty<Colors> COLOR = ModBlockStateProperties.COLOR;

	public ColoredStickyPistonHeadBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(
			FACING, 
			Direction.NORTH
		).setValue(
			TYPE, 
			PistonType.STICKY
		).setValue(
			SHORT,
			Boolean.valueOf(false)
		).setValue(
			COLOR,
			Colors.LIME
		));
	}
	
	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
		builder.add(COLOR);
		super.createBlockStateDefinition(builder);
	}
}
