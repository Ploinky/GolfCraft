package de.jjl.golfcraft.block.marker;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class FiftyMarker extends MarkerBlock
{
	public FiftyMarker()
	{
		super(Block.Properties.create(Material.WOOD)
			.hardnessAndResistance(1.0f)
			.sound(SoundType.WOOD)
			.harvestLevel(0)
			.harvestTool(ToolType.AXE));
	}
}
