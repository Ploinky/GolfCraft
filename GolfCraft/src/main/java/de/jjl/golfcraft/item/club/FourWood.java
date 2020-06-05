package de.jjl.golfcraft.item.club;

public class FourWood extends BaseGolfclub
{
	@Override
	public float getForce(float distance)
	{
		return 22f + distance;
	}

	@Override
	public double getHeight()
	{
		return 1d;
	}

}