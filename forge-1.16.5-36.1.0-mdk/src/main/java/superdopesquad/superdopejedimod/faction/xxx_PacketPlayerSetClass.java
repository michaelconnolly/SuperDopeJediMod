//package superdopesquad.superdopejedimod.faction;
//
//
//import java.util.UUID;
//import java.util.function.Supplier;
//
//import io.netty.buffer.ByteBuf;
////import net.minecraft.entity.player.EntityPlayer;
////import net.minecraft.nbt.NBTTagCompound;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.network.PacketBuffer;
//import net.minecraftforge.fml.network.NetworkEvent;
////import net.minecraftforge.fml.common.network.ByteBufUtils;
////import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
////import net.minecraftforge.fml.common.network.*;
//import net.minecraftforge.fml.network.simple.*;
//import net.minecraftforge.fml.network.simple.SimpleChannel;
//
//
//
////public class PacketPlayerSetClass implements Message {
//public class PacketPlayerSetClass implements MSG {
//
//
//	private UUID _playerId;
//	private int _classId;
//
//
//	// A default constructor is always required
//	public PacketPlayerSetClass() {}
//
//
//	public PacketPlayerSetClass(PlayerEntity player, int classId) {
//
//			this._playerId = player.getUUID();
//			this._classId = classId;
//	}
//
//
//	public UUID getPlayerId() {
//		return this._playerId;
//	}
//
//
//	public int getClassId() {
//		return this._classId;
//	}
//
//
////	 @Override
////	 public void fromBytes(ByteBuf buffer) {
////
////		 long mostsignificant  = buffer.readLong();
////		 long leastsignificant  = buffer.readLong();
////
////		 this._playerId = new UUID(mostsignificant, leastsignificant);
////		 this._classId = buffer.readInt();
////	 }
//
//
////	 @Override
////	 public void toBytes(ByteBuf buffer) {
////
////		 buffer.writeLong(this._playerId.getMostSignificantBits());
////		 buffer.writeLong(this._playerId.getLeastSignificantBits());
////		 buffer.writeInt(this._classId);
////	 }
//
//	public static void encode(PacketPlayerSetClass msg, PacketBuffer packetBuffer) {
//	}
//
//
//	public static void decode(PacketBuffer packetBuffer, PacketPlayerSetClass msg) {
//	}
//
//
//		public static void handle(PacketPlayerSetClass msg, Supplier<NetworkEvent.Context> ctx) {
//
//			ctx.get().enqueueWork(() -> {
//				// Work that needs to be threadsafe (most work)
//				PlayerEntity sender = ctx.get().getSender(); // the client that sent this packet
//				// do stuff
//			});
//			ctx.get().setPacketHandled(true);
//		}
//}