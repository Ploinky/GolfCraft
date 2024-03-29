package de.jjl.golfcraft.block;

import de.jjl.golfcraft.block.marker.MarkerBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class OutOfBounds extends MarkerBlock
{
	public OutOfBounds()
	{
		super(Block.Properties.create(Material.WOOD)
			.hardnessAndResistance(1.0f)
			.sound(SoundType.WOOD)
			.harvestLevel(0)
			.harvestTool(ToolType.AXE));
	}
}
