package de.jjl.golfcraft.item;

import de.jjl.golfcraft.entity.GolfballSpawnEgg;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class GolfballItem extends ItemBase
{
	private String ballName = null;
	
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
	{
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		worldIn.playSound((PlayerEntity) null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(),
				SoundEvents.ENTITY_EGG_THROW, SoundCategory.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
		if (!worldIn.isRemote)
		{
			GolfballSpawnEgg eggEntity = new GolfballSpawnEgg(worldIn, playerIn);
			eggEntity.setBallName(ballName);
			eggEntity.setItem(itemstack);
			eggEntity.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
			worldIn.addEntity(eggEntity);
		}

		playerIn.addStat(Stats.ITEM_USED.get(this));
		if (!playerIn.abilities.isCreativeMode)
		{
			itemstack.shrink(1);
		}

		return ActionResult.resultSuccess(itemstack);
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
