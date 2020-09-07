package net.ddns.samjviana.bunchofthings.block;

import net.ddns.samjviana.bunchofthings.state.properties.Colors;
import net.ddns.samjviana.bunchofthings.state.properties.ModBlockStateProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PistonBlock;
import net.minecraft.block.PistonHeadBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.PistonType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class ColoredStickyPistonHeadBlock extends PistonHeadBlock {
    public static final EnumProperty<Colors> COLOR = ModBlockStateProperties.COLOR;

    public ColoredStickyPistonHeadBlock(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(
            FACING, Direction.NORTH
        ).with(
            TYPE, PistonType.STICKY
        ).with(
            SHORT, Boolean.valueOf(false)
        ).with(
            COLOR, Colors.LIME
        ));
    }
    
    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        return stateIn;
    }

    @Override
    protected void fillStateContainer(Builder<Block, BlockState> builder) {
        builder.add(COLOR);
        super.fillStateContainer(builder);
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        Direction direction = state.get(FACING);
        BlockPos blockPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ());

        if (direction.compareTo(Direction.UP) == 0) {
            worldIn.destroyBlock(blockPos.down(), false);
        }
        else if(direction.compareTo(Direction.DOWN) == 0) {
            worldIn.destroyBlock(blockPos.up(), false);
        }
        else if(direction.compareTo(Direction.EAST) == 0) {
            worldIn.destroyBlock(blockPos.west(), false);
        }
        else if(direction.compareTo(Direction.WEST) == 0) {
            worldIn.destroyBlock(blockPos.east(), false);
        }
        else if(direction.compareTo(Direction.NORTH) == 0) {
            worldIn.destroyBlock(blockPos.south(), false);
        }
        else if(direction.compareTo(Direction.SOUTH) == 0) {
            worldIn.destroyBlock(blockPos.north(), false);
        }

        super.onBlockHarvested(worldIn, pos, state, player);
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockState blockstate = worldIn.getBlockState(pos.offset(state.get(FACING).getOpposite()));
        return this.func_235682_a_(state, blockstate) || blockstate.isIn(Blocks.MOVING_PISTON) && blockstate.get(FACING) == state.get(FACING);
    }

    private boolean func_235682_a_(BlockState p_235682_1_, BlockState p_235682_2_) {
        Block block = ModBlocks.COLORED_STICKY_PISTON.get();
        return p_235682_2_.isIn(block) && p_235682_2_.get(ColoredStickyPistonBlock.EXTENDED) && p_235682_2_.get(FACING) == p_235682_1_.get(FACING);
    }

    @Override
    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        if (state.isValidPosition(worldIn, pos)) {
            BlockPos blockpos = pos.offset(state.get(FACING).getOpposite());
            worldIn.getBlockState(blockpos).neighborChanged(worldIn, blockpos, blockIn, fromPos, false);
        }
    }
}