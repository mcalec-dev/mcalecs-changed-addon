
package net.mcalec.changedaddon.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcalec.changedaddon.entity.DevEntityTestEntity;
import net.mcalec.changedaddon.client.model.Modelmodel;

public class DevEntityTestRenderer extends MobRenderer<DevEntityTestEntity, Modelmodel<DevEntityTestEntity>> {
	public DevEntityTestRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelmodel(context.bakeLayer(Modelmodel.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(DevEntityTestEntity entity) {
		return new ResourceLocation("mcalecs_changed_addon:textures/entities/skin.png");
	}
}
