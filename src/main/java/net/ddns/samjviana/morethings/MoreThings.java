package net.ddns.samjviana.morethings;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.ddns.samjviana.morethings.block.ModBlocks;
import net.ddns.samjviana.morethings.entity.ModEntityType;
import net.ddns.samjviana.morethings.item.ModItems;
import net.ddns.samjviana.morethings.particles.ModParticleTypes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MoreThings.MODID)
public class MoreThings {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "morethings";

    public MoreThings() {
        final ModLoadingContext modLoadingContext = ModLoadingContext.get();
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.BLOCKS.register(modEventBus);
        ModEntityType.ENTITIES.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModParticleTypes.PARTICLE_TYPES.register(modEventBus);
    }
}