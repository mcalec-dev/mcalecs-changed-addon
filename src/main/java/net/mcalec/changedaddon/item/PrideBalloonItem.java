
package net.mcalec.changedaddon.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;

import net.mcalec.changedaddon.procedures.PrideBalloonItemInHandTickProcedure;
import net.mcalec.changedaddon.init.McalecsChangedAddonModTabs;

public class PrideBalloonItem extends Item {
	public PrideBalloonItem() {
		super(new Item.Properties().tab(McalecsChangedAddonModTabs.TAB_MCALECS_CHANGED_TAB).durability(256).fireResistant().rarity(Rarity.UNCOMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.SPEAR;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			PrideBalloonItemInHandTickProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
		PrideBalloonItemInHandTickProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}
