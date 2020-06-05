package de.jjl.golfcraft.item.club;

public class TwoIron extends BaseGolfclub
{
	@Override
	public float getForce(float distance)
	{
		return 20f + distance;
	}

	@Override
	public double getHeight()
	{
		return 1d;
	}

}
