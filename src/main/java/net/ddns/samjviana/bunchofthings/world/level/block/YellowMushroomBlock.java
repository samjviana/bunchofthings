package net.ddns.samjviana.bunchofthings.world.level.block;

import java.util.Random;

import net.ddns.samjviana.bunchofthings.core.particles.ModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class YellowMushroomBlock extends BushBlock {
	public static final int MAX_MUSHROOMS = 3;
	public static final IntegerProperty MUSHROOMS = IntegerProperty.create("mushrooms", 1, 3);
	public static final BooleanProperty LIT = BlockStateProperties.LIT;
    protected static final VoxelShape SHAPE_1 = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 10.0D, 12.0D);
    protected static final VoxelShape SHAPE_2 = Block.box(3.0D, 0.0D, 2.0D, 13.0D, 10.0D, 15.0D);
    protected static final VoxelShape SHAPE_3 = Block.box(2.0D, 0.0D, 1.0D, 13.0D, 10.0D, 15.0D);

	public YellowMushroomBlock(Properties properties) {
		super(properties.lightLevel(YellowMushroomBlock::calculateLightLevel));
		this.registerDefaultState(this.stateDefinition.any().setValue(MUSHROOMS, Integer.valueOf(1)).setValue(LIT, Boolean.valueOf(false)));
	}

	private static int calculateLightLevel(BlockState state) {
		if (state.getValue(LIT)) {
			double x = state.getValue(MUSHROOMS);
			double lightLevel = (-1 * Math.pow(x, 2)) + (8 * x) - 5;
			return (int) Math.round(lightLevel);
		}
		else {
			return 0;
		}
	}

	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
		builder.add(MUSHROOMS, LIT);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockState blockState = context.getLevel().getBlockState(context.getClickedPos());		
		if (blockState.is(this)) {

			return blockState.setValue(MUSHROOMS, Integer.valueOf(Math.min(MAX_MUSHROOMS, blockState.getValue(MUSHROOMS) + 1)));
		}
		return super.getStateForPlacement(context);
	}

	@Override
	@SuppressWarnings("deprecation")
	public void entityInside(BlockState state, Level level, BlockPos pos, Entity entityIn) {
		if (!state.getValue(LIT)) {
			level.setBlock(pos, state.setValue(LIT, Boolean.valueOf(true)), 3);
		}
		super.entityInside(state, level, pos, entityIn);
	}

	@Override
	@SuppressWarnings("deprecation")
	public void randomTick(BlockState state, ServerLevel levelIn, BlockPos pos, RandomSource random) {
		if (state.getValue(LIT)) {
			levelIn.setBlock(pos, state.setValue(LIT, Boolean.valueOf(false)), 3);
		}
		super.randomTick(state, levelIn, pos, random);
	}

	@Override
	@SuppressWarnings("deprecation")
	public VoxelShape getShape(BlockState state, BlockGetter levelIn, BlockPos pos, CollisionContext context) {
		Vec3 vec3 = state.getOffset(levelIn, pos);
		int rand = new Random().nextInt(4);
		Rotation rotation;
		switch (rand) {
			case 0:
			default:
				rotation = Rotation.NONE;
			case 1:
				rotation = Rotation.CLOCKWISE_90;
			case 2:
				rotation = Rotation.CLOCKWISE_180;
			case 3:
				rotation = Rotation.COUNTERCLOCKWISE_90;
		}
		rotate(state, rotation);
		switch (state.getValue(MUSHROOMS)) {
			case 1:
			default:
				return SHAPE_1.move(vec3.x, vec3.y, vec3.z);
			case 2:
				return SHAPE_2.move(vec3.x, vec3.y, vec3.z);
			case 3:
				return SHAPE_3.move(vec3.x, vec3.y, vec3.z);
		}
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
		return state.getValue(MUSHROOMS) < 3 ? true : super.canBeReplaced(state, context);
	}

	@Override
	public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
		/*int i = pos.getX();
		int j = pos.getY();
		int k = pos.getZ();
		double d0 = (double)i + random.nextDouble();
		double d1 = (double)j + 0.7D;
		double d2 = (double)k + random.nextDouble();
		level.addParticle(ModParticleTypes.YELLOW_MUSHROOM_GLOW_PARTICLE.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
		BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
  
		for(int l = 0; l < 14; ++l) {
		   blockpos$mutableblockpos.set(i + Mth.nextInt(random, -10, 10), j - random.nextInt(10), k + Mth.nextInt(random, -10, 10));
		   BlockState blockstate = level.getBlockState(blockpos$mutableblockpos);
		   if (!blockstate.isCollisionShapeFullBlock(level, blockpos$mutableblockpos)) {
			level.addParticle(ModParticleTypes.YELLOW_MUSHROOM_GLOW_PARTICLE.get(), (double)blockpos$mutableblockpos.getX() + random.nextDouble(), (double)blockpos$mutableblockpos.getY() + random.nextDouble(), (double)blockpos$mutableblockpos.getZ() + random.nextDouble(), 0.0D, 0.0D, 0.0D);
		   }
		}*/
		super.animateTick(state, level, pos, random);
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				for (int k = -1; k <= 1; k++) {
					BlockPos blockPos = pos.offset(i, j, k);
					if(!level.getBlockState(blockPos).isSolidRender(level, blockPos)) {
						double d1 = i * random.nextDouble() * 2.0D;
						double d2 = j * random.nextDouble() * 2.0D;
						double d3 = k * random.nextDouble() * 2.0D;
						if (random.nextInt(100) <= (5 * state.getValue(MUSHROOMS))) {
							level.addParticle(ModParticleTypes.YELLOW_MUSHROOM_GLOW_PARTICLE.get(), (double)pos.getX() + d1, (double)pos.getY() + d2 + 0.5D, (double)pos.getZ() + d3, 0.00D, 0.01D, 0.00D);
						}
					}
				}
			}
		}
	}

    public BlockState getWithCount(int count) {
        switch (count) {
            case 0:
                return this.stateDefinition.any().setValue(LIT, Boolean.valueOf(false)).setValue(MUSHROOMS, Integer.valueOf(1));
            case 1:
                return this.stateDefinition.any().setValue(LIT, Boolean.valueOf(false)).setValue(MUSHROOMS, Integer.valueOf(2));
            case 2:
                return this.stateDefinition.any().setValue(LIT, Boolean.valueOf(false)).setValue(MUSHROOMS, Integer.valueOf(3));
        }
        return this.stateDefinition.any().setValue(LIT, Boolean.valueOf(false)).setValue(MUSHROOMS, Integer.valueOf(1));
    }

    public BlockState getRandomState() {
		int randState = new Random().nextInt(3);
        switch (randState) {
            case 0:
                return this.stateDefinition.any().setValue(LIT, Boolean.valueOf(false)).setValue(MUSHROOMS, Integer.valueOf(1));
            case 1:
                return this.stateDefinition.any().setValue(LIT, Boolean.valueOf(false)).setValue(MUSHROOMS, Integer.valueOf(2));
            case 2:
                return this.stateDefinition.any().setValue(LIT, Boolean.valueOf(false)).setValue(MUSHROOMS, Integer.valueOf(3));
        }
        return this.stateDefinition.any().setValue(LIT, Boolean.valueOf(false)).setValue(MUSHROOMS, Integer.valueOf(1));
    }
}
