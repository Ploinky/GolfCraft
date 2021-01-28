package de.jjl.golfcraft.entity;

import java.util.function.Supplier;

import de.jjl.golfcraft.item.BallMarker;
import de.jjl.golfcraft.item.GolfballItem;
import de.jjl.golfcraft.item.ModItems;
import de.jjl.golfcraft.item.club.BaseGolfclub;
import de.jjl.golfcraft.util.ClientGuiHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.NameTagItem;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.DistExecutor.SafeCallable;

public class Golfball extends MobEntity
{
	@Override
	public boolean isInvulnerable()
	{
		return true;
	}

	protected void onImpact(RayTraceResult result)
	{
		if (!this.world.isRemote)
		{
			if (this.rand.nextInt(8) == 0)
			{
				int i = 1;
				if (this.rand.nextInt(32) == 0)
				{
					i = 4;
				}

				for (int j = 0; j < i; ++j)
				{
					Golfball golfball = ModEntities.GOLFBALL.get().create(this.world);
					golfball.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw,
							0.0F);
					this.world.addEntity(golfball);
				}
			}

			this.world.setEntityState(this, (byte) 3);
			this.remove();
		}

	}
	
	@Override
	public boolean processInteract(PlayerEntity player, Hand hand)
	{
		ItemStack itemstack = player.getHeldItem(hand);

		if (BaseGolfclub.class.isInstance(itemstack.getItem()) && hand == Hand.MAIN_HAND)
		{

			double distance = getDistance(player);

			distance -= 2.5;
			
			BaseGolfclub club = ((BaseGolfclub) player.getHeldItemMainhand().getItem());
			knockBack(player, (float) Math.max(0.1, club.getForce((float) distance / 2) - 16),
					(double) MathHelper.sin(player.rotationYaw * ((float) Math.PI / 180F)),
					(double) (-MathHelper.cos(player.rotationYaw * ((float) Math.PI / 180F))), (1f/3f) * club.getHeight());

			return true;
		}
		else if (BallMarker.class.isInstance(itemstack.getItem()) && hand == Hand.MAIN_HAND)
		{
			DistExecutor.safeCallWhenOn(Dist.CLIENT, new  Supplier<DistExecutor.SafeCallable<Void>>()
			{
				@Override
				public SafeCallable<Void> get()
				{
					return new SafeCallable<Void>()
					{

						@Override
						public Void call() throws Exception
						{
							ClientGuiHandler.callBallMarkerScreen(Golfball.this);
							return null;
						}
					};
				}
				
			});
			return true;
		}
		else
		{
			return super.processInteract(player, hand);
		}
	}
	
	public Golfball(EntityType<Golfball> type, World worldIn)
	{
		super(type, worldIn);
	}

	public void shoot(Entity entityThrower, float rotationPitchIn, float rotationYawIn, float pitchOffset,
			float velocity, float inaccuracy)
	{
		float f = -MathHelper.sin(rotationYawIn * ((float) Math.PI / 180F))
				* MathHelper.cos(rotationPitchIn * ((float) Math.PI / 180F));
		float f1 = -MathHelper.sin((rotationPitchIn + pitchOffset) * ((float) Math.PI / 180F));
		float f2 = MathHelper.cos(rotationYawIn * ((float) Math.PI / 180F))
				* MathHelper.cos(rotationPitchIn * ((float) Math.PI / 180F));
		this.shoot((double) f, (double) f1, (double) f2, velocity, inaccuracy);
		Vec3d vec3d = entityThrower.getMotion();
		this.setMotion(this.getMotion().add(vec3d.x, entityThrower.onGround ? 0.0D : vec3d.y, vec3d.z));
	}

	public void shoot(double x, double y, double z, float velocity, float inaccuracy)
	{
		Vec3d vec3d = (new Vec3d(x, y, z)).normalize()
				.add(this.rand.nextGaussian() * (double) 0.0075F * (double) inaccuracy,
						this.rand.nextGaussian() * (double) 0.0075F * (double) inaccuracy,
						this.rand.nextGaussian() * (double) 0.0075F * (double) inaccuracy)
				.scale((double) velocity);
		this.setMotion(vec3d);
		float f = MathHelper.sqrt(horizontalMag(vec3d));
		this.rotationYaw = (float) (MathHelper.atan2(vec3d.x, vec3d.z) * (double) (180F / (float) Math.PI));
		this.rotationPitch = (float) (MathHelper.atan2(vec3d.y, (double) f) * (double) (180F / (float) Math.PI));
		this.prevRotationYaw = this.rotationYaw;
		this.prevRotationPitch = this.rotationPitch;
	}

	@Override
	public boolean hitByEntity(Entity entityIn)
	{
		if (entityIn instanceof PlayerEntity)
		{
			PlayerEntity player = ((PlayerEntity) entityIn);
			if (!BaseGolfclub.class.isInstance(player.getHeldItemMainhand().getItem())
					&& player.getHeldItemMainhand().getItem() != Items.AIR
					&& !NameTagItem.class.isInstance(player.getHeldItemMainhand().getItem()))
			{
				return true;
			}
		}

		return super.hitByEntity(entityIn);
	}
	
	@Override
	public boolean isInRangeToRenderDist(double distance)
	{
		return true;
	}
	

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount)
	{
		if (!world.isRemote && source.getTrueSource() instanceof PlayerEntity)
		{
			return hit(source);
		}
		else if(source.getTrueSource() instanceof PlayerEntity)
		{
			PlayerEntity player = (PlayerEntity) source.getTrueSource();
			if (NameTagItem.class.isInstance(player.getHeldItemMainhand().getItem()))
			{
				return super.attackEntityFrom(source, amount);
			}
		}
		return false;
	}

	@Override
	protected ResourceLocation getLootTable()
	{
		return super.getLootTable();
	}

	private boolean hit(DamageSource source)
	{
		PlayerEntity player = (PlayerEntity) source.getTrueSource();

		if (BaseGolfclub.class.isInstance(player.getHeldItemMainhand().getItem())
				&& !getEntity().isInWater())
		{
			double distance = getDistance(player);

			distance -= 2.5;

			BaseGolfclub club = ((BaseGolfclub) player.getHeldItemMainhand().getItem());
			knockBack(player, club.getForce((float) distance),
					(double) MathHelper.sin(player.rotationYaw * ((float) Math.PI / 180F)),
					(double) (-MathHelper.cos(player.rotationYaw * ((float) Math.PI / 180F))), club.getHeight());

			return true;
		}
		else if (player.getHeldItemMainhand().getItem() == Items.AIR)
		{
			dropLoot();
			remove();

			return true;
		}

		return false;
	}

	
	
	protected void dropLoot()
	{
		if (!this.world.isRemote)
		{
			GolfballItem golfballItem = (GolfballItem) ModItems.GOLFBALL_ITEM.get().asItem();
			
			if(hasCustomName())
			{
				golfballItem.setBallName(getCustomName().getString());
			}
			

			entityDropItem(new ItemStack(golfballItem));
		}
	}
	
	@Override
	public void onCollideWithPlayer(PlayerEntity entityIn)
	{
	}

	@Override
	public void applyEntityCollision(Entity entityIn)
	{
	}

	/**
	 * Constructs a knockback vector from the given direction ratio and magnitude
	 * and adds it to the entity's velocity. If it is on the ground (i.e.
	 * {@code this.onGround}), the Y-velocity is increased as well, clamping it to
	 * {@code
	 * .4}.
	 * 
	 * The entity's existing horizontal velocity is halved, and if the entity is on
	 * the ground the Y-velocity is too.
	 */
	public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio, double height)
	{
		net.minecraftforge.event.entity.living.LivingKnockBackEvent event = net.minecraftforge.common.ForgeHooks
				.onLivingKnockBack(this, entityIn, strength, xRatio, zRatio);
		if (event.isCanceled())
			return;
		strength = event.getStrength();
		xRatio = event.getRatioX();
		zRatio = event.getRatioZ();

		if(entityIn instanceof PlayerEntity)
		{
			if(((PlayerEntity) entityIn).isSneaking())
			{
				height = height / 5;
				strength = strength / 3;
			}
		}
		
		this.isAirBorne = true;
		Vec3d vec3d = this.getMotion();
		Vec3d vec3d1 = (new Vec3d(xRatio, height, zRatio)).normalize().scale((double) strength);
		this.setMotion(vec3d.x / 2.0D - vec3d1.x, height, vec3d.z / 2.0D - vec3d1.z);
	}

	@Override
	protected void collideWithEntity(Entity entityIn)
	{
	}

	@Override
	protected void damageEntity(DamageSource damageSrc, float damageAmount)
	{
	}

	public void setCustomName(String ballName)
	{
		setCustomName(new StringTextComponent(ballName));
	}
}
