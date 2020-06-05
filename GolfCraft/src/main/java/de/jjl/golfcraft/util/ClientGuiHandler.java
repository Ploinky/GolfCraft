package de.jjl.golfcraft.util;

import de.jjl.golfcraft.client.gui.BallMarkerScreen;
import de.jjl.golfcraft.entity.Golfball;
import net.minecraft.client.Minecraft;

public class ClientGuiHandler
{
	public static void callBallMarkerScreen(Golfball golfball)
	{
		Minecraft.getInstance().displayGuiScreen(new BallMarkerScreen(golfball));
	}
}
