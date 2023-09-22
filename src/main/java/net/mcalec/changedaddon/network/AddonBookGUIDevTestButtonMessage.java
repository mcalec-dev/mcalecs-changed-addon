
package net.mcalec.changedaddon.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcalec.changedaddon.world.inventory.AddonBookGUIDevTestMenu;
import net.mcalec.changedaddon.procedures.GUIDevTestUntransfurProcedure;
import net.mcalec.changedaddon.procedures.GUIDevTestTimeSetProcedure;
import net.mcalec.changedaddon.procedures.AddonBookGUIButtonCloseProcedure;
import net.mcalec.changedaddon.McalecsChangedAddonMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AddonBookGUIDevTestButtonMessage {
	private final int buttonID, x, y, z;

	public AddonBookGUIDevTestButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public AddonBookGUIDevTestButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(AddonBookGUIDevTestButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(AddonBookGUIDevTestButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = AddonBookGUIDevTestMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			GUIDevTestUntransfurProcedure.execute(world, x, y, z);
		}
		if (buttonID == 1) {

			AddonBookGUIButtonCloseProcedure.execute(entity);
		}
		if (buttonID == 2) {

			GUIDevTestTimeSetProcedure.execute(world, x, y, z);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		McalecsChangedAddonMod.addNetworkMessage(AddonBookGUIDevTestButtonMessage.class, AddonBookGUIDevTestButtonMessage::buffer, AddonBookGUIDevTestButtonMessage::new, AddonBookGUIDevTestButtonMessage::handler);
	}
}
