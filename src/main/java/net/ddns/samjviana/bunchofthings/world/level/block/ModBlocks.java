package net.ddns.samjviana.bunchofthings.world.level.block;

import java.util.HashMap;
import java.util.Map;

import net.ddns.samjviana.bunchofthings.BunchOfThings;
import net.ddns.samjviana.bunchofthings.state.properties.Colors;
import net.ddns.samjviana.bunchofthings.world.level.block.piston.ColoredMovingPistonBlock;
import net.minecraft.client.renderer.blockentity.PistonHeadRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.piston.PistonBaseBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
        DeferredRegister.create(ForgeRegistries.BLOCKS, BunchOfThings.MODID);

    public static final RegistryObject<Block> WHITE_SLIME_BLOCK =
        BLOCKS.register(
            "white_slime_block",
            () -> {
                return new ColoredSlimeBlock(
                    BlockBehaviour.Properties
                        .of(Material.CLAY)
                        .friction(0.8f)
                        .sound(SoundType.SLIME_BLOCK)
                        .noOcclusion(),
                    Colors.WHITE
                );
            }
        );
    public static final RegistryObject<Block> ORANGE_SLIME_BLOCK =
        BLOCKS.register(
            "orange_slime_block",
            () -> {
                return new ColoredSlimeBlock(
                    BlockBehaviour.Properties
                        .of(Material.CLAY)
                        .friction(0.8f)
                        .sound(SoundType.SLIME_BLOCK)
                        .noOcclusion(),
                    Colors.ORANGE
                );
            }
        );
    public static final RegistryObject<Block> MAGENTA_SLIME_BLOCK =
        BLOCKS.register(
            "magenta_slime_block",
            () -> {
                return new ColoredSlimeBlock(
                    BlockBehaviour.Properties
                        .of(Material.CLAY)
                        .friction(0.8f)
                        .sound(SoundType.SLIME_BLOCK)
                        .noOcclusion(),
                    Colors.MAGENTA
                );
            }
        );
    public static final RegistryObject<Block> LIGHT_BLUE_SLIME_BLOCK =
        BLOCKS.register(
            "light_blue_slime_block",
            () -> {
                return new ColoredSlimeBlock(
                    BlockBehaviour.Properties
                        .of(Material.CLAY)
                        .friction(0.8f)
                        .sound(SoundType.SLIME_BLOCK)
                        .noOcclusion(),
                    Colors.LIGHT_BLUE
                );
            }
        );
    public static final RegistryObject<Block> YELLOW_SLIME_BLOCK =
        BLOCKS.register(
            "yellow_slime_block",
            () -> {
                return new ColoredSlimeBlock(
                    BlockBehaviour.Properties
                        .of(Material.CLAY)
                        .friction(0.8f)
                        .sound(SoundType.SLIME_BLOCK)
                        .noOcclusion(),
                    Colors.YELLOW
                );
            }
        );
    public static final RegistryObject<Block> LIME_SLIME_BLOCK =
        BLOCKS.register(
            "lime_slime_block",
            () -> {
                return new ColoredSlimeBlock(
                    BlockBehaviour.Properties
                        .of(Material.CLAY)
                        .friction(0.8f)
                        .sound(SoundType.SLIME_BLOCK)
                        .noOcclusion(),
                    Colors.LIME
                );
            }
        );
    public static final RegistryObject<Block> PINK_SLIME_BLOCK =
        BLOCKS.register(
            "pink_slime_block",
            () -> {
                return new ColoredSlimeBlock(
                    BlockBehaviour.Properties
                        .of(Material.CLAY)
                        .friction(0.8f)
                        .sound(SoundType.SLIME_BLOCK)
                        .noOcclusion(),
                    Colors.PINK
                );
            }
        );
    public static final RegistryObject<Block> GRAY_SLIME_BLOCK =
        BLOCKS.register(
            "gray_slime_block",
            () -> {
                return new ColoredSlimeBlock(
                    BlockBehaviour.Properties
                        .of(Material.CLAY)
                        .friction(0.8f)
                        .sound(SoundType.SLIME_BLOCK)
                        .noOcclusion(),
                    Colors.GRAY
                );
            }
        );
    public static final RegistryObject<Block> LIGHT_GRAY_SLIME_BLOCK =
        BLOCKS.register(
            "light_gray_slime_block",
            () -> {
                return new ColoredSlimeBlock(
                    BlockBehaviour.Properties
                        .of(Material.CLAY)
                        .friction(0.8f)
                        .sound(SoundType.SLIME_BLOCK)
                        .noOcclusion(),
                    Colors.LIGHT_GRAY
                );
            }
        );
    public static final RegistryObject<Block> CYAN_SLIME_BLOCK =
        BLOCKS.register(
            "cyan_slime_block",
            () -> {
                return new ColoredSlimeBlock(
                    BlockBehaviour.Properties
                        .of(Material.CLAY)
                        .friction(0.8f)
                        .sound(SoundType.SLIME_BLOCK)
                        .noOcclusion(),
                    Colors.CYAN
                );
            }
        );
    public static final RegistryObject<Block> PURPLE_SLIME_BLOCK =
        BLOCKS.register(
            "purple_slime_block",
            () -> {
                return new ColoredSlimeBlock(
                    BlockBehaviour.Properties
                        .of(Material.CLAY)
                        .friction(0.8f)
                        .sound(SoundType.SLIME_BLOCK)
                        .noOcclusion(),
                    Colors.PURPLE
                );
            }
        );
    public static final RegistryObject<Block> BLUE_SLIME_BLOCK =
        BLOCKS.register(
            "blue_slime_block",
            () -> {
                return new ColoredSlimeBlock(
                    BlockBehaviour.Properties
                        .of(Material.CLAY)
                        .friction(0.8f)
                        .sound(SoundType.SLIME_BLOCK)
                        .noOcclusion(),
                    Colors.BLUE
                );
            }
        );
    public static final RegistryObject<Block> BROWN_SLIME_BLOCK =
        BLOCKS.register(
            "brown_slime_block",
            () -> {
                return new ColoredSlimeBlock(
                    BlockBehaviour.Properties
                        .of(Material.CLAY)
                        .friction(0.8f)
                        .sound(SoundType.SLIME_BLOCK)
                        .noOcclusion(),
                    Colors.BROWN
                );
            }
        );
    public static final RegistryObject<Block> GREEN_SLIME_BLOCK =
        BLOCKS.register(
            "green_slime_block",
            () -> {
                return new ColoredSlimeBlock(
                    BlockBehaviour.Properties
                        .of(Material.CLAY)
                        .friction(0.8f)
                        .sound(SoundType.SLIME_BLOCK)
                        .noOcclusion(),
                    Colors.GREEN
                );
            }
        );
    public static final RegistryObject<Block> RED_SLIME_BLOCK = BLOCKS.register(
        "red_slime_block",
        () -> {
            return new ColoredSlimeBlock(
                BlockBehaviour.Properties
                    .of(Material.CLAY)
                    .friction(0.8f)
                    .sound(SoundType.SLIME_BLOCK)
                    .noOcclusion(),
                Colors.RED
            );
        }
    );
    public static final RegistryObject<Block> BLACK_SLIME_BLOCK =
        BLOCKS.register(
            "black_slime_block",
            () -> {
                return new ColoredSlimeBlock(
                    BlockBehaviour.Properties
                        .of(Material.CLAY)
                        .friction(0.8f)
                        .sound(SoundType.SLIME_BLOCK)
                        .noOcclusion(),
                    Colors.BLACK
                );
            }
        );

    public static final RegistryObject<Block> YELLOW_MUSHROOM = BLOCKS.register(
        "yellow_mushroom",
        () -> {
            return new YellowMushroomBlock(
                BlockBehaviour.Properties
                    .of(Material.PLANT, MaterialColor.COLOR_YELLOW)
                    .noCollission()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.GRASS)
            );
        }
    );

    // public static final RegistryObject<Block> COLORED_STICKY_PISTON = BLOCKS.register("colored_sticky_piston", () -> {
    //     return new ColoredStickyPistonBlock(
    //         true,
    //         BlockBehaviour.Properties.of(Material.PISTON).strength(1.5f).isRedstoneConductor(
    //             (blockState, level, blockPos) -> false
    //         ).isSuffocating(
    //             (blockState, level, blockPos) -> !blockState.getValue(PistonBaseBlock.EXTENDED)
    //         ).isViewBlocking(
    //             (blockState, level, blockPos) -> false
    //         ),
    //         Colors.WHITE
    //     );
    // });
    
    public static final Map<Colors, RegistryObject<Block>> COLORED_STICKY_PISTONS = new HashMap<>();
    static {
        for (Colors color : Colors.values()) {
            COLORED_STICKY_PISTONS.put(
                color,
                BLOCKS.register(
                    color.toString() + "_sticky_piston",
                    () -> {
                        BlockBehaviour.StatePredicate blockbehaviour$statepredicate = (p_152641_, p_152642_, p_152643_) -> {
                        return !p_152641_.getValue(PistonBaseBlock.EXTENDED);
                        };
                        return new ColoredStickyPistonBlock(
                            true,
                            BlockBehaviour.Properties.of(Material.PISTON).strength(1.5f)
                                .isRedstoneConductor(ModBlocks::never)
                                .isSuffocating(blockbehaviour$statepredicate)
                                .isViewBlocking(blockbehaviour$statepredicate),
                            color
                        );
                    }
                )
            );
        }
    }

    public static final RegistryObject<Block> COLORED_STICKY_PISTON_HEAD = BLOCKS.register(
        "colored_sticky_piston_head",
        () -> {
            return new ColoredStickyPistonHeadBlock(
                Colors.WHITE,
                BlockBehaviour.Properties
                    .of(Material.PISTON)
                    .strength(1.5f)
                    .noLootTable()
            );
        }
    );

    public static final RegistryObject<Block> COLORED_MOVING_PISTON = BLOCKS.register(
        "colored_moving_piston",
        () -> {
            return new ColoredMovingPistonBlock(BlockBehaviour.Properties.of(Material.PISTON).strength(-1.0F).dynamicShape().noLootTable().noOcclusion()
                .isRedstoneConductor(ModBlocks::never)
                .isSuffocating(ModBlocks::never)
                .isViewBlocking(ModBlocks::never)
            );
        }
    );

    private static boolean never(BlockState p_50806_, BlockGetter p_50807_, BlockPos p_50808_) {
        return false;
    }

}
