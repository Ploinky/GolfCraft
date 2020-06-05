package de.jjl.golfcraft.item.club;

public class FiveWood extends BaseGolfclub
{
	@Override
	public float getForce(float distance)
	{
		return 21f + distance;
	}

	@Override
	public double getHeight()
	{
		return 1d;
	}

}