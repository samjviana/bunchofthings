package net.ddns.samjviana.bunchofthings.world.item;

import java.util.HashMap;
import java.util.Map;

import net.ddns.samjviana.bunchofthings.BunchOfThings;
import net.ddns.samjviana.bunchofthings.state.properties.Colors;
import net.ddns.samjviana.bunchofthings.world.entity.ModEntityType;
import net.ddns.samjviana.bunchofthings.world.level.block.ColoredStickyPistonBlock;
import net.ddns.samjviana.bunchofthings.world.level.block.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
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
                () -> {
                    BlockItem blockItem = new BlockItem(
                        ModBlocks.COLORED_STICKY_PISTONS.get(color).get(),
                        properties
                    );
                    
                    return blockItem;
                }
            ));
        }
    }

    public static final RegistryObject<Item> WHITE_SLIME_BALL = ITEMS.register("white_slime_ball", () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> ORANGE_SLIME_BALL = ITEMS.register("orange_slime_ball", () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> MAGENTA_SLIME_BALL = ITEMS.register("magenta_slime_ball", () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> LIGHT_BLUE_SLIME_BALL = ITEMS.register("light_blue_slime_ball", () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> YELLOW_SLIME_BALL = ITEMS.register("yellow_slime_ball", () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> LIME_SLIME_BALL = ITEMS.register("lime_slime_ball", () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> PINK_SLIME_BALL = ITEMS.register("pink_slime_ball", () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> GRAY_SLIME_BALL = ITEMS.register("gray_slime_ball", () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> LIGHT_GRAY_SLIME_BALL = ITEMS.register("light_gray_slime_ball", () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> CYAN_SLIME_BALL = ITEMS.register("cyan_slime_ball", () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> PURPLE_SLIME_BALL = ITEMS.register("purple_slime_ball", () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> BLUE_SLIME_BALL = ITEMS.register("blue_slime_ball", () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> BROWN_SLIME_BALL = ITEMS.register("brown_slime_ball", () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> GREEN_SLIME_BALL = ITEMS.register("green_slime_ball", () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> RED_SLIME_BALL = ITEMS.register("red_slime_ball", () -> new Item((new Item.Properties())));
    public static final RegistryObject<Item> BLACK_SLIME_BALL = ITEMS.register("black_slime_ball", () -> new Item((new Item.Properties())));
    //public static final RegistryObject<Item> COLORED_SLIME_SPAWN_EGG = ITEMS.register("colored_slime_spawn_egg", () -> new SpawnEggItem(ModEntityType.COLORED_SLIME_TYPE, 0x00ff00, 0x0000ff, new Item.Properties()));
}
