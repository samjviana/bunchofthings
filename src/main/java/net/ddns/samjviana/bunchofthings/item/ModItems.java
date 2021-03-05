package net.ddns.samjviana.bunchofthings.item;

import net.ddns.samjviana.bunchofthings.BunchOfThings;
import net.ddns.samjviana.bunchofthings.entity.ModEntityType;
import net.ddns.samjviana.bunchofthings.entity.monster.ColoredSlimeEntity;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.datafix.fixes.ItemSpawnEggSplit;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BunchOfThings.MODID);

    public static final RegistryObject<Item> WHITE_SLIME_BALL = ITEMS.register("white_slime_ball", () -> new Item((new Item.Properties()).group(ModItemGroup.ITEMS)));
    public static final RegistryObject<Item> ORANGE_SLIME_BALL = ITEMS.register("orange_slime_ball", () -> new Item((new Item.Properties()).group(ModItemGroup.ITEMS)));
    public static final RegistryObject<Item> MAGENTA_SLIME_BALL = ITEMS.register("magenta_slime_ball", () -> new Item((new Item.Properties()).group(ModItemGroup.ITEMS)));
    public static final RegistryObject<Item> LIGHT_BLUE_SLIME_BALL = ITEMS.register("light_blue_slime_ball", () -> new Item((new Item.Properties()).group(ModItemGroup.ITEMS)));
    public static final RegistryObject<Item> YELLOW_SLIME_BALL = ITEMS.register("yellow_slime_ball", () -> new Item((new Item.Properties()).group(ModItemGroup.ITEMS)));
    public static final RegistryObject<Item> LIME_SLIME_BALL = ITEMS.register("lime_slime_ball", () -> new Item((new Item.Properties()).group(ModItemGroup.ITEMS)));
    public static final RegistryObject<Item> PINK_SLIME_BALL = ITEMS.register("pink_slime_ball", () -> new Item((new Item.Properties()).group(ModItemGroup.ITEMS)));
    public static final RegistryObject<Item> GRAY_SLIME_BALL = ITEMS.register("gray_slime_ball", () -> new Item((new Item.Properties()).group(ModItemGroup.ITEMS)));
    public static final RegistryObject<Item> LIGHT_GRAY_SLIME_BALL = ITEMS.register("light_gray_slime_ball", () -> new Item((new Item.Properties()).group(ModItemGroup.ITEMS)));
    public static final RegistryObject<Item> CYAN_SLIME_BALL = ITEMS.register("cyan_slime_ball", () -> new Item((new Item.Properties()).group(ModItemGroup.ITEMS)));
    public static final RegistryObject<Item> PURPLE_SLIME_BALL = ITEMS.register("purple_slime_ball", () -> new Item((new Item.Properties()).group(ModItemGroup.ITEMS)));
    public static final RegistryObject<Item> BLUE_SLIME_BALL = ITEMS.register("blue_slime_ball", () -> new Item((new Item.Properties()).group(ModItemGroup.ITEMS)));
    public static final RegistryObject<Item> BROWN_SLIME_BALL = ITEMS.register("brown_slime_ball", () -> new Item((new Item.Properties()).group(ModItemGroup.ITEMS)));
    public static final RegistryObject<Item> GREEN_SLIME_BALL = ITEMS.register("green_slime_ball", () -> new Item((new Item.Properties()).group(ModItemGroup.ITEMS)));
    public static final RegistryObject<Item> RED_SLIME_BALL = ITEMS.register("red_slime_ball", () -> new Item((new Item.Properties()).group(ModItemGroup.ITEMS)));
    public static final RegistryObject<Item> BLACK_SLIME_BALL = ITEMS.register("black_slime_ball", () -> new Item((new Item.Properties()).group(ModItemGroup.ITEMS)));
    public static final RegistryObject<Item> COLORED_SLIME_SPAWN_EGG = ITEMS.register("colored_slime_spawn_egg", () -> new SpawnEggItem(ModEntityType.COLORED_SLIME_ENTITY_TYPE, 0x00ff00, 0x0000ff, new Item.Properties().group(ModItemGroup.ENTITIES)));
}