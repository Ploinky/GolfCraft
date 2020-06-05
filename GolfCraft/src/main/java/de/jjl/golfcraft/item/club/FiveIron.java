package de.jjl.golfcraft.item.club;

public class FiveIron extends BaseGolfclub
{
	@Override
	public float getForce(float distance)
	{
		return 17f + distance;
	}

	@Override
	public double getHeight()
	{
		return 1.3d;
	}

}