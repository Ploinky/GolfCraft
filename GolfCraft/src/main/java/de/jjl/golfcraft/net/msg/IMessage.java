package de.jjl.golfcraft.net.msg;

import java.util.function.Supplier;

import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public interface IMessage<T>
{
	public void encode(T message, PacketBuffer buffer);
	
	public T decode(PacketBuffer buffer);
	
	public void handle(T message, Supplier<NetworkEvent.Context> supplier);
}
