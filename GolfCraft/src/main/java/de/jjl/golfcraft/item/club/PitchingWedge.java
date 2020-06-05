package de.jjl.golfcraft.item.club;

public class PitchingWedge extends BaseGolfclub
{
	@Override
	public float getForce(float distance)
	{
		return 12f + distance;
	}

	@Override
	public double getHeight()
	{
		return 1.8d;
	}
}