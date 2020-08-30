package net.ddns.samjviana.morethings.entity;

import net.ddns.samjviana.morethings.MoreThings;
import net.ddns.samjviana.morethings.entity.monster.ColoredSlimeEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityType {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, MoreThings.MODID);

    public static final RegistryObject<EntityType<ColoredSlimeEntity>> COLORED_SLIME = ENTITIES.register(
        "colored_slime",
        () -> EntityType.Builder.<ColoredSlimeEntity>create(
            ColoredSlimeEntity::new,
            EntityClassification.MONSTER
        ).size(2.04f, 2.04f).func_233606_a_(10).build(
            new ResourceLocation(MoreThings.MODID, "colored_slime").toString()
        )
    );
}