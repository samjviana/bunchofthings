package net.ddns.samjviana.bunchofthings;

import java.util.List;

import net.ddns.samjviana.bunchofthings.enchantment.ModEnchantments;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IGrowable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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
                Entity entity = event.getEntity();
                if (entity instanceof ServerPlayerEntity && ((ServerPlayerEntity)entity).isSpectator()) {
                    return;
                }

                World world = entity.world;
                int level = maxLevel;
                BlockPos pos = entity.getPosition();
                for (int x = -level; x <= level; x++) {
                    for (int z = -level; z <= level; z++) {
                        if (world.rand.nextInt(100) < 95) {
                            continue;
                        }
                        BlockPos spreadPos = pos.add(x, -1, z);

                        double distance = spreadPos.distanceSq(pos.getX(), pos.getY(), pos.getZ(), false);
                        double levelPow = (level * level) - 1;
                        if (distance > levelPow) {
                            continue;
                        }

                        BlockState blockState = world.getBlockState(spreadPos);
                        if (blockState.getBlock() == Blocks.DIRT) {
                            world.setBlockState(spreadPos, Blocks.GRASS_BLOCK.getDefaultState());
                        }
                        else if (blockState.getBlock() == Blocks.COBBLESTONE) {
                            world.setBlockState(spreadPos, Blocks.MOSSY_COBBLESTONE.getDefaultState());
                        }
                        else if (blockState.getBlock() == Blocks.STONE_BRICKS) {
                            world.setBlockState(spreadPos, Blocks.MOSSY_STONE_BRICKS.getDefaultState());
                        }
                        else if (blockState.getBlock() == Blocks.GRASS_BLOCK && level == 3 && world.rand.nextInt(100) < 2) {
                            IGrowable iGrowable = (IGrowable)blockState.getBlock();
                            if (iGrowable.canGrow(world, pos, blockState, world.isRemote)) {
                                if (iGrowable.canUseBonemeal(world, world.rand, pos, blockState)) {
                                    iGrowable.grow((ServerWorld)world, world.rand, pos, blockState);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
