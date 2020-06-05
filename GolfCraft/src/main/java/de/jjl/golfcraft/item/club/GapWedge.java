package de.jjl.golfcraft.item.club;

public class GapWedge extends BaseGolfclub
{
	@Override
	public float getForce(float distance)
	{
		return 11f + distance;
	}

	@Override
	public double getHeight()
	{
		return 1.9d;
	}
}
