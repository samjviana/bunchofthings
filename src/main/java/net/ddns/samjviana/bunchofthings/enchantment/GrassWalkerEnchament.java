package net.ddns.samjviana.bunchofthings.enchantment;

import net.ddns.samjviana.bunchofthings.BunchOfThings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.WallHeight;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.state.properties.Half;
import net.minecraft.state.properties.SlabType;
import net.minecraft.state.properties.StairsShape;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

public class GrassWalkerEnchament extends Enchantment {
    protected GrassWalkerEnchament() {
        super(Enchantment.Rarity.VERY_RARE, EnchantmentType.ARMOR_FEET, new EquipmentSlotType[] {EquipmentSlotType.FEET});
    }
    
    @Override
    public int getMinEnchantability(int enchantmentLevel) {
        return enchantmentLevel * 10;
    }

    @Override
    public int getMaxEnchantability(int enchantmentLevel) {
        return this.getMinEnchantability(enchantmentLevel) + 15;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public boolean isTreasureEnchantment() {
        return true;
    }

	public static void grassilizeNearby(final LivingUpdateEvent event, int maxLevel) {
		Entity entity = event.getEntity();
		if (/*entity instanceof ServerPlayerEntity &&*/((ServerPlayerEntity)entity).isSpectator()) {
			return;
		}

		World world = entity.world;
		int level = maxLevel;
		BlockPos pos = entity.getPosition();
		for (int x = -level; x <= level; x++) {
			for (int z = -level; z <= level; z++) {
				if (world.rand.nextInt(100) < 0) {
					continue;
				}
				BlockPos spreadPos = pos.add(x, -1, z);
				BlockState currentBlockState = world.getBlockState(new BlockPos(entity.getPosX(), entity.getPosY(), entity.getPosZ()));

				if (currentBlockState.getBlock() instanceof SlabBlock) {
					spreadPos = pos.add(x, 0, z);
				}

				double distance = spreadPos.distanceSq(pos.getX(), pos.getY(), pos.getZ(), false);
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
					world.setBlockState(spreadPos, Blocks.GRASS_BLOCK.getDefaultState());
				}
				else if (blockState.getBlock() == Blocks.COBBLESTONE) {
					world.setBlockState(spreadPos, Blocks.MOSSY_COBBLESTONE.getDefaultState());
				}
				else if (blockState.getBlock() == Blocks.COBBLESTONE_STAIRS) {
					StairsShape stairsShape = blockState.get(StairsBlock.SHAPE);
					Half stairsHalf = blockState.get(StairsBlock.HALF);
					Direction stairsFacing = blockState.get(StairsBlock.FACING);
					Boolean waterlogged = blockState.get(StairsBlock.WATERLOGGED);					
					world.setBlockState(spreadPos, Blocks.MOSSY_COBBLESTONE_STAIRS.getDefaultState().with(
						StairsBlock.SHAPE, stairsShape
					).with(
						StairsBlock.HALF, stairsHalf
					).with(
						StairsBlock.FACING, stairsFacing
					).with(
						StairsBlock.WATERLOGGED,
						waterlogged
					));
				}
				else if (blockState.getBlock() == Blocks.COBBLESTONE_SLAB) {
					SlabType slabType = blockState.get(SlabBlock.TYPE);
					Boolean waterlogged = blockState.get(SlabBlock.WATERLOGGED);					
					world.setBlockState(spreadPos, Blocks.MOSSY_COBBLESTONE_SLAB.getDefaultState().with(
						SlabBlock.TYPE, 
						slabType
					).with(
						SlabBlock.WATERLOGGED,
						waterlogged
					));
				}
				else if (blockState.getBlock() == Blocks.COBBLESTONE_WALL) {
					WallHeight east = blockState.get(WallBlock.WALL_HEIGHT_EAST);
					WallHeight west = blockState.get(WallBlock.WALL_HEIGHT_WEST);
					WallHeight north = blockState.get(WallBlock.WALL_HEIGHT_NORTH);
					WallHeight south = blockState.get(WallBlock.WALL_HEIGHT_SOUTH);
					Boolean up = blockState.get(WallBlock.UP);
					Boolean waterlogged = blockState.get(WallBlock.WATERLOGGED);					
					world.setBlockState(spreadPos, Blocks.MOSSY_COBBLESTONE_WALL.getDefaultState().with(
						WallBlock.WALL_HEIGHT_EAST,
						east
					).with(
						WallBlock.WALL_HEIGHT_WEST,
						west
					).with(
						WallBlock.WALL_HEIGHT_NORTH,
						north
					).with(
						WallBlock.WALL_HEIGHT_SOUTH,
						south
					).with(
						WallBlock.UP,
						up
					).with(
						WallBlock.WATERLOGGED,
						waterlogged
					));
				}
				else if (blockState.getBlock() == Blocks.STONE_BRICKS) {
					world.setBlockState(spreadPos, Blocks.MOSSY_STONE_BRICKS.getDefaultState());
				}
				else if (blockState.getBlock() == Blocks.STONE_BRICK_WALL) {
					WallHeight east = blockState.get(WallBlock.WALL_HEIGHT_EAST);
					WallHeight west = blockState.get(WallBlock.WALL_HEIGHT_WEST);
					WallHeight north = blockState.get(WallBlock.WALL_HEIGHT_NORTH);
					WallHeight south = blockState.get(WallBlock.WALL_HEIGHT_SOUTH);
					Boolean up = blockState.get(WallBlock.UP);
					Boolean waterlogged = blockState.get(WallBlock.WATERLOGGED);					
					world.setBlockState(spreadPos, Blocks.MOSSY_STONE_BRICK_WALL.getDefaultState().with(
						WallBlock.WALL_HEIGHT_EAST,
						east
					).with(
						WallBlock.WALL_HEIGHT_WEST,
						west
					).with(
						WallBlock.WALL_HEIGHT_NORTH,
						north
					).with(
						WallBlock.WALL_HEIGHT_SOUTH,
						south
					).with(
						WallBlock.UP,
						up
					).with(
						WallBlock.WATERLOGGED,
						waterlogged
					));
				}
				else if (blockState.getBlock() == Blocks.STONE_BRICK_STAIRS) {
					StairsShape stairsShape = blockState.get(StairsBlock.SHAPE);
					Half stairsHalf = blockState.get(StairsBlock.HALF);
					Direction stairsFacing = blockState.get(StairsBlock.FACING);
					BunchOfThings.LOGGER.info(stairsFacing);
					Boolean waterlogged = blockState.get(StairsBlock.WATERLOGGED);					
					world.setBlockState(spreadPos, Blocks.MOSSY_STONE_BRICK_STAIRS.getDefaultState().with(
						StairsBlock.SHAPE, stairsShape
					).with(
						StairsBlock.HALF, stairsHalf
					).with(
						StairsBlock.FACING, stairsFacing
					).with(
						StairsBlock.WATERLOGGED,
						waterlogged
					));
				}
				else if (blockState.getBlock() == Blocks.STONE_BRICK_SLAB) {
					SlabType slabType = blockState.get(SlabBlock.TYPE);
					Boolean waterlogged = blockState.get(SlabBlock.WATERLOGGED);					
					world.setBlockState(spreadPos, Blocks.MOSSY_STONE_BRICK_SLAB.getDefaultState().with(
						SlabBlock.TYPE, 
						slabType
					).with(
						SlabBlock.WATERLOGGED,
						waterlogged
					));
				}
				else if (blockState.getBlock() == Blocks.INFESTED_STONE_BRICKS) {
					world.setBlockState(spreadPos, Blocks.INFESTED_MOSSY_STONE_BRICKS.getDefaultState());
				}
				else if (blockState.getBlock() == Blocks.GRASS_BLOCK && level == 3 && world.rand.nextInt(100) < 5) {
					IGrowable iGrowable = (IGrowable)blockState.getBlock();
					if (iGrowable.canGrow(world, pos, blockState, world.isRemote)) {
						if (iGrowable.canUseBonemeal(world, world.rand, pos, blockState)) {
							iGrowable.grow((ServerWorld)world, world.rand, pos, blockState);
						}
					}
				}
			}
		}
	}
}