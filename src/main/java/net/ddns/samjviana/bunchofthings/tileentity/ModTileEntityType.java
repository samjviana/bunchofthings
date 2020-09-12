package net.ddns.samjviana.bunchofthings.tileentity;

import net.ddns.samjviana.bunchofthings.BunchOfThings;
import net.ddns.samjviana.bunchofthings.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityType {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, BunchOfThings.MODID);

    public static final RegistryObject<TileEntityType<ColoredPistonTileEntity>> COLORED_PISTON = TILE_ENTITIES.register("colored_tile_piston", () ->
        TileEntityType.Builder.create(ColoredPistonTileEntity::new, Blocks.MOVING_PISTON).build(null)
    );
}
