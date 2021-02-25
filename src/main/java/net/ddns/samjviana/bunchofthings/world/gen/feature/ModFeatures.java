package net.ddns.samjviana.bunchofthings.world.gen.feature;

import net.ddns.samjviana.bunchofthings.BunchOfThings;
import net.ddns.samjviana.bunchofthings.block.ModBlocks;
import net.ddns.samjviana.bunchofthings.block.YellowMushroomBlock;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.RandomPatchFeature;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, BunchOfThings.MODID);

    public static final RegistryObject<Feature<?>> PATCH_YELLOW_MUSHROOM = FEATURES.register(
        "patch_yellow_mushroom", 
        () -> new RandomPatchFeature(BlockClusterFeatureConfig.field_236587_a_).withConfiguration(
            (new BlockClusterFeatureConfig.Builder(
                new SimpleBlockStateProvider(((YellowMushroomBlock)ModBlocks.YELLOW_MUSHROOM.get()).getRandomState()),
                SimpleBlockPlacer.PLACER
            )).tries(64).func_227317_b_().build()
        ).feature
    );
}
