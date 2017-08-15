package superdopesquad.superdopejedimod.teleporter;


import java.util.UUID;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;


public class PacketTeleporterSetDestination implements IMessage {
  
	private BlockPos _blockPos;
  
	// A default constructor is always required
	public PacketTeleporterSetDestination() {}

	public PacketTeleporterSetDestination(BlockPos blockPos) {
		this._blockPos = blockPos;
	}

	public BlockPos getBlockPos() {
		return this._blockPos;
	}
	
	 @Override
	 public void fromBytes(ByteBuf buffer) {
		 // Get the BlockPos.
		 int x = buffer.readInt();
		 int y = buffer.readInt();
		 int z = buffer.readInt();
		 this._blockPos = new BlockPos(x, y, z);
	 }

	 @Override
	 public void toBytes(ByteBuf buffer) {
		 buffer.writeInt(this._blockPos.getX());
		 buffer.writeInt(this._blockPos.getY());
		 buffer.writeInt(this._blockPos.getZ());
	 }
}