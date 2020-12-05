package net.ddns.samjviana.bunchofthings;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import net.ddns.samjviana.bunchofthings.block.ModBlocks;
import net.ddns.samjviana.bunchofthings.enchantment.ModEnchantments;
import net.ddns.samjviana.bunchofthings.tags.ModBlockTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.RedstoneWireBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.inventory.InventoryScreen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Slot;
import net.minecraft.state.properties.RedstoneSide;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.GuiScreenEvent.InitGuiEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

@Mod.EventBusSubscriber(modid = BunchOfThings.MODID, value = Dist.CLIENT)
public class ClientEventSubscriber {
    private static final boolean isDev = false;

    @SubscribeEvent
    public static void onInitGui(final InitGuiEvent event) {
        final Screen gui = event.getGui();
        if (gui instanceof InventoryScreen && isDev) {
            InventoryScreen inventoryGui = (InventoryScreen) gui;
            ClientPlayerEntity player = gui.getMinecraft().player;
            event.addWidget(new Button(inventoryGui.width + 50, inventoryGui.height, 20, 20,
                new StringTextComponent("<"),
                button -> Minecraft.getInstance().displayGuiScreen(new ChatScreen("defaultText")))
                );

            Method addWidget = ObfuscationReflectionHelper.findMethod(Screen.class, "func_230480_a_",
                    Widget.class);
            try {
                int xPos = inventoryGui.getGuiLeft() + 158;
                int yPos = inventoryGui.height / 2 - 14;
                addWidget.invoke(inventoryGui,
                        new ImageButton(xPos, yPos, 11, 11,
                                0, 0, 11, new ResourceLocation(BunchOfThings.MODID, "textures/gui/sorticon.png"), (p_214086_1_) -> {
                                    sortInventory(player.container.inventorySlots);
                                }));
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    private static void sortInventory(List<Slot> inventory) {
        for (Slot slot : inventory) {
            if (slot instanceof SlotItemHandler) {
                IItemHandler handler = ((SlotItemHandler)slot).getItemHandler();
                BunchOfThings.LOGGER.debug(handler.getStackInSlot(slot.slotNumber));
            }
        }
    }

    @SubscribeEvent
    public static void onLivingUpdate(final LivingUpdateEvent event) {

    } 
}
