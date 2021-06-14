package superdopesquad.superdopejedimod;


import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import superdopesquad.superdopejedimod.command.CommandManager;
import superdopesquad.superdopejedimod.faction.ClassCapability;
import superdopesquad.superdopejedimod.faction.ClassInfo;
import superdopesquad.superdopejedimod.faction.ClassManager;
import superdopesquad.superdopejedimod.weapon.PlasmaShotEntity;


public class SuperDopeEventHandler {


    public static final Logger LOGGER = LogManager.getLogger(SuperDopeJediMod.MODID + "::SuperDopeEventHandler");


    @SubscribeEvent
    public void registerEntities(RegistryEvent.Register<EntityType<?>> event) {

        LOGGER.debug("SuperDopeJediMod::registerEntities ...");

        SuperDopeJediMod.ENTITY_MANAGER.registerEntity(event);
    }



    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event) {

        Entity entity = event.getObject();
        if (entity == null) {
            LOGGER.warn("attachCapability: event.getObject() == NULL");
            return;
        }

        ITextComponent name;
        if (entity instanceof PlayerEntity) {
            name = new StringTextComponent("(a player)");
        } else if (entity instanceof LivingEntity) {
            name = entity.getName();
        } else {
            name = entity.getName();
        }

        if (entity instanceof PlayerEntity) {
            LOGGER.debug(("attachCapability: " + name.getString()));
            final ClassCapability classCapability = new ClassCapability((LivingEntity) event.getObject());
            event.addCapability(new ResourceLocation(SuperDopeJediMod.MODID), ClassManager.createProvider(classCapability));
        }
    }


    @SubscribeEvent
    public void registerCommands(final RegisterCommandsEvent event) {

        CommandManager.registerCommands(event.getDispatcher());
    }


//    @SubscribeEvent
//    public void playerTick(TickEvent.PlayerTickEvent event) {
//
//        if (!(this.timeToCheckThings())) {
//            return;
//        }
//
//        LOGGER.debug("processing playerTick: " + event.player.getName().getString());
//        this.armorSetCheck(event.player);
//    }


    @SubscribeEvent
    public void onPlayerLogsIn(final PlayerEvent.PlayerLoggedInEvent event) {

        PlayerEntity player = event.getPlayer();
        String playerName = player.getName().getString();
        ClassInfo classInfo = SuperDopeJediMod.CLASS_MANAGER.getPlayerClass(player);

        LOGGER.debug("PlayerEvent.PlayerLoggedInEvent: " + playerName + ", class: " +
                (classInfo == null ? "null" : classInfo.getShortName()));

        // Tell all clients that this player logged in, so we fan out the correct ClassInfo to them.
        SuperDopeJediMod.CLASS_MANAGER.communicateToClients(player, classInfo.getId());

        // Say hi to the new user.
        player.sendMessage(new StringTextComponent("Welcome to SuperDopeJediMod!  Your class is " + classInfo.getDescription()), null);

        // We are on the server side; when the player logs in, if they are wearing illegal armor/weapons, say something.
        ClassManager.itemPermissionCheck(player);
    }


    @SubscribeEvent
    public void onPlayerDoesSomething(final PlayerEvent.ItemPickupEvent event) {

        String entityName = event.getEntity().getName().getString();
        LOGGER.debug("PlayerEvent.ItemPickupEvent: " + entityName);
    }


    //******************************
    // MC-TODO: implement something like this, which should fix problem with PlasmaShotEntity.
    // *****************************
    @SubscribeEvent
    public void entityAttributeCreationEvent(EntityAttributeCreationEvent event) {

        LOGGER.error("entityAttributeCreationEvent ... NYI");
        //event.put(PlasmaShotEntity.TYPE, WeirdMobEntity.MAP);
    }

//
//		// We are server-side, so we have accurate information on-hand on class/faction info.
//		// So, let's have a welcome message display to the user.
//		PlayerEntity player = event.getPlayer();
//		ClassInfo classInfo = SuperDopeJediMod.CLASS_MANAGER.getPlayerClass(player);
//		String message = "Welcome back. " + SuperDopeJediMod.CLASS_MANAGER.getPlayerClassLongDescription(player);
//		player.sendMessage(new TranslationTextComponent(message), null);
//
////		// Let's start a conversation with the client about faction/classes, since we need to make
////		// sure all connected clients get refreshed on the current faction/class info of this user.
////		PacketServerPokingClientAboutClass packet = new PacketServerPokingClientAboutClass();
////		System.out.println("SENDING PacketServerPokingClientAboutClass");
////		SuperDopeJediMod.packetManager.INSTANCE.sendTo(packet, player);
//	}
//
//
//	// Any custom properties that we add to player through the capabilities system does not survive
//	// upon player's death.  So, they need to be manually copied over.
//	@SubscribeEvent
//	public void clonePlayer(PlayerEvent.Clone event) {
//
//		if (event.isWasDeath()) {
//
//			PlayerEntity originalPlayer = event.getOriginal();
//			PlayerEntity newPlayer = event.getPlayer();
//
//			// Copy class information to the new player object being clone from the original.
//			String originalClass = SuperDopeJediMod.CLASS_MANAGER.getPlayerClassName(originalPlayer);
//			SuperDopeJediMod.CLASS_MANAGER.setPlayerClassByName(newPlayer, originalClass);
//		}
//	}
//
//
//	// This event is required to add any capabilities to players as they are created.
//	@SubscribeEvent
//	public void attachCapability(AttachCapabilitiesEvent<Entity> event) {
//
//		if (event.getObject() instanceof PlayerEntity) {
//
//			// Attaching the class capability to EntityPlayer.
//			//System.out.println("DEBUG: Attaching the Class capability to EntityPlayer.");
//			ResourceLocation classCapabilityId = new ResourceLocation(SuperDopeJediMod.MODID, "classCapability");
//			event.addCapability(classCapabilityId, new ClassCapabilityProvider());
//		}
//
//		// MC-TODO
////		if (event.getObject() instanceof TeleporterEntity) {
////
////			// Attaching the Teleporter capability to TeleporterEntity.
////			//System.out.println("DEBUG: Attaching the Teleporter capability to TeleporterEntity.");
////			ResourceLocation teleporterCapabilityId = new ResourceLocation(SuperDopeJediMod.MODID, "teleporterCapability");
////			event.addCapability(teleporterCapabilityId, new TeleporterCapabilityProvider());
////		}
//	}
//
//
//	@OnlyIn(Dist.CLIENT)
//	@SubscribeEvent
//	public void onEntityJoined(EntityJoinWorldEvent event)
//	{
//		Entity entity = event.getEntity();
//		PlayerEntity currentPlayer = Minecraft.getInstance().player;
//
//		// We get a wave of events fired prior to 'thePlayer' being initialized.  I don't know why this
//		// occurs, but we should safely disregard these events, since there is no action we can take.
//		// We *will* get the event of ourselves logging in with 'thePlayer' initialized, which will
//		// make it through successfully so we can take proper action.
//		if (currentPlayer == null) {
//			//System.out.println("onEntityJoined: crap, currentPlayer is null!");
//			return;
//		}
//
//		// If this is a player, phone home and ask for accurate information on class/faction.
//		if (entity instanceof PlayerEntity ) {
//
//			PlayerEntity newPlayer = (PlayerEntity) entity;
//			//System.out.println("Inside onEntityJoined: " + (event.getWorld().isRemote) + ", ");
//
//			if (newPlayer.getUniqueID() == (currentPlayer.getUniqueID())) {
//
//				// Ask about class.
//                // MC_TODO
////				PacketClientAskingServerAboutClass packet = new PacketClientAskingServerAboutClass();
////				SuperDopeJediMod.packetManager.INSTANCE.sendToServer(packet);
//
////				// Ask about teleporter data.
////				PacketClientAskingServerAboutTeleporterDestination packet2 = new PacketClientAskingServerAboutTeleporterDestination();
////				SuperDopeJediMod.packetManager.INSTANCE.sendToServer(packet2);
//			}
//		}
//	}
}