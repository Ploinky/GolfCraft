package de.jjl.golfcraft.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import de.jjl.golfcraft.entity.Golfball;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class GolfballModel extends EntityModel<Golfball>
{
	private final ModelRenderer VoxelShapes;

	public GolfballModel()
	{
		textureWidth = 16;
		textureHeight = 16;

		VoxelShapes = new ModelRenderer(this);
		VoxelShapes.setRotationPoint(0.0F, 24.0F, 0.0F);
		VoxelShapes.setTextureOffset(0, 0).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha)
	{
		VoxelShapes.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(Golfball entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch)
	{
		// previously the render function, render code was moved to a method below
	}
}
