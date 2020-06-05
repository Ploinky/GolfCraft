package de.jjl.golfcraft.item.club;

public class FourIron extends BaseGolfclub
{
	@Override
	public float getForce(float distance)
	{
		return 18f + distance;
	}

	@Override
	public double getHeight()
	{
		return 1.2d;
	}

}