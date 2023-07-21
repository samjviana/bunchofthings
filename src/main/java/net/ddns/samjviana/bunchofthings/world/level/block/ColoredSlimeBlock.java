package net.ddns.samjviana.bunchofthings.world.level.block;

import net.ddns.samjviana.bunchofthings.state.properties.Colors;
import net.ddns.samjviana.bunchofthings.state.properties.ModBlockStateProperties;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HoneyBlock;
import net.minecraft.world.level.block.SlimeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class ColoredSlimeBlock extends SlimeBlock {
    public static final EnumProperty<Colors> COLOR = ModBlockStateProperties.COLOR;

    public ColoredSlimeBlock(Properties properties, Colors color) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(COLOR, color));
    }

    @Override
    public boolean isStickyBlock(BlockState state) {
        return true;
    }

    @Override
    public boolean skipRendering(BlockState state, BlockState adjacent, Direction side) {
        return adjacent.is(this) ? true : super.skipRendering(state, adjacent, side);
    }

    @Override
    public boolean canStickTo(BlockState state, BlockState other) {
        if (state.getBlock() == Blocks.HONEY_BLOCK && other.getBlock() == Blocks.SLIME_BLOCK) return false;
        if (state.getBlock() == Blocks.SLIME_BLOCK && other.getBlock() == Blocks.HONEY_BLOCK) return false;

        if (other.getBlock() instanceof ColoredSlimeBlock) {
            Colors currentColor = state.getValue(COLOR);
            Colors otherColor = other.getValue(COLOR);
            if (currentColor != otherColor) return false;
            return true;
        }
       
        return state.isStickyBlock() || other.isStickyBlock();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(COLOR);
    } 
}
