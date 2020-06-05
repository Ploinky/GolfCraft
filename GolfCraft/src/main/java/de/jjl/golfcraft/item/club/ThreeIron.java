package de.jjl.golfcraft.item.club;

public class ThreeIron extends BaseGolfclub
{
	@Override
	public float getForce(float distance)
	{
		return 19f + distance;
	}

	@Override
	public double getHeight()
	{
		return 1.1d;
	}

}