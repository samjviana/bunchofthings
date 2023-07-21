package net.ddns.samjviana.bunchofthings.world.level.block.entity;

import net.ddns.samjviana.bunchofthings.BunchOfThings;
import net.ddns.samjviana.bunchofthings.world.level.block.ModBlocks;
import net.ddns.samjviana.bunchofthings.world.level.block.piston.ColoredMovingPistonBlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntityType {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, BunchOfThings.MODID);

    public static final RegistryObject<BlockEntityType<ColoredMovingPistonBlockEntity>> COLORED_MOVING_PISTON = BLOCK_ENTITY_TYPES.register(
        "colored_moving_piston",
        () -> BlockEntityType.Builder.of(ColoredMovingPistonBlockEntity::new, ModBlocks.COLORED_MOVING_PISTON.get()).build(null)
    );
}