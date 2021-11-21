package net.ddns.samjviana.bunchofthings;

import net.ddns.samjviana.bunchofthings.enchantment.GrassWalkerEnchantment;
import net.ddns.samjviana.bunchofthings.enchantment.ModEnchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BunchOfThings.MODID, value = Dist.CLIENT)
public class ClientEventSubscriber {
    @SubscribeEvent
    public static void onLivingUpdate(final LivingUpdateEvent event) {
        if (event.getEntity().level.isClientSide) {
            int maxLevel = EnchantmentHelper.getEnchantmentLevel(ModEnchantments.GRASS_WALKER.get(), event.getEntityLiving());

			if (maxLevel > 0 && event.getEntityLiving().isOnGround()) {
				GrassWalkerEnchantment.grassilizeNearby(event.getEntity(), maxLevel);
			}
		}
    }
}
