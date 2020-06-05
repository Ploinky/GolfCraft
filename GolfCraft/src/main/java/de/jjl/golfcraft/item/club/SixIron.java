package de.jjl.golfcraft.item.club;

public class SixIron extends BaseGolfclub
{
	@Override
	public float getForce(float distance)
	{
		return 16f + distance;
	}

	@Override
	public double getHeight()
	{
		return 1.4d;
	}

}