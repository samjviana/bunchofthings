package net.ddns.samjviana.morethings.block;

import net.ddns.samjviana.morethings.MoreThings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SlimeBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MoreThings.MODID);

    public static final RegistryObject<Block> WHITE_SLIME_BLOCK = BLOCKS.register("white_slime_block", () -> new SlimeBlock(AbstractBlock.Properties.create(Material.CLAY, MaterialColor.BLACK).slipperiness(0.8f).sound(SoundType.SLIME).notSolid()));
    public static final RegistryObject<Block> ORANGE_SLIME_BLOCK = BLOCKS.register("orange_slime_block", () -> new SlimeBlock(AbstractBlock.Properties.create(Material.CLAY, MaterialColor.ORANGE_TERRACOTTA).slipperiness(0.8f).sound(SoundType.SLIME).notSolid()));
    public static final RegistryObject<Block> MAGENTA_SLIME_BLOCK = BLOCKS.register("magenta_slime_block", () -> new SlimeBlock(AbstractBlock.Properties.create(Material.CLAY, MaterialColor.MAGENTA).slipperiness(0.8f).sound(SoundType.SLIME).notSolid()));
    public static final RegistryObject<Block> LIGHT_BLUE_SLIME_BLOCK = BLOCKS.register("light_blue_slime_block", () -> new SlimeBlock(AbstractBlock.Properties.create(Material.CLAY, MaterialColor.LIGHT_BLUE).slipperiness(0.8f).sound(SoundType.SLIME).notSolid()));
    public static final RegistryObject<Block> YELLOW_SLIME_BLOCK = BLOCKS.register("yellow_slime_block", () -> new SlimeBlock(AbstractBlock.Properties.create(Material.CLAY, MaterialColor.YELLOW).slipperiness(0.8f).sound(SoundType.SLIME).notSolid()));
    public static final RegistryObject<Block> LIME_SLIME_BLOCK = BLOCKS.register("lime_slime_block", () -> new SlimeBlock(AbstractBlock.Properties.create(Material.CLAY, MaterialColor.LIME).slipperiness(0.8f).sound(SoundType.SLIME).notSolid()));
    public static final RegistryObject<Block> PINK_SLIME_BLOCK = BLOCKS.register("pink_slime_block", () -> new SlimeBlock(AbstractBlock.Properties.create(Material.CLAY, MaterialColor.PINK).slipperiness(0.8f).sound(SoundType.SLIME).notSolid()));
    public static final RegistryObject<Block> GRAY_SLIME_BLOCK = BLOCKS.register("gray_slime_block", () -> new SlimeBlock(AbstractBlock.Properties.create(Material.CLAY, MaterialColor.GRAY).slipperiness(0.8f).sound(SoundType.SLIME).notSolid()));
    public static final RegistryObject<Block> LIGHT_GRAY_SLIME_BLOCK = BLOCKS.register("light_gray_slime_block", () -> new SlimeBlock(AbstractBlock.Properties.create(Material.CLAY, MaterialColor.LIGHT_GRAY_TERRACOTTA).slipperiness(0.8f).sound(SoundType.SLIME).notSolid()));
    public static final RegistryObject<Block> CYAN_SLIME_BLOCK = BLOCKS.register("cyan_slime_block", () -> new SlimeBlock(AbstractBlock.Properties.create(Material.CLAY, MaterialColor.CYAN).slipperiness(0.8f).sound(SoundType.SLIME).notSolid()));
    public static final RegistryObject<Block> PURPLE_SLIME_BLOCK = BLOCKS.register("purple_slime_block", () -> new SlimeBlock(AbstractBlock.Properties.create(Material.CLAY, MaterialColor.PURPLE).slipperiness(0.8f).sound(SoundType.SLIME).notSolid()));
    public static final RegistryObject<Block> BLUE_SLIME_BLOCK = BLOCKS.register("blue_slime_block", () -> new SlimeBlock(AbstractBlock.Properties.create(Material.CLAY, MaterialColor.BLUE).slipperiness(0.8f).sound(SoundType.SLIME).notSolid()));
    public static final RegistryObject<Block> BROWN_SLIME_BLOCK = BLOCKS.register("brown_slime_block", () -> new SlimeBlock(AbstractBlock.Properties.create(Material.CLAY, MaterialColor.BROWN).slipperiness(0.8f).sound(SoundType.SLIME).notSolid()));
    public static final RegistryObject<Block> GREEN_SLIME_BLOCK = BLOCKS.register("green_slime_block", () -> new SlimeBlock(AbstractBlock.Properties.create(Material.CLAY, MaterialColor.GREEN).slipperiness(0.8f).sound(SoundType.SLIME).notSolid()));
    public static final RegistryObject<Block> RED_SLIME_BLOCK = BLOCKS.register("red_slime_block", () -> new SlimeBlock(AbstractBlock.Properties.create(Material.CLAY, MaterialColor.RED).slipperiness(0.8f).sound(SoundType.SLIME).notSolid()));
    public static final RegistryObject<Block> BLACK_SLIME_BLOCK = BLOCKS.register("black_slime_block", () -> new SlimeBlock(AbstractBlock.Properties.create(Material.CLAY, MaterialColor.BLACK).slipperiness(0.8f).sound(SoundType.SLIME).notSolid()));
}