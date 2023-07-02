package net.ddns.samjviana.bunchofthings;

import java.util.ArrayList;
import java.util.List;

import net.ddns.samjviana.bunchofthings.client.particle.YellowMushroomGlowParticle;
import net.ddns.samjviana.bunchofthings.core.particles.ModParticleTypes;
import net.ddns.samjviana.bunchofthings.world.item.ModItems;
import net.ddns.samjviana.bunchofthings.world.level.block.ColoredSlimeBlock;
import net.ddns.samjviana.bunchofthings.world.level.block.ModBlocks;
import net.ddns.samjviana.bunchofthings.world.level.block.YellowMushroomBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.RegistryObject;

@EventBusSubscriber(modid = BunchOfThings.MODID, bus = Bus.MOD)
public class ModEventSubscriber {
	private static final Minecraft INSTANCE = Minecraft.getInstance();

	@SubscribeEvent
	public static void onRegisterCreativeModeTab(CreativeModeTabEvent.Register event) {
		event.registerCreativeModeTab(
			new ResourceLocation(BunchOfThings.MODID, "blocks"),
			builder -> builder.title(
				Component.translatable("itemGroup.blocks")
			).icon(
				() -> new ItemStack(ModBlocks.PURPLE_SLIME_BLOCK.get())
			).displayItems((params, output) -> {
				ModItems.ITEMS.getEntries().stream().map(RegistryObject::get).forEach((item) -> {
					output.accept(item.getDefaultInstance());
				});
			})
		);
	}

	@SubscribeEvent
	public static void onRegisterParticleProviders(RegisterParticleProvidersEvent event) {
		event.register(
			ModParticleTypes.YELLOW_MUSHROOM_GLOW_PARTICLE.get(), 
			sprite -> new YellowMushroomGlowParticle.GlowParticleFactory(sprite)
		);
	}

	// @SubscribeEvent
	// public static void onGatherData(GatherDataEvent event) {
	// 	DataGenerator dataGenerator = event.getGenerator();
	// 	PackOutput packOutput = dataGenerator.getPackOutput();
	// 	ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

	// 	dataGenerator.addProvider(event.includeServer(), new DatapackBuiltinEntriesProvider(packOutput, event.getLookupProvider(), BUILDER, Set.of(BunchOfThings.MODID)));
	// }

	/*@SubscribeEvent
	public static void onRegister(RegisterEvent event) {
		event.register(
			ForgeRegistries.Keys.BLOCKS,
        	helper -> helper.register(new ResourceLocation(BunchOfThings.MODID, "orange_slime_block"), ModBlocks.ORANGE_SLIME_BLOCK.get())
    	);
	}*/

    /*@SubscribeEvent
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
    }

	@SubscribeEvent
	public static void onRegisterBlock(final RegistryEvent.Register<Block> event) {
		final IForgeRegistry<Block> registry = event.getRegistry();

		ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach((block) -> {
			registry.register(block);
		});
	}*/

	private static boolean shouldHide(Block block) {
		return false;
	}

	private static boolean isBlockItem(Block block) {
		List<Block> blockItems = new ArrayList<Block>(List.of(
			//ModBlocks.YELLOW_MUSHROOM.get()
		));

		if (blockItems.contains(block)) {
			return true;
		}
		return false;
	}
       
    /*@SubscribeEvent
    @OnlyIn(Dist.CLIENT)
	@SuppressWarnings("deprecation")
    public static void onParticleFactoryRegistration(RegisterParticleProvidersEvent event) {
        INSTANCE.particleEngine.register(
            ModParticleTypes.YELLOW_MUSHROOM_GLOW_PARTICLE.get(), 
            sprite -> new YellowMushroomGlowParticle.GlowParticleFactory(sprite)
        );
    }*/

	/*public static void onBiomeLoading(final BiomeLoadingEvent event) {
		BiomeCategory category = event.getCategory();
		if (category == BiomeCategory.TAIGA || category == BiomeCategory.SWAMP) {
			event.getGeneration().getFeatures(Decoration.VEGETAL_DECORATION).add(
				() -> ModFeatures.PATCH_YELLOW_MUSHROOM.get().configured(
					(new RandomPatchConfiguration.GrassConfigurationBuilder(
						new SimpleStateProvider(((YellowMushroomBlock)ModBlocks.YELLOW_MUSHROOM.get()).getRandomState()), 
						SimpleBlockPlacer.INSTANCE
					)).tries(8).noProjection().build()
				).decorated(Features.Decorators.HEIGHTMAP_SQUARE).rarity(8)
			);
		}
	}*/

	/*@SubscribeEvent
	public static void onRegisterEnchantment(final RegistryEvent.Register<Enchantment> event) {
		final IForgeRegistry<Enchantment> registry = event.getRegistry();

		ModEnchantments.ENCHANTMENTS.getEntries().stream().map(RegistryObject::get).forEach(enchantment -> {
			
		});
	}*/

	//Feature.SEA_PICKLE.configured(new CountConfiguration(20)).decorated(Features.Decorators.TOP_SOLID_HEIGHTMAP_SQUARE).rarity(16)

    @SubscribeEvent
    public static void onSetup(final FMLCommonSetupEvent event) {
		for (RegistryObject<Block> registryObject : ModBlocks.BLOCKS.getEntries()) {
			//ItemBlockRenderTypes.setRenderLayer(registryObject.get(), RenderType.translucent());
		}

		/*if (FMLEnvironment.dist == Dist.CLIENT) {
			DistExecutor.callWhenOn(Dist.CLIENT, () -> ModEventSubscriber::clientOnlySetup);
		}*/
		
		/* *
		for (RegistryObject<Block> regBlock : ModBlocks.BLOCKS.getEntries()) {
			if (regBlock.get() instanceof ColoredSlimeBlock) {
				ItemBlockRenderTypes.setRenderLayer(regBlock.get(), RenderType.translucent());
			}
			else if (regBlock.get() instanceof YellowMushroomBlock) {
				ItemBlockRenderTypes.setRenderLayer(regBlock.get(), RenderType.cutout());
			}
		}*/
        
		/*GlobalEntityTypeAttributes.put(ModEntityType.COLORED_SLIME.get(), ColoredSlimeEntity.getAttributes());
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

	@OnlyIn(Dist.CLIENT)
	public static Object clientOnlySetup() {
		for (RegistryObject<Block> regBlock : ModBlocks.BLOCKS.getEntries()) {
			if (regBlock.get() instanceof ColoredSlimeBlock) {
				ItemBlockRenderTypes.setRenderLayer(regBlock.get(), RenderType.translucent());
			}
			else if (regBlock.get() instanceof YellowMushroomBlock) {
				ItemBlockRenderTypes.setRenderLayer(regBlock.get(), RenderType.cutout());
			}
		}

		return null;
	}
}