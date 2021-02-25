package net.ddns.samjviana.bunchofthings;

import java.lang.reflect.Method;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

import com.electronwill.nightconfig.core.conversion.Path;
import com.google.common.base.Supplier;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonElement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Consumer;
import net.ddns.samjviana.bunchofthings.block.ModBlocks;
import net.ddns.samjviana.bunchofthings.client.particle.ModBreakingParticle;
import net.ddns.samjviana.bunchofthings.client.particle.YellowMushroomGlowParticle;
import net.ddns.samjviana.bunchofthings.client.renderer.entity.ColoredSlimeRenderer;
import net.ddns.samjviana.bunchofthings.client.renderer.tileentity.ColoredPistonTileEntityRenderer;
import net.ddns.samjviana.bunchofthings.entity.ModEntityType;
import net.ddns.samjviana.bunchofthings.entity.monster.ColoredSlimeEntity;
import net.ddns.samjviana.bunchofthings.item.ModItemGroup;
import net.ddns.samjviana.bunchofthings.item.ModItems;
import net.ddns.samjviana.bunchofthings.particles.ModParticleTypes;
import net.ddns.samjviana.bunchofthings.state.properties.Colors;
import net.ddns.samjviana.bunchofthings.tileentity.ModTileEntityType;
import net.ddns.samjviana.bunchofthings.world.gen.feature.ModFeatures;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.data.BlockModelProvider;
import net.minecraft.data.IFinishedBlockState;
import net.minecraft.data.ModelTextures;
import net.minecraft.data.ModelsResourceUtil;
import net.minecraft.data.StockModelShapes;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.particles.ParticleType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.MobSpawnInfo.Spawners;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = BunchOfThings.MODID, bus = Bus.MOD)
public class ModEventSubscriber {
    private static final Logger LOGGER = LogManager.getLogger(BunchOfThings.MODID + "Mod Event Subscriber");

    @SubscribeEvent
    public static void onRegister(final RegistryEvent.Register<Feature<?>> event) {
        final IForgeRegistry<Feature<?>> registry = event.getRegistry();

        ModFeatures.FEATURES.getEntries().stream().map(RegistryObject::get).forEach(feature -> {
            BunchOfThings.LOGGER.debug(feature.toString());
        });
    }

    @SubscribeEvent
    public static void onRegisterItem(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();

        ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            if (!filterBlock(block)) {
                return;
            }
            else if (block == ModBlocks.YELLOW_MUSHROOM.get()) {
                final Item.Properties properties = new Item.Properties().group(ModItemGroup.ITEMS);
                final BlockItem blockItem = new BlockItem(block, properties);
    
                blockItem.setRegistryName(block.getRegistryName());
                registry.register(blockItem);
            }
            else {
                final Item.Properties properties = new Item.Properties().group(ModItemGroup.BLOCKS);
                final BlockItem blockItem = new BlockItem(block, properties);
    
                blockItem.setRegistryName(block.getRegistryName());
                registry.register(blockItem);
            }
        });
    }

    private static boolean filterBlock(Block block) {
        if (block == ModBlocks.COLORED_STICKY_PISTON_HEAD.get()) {
            return false;
        }
        return true;
    }
       
    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onParticleFactoryRegistration(ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particles.registerFactory(
            ModParticleTypes.YELLOW_MUSHROOM_GLOW_PARTICLE.get(), 
            sprite -> new YellowMushroomGlowParticle.GlowParticleFactory(sprite)
        );
    }

    @OnlyIn(Dist.CLIENT)
    public static Object clientOnlySetup() {
        for (RegistryObject<Block> regBlock : ModBlocks.BLOCKS.getEntries()) {
            if (regBlock.getId().toString().contains("slime_block")) {
                RenderTypeLookup.setRenderLayer(regBlock.get(), RenderType.getTranslucent());
            }
            else if (regBlock.getId().toString().contains("yellow_mushroom")) {
                RenderTypeLookup.setRenderLayer(regBlock.get(), RenderType.getCutout());
            }
        }

        RenderingRegistry.registerEntityRenderingHandler(ModEntityType.COLORED_SLIME.get(), ColoredSlimeRenderer::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntityType.COLORED_PISTON.get(), ColoredPistonTileEntityRenderer::new);

        ParticleManager particleManager = Minecraft.getInstance().particles;

        particleManager.registerFactory(ModParticleTypes.WHITE_SLIME_PARTICLE.get(),new ModBreakingParticle.ColoredSlimeFactory(ModItems.WHITE_SLIME_BALL.get()));
        particleManager.registerFactory(ModParticleTypes.BLACK_SLIME_PARTICLE.get(), new ModBreakingParticle.ColoredSlimeFactory(ModItems.BLACK_SLIME_BALL.get()));
        particleManager.registerFactory(ModParticleTypes.BLUE_SLIME_PARTICLE.get(), new ModBreakingParticle.ColoredSlimeFactory(ModItems.BLUE_SLIME_BALL.get()));
        particleManager.registerFactory(ModParticleTypes.BROWN_SLIME_PARTICLE.get(), new ModBreakingParticle.ColoredSlimeFactory(ModItems.BROWN_SLIME_BALL.get()));
        particleManager.registerFactory(ModParticleTypes.CYAN_SLIME_PARTICLE.get(), new ModBreakingParticle.ColoredSlimeFactory(ModItems.CYAN_SLIME_BALL.get()));
        particleManager.registerFactory(ModParticleTypes.GRAY_SLIME_PARTICLE.get(), new ModBreakingParticle.ColoredSlimeFactory(ModItems.GRAY_SLIME_BALL.get()));
        particleManager.registerFactory(ModParticleTypes.GREEN_SLIME_PARTICLE.get(), new ModBreakingParticle.ColoredSlimeFactory(ModItems.GREEN_SLIME_BALL.get()));
        particleManager.registerFactory(ModParticleTypes.LIGHT_BLUE_SLIME_PARTICLE.get(), new ModBreakingParticle.ColoredSlimeFactory(ModItems.LIGHT_BLUE_SLIME_BALL.get()));
        particleManager.registerFactory(ModParticleTypes.LIGHT_GRAY_SLIME_PARTICLE.get(), new ModBreakingParticle.ColoredSlimeFactory(ModItems.LIGHT_GRAY_SLIME_BALL.get()));
        particleManager.registerFactory(ModParticleTypes.LIME_SLIME_PARTICLE.get(), new ModBreakingParticle.ColoredSlimeFactory(ModItems.LIME_SLIME_BALL.get()));
        particleManager.registerFactory(ModParticleTypes.MAGENTA_SLIME_PARTICLE.get(), new ModBreakingParticle.ColoredSlimeFactory(ModItems.MAGENTA_SLIME_BALL.get()));
        particleManager.registerFactory(ModParticleTypes.ORANGE_SLIME_PARTICLE.get(), new ModBreakingParticle.ColoredSlimeFactory(ModItems.ORANGE_SLIME_BALL.get()));
        particleManager.registerFactory(ModParticleTypes.PINK_SLIME_PARTICLE.get(), new ModBreakingParticle.ColoredSlimeFactory(ModItems.PINK_SLIME_BALL.get()));
        particleManager.registerFactory(ModParticleTypes.PURPLE_SLIME_PARTICLE.get(), new ModBreakingParticle.ColoredSlimeFactory(ModItems.PURPLE_SLIME_BALL.get()));
        particleManager.registerFactory(ModParticleTypes.RED_SLIME_PARTICLE.get(), new ModBreakingParticle.ColoredSlimeFactory(ModItems.RED_SLIME_BALL.get()));
        particleManager.registerFactory(ModParticleTypes.YELLOW_SLIME_PARTICLE.get(), new ModBreakingParticle.ColoredSlimeFactory(ModItems.YELLOW_SLIME_BALL.get()));


        return null;
    }

    @SubscribeEvent
    public static void onSetup(final FMLCommonSetupEvent event) {
        if (FMLEnvironment.dist == Dist.CLIENT) {
            DistExecutor.callWhenOn(Dist.CLIENT, () -> ModEventSubscriber::clientOnlySetup);
        }

        GlobalEntityTypeAttributes.put(ModEntityType.COLORED_SLIME.get(), ColoredSlimeEntity.getAttributes());
        EntitySpawnPlacementRegistry.register(ModEntityType.COLORED_SLIME.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ColoredSlimeEntity::_canSpawn);

        for (Biome biome : WorldGenRegistries.BIOME /* Collection of Biome Entries */) {
            if (biome != null && !biome.getCategory().equals(Biome.Category.NETHER) && !biome.getCategory().equals(Biome.Category.THEEND)) {
                MobSpawnInfo mobSpawnInfo = biome.getMobSpawnInfo();
                List<Spawners> spawnList = new ArrayList<Spawners>(mobSpawnInfo.getSpawners(EntityClassification.MONSTER));

                Spawners spawnToRemove = null;

                for (Spawners spawn : spawnList) {
                    if (spawn.type == EntityType.SLIME) {
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
                
                /*
                ModelProvider.BLOCK_FOLDER

                Path path = this.field_240080_d_.getOutputFolder();
                Map<Block, IFinishedBlockState> map = Maps.newHashMap();
                Consumer<IFinishedBlockState> consumer = (p_240085_1_) -> {
                    Block block = p_240085_1_.func_230524_a_();
                    IFinishedBlockState ifinishedblockstate = map.put(block, p_240085_1_);
                    if (ifinishedblockstate != null) {
                        throw new IllegalStateException("Duplicate blockstate definition for " + block);
                    }
                };
                
                Map<ResourceLocation, Supplier<JsonElement>> map1 = Maps.newHashMap();
                Set<Item> set = Sets.newHashSet();
                BiConsumer<ResourceLocation, Supplier<JsonElement>> biconsumer = (p_240086_1_, p_240086_2_) -> {
                    Supplier<JsonElement> supplier = map1.put(p_240086_1_, p_240086_2_);
                    if (supplier != null) {
                        throw new IllegalStateException("Duplicate model definition for " + p_240086_1_);
                    }
                };

                Consumer<Item> consumer1 = set::add;

                BlockModelProvider blockModelProvider = new BlockModelProvider(consumer, biconsumer, consumer1);

                final BiConsumer<ResourceLocation, Supplier<JsonElement>> field_239835_b_ = ObfuscationReflectionHelper.getPrivateValue(BlockModelProvider.class, instance, fieldName)

                Method func_239866_a_ = ObfuscationReflectionHelper.findMethod(BlockModelProvider.class, "func_239866_a_", Item.class);
                StockModelShapes.GENERATED.func_240234_a_(p_240234_1_, p_240234_2_, p_240234_3_)
                func_239866_a_.invoke(obj, args)*/
            }
        }
    }
    
    /*
    private void test(Item p_239866_1_) {
        StockModelShapes.GENERATED.func_240234_a_(ModelsResourceUtil.func_240219_a_(p_239866_1_), ModelTextures.func_240352_b_(p_239866_1_), this.field_239835_b_);
    }*/
}