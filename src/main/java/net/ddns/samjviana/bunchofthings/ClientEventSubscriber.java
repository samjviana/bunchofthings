package net.ddns.samjviana.bunchofthings;

import net.ddns.samjviana.bunchofthings.world.entity.ModEntityType;
import net.ddns.samjviana.bunchofthings.world.entity.monster.ColoredSlime;
import net.minecraft.world.entity.monster.Slime;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
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
