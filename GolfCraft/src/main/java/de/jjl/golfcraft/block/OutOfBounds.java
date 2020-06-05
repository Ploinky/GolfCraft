package de.jjl.golfcraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class OutOfBounds extends Block
{
	public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos position, ISelectionContext context)
	{
		return Block.makeCuboidShape(7d, 0d, 7d, 9d, 16d, 9d);
	}
	
	public OutOfBounds()
	{
		super(Block.Properties.create(Material.WOOD)
			.hardnessAndResistance(1.0f)
			.sound(SoundType.WOOD)
			.harvestLevel(0)
			.harvestTool(ToolType.AXE));
	}
}
