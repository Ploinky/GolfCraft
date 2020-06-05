package de.jjl.golfcraft.item.club;

public class SevenIron extends BaseGolfclub
{
	@Override
	public float getForce(float distance)
	{
		return 15f + distance;
	}

	@Override
	public double getHeight()
	{
		return 1.5d;
	}

}
