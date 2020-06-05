package de.jjl.golfcraft.item;

import de.jjl.golfcraft.GolfCraft;
import net.minecraft.item.Item;

public class ItemBase extends Item
{
	public ItemBase()
	{
		super(new Item.Properties().group(GolfCraft.ITEM_GROUP));
	}
}
