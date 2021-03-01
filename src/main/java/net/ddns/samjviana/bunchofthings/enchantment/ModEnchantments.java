package net.ddns.samjviana.bunchofthings.enchantment;

import net.ddns.samjviana.bunchofthings.BunchOfThings;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, BunchOfThings.MODID);
    
    public static final RegistryObject<Enchantment> GRASS_WALKER = ENCHANTMENTS.register("grass_walker", () -> new GrassWalkerEnchament());
}
