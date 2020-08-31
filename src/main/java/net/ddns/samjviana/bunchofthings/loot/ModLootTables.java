package net.ddns.samjviana.bunchofthings.loot;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.util.ResourceLocation;

public class ModLootTables {
    private static final Set<ResourceLocation> LOOT_TABLES = Sets.newHashSet();

    public static final ResourceLocation ENTITIES_SLIME_WHITE = register("bunchofthings:entities/colored_slime/white");
    public static final ResourceLocation ENTITIES_SLIME_ORANGE = register("bunchofthings:entities/colored_slime/orange");
    public static final ResourceLocation ENTITIES_SLIME_MAGENTA = register("bunchofthings:entities/colored_slime/magenta");
    public static final ResourceLocation ENTITIES_SLIME_LIGHT_BLUE = register("bunchofthings:entities/colored_slime/light_blue");
    public static final ResourceLocation ENTITIES_SLIME_YELLOW = register("bunchofthings:entities/colored_slime/yellow");
    public static final ResourceLocation ENTITIES_SLIME_LIME = register("bunchofthings:entities/colored_slime/lime");
    public static final ResourceLocation ENTITIES_SLIME_PINK = register("bunchofthings:entities/colored_slime/pink");
    public static final ResourceLocation ENTITIES_SLIME_GRAY = register("bunchofthings:entities/colored_slime/gray");
    public static final ResourceLocation ENTITIES_SLIME_LIGHT_GRAY = register("bunchofthings:entities/colored_slime/light_gray");
    public static final ResourceLocation ENTITIES_SLIME_CYAN = register("bunchofthings:entities/colored_slime/cyan");
    public static final ResourceLocation ENTITIES_SLIME_PURPLE = register("bunchofthings:entities/colored_slime/purple");
    public static final ResourceLocation ENTITIES_SLIME_BLUE = register("bunchofthings:entities/colored_slime/blue");
    public static final ResourceLocation ENTITIES_SLIME_BROWN = register("bunchofthings:entities/colored_slime/brown");
    public static final ResourceLocation ENTITIES_SLIME_GREEN = register("bunchofthings:entities/colored_slime/green");
    public static final ResourceLocation ENTITIES_SLIME_RED = register("bunchofthings:entities/colored_slime/red");
    public static final ResourceLocation ENTITIES_SLIME_BLACK = register("bunchofthings:entities/colored_slime/black");

    private static ResourceLocation register(String id) {
        return register(new ResourceLocation(id));
    }

    private static ResourceLocation register(ResourceLocation id) {
        if (LOOT_TABLES.add(id)) {
            return id;
        } else {
            throw new IllegalArgumentException(id + " is already a registered built-in loot table");
        }
    }
}