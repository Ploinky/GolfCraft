package de.jjl.golfcraft.net.packet;

import java.io.IOException;

import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.IServerPlayNetHandler;

public class UpdateGolfballNamePacket implements IPacket<IServerPlayNetHandler>
{

	@Override
	public void readPacketData(PacketBuffer buf) throws IOException
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writePacketData(PacketBuffer buf) throws IOException
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processPacket(IServerPlayNetHandler handler)
	{
		// TODO Auto-generated method stub
		
	}

//	/**
//	 * Reads the raw packet data from the data stream.
//	 */
//	@Override
//	public void readPacketData(PacketBuffer buf) throws IOException
//	{
//		this.pos = buf.read();
//		this.command = buf.readString(32767);
//		this.mode = buf.readEnumValue(CommandBlockTileEntity.Mode.class);
//		int i = buf.readByte();
//		this.trackOutput = (i & 1) != 0;
//		this.conditional = (i & 2) != 0;
//		this.auto = (i & 4) != 0;
//	}
//
//	   /**
//	    * Writes the raw packet data to the data stream.
//	    */
//	   public void writePacketData(PacketBuffer buf) throws IOException {
//	      buf.writeBlockPos(this.pos);
//	      buf.writeString(this.command);
//	      buf.writeEnumValue(this.mode);
//	      int i = 0;
//	      if (this.trackOutput) {
//	         i |= 1;
//	      }
//
//	      if (this.conditional) {
//	         i |= 2;
//	      }
//
//	      if (this.auto) {
//	         i |= 4;
//	      }
//
//	      buf.writeByte(i);
//	   }
//
//	   /**
//	    * Passes this Packet on to the NetHandler for processing.
//	    */
//	   public void processPacket(IServerPlayNetHandler handler) {
//	      handler.processUpdateCommandBlock(this);
//	   }
}
