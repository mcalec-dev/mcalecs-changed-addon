package net.mcalec.changedaddon.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelmodel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("mcalecs_changed", "modelmodel"), "main");
	public final ModelPart Head;
	public final ModelPart Torso;
	public final ModelPart RightArm;
	public final ModelPart LeftArm;
	public final ModelPart LeftLeg;
	public final ModelPart RightLeg;

	public Modelmodel(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Torso = root.getChild("Torso");
		this.RightArm = root.getChild("RightArm");
		this.LeftArm = root.getChild("LeftArm");
		this.LeftLeg = root.getChild("LeftLeg");
		this.RightLeg = root.getChild("RightLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));
		PartDefinition Ears = Head.addOrReplaceChild("Ears", CubeListBuilder.create(), PartPose.offset(0.0F, 25.0F, 0.0F));
		PartDefinition LeftEar = Ears.addOrReplaceChild("LeftEar", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition Bottom_r1 = LeftEar.addOrReplaceChild("Bottom_r1",
				CubeListBuilder.create().texOffs(36, 5).addBox(2.0F, -33.0F, -14.5F, 1.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(38, 0).addBox(2.0F, -33.75F, -14.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5236F, 0.6545F, 0.0F));
		PartDefinition RightEar = Ears.addOrReplaceChild("RightEar", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition Bottom_r2 = RightEar.addOrReplaceChild("Bottom_r2",
				CubeListBuilder.create().texOffs(48, 5).addBox(-3.0F, -33.0F, -14.5F, 1.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(48, 0).addBox(-3.0F, -33.75F, -14.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5236F, -0.6545F, 0.0F));
		PartDefinition Torso = partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(0, 20).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));
		PartDefinition Tail = Torso.addOrReplaceChild("Tail", CubeListBuilder.create(), PartPose.offset(0.0F, 11.0F, 0.0F));
		PartDefinition Tip_r1 = Tail.addOrReplaceChild("Tip_r1", CubeListBuilder.create().texOffs(28, 27).addBox(-1.5F, 0.25F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 6.0F, 1.4835F, 0.0F, 0.0F));
		PartDefinition Base_r1 = Tail.addOrReplaceChild("Base_r1", CubeListBuilder.create().texOffs(44, 26).addBox(-1.5F, 0.0F, -1.0F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.1781F, 0.0F, 0.0F));
		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 40).addBox(0.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -1.0F, 0.0F));
		PartDefinition RightFingers = RightArm.addOrReplaceChild("RightFingers",
				CubeListBuilder.create().texOffs(20, 37).addBox(7.0F, -12.0F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(20, 37).addBox(7.0F, -12.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(20, 37)
						.addBox(7.0F, -12.0F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(20, 37).addBox(4.0F, -12.0F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-4.0F, 24.0F, 0.0F));
		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(20, 40).addBox(-4.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -1.0F, 0.0F));
		PartDefinition LeftFingers = LeftArm.addOrReplaceChild("LeftFingers",
				CubeListBuilder.create().texOffs(12, 37).addBox(-8.0F, -12.0F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 37).addBox(-8.0F, -12.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 37)
						.addBox(-8.0F, -12.0F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 37).addBox(-5.0F, -12.0F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(4.0F, 24.0F, 0.0F));
		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(58, 65).addBox(-1.75F, 11.0F, -2.75F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 11.0F, 0.0F));
		PartDefinition Lower_r1 = LeftLeg.addOrReplaceChild("Lower_r1", CubeListBuilder.create().texOffs(40, 62).addBox(-2.25F, -7.5F, -1.0F, 4.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.5F, 13.25F, -1.25F, -0.5236F, 0.0F, 0.0F));
		PartDefinition Middle_r1 = LeftLeg.addOrReplaceChild("Middle_r1", CubeListBuilder.create().texOffs(0, 60).addBox(-2.25F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(-0.01F)),
				PartPose.offsetAndRotation(0.5F, 3.25F, -1.5F, 0.5672F, 0.0F, 0.0F));
		PartDefinition Upper_r1 = LeftLeg.addOrReplaceChild("Upper_r1", CubeListBuilder.create().texOffs(20, 61).addBox(-2.25F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.5F, -1.0F, 0.0F, -0.2182F, 0.0F, 0.0F));
		PartDefinition LeftToes = LeftLeg.addOrReplaceChild("LeftToes", CubeListBuilder.create(), PartPose.offset(-2.0F, 13.0F, 0.0F));
		PartDefinition LeftUpperToes = LeftToes.addOrReplaceChild("LeftUpperToes", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition Toe3_r1 = LeftUpperToes.addOrReplaceChild("Toe3_r1", CubeListBuilder.create().texOffs(20, 37).addBox(3.25F, 0.05F, -3.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(20, 37)
				.addBox(1.75F, 0.05F, -3.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(20, 37).addBox(0.25F, 0.05F, -3.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.6109F, 0.0F, 0.0F));
		PartDefinition LeftLowerToes = LeftToes.addOrReplaceChild("LeftLowerToes", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition Toe3_r2 = LeftLowerToes.addOrReplaceChild("Toe3_r2", CubeListBuilder.create().texOffs(20, 37).addBox(3.25F, -1.0F, -3.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(20, 37)
				.addBox(1.75F, -1.0F, -3.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(20, 37).addBox(0.25F, -1.0F, -3.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(58, 65).addBox(-2.0F, 11.0F, -2.75F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.25F, 11.0F, 0.0F));
		PartDefinition Lower_r2 = RightLeg.addOrReplaceChild("Lower_r2", CubeListBuilder.create().texOffs(40, 62).addBox(-1.75F, -7.5F, -1.0F, 4.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.25F, 13.25F, -1.25F, -0.5236F, 0.0F, 0.0F));
		PartDefinition Middle_r2 = RightLeg.addOrReplaceChild("Middle_r2", CubeListBuilder.create().texOffs(0, 60).addBox(-1.75F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(-0.01F)),
				PartPose.offsetAndRotation(-0.25F, 3.25F, -1.5F, 0.5672F, 0.0F, 0.0F));
		PartDefinition Upper_r2 = RightLeg.addOrReplaceChild("Upper_r2", CubeListBuilder.create().texOffs(20, 61).addBox(-1.75F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.25F, -1.0F, 0.0F, -0.2182F, 0.0F, 0.0F));
		PartDefinition RightToes = RightLeg.addOrReplaceChild("RightToes", CubeListBuilder.create(), PartPose.offset(2.25F, 13.0F, 0.0F));
		PartDefinition RightUpperToes = RightToes.addOrReplaceChild("RightUpperToes", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition Toe3_r3 = RightUpperToes.addOrReplaceChild("Toe3_r3", CubeListBuilder.create().texOffs(12, 37).addBox(-1.25F, 0.05F, -3.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 37)
				.addBox(-2.75F, 0.05F, -3.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 37).addBox(-4.25F, 0.05F, -3.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.6109F, 0.0F, 0.0F));
		PartDefinition RightLowerToes = RightToes.addOrReplaceChild("RightLowerToes", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition RightLowerToe3_r1 = RightLowerToes.addOrReplaceChild("RightLowerToe3_r1", CubeListBuilder.create().texOffs(12, 37).addBox(-1.25F, -1.0F, -3.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 37)
				.addBox(-2.75F, -1.0F, -3.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 37).addBox(-4.25F, -1.0F, -3.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.RightArm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.LeftLeg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch / (180F / (float) Math.PI);
		this.LeftArm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.RightLeg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}
