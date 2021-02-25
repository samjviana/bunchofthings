package net.ddns.samjviana.bunchofthings.block;

import net.ddns.samjviana.bunchofthings.BunchOfThings;
import net.ddns.samjviana.bunchofthings.state.properties.Colors;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.MushroomBlock;
import net.minecraft.block.PistonBlock;
import net.minecraft.block.SlimeBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.gui.recipebook.RecipeBookGui;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BunchOfThings.MODID);

    public static final RegistryObject<Block> COLORED_STICKY_PISTON_HEAD = BLOCKS.register("colored_sticky_piston_head", () -> new ColoredStickyPistonHeadBlock(AbstractBlock.Properties.create(Material.PISTON).hardnessAndResistance(1.5f).noDrops()));
    public static final RegistryObject<Block> YELLOW_MUSHROOM = BLOCKS.register("yellow_mushroom", () -> new YellowMushroomBlock(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().zeroHardnessAndResistance().notSolid().sound(SoundType.PLANT)));

    private static ColoredStickyPistonBlock createColoredStickyPiston(Colors color) {
        AbstractBlock.IPositionPredicate abstractblock$ipositionpredicate = (p_235440_0_, p_235440_1_, p_235440_2_) -> {
            return !p_235440_0_.get(ColoredStickyPistonBlock.EXTENDED);
        };
        return new ColoredStickyPistonBlock(color, true, AbstractBlock.Properties.create(Material.PISTON).hardnessAndResistance(1.5F).setOpaque(ModBlocks::isntSolid).setSuffocates(abstractblock$ipositionpredicate).setBlocksVision(abstractblock$ipositionpredicate));
    }

    private static boolean isntSolid(BlockState state, IBlockReader reader, BlockPos pos) {
        return false;
    }

    public static void registerStickyPistons() {
        for (int i = 0; i < Colors.values().length; i++) {
            Colors color = Colors.values()[i];
            BLOCKS.register(color.toString() + "_sticky_piston", () -> createColoredStickyPiston(color));
        }
    }

    public static void registerSlimeBlocks() {
        for (int i = 0; i < Colors.values().length; i++) {
            Colors color = Colors.values()[i];
            BLOCKS.register(color.toString() + "_slime_block", () -> new ColoredSlimeBlock(AbstractBlock.Properties.create(Material.CLAY).slipperiness(0.8f).sound(SoundType.SLIME).notSolid()));
        }
    }
}