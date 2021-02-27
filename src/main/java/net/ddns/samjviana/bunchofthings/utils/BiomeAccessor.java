package net.ddns.samjviana.bunchofthings.utils;

import java.util.List;
import java.util.Map;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.structure.Structure;

@Mixin(Biome.class)
public interface BiomeAccessor {
    @Accessor
    Map<Integer, List<Structure<?>>> getField_242421_g();

}