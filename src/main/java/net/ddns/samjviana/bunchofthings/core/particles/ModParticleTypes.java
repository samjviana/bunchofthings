package net.ddns.samjviana.bunchofthings.core.particles;

import net.ddns.samjviana.bunchofthings.BunchOfThings;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModParticleTypes {

    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
        DeferredRegister.create(
            ForgeRegistries.PARTICLE_TYPES,
            BunchOfThings.MODID
        );
    public static final RegistryObject<ParticleType<SimpleParticleType>> WHITE_SLIME_PARTICLE = PARTICLE_TYPES.register("white_slime_particle", () -> new SimpleParticleType(false));
    public static final RegistryObject<ParticleType<SimpleParticleType>> ORANGE_SLIME_PARTICLE = PARTICLE_TYPES.register("orange_slime_particle", () -> new SimpleParticleType(false));
    public static final RegistryObject<ParticleType<SimpleParticleType>> MAGENTA_SLIME_PARTICLE = PARTICLE_TYPES.register("magenta_slime_particle", () -> new SimpleParticleType(false));
    public static final RegistryObject<ParticleType<SimpleParticleType>> LIGHT_BLUE_SLIME_PARTICLE = PARTICLE_TYPES.register("light_blue_slime_particle", () -> new SimpleParticleType(false));
    public static final RegistryObject<ParticleType<SimpleParticleType>> YELLOW_SLIME_PARTICLE = PARTICLE_TYPES.register("yellow_slime_particle", () -> new SimpleParticleType(false));
    public static final RegistryObject<ParticleType<SimpleParticleType>> LIME_SLIME_PARTICLE = PARTICLE_TYPES.register("lime_slime_particle", () -> new SimpleParticleType(false));
    public static final RegistryObject<ParticleType<SimpleParticleType>> PINK_SLIME_PARTICLE = PARTICLE_TYPES.register("pink_slime_particle", () -> new SimpleParticleType(false));
    public static final RegistryObject<ParticleType<SimpleParticleType>> GRAY_SLIME_PARTICLE = PARTICLE_TYPES.register("gray_slime_particle", () -> new SimpleParticleType(false));
    public static final RegistryObject<ParticleType<SimpleParticleType>> LIGHT_GRAY_SLIME_PARTICLE = PARTICLE_TYPES.register("light_gray_slime_particle", () -> new SimpleParticleType(false));
    public static final RegistryObject<ParticleType<SimpleParticleType>> CYAN_SLIME_PARTICLE = PARTICLE_TYPES.register("cyan_slime_particle", () -> new SimpleParticleType(false));
    public static final RegistryObject<ParticleType<SimpleParticleType>> PURPLE_SLIME_PARTICLE = PARTICLE_TYPES.register("purple_slime_particle", () -> new SimpleParticleType(false));
    public static final RegistryObject<ParticleType<SimpleParticleType>> BLUE_SLIME_PARTICLE = PARTICLE_TYPES.register("blue_slime_particle", () -> new SimpleParticleType(false));
    public static final RegistryObject<ParticleType<SimpleParticleType>> BROWN_SLIME_PARTICLE = PARTICLE_TYPES.register("brown_slime_particle", () -> new SimpleParticleType(false));
    public static final RegistryObject<ParticleType<SimpleParticleType>> GREEN_SLIME_PARTICLE = PARTICLE_TYPES.register("green_slime_particle", () -> new SimpleParticleType(false));
    public static final RegistryObject<ParticleType<SimpleParticleType>> RED_SLIME_PARTICLE = PARTICLE_TYPES.register("red_slime_particle", () -> new SimpleParticleType(false));
    public static final RegistryObject<ParticleType<SimpleParticleType>> BLACK_SLIME_PARTICLE = PARTICLE_TYPES.register("black_slime_particle", () -> new SimpleParticleType(false));
    
    public static final RegistryObject<SimpleParticleType> YELLOW_MUSHROOM_GLOW_PARTICLE =
        PARTICLE_TYPES.register(
            "yellow_mushroom_glow_particle",
            () -> {
                return new SimpleParticleType(false);
            }
        );
}
