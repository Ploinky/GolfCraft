package de.jjl.golfcraft.item.club;

public class Putter extends BaseGolfclub
{
	@Override
	public float getForce(float distance)
	{
		return 2f * (distance + 2.5f);
	}

	@Override
	public double getHeight()
	{
		return 0d;
	}
}
