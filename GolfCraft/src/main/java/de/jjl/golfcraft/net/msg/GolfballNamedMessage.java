package de.jjl.golfcraft.net.msg;

import java.util.function.Supplier;

import de.jjl.golfcraft.entity.Golfball;
import de.jjl.golfcraft.util.RegistryHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkEvent;

public class GolfballNamedMessage implements IMessage<GolfballNamedMessage>
{
	private int entityId;

	private String ballName;

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

	@Override
	public GolfballNamedMessage decode(PacketBuffer buffer)
	{
		return new GolfballNamedMessage(buffer.readInt(), buffer.readString(32767));
	}

	@Override
	public void handle(GolfballNamedMessage message, Supplier<NetworkEvent.Context> supplier)
	{
		supplier.get().enqueueWork(() -> {
			ServerPlayerEntity sender = supplier.get().getSender();

			if (sender != null)
			{
				World world = sender.world;
				Entity targetEntity = world.getEntityByID(message.entityId);
				if (targetEntity instanceof Golfball)
				{
					float reachDistance = (float) sender.getAttribute(PlayerEntity.REACH_DISTANCE).getValue();
					if (sender.getDistance(targetEntity) < reachDistance)
					{
						ItemStack stack = sender.inventory.getCurrentItem();
						if (!stack.isEmpty() && stack.getItem() == RegistryHandler.BALL_MARKER.get())
						{
							Golfball golfball = (Golfball) targetEntity;
							golfball.setCustomName(message.getBallName());
						}
					}
				}
			}
		});
		supplier.get().setPacketHandled(true);
	}

	public int getEntityId()
	{
		return entityId;
	}

	public GolfballNamedMessage(int entityId, String ballName)
	{
		super();
		this.entityId = entityId;
		this.ballName = ballName;
	}

	public GolfballNamedMessage()
	{
	}

	public void setEntityId(int entityId)
	{
		this.entityId = entityId;
	}

	public void setBallName(String ballName)
	{
		this.ballName = ballName;
	}
}
