package de.jjl.golfcraft.block;

import de.jjl.golfcraft.GolfCraft;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class BlockItemBase extends BlockItem
{
	public BlockItemBase(Block block)
	{
		super(block, new Item.Properties().group(GolfCraft.ITEM_GROUP));
	}
}
