package net.ddns.samjviana.bunchofthings;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.ddns.samjviana.bunchofthings.block.ModBlocks;
import net.ddns.samjviana.bunchofthings.particles.ModParticleTypes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(BunchOfThings.MODID)
public class BunchOfThings {
    public static final String MODID = "bunchofthings";
    public static final Logger LOGGER = LogManager.getLogger();

    public BunchOfThings() {
        //final ModLoadingContext modLoadingContext = ModLoadingContext.get();
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        final IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;

        forgeEventBus.addListener(EventPriority.HIGH, ModEventSubscriber::onBiomeLoading);
        ModBlocks.BLOCKS.register(modEventBus);
        /*ModBlocks.registerStickyPistons();
        ModBlocks.registerSlimeBlocks();
        ModFeatures.FEATURES.register(modEventBus);
        ModEntityType.ENTITIES.register(modEventBus);
        ModTileEntityType.BLOCK_ENTITIES.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModEnchantments.ENCHANTMENTS.register(modEventBus);*/
        ModParticleTypes.PARTICLE_TYPES.register(modEventBus);
    }
}
