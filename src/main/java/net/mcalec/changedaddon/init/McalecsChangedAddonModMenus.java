
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcalec.changedaddon.init;

import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.AbstractContainerMenu;

import net.mcalec.changedaddon.world.inventory.AddonBookGUIPage1Menu;
import net.mcalec.changedaddon.world.inventory.AddonBookGUIMenu;
import net.mcalec.changedaddon.world.inventory.AddonBookGUIDevTestMenu;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class McalecsChangedAddonModMenus {
	private static final List<MenuType<?>> REGISTRY = new ArrayList<>();
	public static final MenuType<AddonBookGUIPage1Menu> ADDON_BOOK_GUI_PAGE_1 = register("addon_book_gui_page_1", (id, inv, extraData) -> new AddonBookGUIPage1Menu(id, inv, extraData));
	public static final MenuType<AddonBookGUIMenu> ADDON_BOOK_GUI = register("addon_book_gui", (id, inv, extraData) -> new AddonBookGUIMenu(id, inv, extraData));
	public static final MenuType<AddonBookGUIDevTestMenu> ADDON_BOOK_GUI_DEV_TEST = register("addon_book_gui_dev_test", (id, inv, extraData) -> new AddonBookGUIDevTestMenu(id, inv, extraData));

	private static <T extends AbstractContainerMenu> MenuType<T> register(String registryname, IContainerFactory<T> containerFactory) {
		MenuType<T> menuType = new MenuType<T>(containerFactory);
		menuType.setRegistryName(registryname);
		REGISTRY.add(menuType);
		return menuType;
	}

	@SubscribeEvent
	public static void registerContainers(RegistryEvent.Register<MenuType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new MenuType[0]));
	}
}
