package de.jjl.golfcraft.entity.render;

import de.jjl.golfcraft.GolfCraft;
import de.jjl.golfcraft.entity.EntityNames;
import de.jjl.golfcraft.entity.Golfball;
import de.jjl.golfcraft.entity.model.GolfballModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class GolfballRenderer extends MobRenderer<Golfball, GolfballModel>
{
	protected static final ResourceLocation TEXTURE = new ResourceLocation(GolfCraft.MOD_ID, "textures/entity/"
		+ EntityNames.GOLFBALL + ".png");
	
	public GolfballRenderer(EntityRendererManager renderManager)
	{
		super(renderManager, new GolfballModel(), 0.2f);
	}

	@Override
	public ResourceLocation getEntityTexture(Golfball entity)
	{
		return TEXTURE;
	}
}
