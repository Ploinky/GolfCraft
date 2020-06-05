package de.jjl.golfcraft.item.club;

import de.jjl.golfcraft.item.ItemBase;

public abstract class BaseGolfclub extends ItemBase
{
	public abstract float getForce(float distance);

	public abstract double getHeight();
}
