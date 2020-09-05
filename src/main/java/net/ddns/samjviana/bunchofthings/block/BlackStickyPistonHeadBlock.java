package net.ddns.samjviana.bunchofthings.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PistonBlock;
import net.minecraft.block.PistonHeadBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.properties.PistonType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class BlackStickyPistonHeadBlock extends PistonHeadBlock {
    public BlackStickyPistonHeadBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        return super.isValidPosition(state, worldIn, pos);
    }

    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn,
            BlockPos currentPos, BlockPos facingPos) {
        if (facing.getOpposite() == stateIn.get(FACING)) {
            if (!stateIn.isValidPosition(worldIn, currentPos)) {
                return stateIn;
            }
        }
        if (!stateIn.isValidPosition(worldIn, currentPos)) {
            if (facing.getOpposite() == stateIn.get(FACING)) {
                return Blocks.AIR.getDefaultState();
            }
        }
        return stateIn;
    }
}
