package de.jjl.golfcraft.net;

import de.jjl.golfcraft.GolfCraft;
import de.jjl.golfcraft.net.msg.GolfballNamedMessage;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class NetworkHandler
{
	private static SimpleChannel instance;
	
	private static final String PROTOCOL_VERSION = "1";
	
	private static int id = 0;
	
	public static void init()
	{
		instance = NetworkRegistry.newSimpleChannel(new ResourceLocation(GolfCraft.MOD_ID, "main"),
				() -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
		
		instance.<GolfballNamedMessage>registerMessage(id++, GolfballNamedMessage.class,
				(msg, buf) -> msg.encode(msg, buf),
				buf -> new GolfballNamedMessage().decode(buf), (msg, supp) -> msg.handle(msg, supp));
	}

}
