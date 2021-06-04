package superdopesquad.superdopejedimod.packet;


import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import superdopesquad.superdopejedimod.SuperDopeJediMod;


// **************************************************************************
// Read this: https://mcforge.readthedocs.io/en/1.16.x/networking/simpleimpl/
// **************************************************************************

public class PacketManager {

	private int nextMessageId = 0;

    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(SuperDopeJediMod.MODID, "main_channel"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );


	public PacketManager() {

//		Next, we must declare the types of messages that we would like to send and receive. This is done using the INSTANCE.registerMessage method, which takes 5 parameters.
//		The first parameter is the discriminator for the packet. This is a per-channel unique ID for the packet. We recommend you use a local variable to hold the ID, and then call registerMessage using id++. This will guarantee 100% unique IDs.
//		The second parameter is the actual packet class MSG.
//		The third parameter is a BiConsumer<MSG, PacketBuffer> responsible for encoding the message into the provided PacketBuffer
//		The fourth parameter is a Function<PacketBuffer, MSG> responsible for decoding the message from the provided PacketBuffer
//		The final parameter is a BiConsumer<MSG, Supplier<NetworkEvent.Context>> responsible for handling the message itself.

		CHANNEL.registerMessage(this.nextMessageId, PlayerSetClassPacket.class, PlayerSetClassPacket::encode, PlayerSetClassPacket::decode,
				PlayerSetClassPacket::onMessageReceived);
	}
}
