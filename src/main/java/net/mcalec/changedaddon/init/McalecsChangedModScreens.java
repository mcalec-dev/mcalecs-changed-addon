
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcalec.changedaddon.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcalec.changedaddon.client.gui.AddonBookGUIScreen;
import net.mcalec.changedaddon.client.gui.AddonBookGUIPage1Screen;
import net.mcalec.changedaddon.client.gui.AddonBookGUIDevTestScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class McalecsChangedModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(McalecsChangedModMenus.ADDON_BOOK_GUI_PAGE_1, AddonBookGUIPage1Screen::new);
			MenuScreens.register(McalecsChangedModMenus.ADDON_BOOK_GUI, AddonBookGUIScreen::new);
			MenuScreens.register(McalecsChangedModMenus.ADDON_BOOK_GUI_DEV_TEST, AddonBookGUIDevTestScreen::new);
		});
	}
}
