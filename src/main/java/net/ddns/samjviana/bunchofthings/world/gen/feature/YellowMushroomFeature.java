package net.ddns.samjviana.bunchofthings.world.gen.feature;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;

public class YellowMushroomFeature extends Feature<RandomPatchConfiguration> {
	public YellowMushroomFeature(Codec<RandomPatchConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<RandomPatchConfiguration> context) {
		Random random = context.random();
		BlockPos currentBlockPos = context.origin();
		WorldGenLevel worldGenLevel = context.level();
		RandomPatchConfiguration featureConfiguration = context.config();
		BlockState blockstate = featureConfiguration.stateProvider.getState(random, currentBlockPos);

		BlockPos blockPos;
		if (featureConfiguration.project) {
			blockPos = worldGenLevel.getHeightmapPos(Heightmap.Types.WORLD_SURFACE_WG, currentBlockPos);
		}
		else {
			blockPos = currentBlockPos;
		}

		int i = 0;
		BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

		for (int j = 0; j < featureConfiguration.tries; ++j) {
			blockpos$mutableblockpos.setWithOffset(
				blockPos, 
				random.nextInt(featureConfiguration.xspread + 1) - random.nextInt(featureConfiguration.xspread + 1), 
				random.nextInt(featureConfiguration.yspread + 1) - random.nextInt(featureConfiguration.yspread + 1), 
				random.nextInt(featureConfiguration.zspread + 1) - random.nextInt(featureConfiguration.zspread + 1)
			);
			BlockPos belowBlockPos = blockpos$mutableblockpos.below();
			BlockState belowBlockState = worldGenLevel.getBlockState(belowBlockPos);
			if ((worldGenLevel.isEmptyBlock(blockpos$mutableblockpos) 
				|| featureConfiguration.canReplace
				&& worldGenLevel.getBlockState(blockpos$mutableblockpos).getMaterial().isReplaceable()) 
				&& blockstate.canSurvive(worldGenLevel, blockpos$mutableblockpos) 
				&& (featureConfiguration.whitelist.isEmpty() 
				|| featureConfiguration.whitelist.contains(belowBlockState.getBlock())) 
				&& !featureConfiguration.blacklist.contains(belowBlockState) 
				&& (!featureConfiguration.needWater 
				|| worldGenLevel.getFluidState(belowBlockPos.west()).is(FluidTags.WATER) 
				|| worldGenLevel.getFluidState(belowBlockPos.east()).is(FluidTags.WATER) 
				|| worldGenLevel.getFluidState(belowBlockPos.north()).is(FluidTags.WATER) 
				|| worldGenLevel.getFluidState(belowBlockPos.south()).is(FluidTags.WATER))
			) {
				featureConfiguration.blockPlacer.place(worldGenLevel, blockpos$mutableblockpos, blockstate, random);
				++i;
			}
		}

		return i > 0;
	}
}
