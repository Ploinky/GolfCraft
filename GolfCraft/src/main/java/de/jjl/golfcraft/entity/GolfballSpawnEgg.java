package de.jjl.golfcraft.entity;

import de.jjl.golfcraft.util.RegistryHandler;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class GolfballSpawnEgg extends ProjectileItemEntity
{
	private String ballName = null;
	
	public GolfballSpawnEgg(EntityType<? extends GolfballSpawnEgg> type, World worldIn)
	{
		super(type, worldIn);
	}

	public GolfballSpawnEgg(World worldIn, LivingEntity throwerIn)
	{
		super(RegistryHandler.GOLFBALL_EGG.get(), throwerIn, worldIn);
	}

	public GolfballSpawnEgg(World worldIn, double x, double y, double z)
	{
		super(RegistryHandler.GOLFBALL_EGG.get(), x, y, z, worldIn);
	}

	@Override
	protected Item getDefaultItem()
	{
		return RegistryHandler.PUTTER.get();
	}

	@Override
	protected void onImpact(RayTraceResult result)
	{
		if (result.getType() == RayTraceResult.Type.ENTITY)
		{
			((EntityRayTraceResult) result).getEntity()
					.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.0F);
		}

		if (!this.world.isRemote)
		{
			Golfball golfball = RegistryHandler.GOLFBALL.get().create(this.world);
			
			if(ballName != null)
			{
				golfball.setCustomName(new StringTextComponent(ballName));
			}
			
			golfball.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw,
					0.0F);
			this.world.addEntity(golfball);

			this.world.setEntityState(this, (byte) 3);
			this.remove();
		}
	}
	
	public String getBallName()
	{
		return ballName;
	}
	
	public void setBallName(String ballName)
	{
		this.ballName = ballName;
	}
}
