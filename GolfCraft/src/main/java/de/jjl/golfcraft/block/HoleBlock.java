package de.jjl.golfcraft.block;

import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class HoleBlock extends Block
{
	public HoleBlock()
	{
		super(Block.Properties.create(Material.WOOD)
			.hardnessAndResistance(5.0f, 6.0f)
			.sound(SoundType.WOOD)
			.harvestLevel(1)
			.harvestTool(ToolType.AXE));
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
	{
		return Stream.of(
			Block.makeCuboidShape(0, 0, 0, 16, 16, 1),
			Block.makeCuboidShape(0, 0, 1, 1, 16, 15),
			Block.makeCuboidShape(0, 0, 15, 16, 16, 16),
			Block.makeCuboidShape(15, 0, 1, 16, 16, 15),
			Block.makeCuboidShape(1, 0, 1, 15, 1, 15)
			).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR))
				.orElseGet(() -> null);
	}
}
