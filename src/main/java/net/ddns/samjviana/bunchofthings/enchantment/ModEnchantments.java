package net.ddns.samjviana.bunchofthings.enchantment;

import net.ddns.samjviana.bunchofthings.BunchOfThings;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEnchantments {
	public static DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, BunchOfThings.MODID);

	public static final RegistryObject<Enchantment> GRASS_WALKER = ENCHANTMENTS.register("grass_walker", () -> new GrassWalkerEnchantment());
}
