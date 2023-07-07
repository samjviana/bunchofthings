package net.ddns.samjviana.bunchofthings.world.item;

import java.util.HashMap;
import java.util.Map;

import net.ddns.samjviana.bunchofthings.BunchOfThings;
import net.ddns.samjviana.bunchofthings.state.properties.Colors;
import net.ddns.samjviana.bunchofthings.world.level.block.ColoredStickyPistonBlock;
import net.ddns.samjviana.bunchofthings.world.level.block.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(
        ForgeRegistries.ITEMS,
        BunchOfThings.MODID
    );

    public static final RegistryObject<BlockItem> WHITE_SLIME_BLOCK_ITEM =
        ITEMS.register(
            "white_slime_block",
            () ->
                new BlockItem(
                    ModBlocks.WHITE_SLIME_BLOCK.get(),
                    new Item.Properties()
                )
        );
    public static final RegistryObject<BlockItem> ORANGE_SLIME_BLOCK_ITEM =
        ITEMS.register(
            "orange_slime_block",
            () ->
                new BlockItem(
                    ModBlocks.ORANGE_SLIME_BLOCK.get(),
                    new Item.Properties()
                )
        );
    public static final RegistryObject<BlockItem> MAGENTA_SLIME_BLOCK_ITEM =
        ITEMS.register(
            "magenta_slime_block",
            () ->
                new BlockItem(
                    ModBlocks.MAGENTA_SLIME_BLOCK.get(),
                    new Item.Properties()
                )
        );
    public static final RegistryObject<BlockItem> LIGHT_BLUE_SLIME_BLOCK_ITEM =
        ITEMS.register(
            "light_blue_slime_block",
            () ->
                new BlockItem(
                    ModBlocks.LIGHT_BLUE_SLIME_BLOCK.get(),
                    new Item.Properties()
                )
        );
    public static final RegistryObject<BlockItem> YELLOW_SLIME_BLOCK_ITEM =
        ITEMS.register(
            "yellow_slime_block",
            () ->
                new BlockItem(
                    ModBlocks.YELLOW_SLIME_BLOCK.get(),
                    new Item.Properties()
                )
        );
    public static final RegistryObject<BlockItem> LIME_SLIME_BLOCK_ITEM =
        ITEMS.register(
            "lime_slime_block",
            () ->
                new BlockItem(
                    ModBlocks.LIME_SLIME_BLOCK.get(),
                    new Item.Properties()
                )
        );
    public static final RegistryObject<BlockItem> PINK_SLIME_BLOCK_ITEM =
        ITEMS.register(
            "pink_slime_block",
            () ->
                new BlockItem(
                    ModBlocks.PINK_SLIME_BLOCK.get(),
                    new Item.Properties()
                )
        );
    public static final RegistryObject<BlockItem> GRAY_SLIME_BLOCK_ITEM =
        ITEMS.register(
            "gray_slime_block",
            () ->
                new BlockItem(
                    ModBlocks.GRAY_SLIME_BLOCK.get(),
                    new Item.Properties()
                )
        );
    public static final RegistryObject<BlockItem> LIGHT_GRAY_SLIME_BLOCK_ITEM =
        ITEMS.register(
            "light_gray_slime_block",
            () ->
                new BlockItem(
                    ModBlocks.LIGHT_GRAY_SLIME_BLOCK.get(),
                    new Item.Properties()
                )
        );
    public static final RegistryObject<BlockItem> CYAN_SLIME_BLOCK_ITEM =
        ITEMS.register(
            "cyan_slime_block",
            () ->
                new BlockItem(
                    ModBlocks.CYAN_SLIME_BLOCK.get(),
                    new Item.Properties()
                )
        );
    public static final RegistryObject<BlockItem> PURPLE_SLIME_BLOCK_ITEM =
        ITEMS.register(
            "purple_slime_block",
            () ->
                new BlockItem(
                    ModBlocks.PURPLE_SLIME_BLOCK.get(),
                    new Item.Properties()
                )
        );
    public static final RegistryObject<BlockItem> BLUE_SLIME_BLOCK_ITEM =
        ITEMS.register(
            "blue_slime_block",
            () ->
                new BlockItem(
                    ModBlocks.BLUE_SLIME_BLOCK.get(),
                    new Item.Properties()
                )
        );
    public static final RegistryObject<BlockItem> BROWN_SLIME_BLOCK_ITEM =
        ITEMS.register(
            "brown_slime_block",
            () ->
                new BlockItem(
                    ModBlocks.BROWN_SLIME_BLOCK.get(),
                    new Item.Properties()
                )
        );
    public static final RegistryObject<BlockItem> GREEN_SLIME_BLOCK_ITEM =
        ITEMS.register(
            "green_slime_block",
            () ->
                new BlockItem(
                    ModBlocks.GREEN_SLIME_BLOCK.get(),
                    new Item.Properties()
                )
        );
    public static final RegistryObject<BlockItem> RED_SLIME_BLOCK_ITEM =
        ITEMS.register(
            "red_slime_block",
            () ->
                new BlockItem(
                    ModBlocks.RED_SLIME_BLOCK.get(),
                    new Item.Properties()
                )
        );
    public static final RegistryObject<BlockItem> BLACK_SLIME_BLOCK_ITEM =
        ITEMS.register(
            "black_slime_block",
            () ->
                new BlockItem(
                    ModBlocks.BLACK_SLIME_BLOCK.get(),
                    new Item.Properties()
                )
        );

    public static final RegistryObject<BlockItem> YELLOW_MUSHROOM_ITEM =
        ITEMS.register(
            "yellow_mushroom",
            () ->
                new BlockItem(
                    ModBlocks.YELLOW_MUSHROOM.get(),
                    new Item.Properties()
                )
        );

    public static final Map<Colors, RegistryObject<Item>> COLORED_STICKY_PISTONS = new HashMap<>();
    static {
        Item.Properties properties = new Item.Properties();
        for (Colors color : Colors.values()) {
            COLORED_STICKY_PISTONS.put(color, ITEMS.register(
                color.toString() + "_sticky_piston",
                () -> new BlockItem(
                    ModBlocks.COLORED_STICKY_PISTON.get().defaultBlockState().setValue(ColoredStickyPistonBlock.COLOR, color).getBlock(),
                    properties
                )
            ));
        }
    }

    // public static final RegistryObject<BlockItem> WHITE_STICKY_PISTON_ITEM =
    //     ITEMS.register(
    //         "white_sticky_piston",
    //         () ->
    //             new BlockItem(
    //                 ModBlocks.WHITE_STICKY_PISTON.get(),
    //                 new Item.Properties()
    //             )
    //     );
    // public static final RegistryObject<BlockItem> ORANGE_STICKY_PISTON_ITEM =
    //     ITEMS.register(
    //         "orange_sticky_piston",
    //         () ->
    //             new BlockItem(
    //                 ModBlocks.ORANGE_STICKY_PISTON.get(),
    //                 new Item.Properties()
    //             )
    //     );
    // public static final RegistryObject<BlockItem> MAGENTA_STICKY_PISTON_ITEM =
    //     ITEMS.register(
    //         "magenta_sticky_piston",
    //         () ->
    //             new BlockItem(
    //                 ModBlocks.MAGENTA_STICKY_PISTON.get(),
    //                 new Item.Properties()
    //             )
    //     );
    // public static final RegistryObject<BlockItem> LIGHT_BLUE_STICKY_PISTON_ITEM =
    //     ITEMS.register(
    //         "light_blue_sticky_piston",
    //         () ->
    //             new BlockItem(
    //                 ModBlocks.LIGHT_BLUE_STICKY_PISTON.get(),
    //                 new Item.Properties()
    //             )
    //     );
    // public static final RegistryObject<BlockItem> YELLOW_STICKY_PISTON_ITEM =
    //     ITEMS.register(
    //         "yellow_sticky_piston",
    //         () ->
    //             new BlockItem(
    //                 ModBlocks.YELLOW_STICKY_PISTON.get(),
    //                 new Item.Properties()
    //             )
    //     );
    // public static final RegistryObject<BlockItem> LIME_STICKY_PISTON_ITEM =
    //     ITEMS.register(
    //         "lime_sticky_piston",
    //         () ->
    //             new BlockItem(
    //                 ModBlocks.LIME_STICKY_PISTON.get(),
    //                 new Item.Properties()
    //             )
    //     );
    // public static final RegistryObject<BlockItem> PINK_STICKY_PISTON_ITEM =
    //     ITEMS.register(
    //         "pink_sticky_piston",
    //         () ->
    //             new BlockItem(
    //                 ModBlocks.PINK_STICKY_PISTON.get(),
    //                 new Item.Properties()
    //             )
    //     );
    // public static final RegistryObject<BlockItem> GRAY_STICKY_PISTON_ITEM =
    //     ITEMS.register(
    //         "gray_sticky_piston",
    //         () ->
    //             new BlockItem(
    //                 ModBlocks.GRAY_STICKY_PISTON.get(),
    //                 new Item.Properties()
    //             )
    //     );
    // public static final RegistryObject<BlockItem> LIGHT_GRAY_STICKY_PISTON_ITEM =
    //     ITEMS.register(
    //         "light_gray_sticky_piston",
    //         () ->
    //             new BlockItem(
    //                 ModBlocks.LIGHT_GRAY_STICKY_PISTON.get(),
    //                 new Item.Properties()
    //             )
    //     );
    // public static final RegistryObject<BlockItem> CYAN_STICKY_PISTON_ITEM =
    //     ITEMS.register(
    //         "cyan_sticky_piston",
    //         () ->
    //             new BlockItem(
    //                 ModBlocks.CYAN_STICKY_PISTON.get(),
    //                 new Item.Properties()
    //             )
    //     );
    // public static final RegistryObject<BlockItem> PURPLE_STICKY_PISTON_ITEM =
    //     ITEMS.register(
    //         "purple_sticky_piston",
    //         () ->
    //             new BlockItem(
    //                 ModBlocks.PURPLE_STICKY_PISTON.get(),
    //                 new Item.Properties()
    //             )
    //     );
    // public static final RegistryObject<BlockItem> BLUE_STICKY_PISTON_ITEM =
    //     ITEMS.register(
    //         "blue_sticky_piston",
    //         () ->
    //             new BlockItem(
    //                 ModBlocks.BLUE_STICKY_PISTON.get(),
    //                 new Item.Properties()
    //             )
    //     );
    // public static final RegistryObject<BlockItem> BROWN_STICKY_PISTON_ITEM =
    //     ITEMS.register(
    //         "brown_sticky_piston",
    //         () ->
    //             new BlockItem(
    //                 ModBlocks.BROWN_STICKY_PISTON.get(),
    //                 new Item.Properties()
    //             )
    //     );
    // public static final RegistryObject<BlockItem> GREEN_STICKY_PISTON_ITEM =
    //     ITEMS.register(
    //         "green_sticky_piston",
    //         () ->
    //             new BlockItem(
    //                 ModBlocks.GREEN_STICKY_PISTON.get(),
    //                 new Item.Properties()
    //             )
    //     );
    // public static final RegistryObject<BlockItem> RED_STICKY_PISTON_ITEM =
    //     ITEMS.register(
    //         "red_sticky_piston",
    //         () ->
    //             new BlockItem(
    //                 ModBlocks.RED_STICKY_PISTON.get(),
    //                 new Item.Properties()
    //             )
    //     );
    // public static final RegistryObject<BlockItem> BLACK_STICKY_PISTON_ITEM =
    //     ITEMS.register(
    //         "black_sticky_piston",
    //         () ->
    //             new BlockItem(
    //                 ModBlocks.BLACK_STICKY_PISTON.get(),
    //                 new Item.Properties()
    //             )
    //     );
}
