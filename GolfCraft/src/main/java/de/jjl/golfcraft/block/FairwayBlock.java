package de.jjl.golfcraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class FairwayBlock extends Block
{
	public FairwayBlock()
	{
		super(Block.Properties.create(Material.EARTH).hardnessAndResistance(1.0f).sound(SoundType.GROUND)
				.harvestLevel(1).harvestTool(ToolType.SHOVEL));
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack)
	{
		if(placer != null)
		{
			worldIn.setBlockState(pos, state.with(BlockStateProperties.FACING, getFacingFromEntity(pos, placer)), 2);
		}
	}

	private Direction getFacingFromEntity(BlockPos pos, LivingEntity placer)
	{
		return Direction.getFacingFromVector((float) (placer.getPosX() - pos.getX()), (float) (placer.getPosY() - pos.getY()),
				(float) (placer.getPosZ() - pos.getZ()));
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder)
	{
		super.fillStateContainer(builder);
		builder.add(BlockStateProperties.FACING);
	}
}
