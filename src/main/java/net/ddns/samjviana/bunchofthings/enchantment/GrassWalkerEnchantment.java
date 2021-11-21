package net.ddns.samjviana.bunchofthings.enchantment;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.block.state.properties.StairsShape;
import net.minecraft.world.level.block.state.properties.WallSide;

public class GrassWalkerEnchantment extends Enchantment {
	protected GrassWalkerEnchantment() {
		super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.ARMOR_FEET, new EquipmentSlot[] { EquipmentSlot.FEET });
	}

	@Override
	public int getMinCost(int level) {
		return level * 10;
	}

	@Override
	public int getMaxCost(int level) {
		return this.getMinCost(level) + 15;
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

	@Override
	public boolean isTreasureOnly() {
		return true;
	}

	public static void grassilizeNearby(Entity entity, int maxLevel) {
		Level world = entity.level;
		int level = maxLevel;
		BlockPos pos = entity.blockPosition();
		for (int x = -level; x <= level; x++) {
			for (int z = -level; z <= level; z++) {
				if (world.random.nextInt(100) < 95) {
					continue;
				}

				BlockPos spreadPos = pos.offset(x, -1, z);
				BlockState currentBlockState = world.getBlockState(new BlockPos(entity.getX(), entity.getY(), entity.getZ()));

				if (currentBlockState.getBlock() instanceof SlabBlock) {
					spreadPos = pos.offset(x, 0, z);
				}

				double distance = spreadPos.distSqr(pos.getX(), pos.getY(), pos.getZ(), false);
				double levelPow = (level * level) - 1;
				if (level == 1) {
					levelPow = 1;
				}
				if (distance > levelPow) {
					continue;
				}

				BlockState blockState = world.getBlockState(spreadPos);
				if (blockState.getBlock() == Blocks.AIR) {
					continue;
				}

				if (blockState.getBlock() == Blocks.DIRT) {
					world.setBlockAndUpdate(spreadPos, Blocks.GRASS_BLOCK.defaultBlockState());
				}
				else if (blockState.getBlock() == Blocks.COBBLESTONE) {
					world.setBlockAndUpdate(spreadPos, Blocks.MOSSY_COBBLESTONE.defaultBlockState());
				}
				else if (blockState.getBlock() == Blocks.COBBLESTONE_STAIRS) {
					StairsShape stairsShape = blockState.getValue(StairBlock.SHAPE);
					Half stairsHalf = blockState.getValue(StairBlock.HALF);
					Direction stairsFacing = blockState.getValue(StairBlock.FACING);
					Boolean waterlogged = blockState.getValue(StairBlock.WATERLOGGED);					
					world.setBlockAndUpdate(spreadPos, Blocks.MOSSY_COBBLESTONE_STAIRS.defaultBlockState().setValue(
						StairBlock.SHAPE, stairsShape
					).setValue(
						StairBlock.HALF, stairsHalf
					).setValue(
						StairBlock.FACING, stairsFacing
					).setValue(
						StairBlock.WATERLOGGED,
						waterlogged
					));
				}
				else if (blockState.getBlock() == Blocks.COBBLESTONE_SLAB) {
					SlabType slabType = blockState.getValue(SlabBlock.TYPE);
					Boolean waterlogged = blockState.getValue(SlabBlock.WATERLOGGED);					
					world.setBlockAndUpdate(spreadPos, Blocks.MOSSY_COBBLESTONE_SLAB.defaultBlockState().setValue(
						SlabBlock.TYPE, 
						slabType
					).setValue(
						SlabBlock.WATERLOGGED,
						waterlogged
					));
				}
				else if (blockState.getBlock() == Blocks.COBBLESTONE_WALL) {
					WallSide east = blockState.getValue(WallBlock.EAST_WALL);
					WallSide west = blockState.getValue(WallBlock.WEST_WALL);
					WallSide north = blockState.getValue(WallBlock.NORTH_WALL);
					WallSide south = blockState.getValue(WallBlock.SOUTH_WALL);
					Boolean up = blockState.getValue(WallBlock.UP);
					Boolean waterlogged = blockState.getValue(WallBlock.WATERLOGGED);					
					world.setBlockAndUpdate(spreadPos, Blocks.MOSSY_COBBLESTONE_WALL.defaultBlockState().setValue(
						WallBlock.EAST_WALL,
						east
					).setValue(
						WallBlock.WEST_WALL,
						west
					).setValue(
						WallBlock.NORTH_WALL,
						north
					).setValue(
						WallBlock.SOUTH_WALL,
						south
					).setValue(
						WallBlock.UP,
						up
					).setValue(
						WallBlock.WATERLOGGED,
						waterlogged
					));
				}
				else if (blockState.getBlock() == Blocks.STONE_BRICKS) {
					world.setBlockAndUpdate(spreadPos, Blocks.MOSSY_STONE_BRICKS.defaultBlockState());
				}
				else if (blockState.getBlock() == Blocks.STONE_BRICK_WALL) {
					WallSide east = blockState.getValue(WallBlock.EAST_WALL);
					WallSide west = blockState.getValue(WallBlock.WEST_WALL);
					WallSide north = blockState.getValue(WallBlock.NORTH_WALL);
					WallSide south = blockState.getValue(WallBlock.SOUTH_WALL);
					Boolean up = blockState.getValue(WallBlock.UP);
					Boolean waterlogged = blockState.getValue(WallBlock.WATERLOGGED);					
					world.setBlockAndUpdate(spreadPos, Blocks.MOSSY_STONE_BRICK_WALL.defaultBlockState().setValue(
						WallBlock.EAST_WALL,
						east
					).setValue(
						WallBlock.WEST_WALL,
						west
					).setValue(
						WallBlock.NORTH_WALL,
						north
					).setValue(
						WallBlock.SOUTH_WALL,
						south
					).setValue(
						WallBlock.UP,
						up
					).setValue(
						WallBlock.WATERLOGGED,
						waterlogged
					));
				}
				else if (blockState.getBlock() == Blocks.STONE_BRICK_STAIRS) {
					StairsShape stairsShape = blockState.getValue(StairBlock.SHAPE);
					Half stairsHalf = blockState.getValue(StairBlock.HALF);
					Direction stairsFacing = blockState.getValue(StairBlock.FACING);
					Boolean waterlogged = blockState.getValue(StairBlock.WATERLOGGED);					
					world.setBlockAndUpdate(spreadPos, Blocks.MOSSY_STONE_BRICK_STAIRS.defaultBlockState().setValue(
						StairBlock.SHAPE, stairsShape
					).setValue(
						StairBlock.HALF, stairsHalf
					).setValue(
						StairBlock.FACING, stairsFacing
					).setValue(
						StairBlock.WATERLOGGED,
						waterlogged
					));
				}
				else if (blockState.getBlock() == Blocks.STONE_BRICK_SLAB) {
					SlabType slabType = blockState.getValue(SlabBlock.TYPE);
					Boolean waterlogged = blockState.getValue(SlabBlock.WATERLOGGED);					
					world.setBlockAndUpdate(spreadPos, Blocks.MOSSY_STONE_BRICK_SLAB.defaultBlockState().setValue(
						SlabBlock.TYPE, 
						slabType
					).setValue(
						SlabBlock.WATERLOGGED,
						waterlogged
					));
				}
				else if (blockState.getBlock() == Blocks.INFESTED_STONE_BRICKS) {
					world.setBlockAndUpdate(spreadPos, Blocks.INFESTED_MOSSY_STONE_BRICKS.defaultBlockState());
				}
				else if (blockState.getBlock() == Blocks.GRASS_BLOCK && level == 3 && world.random.nextInt(100) < 5) {
					BonemealableBlock iGrowable = (BonemealableBlock)blockState.getBlock();
					if (iGrowable.isValidBonemealTarget(world, pos, blockState, world.isClientSide)) {
						if (iGrowable.isBonemealSuccess(world, world.random, pos, blockState)) {
							iGrowable.performBonemeal((ServerLevel)world, world.random, pos, blockState);
						}
					}
				}
			}
		}
	}
}
