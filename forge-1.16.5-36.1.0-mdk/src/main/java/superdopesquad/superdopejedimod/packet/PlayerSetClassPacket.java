package superdopesquad.superdopejedimod.packet;


import net.minecraft.client.Minecraft;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.LogicalSidedProvider;
import net.minecraftforge.fml.network.NetworkEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import superdopesquad.superdopejedimod.SuperDopeJediMod;
import superdopesquad.superdopejedimod.armor.ArmorManager;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

/**
 * This Network Message is sent from the server to all clients in the same dimension, to tell them to draw a "target indicator" at the target point
 * Typical usage:
 * PREQUISITES:
 *   have previously setup SimpleChannel, registered the message class and the handler
 *
 * 1) User creates a TargetEffectMessageToClient(targetCoordinates)
 * 2) simpleChannel.sendToDimension(targetEffectMessageToClient);
 * 3) Forge network code calls targetEffectMessageToClient.encode() to copy the message member variables to a PacketBuffer, ready for sending
 * ... bytes are sent over the network and arrive at the client....
 * 4) Forge network code calls targetEffectMessageToClient.decode() to recreate the targetEffectMessageToClient instance by reading
 *     from the PacketBuffer into the member variables
 * 5) the handler.onMessage(targetEffectMessageToClient) is called to process the message
 */


public class PlayerSetClassPacket {

    private UUID playerId;
    private int classId;
    public boolean messageIsValid = false;
    private static final Logger LOGGER = LogManager.getLogger();


    public PlayerSetClassPacket(UUID playerId, int classId) {

        this.playerId = playerId;
        this.classId = classId;
        this.messageIsValid = true;
    }


    // for use by the message handler only.
    public PlayerSetClassPacket() { }


    /**
     * Called by the network code once it has received the message bytes over the network.
     * Used to read the ByteBuf contents into your member variables
     * @param buf
     */
    public static PlayerSetClassPacket decode(PacketBuffer buf) {

        PlayerSetClassPacket retval = new PlayerSetClassPacket();

        try {
            retval.playerId = buf.readUUID();
            retval.classId = buf.readInt();
            LOGGER.debug("Message Received! Player: " + retval.playerId.toString() + ", Class: " + retval.classId);
        }
        catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            LOGGER.warn("Exception while reading buffer: " + e);
            return retval;
        }

        retval.messageIsValid = true;
        return retval;
    }

    /**
     * Called by the network code.
     * Used to write the contents of your message member variables into the ByteBuf, ready for transmission over the network.
     * @param buf
     */
    public void encode(PacketBuffer buf) {

        if (!messageIsValid) {

            LOGGER.warn("Tried to encode a non-valid Message.  Bailing early.");
            return;
        }

        buf.writeUUID(this.playerId);
        buf.writeInt(this.classId);
    }


    public static void onMessageReceived(final PlayerSetClassPacket message,
                                         Supplier<NetworkEvent.Context> ctxSupplier) {

        //LOGGER.debug("inside ServerToClientPlayerSetClass::onMessageReceived");

        NetworkEvent.Context ctx = ctxSupplier.get();
        LogicalSide sideReceived = ctx.getDirection().getReceptionSide();
        ctx.setPacketHandled(true);

        if (sideReceived != LogicalSide.CLIENT) {
            LOGGER.warn("Packet received on wrong side:" + ctx.getDirection().getReceptionSide());
            return;
        }
        if (!message.messageIsValid) {
            LOGGER.warn("Packet was invalid: " + message.toString());
            return;
        }
        // we know for sure that this handler is only used on the client side, so it is ok to assume
        //  that the ctx handler is a client, and that Minecraft exists.
        // Packets received on the server side must be handled differently!  See MessageHandlerOnServer

        Optional<ClientWorld> clientWorld = LogicalSidedProvider.CLIENTWORLD.get(sideReceived);
        if (!clientWorld.isPresent()) {
            LOGGER.warn("Packet context could not provide a ClientWorld.");
            return;
        }

        // This code creates a new task which will be executed by the client during the next tick
        ctx.enqueueWork(() -> processMessage(clientWorld.get(), message));
    }


    private static void processMessage(ClientWorld worldClient, PlayerSetClassPacket message) {

        //LOGGER.debug("inside ServerToClientPlayerSetClass::processMessage");

        if (!(worldClient.isClientSide)) {
            LOGGER.warn("Incorrectly received PlayerSetClassPacket:processMessage on server-side.");
            return;
        }

        PlayerEntity activePlayer = Minecraft.getInstance().player;
        PlayerEntity changedPlayer = worldClient.getPlayerByUUID(message.playerId);
        LOGGER.debug("processMessage: activePlayer: " + activePlayer.getName().getString(), ", changedPlayer: " +changedPlayer.getName().getString());
        SuperDopeJediMod.CLASS_MANAGER.setPlayerClassById(activePlayer, message.classId, false);

        // If we are getting notified about a change in the active player that the
        // client side is managing, what work should we do?
        // Example: make sure the armor you are currently wearing is wearable.
//        if (activePlayer == changedPlayer) {
//            ArmorManager.armorSetCheck(activePlayer);
//        }

        return;
    }
}

