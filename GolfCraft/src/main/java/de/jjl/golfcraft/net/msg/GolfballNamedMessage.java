package de.jjl.golfcraft.net.msg;

import java.util.function.Supplier;

import de.jjl.golfcraft.entity.Golfball;
import de.jjl.golfcraft.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkEvent;

public class GolfballNamedMessage implements IMessage<GolfballNamedMessage>
{
	private String ballName;

	private int entityId;

	public GolfballNamedMessage()
	{
	}

	public GolfballNamedMessage(int entityId, String ballName)
	{
		super();
		this.entityId = entityId;
		this.ballName = ballName;
	}

	@Override
	public GolfballNamedMessage decode(PacketBuffer buffer)
	{
		return new GolfballNamedMessage(buffer.readInt(), buffer.readString(32767));
	}

	@Override
	public void encode(GolfballNamedMessage message, PacketBuffer buffer)
	{
		buffer.writeInt(message.getEntityId());
		buffer.writeString(message.getBallName());
	}

	private String getBallName()
	{
		return ballName;
	}

	public int getEntityId()
	{
		return entityId;
	}

	@Override
	public void handle(GolfballNamedMessage message, Supplier<NetworkEvent.Context> supplier)
	{
		supplier.get().enqueueWork(() ->
		{
			ServerPlayerEntity sender = supplier.get().getSender();

			if (sender == null)
			{
				return;
			}

			World world = sender.world;
			Entity targetEntity = world.getEntityByID(message.entityId);

			if (!(targetEntity instanceof Golfball))
			{
				return;
			}
			
			float reachDistance = (float) sender.getAttribute(PlayerEntity.REACH_DISTANCE).getValue();
			if (sender.getDistance(targetEntity) >= reachDistance)
			{
				return;
			}
			
			ItemStack stack = sender.inventory.getCurrentItem();
			if (!stack.isEmpty() && stack.getItem() == ModItems.BALL_MARKER.get())
			{
				Golfball golfball = (Golfball) targetEntity;
				golfball.setCustomName(message.getBallName());
			}
		});
		
		supplier.get().setPacketHandled(true);
	}

	public void setBallName(String ballName)
	{
		this.ballName = ballName;
	}

	public void setEntityId(int entityId)
	{
		this.entityId = entityId;
	}
}
