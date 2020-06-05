package de.jjl.golfcraft.item.club;

public class EightIron extends BaseGolfclub
{
	@Override
	public float getForce(float distance)
	{
		return 14f + distance;
	}

	@Override
	public double getHeight()
	{
		return 1.6d;
	}
}
