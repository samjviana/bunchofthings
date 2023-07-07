package net.ddns.samjviana.bunchofthings.core.particles;

import net.ddns.samjviana.bunchofthings.BunchOfThings;
import net.minecraft.core.particles.ParticleType;
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

    public static final RegistryObject<SimpleParticleType> YELLOW_MUSHROOM_GLOW_PARTICLE =
        PARTICLE_TYPES.register(
            "yellow_mushroom_glow_particle",
            () -> {
                return new SimpleParticleType(false);
            }
        );
}
