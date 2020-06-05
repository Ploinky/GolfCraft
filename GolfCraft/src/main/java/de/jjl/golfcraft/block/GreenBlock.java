package de.jjl.golfcraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class GreenBlock extends Block
{
	public GreenBlock()
	{
		super(Block.Properties.create(Material.EARTH)
			.hardnessAndResistance(1.0f)
			.sound(SoundType.GROUND)
			.harvestLevel(1)
			.harvestTool(ToolType.SHOVEL));
	}
}
