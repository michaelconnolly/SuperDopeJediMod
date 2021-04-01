package superdopesquad.superdopejedimod;


import com.sun.java.accessibility.util.java.awt.TextComponentTranslator;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import superdopesquad.superdopejedimod.entity.EntityManager;
import superdopesquad.superdopejedimod.faction.ClassCapability;
import superdopesquad.superdopejedimod.faction.ClassCapabilityInterface;
import superdopesquad.superdopejedimod.faction.ClassCapabilityProvider;
import superdopesquad.superdopejedimod.faction.ClassInfo;

import java.awt.*;
import java.util.List;
//import superdopesquad.superdopejedimod.faction.PacketClientAskingServerAboutClass;
//import superdopesquad.superdopejedimod.faction.PacketPlayerSetClass;
//import superdopesquad.superdopejedimod.faction.PacketServerPokingClientAboutClass;
////import superdopesquad.superdopejedimod.teleporter.PacketClientAskingServerAboutTeleporterDestination;
//import superdopesquad.superdopejedimod.teleporter.TeleporterCapabilityProvider;
//import superdopesquad.superdopejedimod.teleporter.TeleporterEntity;


//@Mod.EventBusSubscriber(modid = SuperDopeJediMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SuperDopeEventHandler {


    public static final Logger LOGGER = LogManager.getLogger(SuperDopeJediMod.MODID + "::SuperDopeEventHandler");


    @SubscribeEvent
	public void registerBlocks(RegistryEvent.Register<Block> event) {

        LOGGER.debug("INSIDE SuperDopeJediMod:registerBlocks");

		// Iterate through all our custom blocks and items, and register them all.
//		for (SuperDopeObject superDopeObject : SuperDopeJediMod.customObjects) {
//
//			superDopeObject.registerBlocks(event);
//		}
	}


	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event) {

        LOGGER.debug("INSIDE SuperDopeJediMod:registerItems");


//		// Iterate through all our custom items, and register them all.
//		for (SuperDopeObject superDopeObject : SuperDopeJediMod.customObjects) {
//
//			superDopeObject.registerItems(event);
//		}
	}


 //   @SubscribeEvent
    // public void registerEntities(final RegistryEvent.Register<EntityType<WookieEntity>> event) {
 @SubscribeEvent
 public void registerEntities(RegistryEvent.Register<EntityType<?>> event) {

        LOGGER.debug("INSIDE SuperDopeJediMod::registerEntities");

        // MC: FIND ME :
        event.getRegistry().register(EntityManager.WOOKIE);

//        event.getRegistry().register(EntityType.Builder.create(WookieEntity::new, EntityClassification.MONSTER)
//                .build(SuperDopeJediMod.MODID + ":wookie")
//                .setRegistryName(new ResourceLocation(SuperDopeJediMod.MODID, "wookie")));
//
        //event.getRegistry().registerAll(new Block(...), new Block(...), ...);

//        public static final RegistryObject<EntityType<?>> WOOKIE =
//                SuperDopeJediMod.ENTITIES.register("wookie",
//                        () -> EntityType.Builder.create(WookieEntity::new, EntityClassification.MONSTER)
//                                .build(SuperDopeJediMod.MODID + ":wookie")
//                                .setRegistryName(new ResourceLocation(SuperDopeJediMod.MODID, "wookie")));
    }

//
//    @SubscribeEvent
//	public void blockBreakEvent(BreakEvent e)
//	{
//		// System.out.println("Inside blockBreakEvent");
//
//        //MC-TO_DO
////		IBlockState blockState = e.getState();
////		Block block = blockState.getBlock();
////
////		if (block instanceof BaseBlock) {
////			((BaseBlock)block).blockBreakEvent(e);
////			return;
////		}
//
////	    if (e.getWorld().isRemote)
////	        return;
//	}


//
//	@SubscribeEvent
//	public void onPlayerLogsIn(PlayerEvent.PlayerLoggedInEvent event) {
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