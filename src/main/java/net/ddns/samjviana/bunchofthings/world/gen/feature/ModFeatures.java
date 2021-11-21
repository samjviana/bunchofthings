package net.ddns.samjviana.bunchofthings.world.gen.feature;

import net.ddns.samjviana.bunchofthings.BunchOfThings;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFeatures {
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, BunchOfThings.MODID);
	
	public static final RegistryObject<Feature<RandomPatchConfiguration>> PATCH_YELLOW_MUSHROOM = FEATURES.register(
		"patch_yellow_mushroom",
		() -> new YellowMushroomFeature(RandomPatchConfiguration.CODEC)
	);
}
