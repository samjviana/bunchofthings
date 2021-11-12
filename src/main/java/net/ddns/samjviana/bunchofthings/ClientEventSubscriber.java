package net.ddns.samjviana.bunchofthings;

import java.util.List;

import net.ddns.samjviana.bunchofthings.enchantment.GrassWalkerEnchament;
import net.ddns.samjviana.bunchofthings.enchantment.ModEnchantments;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.properties.Half;
import net.minecraft.state.properties.SlabType;
import net.minecraft.state.properties.StairsShape;
import net.minecraft.util.Direction;
import net.minecraft.util.FoodStats;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.TickEvent.ClientTickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BunchOfThings.MODID, value = Dist.CLIENT)
public class ClientEventSubscriber {
    @SubscribeEvent
    public static void onLivingUpdate(final LivingUpdateEvent event) {
        if (!event.getEntity().world.isRemote) {
            int maxLevel = EnchantmentHelper.getMaxEnchantmentLevel(ModEnchantments.GRASS_WALKER.get(), event.getEntityLiving());

			if (maxLevel > 0 && event.getEntityLiving().isOnGround()) {
				GrassWalkerEnchament.grassilizeNearby(event, maxLevel);
			}
		}
    }
}
