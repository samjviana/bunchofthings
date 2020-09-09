package net.ddns.samjviana.bunchofthings.block;

import net.ddns.samjviana.bunchofthings.state.properties.Colors;
import net.ddns.samjviana.bunchofthings.state.properties.ModBlockStateProperties;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlimeBlock;
import net.minecraft.state.EnumProperty;

public class ColoredSlimeBlock extends SlimeBlock {
    public static final EnumProperty<Colors> COLOR = ModBlockStateProperties.COLOR;

    public ColoredSlimeBlock(Properties properties) {
        super(properties);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean isStickyBlock(BlockState state) {
        return true;
    }
}
