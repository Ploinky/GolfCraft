package de.jjl.golfcraft.block.marker;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public abstract class MarkerBlock extends Block 
{
	public MarkerBlock(Properties properties)
	{
		super(properties);
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos position, ISelectionContext context)
	{
		return Block.makeCuboidShape(6d, 0d, 6d, 10d, 16d, 10d);
	}
}
