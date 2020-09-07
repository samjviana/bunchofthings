package net.ddns.samjviana.bunchofthings;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.ddns.samjviana.bunchofthings.block.ModBlocks;
import net.ddns.samjviana.bunchofthings.enchantment.ModEnchantments;
import net.ddns.samjviana.bunchofthings.entity.ModEntityType;
import net.ddns.samjviana.bunchofthings.item.ModItems;
import net.ddns.samjviana.bunchofthings.particles.ModParticleTypes;
import net.ddns.samjviana.bunchofthings.tileentity.ModTileEntityType;
import net.minecraft.block.Blocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(BunchOfThings.MODID)
public class BunchOfThings {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "bunchofthings";

    public BunchOfThings() {
        final ModLoadingContext modLoadingContext = ModLoadingContext.get();
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.BLOCKS.register(modEventBus);
        ModBlocks.registerStickyPistons();
        ModEntityType.ENTITIES.register(modEventBus);
        ModTileEntityType.TILE_ENTITIES.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModEnchantments.ENCHANTMENTS.register(modEventBus);
        ModParticleTypes.PARTICLE_TYPES.register(modEventBus);
    }
}