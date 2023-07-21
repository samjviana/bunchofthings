package net.ddns.samjviana.bunchofthings.world.entity;

import net.ddns.samjviana.bunchofthings.BunchOfThings;
import net.ddns.samjviana.bunchofthings.world.entity.monster.ColoredSlime;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityType {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(
        ForgeRegistries.ENTITY_TYPES,
        BunchOfThings.MODID
    );

    public static final RegistryObject<EntityType<ColoredSlime>> COLORED_SLIME = ENTITY_TYPES.register(
        "colored_slime",
        () -> EntityType.Builder.<ColoredSlime>of(ColoredSlime::new, MobCategory.MONSTER)
            .sized(2.04F, 2.04F).clientTrackingRange(10)
            .build(new ResourceLocation(BunchOfThings.MODID, "colored_slime").toString())
    );
}
