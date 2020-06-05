package de.jjl.golfcraft.item.club;

public class NineIron extends BaseGolfclub
{
	@Override
	public float getForce(float distance)
	{
		return 13f + distance;
	}

	@Override
	public double getHeight()
	{
		return 1.7d;
	}
}
