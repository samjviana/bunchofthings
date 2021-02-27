package net.ddns.samjviana.bunchofthings.block;

import java.util.Random;

import net.ddns.samjviana.bunchofthings.BunchOfThings;
import net.ddns.samjviana.bunchofthings.particles.ModParticleTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BushBlock;
import net.minecraft.client.renderer.FaceDirection;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.entity.Entity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.client.model.b3d.B3DModel.Face;
import net.minecraftforge.client.model.generators.ModelBuilder.FaceRotation;

public class YellowMushroomBlock extends BushBlock {
    protected static final VoxelShape SHAPE_1 = Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 10.0D, 12.0D);
    protected static final VoxelShape SHAPE_2 = Block.makeCuboidShape(2.0D, 0.0D, 3.0D, 15.0D, 10.0D, 15.0D);
    protected static final VoxelShape SHAPE_3 = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 15.0D, 10.0D, 15.0D);
    public static final IntegerProperty MUSHROOMS = IntegerProperty.create("mushrooms", 1, 3);
    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    public YellowMushroomBlock(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(LIT, Boolean.valueOf(false)).with(MUSHROOMS, Integer.valueOf(1)));
    }

    public BlockState getRandomState() {
        int rand = RANDOM.nextInt(3);
        switch (rand) {
            case 0:
                return this.stateContainer.getBaseState().with(LIT, Boolean.valueOf(false)).with(MUSHROOMS, Integer.valueOf(1));
            case 1:
                return this.stateContainer.getBaseState().with(LIT, Boolean.valueOf(false)).with(MUSHROOMS, Integer.valueOf(2));
            case 2:
                return this.stateContainer.getBaseState().with(LIT, Boolean.valueOf(false)).with(MUSHROOMS, Integer.valueOf(3));
        }
        return this.stateContainer.getBaseState().with(LIT, Boolean.valueOf(false)).with(MUSHROOMS, Integer.valueOf(1));
    }

    public BlockState getWithCount(int count) {
        switch (count) {
            case 0:
                return this.stateContainer.getBaseState().with(LIT, Boolean.valueOf(false)).with(MUSHROOMS, Integer.valueOf(1));
            case 1:
                return this.stateContainer.getBaseState().with(LIT, Boolean.valueOf(false)).with(MUSHROOMS, Integer.valueOf(2));
            case 2:
                return this.stateContainer.getBaseState().with(LIT, Boolean.valueOf(false)).with(MUSHROOMS, Integer.valueOf(3));
        }
        return this.stateContainer.getBaseState().with(LIT, Boolean.valueOf(false)).with(MUSHROOMS, Integer.valueOf(1));
    }

    @Override
    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        Vector3d vector3d = state.getOffset(worldIn, pos);
        switch (state.get(MUSHROOMS)) {
            case 1:
            default:
                return SHAPE_1.withOffset(vector3d.x, vector3d.y, vector3d.z);
            case 2:
                return SHAPE_2.withOffset(vector3d.x, vector3d.y, vector3d.z);
            case 3:
                return SHAPE_3.withOffset(vector3d.x, vector3d.y, vector3d.z);
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockState blockstate = context.getWorld().getBlockState(context.getPos());
        if (blockstate.isIn(this)) {
            return blockstate.with(MUSHROOMS, Integer.valueOf(Math.min(3, blockstate.get(MUSHROOMS) + 1)));
        }
        return super.getStateForPlacement(context);
    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if (!worldIn.getBlockState(pos).get(LIT)) {
            worldIn.setBlockState(pos, worldIn.getBlockState(pos).with(LIT, Boolean.valueOf(true)), 3);
        }

        super.onEntityCollision(state, worldIn, pos, entityIn);
    }
    
    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (!stateIn.isValidPosition(worldIn, currentPos)) {
            return Blocks.AIR.getDefaultState();
        } 
        return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Override
    public boolean isReplaceable(BlockState state, BlockItemUseContext useContext) {
        return useContext.getItem().getItem() == this.asItem() && state.get(MUSHROOMS) < 3 ? true : super.isReplaceable(state, useContext);    }

    @Override
    protected void fillStateContainer(Builder<Block, BlockState> builder) {
        builder.add(LIT, MUSHROOMS);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if (state.get(LIT)) {
            worldIn.setBlockState(pos, state.with(LIT, Boolean.valueOf(false)), 3);
        }
    }

    @Override
    public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
        return 11;
    }

    @Override
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        super.animateTick(stateIn, worldIn, pos, rand);
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                for (int k = -1; k <= 1; k++) {
                    BlockPos blockpos = pos.add(i, j, k);
                    if (!worldIn.getBlockState(blockpos).isOpaqueCube(worldIn, blockpos)) {
                        double d1 = i * rand.nextDouble() * 2.0D;
                        double d2 = j * rand.nextDouble() * 2.0D;
                        double d3 = k * rand.nextDouble() * 2.0D;
                        if (rand.nextInt(100) <= (5 * stateIn.get(MUSHROOMS))) {
                            worldIn.addParticle(ModParticleTypes.YELLOW_MUSHROOM_GLOW_PARTICLE.get(), (double)pos.getX() + d1, (double)pos.getY() + d2 + 0.5D, (double)pos.getZ() + d3, 0.00D, 0.01D, 0.00D);
                        }
                    }
                }
            }
        }
    }
}
