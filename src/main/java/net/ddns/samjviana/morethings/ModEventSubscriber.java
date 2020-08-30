package net.ddns.samjviana.morethings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.ddns.samjviana.morethings.block.ModBlocks;
import net.ddns.samjviana.morethings.client.particle.ModBreakingParticle;
import net.ddns.samjviana.morethings.client.renderer.entity.ColoredSlimeRenderer;
import net.ddns.samjviana.morethings.entity.ModEntityType;
import net.ddns.samjviana.morethings.entity.monster.ColoredSlimeEntity;
import net.ddns.samjviana.morethings.item.ModItemGroup;
import net.ddns.samjviana.morethings.item.ModItems;
import net.ddns.samjviana.morethings.particles.ModParticleTypes;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.MobSpawnInfo.Spawners;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = MoreThings.MODID, bus = Bus.MOD)
public class ModEventSubscriber {
    private static final Logger LOGGER = LogManager.getLogger(MoreThings.MODID + "Mod Event Subscriber");

    @SubscribeEvent
    public static void onRegisterItem(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();

        ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            final Item.Properties properties = new Item.Properties().group(ModItemGroup.BLOCKS);
            final BlockItem blockItem = new BlockItem(block, properties);

            blockItem.setRegistryName(block.getRegistryName());
            registry.register(blockItem);
        });
    }
       
    @SubscribeEvent
    public static void onSetup(final FMLCommonSetupEvent event) {
        for (RegistryObject<Block> regBlock : ModBlocks.BLOCKS.getEntries()) {
            if (regBlock.getId().toString().contains("slime_block")) {
                RenderTypeLookup.setRenderLayer(regBlock.get(), RenderType.getTranslucent());
            }
        }

        RenderingRegistry.registerEntityRenderingHandler(ModEntityType.COLORED_SLIME.get(), ColoredSlimeRenderer::new);

        GlobalEntityTypeAttributes.put(ModEntityType.COLORED_SLIME.get(), ColoredSlimeEntity.getAttributes());
        EntitySpawnPlacementRegistry.register(ModEntityType.COLORED_SLIME.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ColoredSlimeEntity::_canSpawn);
        ParticleManager particleManager = Minecraft.getInstance().particles;
        /*
        for (RegistryObject<ParticleType<?>> particleType : ModParticleTypes.PARTICLE_TYPES.getEntries()) {
            String resourceName = particleType.getId().toString();
            String prefix = resourceName.substring(0, resourceName.indexOf("_particle"));
            ModItems.ITEMS.getEntries().forEach((item) -> {
                if (item.getId().toString().startsWith(prefix)) {
                    particleManager.registerFactory(particleType.get(), new ModBreakingParticle.ColoredSlimeFactory(item.get()));
                    LOGGER.debug(item.getId());
                }
            });
        }
        */

        particleManager.registerFactory(ModParticleTypes.WHITE_SLIME_PARTICLE.get(),
                new ModBreakingParticle.ColoredSlimeFactory(ModItems.WHITE_SLIME_BALL.get()));
        particleManager.registerFactory(ModParticleTypes.BLACK_SLIME_PARTICLE.get(),
                new ModBreakingParticle.ColoredSlimeFactory(ModItems.BLACK_SLIME_BALL.get()));
        particleManager.registerFactory(ModParticleTypes.BLUE_SLIME_PARTICLE.get(),
                new ModBreakingParticle.ColoredSlimeFactory(ModItems.BLUE_SLIME_BALL.get()));
        particleManager.registerFactory(ModParticleTypes.BROWN_SLIME_PARTICLE.get(),
                new ModBreakingParticle.ColoredSlimeFactory(ModItems.BROWN_SLIME_BALL.get()));
        particleManager.registerFactory(ModParticleTypes.CYAN_SLIME_PARTICLE.get(),
                new ModBreakingParticle.ColoredSlimeFactory(ModItems.CYAN_SLIME_BALL.get()));
        particleManager.registerFactory(ModParticleTypes.GRAY_SLIME_PARTICLE.get(),
                new ModBreakingParticle.ColoredSlimeFactory(ModItems.GRAY_SLIME_BALL.get()));
        particleManager.registerFactory(ModParticleTypes.GREEN_SLIME_PARTICLE.get(),
                new ModBreakingParticle.ColoredSlimeFactory(ModItems.GREEN_SLIME_BALL.get()));
        particleManager.registerFactory(ModParticleTypes.LIGHT_BLUE_SLIME_PARTICLE.get(),
                new ModBreakingParticle.ColoredSlimeFactory(ModItems.LIGHT_BLUE_SLIME_BALL.get()));
        particleManager.registerFactory(ModParticleTypes.LIGHT_GRAY_SLIME_PARTICLE.get(),
                new ModBreakingParticle.ColoredSlimeFactory(ModItems.LIGHT_GRAY_SLIME_BALL.get()));
        particleManager.registerFactory(ModParticleTypes.LIME_SLIME_PARTICLE.get(),
                new ModBreakingParticle.ColoredSlimeFactory(ModItems.LIME_SLIME_BALL.get()));
        particleManager.registerFactory(ModParticleTypes.MAGENTA_SLIME_PARTICLE.get(),
                new ModBreakingParticle.ColoredSlimeFactory(ModItems.MAGENTA_SLIME_BALL.get()));
        particleManager.registerFactory(ModParticleTypes.ORANGE_SLIME_PARTICLE.get(),
                new ModBreakingParticle.ColoredSlimeFactory(ModItems.ORANGE_SLIME_BALL.get()));
        particleManager.registerFactory(ModParticleTypes.PINK_SLIME_PARTICLE.get(),
                new ModBreakingParticle.ColoredSlimeFactory(ModItems.PINK_SLIME_BALL.get()));
        particleManager.registerFactory(ModParticleTypes.PURPLE_SLIME_PARTICLE.get(),
                new ModBreakingParticle.ColoredSlimeFactory(ModItems.PURPLE_SLIME_BALL.get()));
        particleManager.registerFactory(ModParticleTypes.RED_SLIME_PARTICLE.get(),
                new ModBreakingParticle.ColoredSlimeFactory(ModItems.RED_SLIME_BALL.get()));
        particleManager.registerFactory(ModParticleTypes.YELLOW_SLIME_PARTICLE.get(),
                new ModBreakingParticle.ColoredSlimeFactory(ModItems.YELLOW_SLIME_BALL.get()));

        for (Map.Entry<RegistryKey<Biome>, Biome> biome : WorldGenRegistries.field_243657_i.func_239659_c_() /* Collection of Biome Entries */) {
            if (biome.getValue() != null && !biome.getValue().getCategory().equals(Biome.Category.NETHER) && !biome.getValue().getCategory().equals(Biome.Category.THEEND)) {
                MobSpawnInfo mobSpawnInfo = biome.getValue().func_242433_b();
                List<Spawners> spawnList = new ArrayList<Spawners>(mobSpawnInfo.func_242559_a(EntityClassification.MONSTER));

                Spawners spawnToRemove = null;

                for (Spawners spawn : spawnList) {
                    if (spawn.field_242588_c == EntityType.SLIME) {
                        spawnToRemove = spawn;
                    }
                }
                if (spawnToRemove != null) {
                    spawnList.remove(spawnToRemove);
                }
                spawnList.add(new Spawners(ModEntityType.COLORED_SLIME.get(), 100, 4, 4));

                /* Change field_242484_f that contains the Configured Features of the Biome*/
                final Map<EntityClassification, List<Spawners>> privateSpawnList = new HashMap<>(ObfuscationReflectionHelper.getPrivateValue(MobSpawnInfo.class, mobSpawnInfo, "field_242554_e"));
                privateSpawnList.replace(EntityClassification.MONSTER, spawnList);
                ObfuscationReflectionHelper.setPrivateValue(MobSpawnInfo.class, mobSpawnInfo, privateSpawnList, "field_242554_e");
            }
        }
    }
}