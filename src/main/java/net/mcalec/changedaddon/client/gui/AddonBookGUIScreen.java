
package net.mcalec.changedaddon.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcalec.changedaddon.world.inventory.AddonBookGUIMenu;
import net.mcalec.changedaddon.network.AddonBookGUIButtonMessage;
import net.mcalec.changedaddon.McalecsChangedAddonMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class AddonBookGUIScreen extends AbstractContainerScreen<AddonBookGUIMenu> {
	private final static HashMap<String, Object> guistate = AddonBookGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox searchEngineTest;
	Button button_close;
	Button button_next;
	Button button_search;

	public AddonBookGUIScreen(AddonBookGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 208;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("mcalecs_changed_addon:textures/screens/addon_book_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		searchEngineTest.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		if (mouseX > leftPos + 95 && mouseX < leftPos + 119 && mouseY > topPos + 138 && mouseY < topPos + 162)
			this.renderTooltip(ms, new TranslatableComponent("gui.mcalecs_changed_addon.addon_book_gui.tooltip_more_pages_will_be_added_on_late"), mouseX, mouseY);
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
		if (searchEngineTest.isFocused())
			return searchEngineTest.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		searchEngineTest.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, new TranslatableComponent("gui.mcalecs_changed_addon.addon_book_gui.label_mcalecs_changed_addon"), 45, 28, -14145496);
		this.font.draw(poseStack, new TranslatableComponent("gui.mcalecs_changed_addon.addon_book_gui.label_thank_you_for_downloading"), 35, 98, -10066330);
		this.font.draw(poseStack, new TranslatableComponent("gui.mcalecs_changed_addon.addon_book_gui.label_hint_type_test_for_a_secret_s"), 5, 118, -10066330);
		this.font.draw(poseStack, new TranslatableComponent("gui.mcalecs_changed_addon.addon_book_gui.label_i"), 105, 148, -12829636);
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
		searchEngineTest = new EditBox(this.font, this.leftPos + 5, this.topPos + 58, 120, 20, new TranslatableComponent("gui.mcalecs_changed_addon.addon_book_gui.searchEngineTest")) {
			{
				setSuggestion(new TranslatableComponent("gui.mcalecs_changed_addon.addon_book_gui.searchEngineTest").getString());
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(new TranslatableComponent("gui.mcalecs_changed_addon.addon_book_gui.searchEngineTest").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(new TranslatableComponent("gui.mcalecs_changed_addon.addon_book_gui.searchEngineTest").getString());
				else
					setSuggestion(null);
			}
		};
		searchEngineTest.setMaxLength(32767);
		guistate.put("text:searchEngineTest", searchEngineTest);
		this.addWidget(this.searchEngineTest);
		button_close = new Button(this.leftPos + 15, this.topPos + 138, 51, 20, new TranslatableComponent("gui.mcalecs_changed_addon.addon_book_gui.button_close"), e -> {
			if (true) {
				McalecsChangedAddonMod.PACKET_HANDLER.sendToServer(new AddonBookGUIButtonMessage(0, x, y, z));
				AddonBookGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_close", button_close);
		this.addRenderableWidget(button_close);
		button_next = new Button(this.leftPos + 145, this.topPos + 138, 46, 20, new TranslatableComponent("gui.mcalecs_changed_addon.addon_book_gui.button_next"), e -> {
		});
		guistate.put("button:button_next", button_next);
		this.addRenderableWidget(button_next);
		button_search = new Button(this.leftPos + 145, this.topPos + 58, 56, 20, new TranslatableComponent("gui.mcalecs_changed_addon.addon_book_gui.button_search"), e -> {
			if (true) {
				McalecsChangedAddonMod.PACKET_HANDLER.sendToServer(new AddonBookGUIButtonMessage(2, x, y, z));
				AddonBookGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_search", button_search);
		this.addRenderableWidget(button_search);
	}
}
