
package net.mcalec.changedaddon.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

import net.mcalec.changedaddon.procedures.AddonBookRightClickedProcedure;
import net.mcalec.changedaddon.init.McalecsChangedAddonModTabs;

public class AddonBookItem extends Item {
	public AddonBookItem() {
		super(new Item.Properties().tab(McalecsChangedAddonModTabs.TAB_MCALECS_CHANGED_TAB).stacksTo(1).rarity(Rarity.RARE));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		AddonBookRightClickedProcedure.execute(world, x, y, z, entity);
		return ar;
	}
}
