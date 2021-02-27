package net.ddns.samjviana.bunchofthings.utils;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.IFeatureConfig;

@Mixin(Features.class)
public class ConfiguredFeaturesAccessor {
    @Invoker("func_243968_a")
    public static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String id, ConfiguredFeature<FC, ?> configuredFeature) {
        throw new AssertionError();
    }
}