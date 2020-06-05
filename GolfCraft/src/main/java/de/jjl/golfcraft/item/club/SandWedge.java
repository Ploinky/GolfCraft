package de.jjl.golfcraft.item.club;

public class SandWedge extends BaseGolfclub
{
	@Override
	public float getForce(float distance)
	{
		return 10f + distance;
	}

	@Override
	public double getHeight()
	{
		return 2d;
	}
}