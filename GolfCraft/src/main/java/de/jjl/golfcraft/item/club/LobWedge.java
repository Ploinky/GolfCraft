package de.jjl.golfcraft.item.club;

public class LobWedge extends BaseGolfclub
{
	@Override
	public float getForce(float distance)
	{
		return 18f + distance * 2f;
	}

	@Override
	public double getHeight()
	{
		return 2;
	}

}
