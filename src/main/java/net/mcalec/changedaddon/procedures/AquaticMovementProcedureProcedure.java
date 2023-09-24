package net.mcalec.changedaddon.procedures;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

public class AquaticMovementProcedureProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double motionZ = 0;
		double deltaZ = 0;
		double distance = 0;
		double deltaX = 0;
		double motionY = 0;
		double deltaY = 0;
		double motionX = 0;
		double maxSpeed = 0;
		double speed = 0;
		if (entity.isInWater()) {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == (null))) {
				deltaX = (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() - entity.getX();
				deltaY = (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() - entity.getY();
				deltaZ = (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() - entity.getZ();
				distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);
			}
			if (distance > 0) {
				speed = 0.04;
				motionX = deltaX / distance * speed;
				motionY = deltaY / distance * speed;
				motionZ = deltaZ / distance * speed;
				maxSpeed = 0.2;
			}
		}
	}
}
