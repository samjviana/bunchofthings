package net.ddns.samjviana.morethings.particles;

import net.ddns.samjviana.morethings.MoreThings;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModParticleTypes {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, MoreThings.MODID); 

    public static final RegistryObject<ParticleType<BasicParticleType>> WHITE_SLIME_PARTICLE = PARTICLE_TYPES.register("white_slime_particle", () -> new BasicParticleType(false));
    public static final RegistryObject<ParticleType<BasicParticleType>> ORANGE_SLIME_PARTICLE = PARTICLE_TYPES.register("orange_slime_particle", () -> new BasicParticleType(false));
    public static final RegistryObject<ParticleType<BasicParticleType>> MAGENTA_SLIME_PARTICLE = PARTICLE_TYPES.register("magenta_slime_particle", () -> new BasicParticleType(false));
    public static final RegistryObject<ParticleType<BasicParticleType>> LIGHT_BLUE_SLIME_PARTICLE = PARTICLE_TYPES.register("light_blue_slime_particle", () -> new BasicParticleType(false));
    public static final RegistryObject<ParticleType<BasicParticleType>> YELLOW_SLIME_PARTICLE = PARTICLE_TYPES.register("yellow_slime_particle", () -> new BasicParticleType(false));
    public static final RegistryObject<ParticleType<BasicParticleType>> LIME_SLIME_PARTICLE = PARTICLE_TYPES.register("lime_slime_particle", () -> new BasicParticleType(false));
    public static final RegistryObject<ParticleType<BasicParticleType>> PINK_SLIME_PARTICLE = PARTICLE_TYPES.register("pink_slime_particle", () -> new BasicParticleType(false));
    public static final RegistryObject<ParticleType<BasicParticleType>> GRAY_SLIME_PARTICLE = PARTICLE_TYPES.register("gray_slime_particle", () -> new BasicParticleType(false));
    public static final RegistryObject<ParticleType<BasicParticleType>> LIGHT_GRAY_SLIME_PARTICLE = PARTICLE_TYPES.register("light_gray_slime_particle", () -> new BasicParticleType(false));
    public static final RegistryObject<ParticleType<BasicParticleType>> CYAN_SLIME_PARTICLE = PARTICLE_TYPES.register("cyan_slime_particle", () -> new BasicParticleType(false));
    public static final RegistryObject<ParticleType<BasicParticleType>> PURPLE_SLIME_PARTICLE = PARTICLE_TYPES.register("purple_slime_particle", () -> new BasicParticleType(false));
    public static final RegistryObject<ParticleType<BasicParticleType>> BLUE_SLIME_PARTICLE = PARTICLE_TYPES.register("blue_slime_particle", () -> new BasicParticleType(false));
    public static final RegistryObject<ParticleType<BasicParticleType>> BROWN_SLIME_PARTICLE = PARTICLE_TYPES.register("brown_slime_particle", () -> new BasicParticleType(false));
    public static final RegistryObject<ParticleType<BasicParticleType>> GREEN_SLIME_PARTICLE = PARTICLE_TYPES.register("green_slime_particle", () -> new BasicParticleType(false));
    public static final RegistryObject<ParticleType<BasicParticleType>> RED_SLIME_PARTICLE = PARTICLE_TYPES.register("red_slime_particle", () -> new BasicParticleType(false));
    public static final RegistryObject<ParticleType<BasicParticleType>> BLACK_SLIME_PARTICLE = PARTICLE_TYPES.register("black_slime_particle", () -> new BasicParticleType(false));
}