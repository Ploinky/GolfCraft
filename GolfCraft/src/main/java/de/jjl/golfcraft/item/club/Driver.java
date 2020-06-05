package de.jjl.golfcraft.item.club;

public class Driver extends BaseGolfclub
{
	@Override
	public float getForce(float distance)
	{
		return 24f + distance;
	}

	@Override
	public double getHeight()
	{
		return 1d;
	}

}