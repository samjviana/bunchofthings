package net.ddns.samjviana.bunchofthings;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BunchOfThings.MODID, value = Dist.CLIENT)
public class ClientEventSubscriber {
    /*@SubscribeEvent
    public static void onLivingUpdate(final LivingTickEvent event) {
        if (event.getEntity().level.isClientSide) {
            int maxLevel = EnchantmentHelper.getEnchantmentLevel(ModEnchantments.GRASS_WALKER.get(), event.getEntity());

			if (maxLevel > 0 && event.getEntity().isOnGround()) {
				GrassWalkerEnchantment.grassilizeNearby(event.getEntity(), maxLevel);
			}
		}
    }*/
}
