
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcalec.changedaddon.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class McalecsChangedModTabs {
	public static CreativeModeTab TAB_MCALECS_CHANGED_TAB;

	public static void load() {
		TAB_MCALECS_CHANGED_TAB = new CreativeModeTab("tabmcalecs_changed_tab") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(McalecsChangedModItems.DEV_ITEM.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
