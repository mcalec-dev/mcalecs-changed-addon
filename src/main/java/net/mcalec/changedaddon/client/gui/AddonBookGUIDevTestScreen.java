
package net.mcalec.changedaddon.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcalec.changedaddon.world.inventory.AddonBookGUIDevTestMenu;
import net.mcalec.changedaddon.network.AddonBookGUIDevTestButtonMessage;
import net.mcalec.changedaddon.McalecsChangedMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class AddonBookGUIDevTestScreen extends AbstractContainerScreen<AddonBookGUIDevTestMenu> {
	private final static HashMap<String, Object> guistate = AddonBookGUIDevTestMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_untransfer;
	Button button_exit;
	Button button_time_set_day;

	public AddonBookGUIDevTestScreen(AddonBookGUIDevTestMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("mcalecs_changed:textures/screens/addon_book_gui_dev_test.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, new TranslatableComponent("gui.mcalecs_changed.addon_book_gui_dev_test.label_mcalecs_dev_test_screen"), 26, 14, -16777216);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		button_untransfer = new Button(this.leftPos + 5, this.topPos + 138, 77, 20, new TranslatableComponent("gui.mcalecs_changed.addon_book_gui_dev_test.button_untransfer"), e -> {
			if (true) {
				McalecsChangedMod.PACKET_HANDLER.sendToServer(new AddonBookGUIDevTestButtonMessage(0, x, y, z));
				AddonBookGUIDevTestButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_untransfer", button_untransfer);
		this.addRenderableWidget(button_untransfer);
		button_exit = new Button(this.leftPos + 4, this.topPos + 169, 46, 20, new TranslatableComponent("gui.mcalecs_changed.addon_book_gui_dev_test.button_exit"), e -> {
			if (true) {
				McalecsChangedMod.PACKET_HANDLER.sendToServer(new AddonBookGUIDevTestButtonMessage(1, x, y, z));
				AddonBookGUIDevTestButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_exit", button_exit);
		this.addRenderableWidget(button_exit);
		button_time_set_day = new Button(this.leftPos + 82, this.topPos + 138, 87, 20, new TranslatableComponent("gui.mcalecs_changed.addon_book_gui_dev_test.button_time_set_day"), e -> {
			if (true) {
				McalecsChangedMod.PACKET_HANDLER.sendToServer(new AddonBookGUIDevTestButtonMessage(2, x, y, z));
				AddonBookGUIDevTestButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_time_set_day", button_time_set_day);
		this.addRenderableWidget(button_time_set_day);
	}
}
