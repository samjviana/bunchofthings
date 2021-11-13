package net.ddns.samjviana.bunchofthings;

import java.util.ArrayList;
import java.util.List;

import net.ddns.samjviana.bunchofthings.block.ModBlocks;
import net.ddns.samjviana.bunchofthings.client.particle.YellowMushroomGlowParticle;
import net.ddns.samjviana.bunchofthings.item.ModCreativeTab;
import net.ddns.samjviana.bunchofthings.particles.ModParticleTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = BunchOfThings.MODID, bus = Bus.MOD)
public class ModEventSubscriber {
	private static final Minecraft INSTANCE = Minecraft.getInstance();

	@SubscribeEvent
    public static void onRegisterFeature(final RegistryEvent.Register<Feature<?>> event) {
        final IForgeRegistry<Feature<?>> registry = event.getRegistry();

        /*ModFeatures.FEATURES.getEntries().stream().map(RegistryObject::get).forEach(feature -> {
            registry.register(feature);
        });*/
    }

    @SubscribeEvent
    public static void onRegisterEnchantment(final RegistryEvent.Register<Enchantment> event) {
        final IForgeRegistry<Enchantment> registry = event.getRegistry();

        /*ifModEnchantments.ENCHANTMENTS.getEntries().stream().map(RegistryObject::get).forEach(enchantment -> {
            
        });*/
    }


    @SubscribeEvent
    public static void onRegisterItem(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();

		ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach((block) -> {
			final Item.Properties properties;
			if (shouldHide(block)) {
				return;
			}
			else if (isBlockItem(block)) {
				properties = new Item.Properties().tab(ModCreativeTab.ITEMS);
			}
			else {
				properties = new Item.Properties().tab(ModCreativeTab.BLOCKS);
			}
			final BlockItem blockItem = new BlockItem(block, properties);

			blockItem.setRegistryName(block.getRegistryName());
			registry.register(blockItem);
	});
        
		/*ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
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
        });*/
    }

	private static boolean shouldHide(Block block) {
		return false;
	}

	private static boolean isBlockItem(Block block) {
		List<Block> blockItems = new ArrayList<Block>(List.of(
			ModBlocks.YELLOW_MUSHROOM.get()
		));

		if (blockItems.contains(block)) {
			return true;
		}
		return false;
	}
       
    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onParticleFactoryRegistration(ParticleFactoryRegisterEvent event) {
        INSTANCE.particleEngine.register(
            ModParticleTypes.YELLOW_MUSHROOM_GLOW_PARTICLE.get(), 
            sprite -> new YellowMushroomGlowParticle.GlowParticleFactory(sprite)
        );
    }

    @OnlyIn(Dist.CLIENT)
    public static Object clientOnlySetup() {
        /*for (RegistryObject<Block> regBlock : ModBlocks.BLOCKS.getEntries()) {
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
		*/
        return null;
    }

    public static void onBiomeLoading(final BiomeLoadingEvent event) {
        /*event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(
            () -> new RandomPatchFeature(BlockClusterFeatureConfig.field_236587_a_).withConfiguration(
                (new BlockClusterFeatureConfig.Builder(
                    new SimpleBlockStateProvider(((YellowMushroomBlock)ModBlocks.YELLOW_MUSHROOM.get()).getRandomState()),
                    SimpleBlockPlacer.PLACER
                )).tries(64).func_227317_b_().build()
            )
        );*/
        //if (event.getCategory() == Biome.Category.TAIGA || event.getCategory() == Biome.Category.SWAMP) {
            /*event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(
                () -> Feature.RANDOM_PATCH.withConfiguration(
                    (new BlockClusterFeatureConfig.Builder(
                        new SimpleBlockStateProvider(((YellowMushroomBlock)ModBlocks.YELLOW_MUSHROOM.get()).getRandomState()), SimpleBlockPlacer.PLACER
                    )).tries(4).build()
                ).withPlacement(
                    Features.Placements.PATCH_PLACEMENT
                ).withPlacement(
                    Placement.COUNT_NOISE.configure(new NoiseDependant(-0.8D, 5, 10))
                )
            );*/
            /*event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(
                () -> ModFeatures.PATCH_YELLOW_MUSHROOM.get().withConfiguration(
                    (new BlockClusterFeatureConfig.Builder(
                        new SimpleBlockStateProvider(((YellowMushroomBlock)ModBlocks.YELLOW_MUSHROOM.get()).getWithCount(1)), SimpleBlockPlacer.PLACER
                    )).tries(32).func_227317_b_().build()
                ).withPlacement(
                    Features.Placements.PATCH_PLACEMENT
                )
            );
        }*/
    }

    @SubscribeEvent
    public static void onSetup(final FMLCommonSetupEvent event) {
        /*if (FMLEnvironment.dist == Dist.CLIENT) {
            DistExecutor.callWhenOn(Dist.CLIENT, () -> ModEventSubscriber::clientOnlySetup);
        }

        GlobalEntityTypeAttributes.put(ModEntityType.COLORED_SLIME.get(), ColoredSlimeEntity.getAttributes());
        EntitySpawnPlacementRegistry.register(ModEntityType.COLORED_SLIME.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ColoredSlimeEntity::_canSpawn);
		*/
        //for (Biome biome : WorldGenRegistries.BIOME /* Collection of Biome Entries */) {
            /*BiomeModifier.addFeatureToBiome(
                biome, 
                GenerationStage.Decoration.VEGETAL_DECORATION, 
                WorldGenRegistries.CONFIGURED_FEATURE.getOrDefault(ModBlocks.YELLOW_MUSHROOM.get().getRegistryName())
            );*/
            /*List<Supplier<ConfiguredFeature<?, ?>>> features = new ArrayList<>(biome.getGenerationSettings().getFeatures().get(GenerationStage.Decoration.VEGETAL_DECORATION.ordinal()));
            features.add(() -> new RandomPatchFeature(BlockClusterFeatureConfig.field_236587_a_).withConfiguration(
                (new BlockClusterFeatureConfig.Builder(
                    new SimpleBlockStateProvider(((YellowMushroomBlock)ModBlocks.YELLOW_MUSHROOM.get()).getRandomState()),
                    SimpleBlockPlacer.PLACER
                )).tries(64).func_227317_b_().build()
            ));
            biome.getGenerationSettings().getFeatures().add(features);*/

            /*if (biome != null && !biome.getCategory().equals(Biome.Category.NETHER) && !biome.getCategory().equals(Biome.Category.THEEND)) {
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
                spawnList.add(new Spawners(ModEntityType.COLORED_SLIME.get(), 100, 4, 4));*/

                /* Change field_242484_f that contains the Configured Features of the Biome*/
                /*final Map<EntityClassification, List<Spawners>> privateSpawnList = new HashMap<>(ObfuscationReflectionHelper.getPrivateValue(MobSpawnInfo.class, mobSpawnInfo, "field_242554_e"));
                privateSpawnList.replace(EntityClassification.MONSTER, spawnList);
                ObfuscationReflectionHelper.setPrivateValue(MobSpawnInfo.class, mobSpawnInfo, privateSpawnList, "field_242554_e");*/
                
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
            //}
        //}
    }
}