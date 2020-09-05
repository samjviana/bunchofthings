package net.ddns.samjviana.bunchofthings;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.screen.inventory.InventoryScreen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.GuiScreenEvent.InitGuiEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.SlotItemHandler;

@Mod.EventBusSubscriber(modid = BunchOfThings.MODID, value = Dist.CLIENT)
public class ClientEventSubscriber {
    @SubscribeEvent
    public static void onInitGui(final InitGuiEvent event) {
        final Screen gui = event.getGui();
        if (gui instanceof InventoryScreen) {
            InventoryScreen inventoryGui = (InventoryScreen) gui;
            ClientPlayerEntity player = gui.getMinecraft().player;
            event.addWidget(new Button(inventoryGui.field_230708_k_ + 50, inventoryGui.field_230709_l_, 20, 20,
                    new StringTextComponent("<"),
                    button -> Minecraft.getInstance().displayGuiScreen(new ChatScreen("defaultText"))));

            Method addWidget = ObfuscationReflectionHelper.findMethod(Screen.class, "func_230480_a_",
                    Widget.class);
            try {
                int xPos = inventoryGui.getGuiLeft() + 158;
                int yPos = inventoryGui.field_230709_l_ / 2 - 14;
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

    public static void sortInventory(List<Slot> inventory) {
        for (Slot slot : inventory) {
            if (slot instanceof SlotItemHandler) {
                IItemHandler handler = ((SlotItemHandler)slot).getItemHandler();
                BunchOfThings.LOGGER.debug(handler.getStackInSlot(slot.slotNumber));
            }
        }
    }
}
