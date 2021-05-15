package superdopesquad.superdopejedimod.faction;


import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import superdopesquad.superdopejedimod.SuperDopeJediMod;

import javax.annotation.Nullable;


public class ClassManager {

	private static final Logger LOGGER = LogManager.getLogger();

	public static final HashMap factionMap = new HashMap();
	public static final HashMap classMap = new HashMap();
	ArrayList<ClassInfo> _forceWieldingClasses = new ArrayList<ClassInfo>();

	public static final FactionInfo REBEL_ALLIANCE = new FactionInfo(0, "Rebel Alliance");
	public static final FactionInfo THE_EMPIRE = new FactionInfo(1, "The Empire");
	public static final FactionInfo INDEPENDENT_CONTRACTOR = new FactionInfo(2, "Independent Contractor");

	public static final ClassInfo UNAFFILIATED = new ClassInfo(0, "Unaffiliated", Color.white);
	public static final ClassInfo JEDI_KNIGHT = new ClassInfo(1, "Jedi Knight", Color.blue, true, REBEL_ALLIANCE);
	public static final ClassInfo REBEL_CELL_COMMANDER = new ClassInfo(2, "Rebel Cell Commander", Color.cyan, true, REBEL_ALLIANCE);
	public static final ClassInfo SITH_LORD = new ClassInfo(3, "Sith Lord", Color.red, true, THE_EMPIRE);
	public static final ClassInfo STORMTROOPER = new ClassInfo(4, "Stormtrooper", Color.orange, true, THE_EMPIRE);
	public static final ClassInfo BOUNTYHUNTER = new ClassInfo(5, "Bounty Hunter", Color.black, true, INDEPENDENT_CONTRACTOR);
	public static final ClassInfo SMUGGLER = new ClassInfo(6, "Smuggler", Color.green, true, INDEPENDENT_CONTRACTOR);
	public static final ClassInfo TUNNELER = new ClassInfo(7, "Tunneler", Color.lightGray, true, INDEPENDENT_CONTRACTOR);
	public static final ClassInfo TEAMJUDE = new ClassInfo(8, "Team Jude", Color.pink, true, INDEPENDENT_CONTRACTOR);

	public static final ClassCapabilityStorage classCapabilityStorage = new ClassCapabilityStorage();

	@CapabilityInject(ClassCapabilityInterface.class)
	public static final Capability<ClassCapabilityInterface> INSTANCE = null;
	private static final Direction DEFAULT_FACING = null;


	public ClassManager() {

		// Stash the list of force wielding classes for easy access later.
		this._forceWieldingClasses.add(JEDI_KNIGHT);
		this._forceWieldingClasses.add(SITH_LORD);

		// Let's do a shout-out.
		System.out.println("SuperDopeJediMod: initialized " + this.factionMap.size() + " player factions.");
		System.out.println("SuperDopeJediMod: initialized " + this.classMap.size() + " player classes.");
	}


	public void register() {

		//CapabilityManager.INSTANCE.register(capability interface class, storage, default implementation factory);

		//CapabilityManager.INSTANCE.register(IEntityStats.class, new Capability.IStorage<IEntityStats>()

		// Register the 'class' capability.
		CapabilityManager.INSTANCE.register(ClassCapabilityInterface.class, ClassManager.classCapabilityStorage,
				() -> new ClassCapability(null));
	}


	public static ICapabilityProvider createProvider(final ClassCapabilityInterface classCapabilityInterface) {
		return new ClassCapabilityProvider<>(INSTANCE, DEFAULT_FACING, classCapabilityInterface);
	}


	public static LazyOptional<ClassCapabilityInterface> getClassCapability(final LivingEntity entity) {
		return entity.getCapability(INSTANCE, DEFAULT_FACING);
	}


	public boolean canPlayerUse(PlayerEntity player, ClassAwareInterface object) {

		ClassInfo classInfo = this.getPlayerClass(player);

		//System.out.println(classInfo.toString() + ", " + (object.IsUseFriendlyOnly()) + ", " + object.GetFriendlyClasses().toString() + ", " + object.IsUseUnfriendlyBanned() + ", " + object.GetUnfriendlyClasses());

		// is this object set to be only used by friendly classes, and is this object not in that friendly list?
		if (object.IsUseFriendlyOnly() && (!(object.GetFriendlyClasses().contains(classInfo)))) {
			//System.out.println("failed due to lock down on IsUseFriendly and failed being included in GetFriendlyClasses.");
			return false;
		}

		// is this object set to be banned by unfriendly classes, and is this object in that unfriendly list?
		if (object.IsUseUnfriendlyBanned() && (object.GetUnfriendlyClasses().contains(classInfo))) {
			//System.out.println("failed due to lock down on IsUseUnFriendlyBanned and failed being included in GetUnFriendlyClasses.");
			return false;
		}

		// Otherwise, we all good here.
		return true;
	}


	public boolean canPlayerUse(PlayerEntity player, FactionAwareInterface object) {

		FactionInfo factionInfo = this.getPlayerFaction(player);

		// is this object set to be only used by friendly factions, and is this object not in that friendly list?
		if (object.IsUseFriendlyOnly() && (!(object.GetFriendlyFactions().contains(factionInfo)))) {
			//System.out.println("failed due to lock down on IsUseFriendly and failed being included in GetFriendlyFactions.");
			return false;
		}

		// is this object set to be banned by unfriendly factions, and is this object in that unfriendly list?
		if (object.IsUseUnfriendlyBanned() && (object.GetUnfriendlyFactions().contains(factionInfo))) {
			//System.out.println("failed due to lock down on IsUseUnFriendlyBanned and failed being included in GetUnFriendlyFactions.");
			return false;
		}

		// Otherwise, we all good here.
		return true;
	}


	public ArrayList<ClassInfo> getForceWieldingClasses() {

		return this._forceWieldingClasses;
	}


//	public ArrayList<FactionInfo> getRepublicFactions() {
//
//		ArrayList<FactionInfo> list = new ArrayList<FactionInfo>();
//		list.add(this.getFactionInfo(REBEL_ALLIANCE));
//		return list;
//	}


//	public ArrayList<FactionInfo> getImperialFactions() {
//
//		ArrayList<FactionInfo> list = new ArrayList<FactionInfo>();
//		list.add(this.getFactionInfo(THE_EMPIRE));
//		return list;
//	}


	public void onUpdateHandlerClassAware(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {

		// Bail if we are on the client.  This event is fired on both sides, just need to react appropriately on server.
		if (world.isClientSide) {
			return;
		}

		// We only want to do tests if the player is holding it in their hand.
		if (!(isSelected)) {
			return;
		}

		// We only care about testing objects that are class aware.
		if (!(stack.getItem() instanceof ClassAwareInterface)) {
			return;
		}

		// We only care if the entity is a player.
		if (!(entity instanceof PlayerEntity)) {
			return;
		}

		// Grab a more specific handle to the two objects we need: the item and the player.
		ClassAwareInterface itemToTest = (ClassAwareInterface) stack.getItem();
		PlayerEntity player = (PlayerEntity) entity;

//		// OK, time for the actual check.
//		boolean canUse = this.canPlayerUse(player, itemToTest);
//		if (!canUse) {
//			//System.out.println("DEBUG: Can't use this! " + itemToTest.toString() + ", " + entity.toString() + ", " + (itemSlot) + ", " + (isSelected));
//			player.dropItem(true);
//	 		player.sendMessage(new StringTextComponent("Due to your class, you can't use this item.  Dropping it!") {
//			});

		//player.sen
		//}
	}


	public boolean IsPlayerForceWielding(PlayerEntity player) {

		ArrayList<ClassInfo> classes = this.getForceWieldingClasses();
		ClassInfo classInfo = this.getPlayerClass(player);

		return (classes.contains(classInfo));
	}


	public boolean IsPlayerNonForceWielding(PlayerEntity player) {

		return (!(this.IsPlayerForceWielding(player)));
	}


	public ArrayList<ClassInfo> getClasses() {

		ArrayList<ClassInfo> classes = new ArrayList<ClassInfo>();
		int index = 0;

		for (Object o : this.classMap.values()) {
			classes.add((ClassInfo) o);
		}

		return classes;
	}


	public ArrayList<FactionInfo> getFactions() {

		ArrayList<FactionInfo> factions = new ArrayList<FactionInfo>();

		for (Object o : this.factionMap.values()) {
			factions.add((FactionInfo) o);
		}

		return factions;
	}


//	public FactionInfo getFactionInfo(Integer id) {
//
//		Object factionInfo = this._factionMap.get(id);
//
//		if (factionInfo == null) {
//			return null;
//		}
//
//		return (FactionInfo) factionInfo;
//	}


//	public ClassInfo getClassInfo(Integer id) {
//
//		Object classInfo = this._classMap.get(id);
//
//		if (classInfo == null) {
//			return null;
//		}
//
//		return (ClassInfo) classInfo;
//	}


	public boolean isPlayerInFaction(PlayerEntity player, FactionInfo factionInfoInput) {

		ClassInfo classInfo = this.getPlayerClass(player);
		FactionInfo factionInfo = (classInfo == null) ? null : classInfo.getFaction();

		if ((factionInfoInput == null) || (factionInfo == null)) {
			return false;
		}

		return (factionInfoInput.getId() == factionInfo.getId());
	}


	public ClassInfo getPlayerClass(PlayerEntity player) {

		int classIdOld;
		int classIdNew;
		String debugMessage;

		//LOGGER.debug("inside getPlayerClass: " + player.getName());

		//ClassCapabilityInterface classCapability = player.getCapability(INSTANCE,Direction.UP )

		LazyOptional<ClassCapabilityInterface> capability =  player.getCapability(INSTANCE, null);
		if (!(capability.isPresent())) {
			LOGGER.error("failed to find className Capability.");
			return null;
		}

		ClassCapabilityInterface classCapabilityInterface = capability.orElse(new ClassCapability(player));


		// We should have the Class capability set on every player.
		// DEBUG CODE ONLY.  Let's verify that fact.
		//boolean hasCapability = player.hasCapability(ClassCapabilityProvider.ClassCapability, null);
		//boolean hasCapability = false;

		//assert (hasCapability);

		// Let's get the Faction capability that is set on every player.
		//ClassCapabilityInterface classCapability = player.getCapability(ClassManager.INSTANCE.orEmpty(Capability<ClassCapability>), null);
//		ClassCapabilityInterface classCapability = null;

//		assert (classCapability != null);
//		if (classCapability == null) {
//			System.out.println("Uh oh! Failed to find class capability.");
//			//return (ClassInfo) this.classMap.get(UNAFFILIATED);
//			return (ClassInfo) SuperDopeJediMod.CLASS_MANAGER.UNAFFILIATED;
//		}

		// Extract the name out of factionInfo, now that we have the proper id.
		Integer classId = classCapabilityInterface.getClassId();
		ClassInfo classInfo = (ClassInfo) this.classMap.get(classId);

		//System.out.println("getPlayerFaction: " + player.toString() + ", factionid:" + factionId.toString());

		return classInfo;
	}


	public FactionInfo getPlayerFaction(PlayerEntity player) {

		ClassInfo classInfo = this.getPlayerClass(player);
		if (classInfo == null) {
			System.out.println("ERROR! Should track this down.  ClassInfo was null for player '" + player.getName() + "'");
			return null;
		}

		return classInfo.getFaction();
	}


	public String getPlayerClassName(PlayerEntity player) {

		ClassInfo classInfo = this.getPlayerClass(player);
		String className = classInfo.getName();

		return className;
	}


	public String getPlayerClassLongDescription(PlayerEntity player) {

		// Let's refresh it.
		ClassInfo classInfo = this.getPlayerClass(player);

		if (classInfo.getId() == SuperDopeJediMod.CLASS_MANAGER.UNAFFILIATED.getId()) {
			return ("You are not affiliated with any class.");
		}

		String message = "You are a member of the " + classInfo.getName() + " class.";

		FactionInfo factionInfo = classInfo.getFaction();
		if (factionInfo != null) {
			message += " You are " + classInfo.getFactionDescription();
		}

		return message;
	}


	public boolean setPlayerClassById(PlayerEntity player, Integer inputClassId) {

		//LOGGER.debug("inside setPlayerClassById; old class: " + this.getPlayerClassName(player));

		// If we can't find this capability, that there is a bad error!
		LazyOptional<ClassCapabilityInterface> capability =  player.getCapability(INSTANCE, null);
		if (!(capability.isPresent())) {
			LOGGER.error("failed to find className Capability.");
			return false;
		}

		// Grab the capability and set it to the new value.
		ClassCapabilityInterface classCapabilityInterface = capability.orElse(new ClassCapability(player));
		classCapabilityInterface.setClassId(inputClassId);

		// Send a message to the user what their new class is.
		//player.sendMessage(new StringTextComponent("Your new class is " + (this.getPlayerClassName(player))), null);

//		// Tell the client what is going on.
//		PacketPlayerSetClass message = new PacketPlayerSetClass(player, inputClassId);
//		SuperDopeJediMod.packetManager.INSTANCE.sendToAll(message);

		return true;
	}


	// MC-TO: Instead of having a separate function setPlayerFactionByclientId, i think i can just have a "isWorldRemote"
	// check in the setPlayerFactionById call, just to prevent recursive calling of the client message.
	public boolean setPlayerClassByClientId(PlayerEntity player, Integer inputClassId) {

		// Let's get the Faction capability that is set on every player.
		//ClassCapabilityInterface classCapability = player.getCapability(ClassCapabilityProvider.ClassCapability, null);
		ClassCapabilityInterface classCapability = null;


		assert (classCapability != null);
		if (classCapability == null) {
			return false;
		}

		// This sets it on the client.
		boolean setSuccess = classCapability.setClassId(inputClassId);
		if (!setSuccess) {
			return false;
		}

		return true;
	}


	public boolean setPlayerClassByName(PlayerEntity player, String inputClassName) {

		//int classId = -1;

		//System.out.println("count of this.classMap: " + this.classMap.size());

//		ArrayList<ClassInfo> classes = this.getClasses();
//		for (int i = 0; i < classes.size(); i++) {
//			System.out.println("(" + classes.get(1).getId().toString() + ") " + classes.get(i).getName() + " " + classes.get(i).getShortName());
//		}

		//this.classMap.
		// Now, let's enumerate our dictionary map and find the faction that the user wants to join.
		for (Object key : this.classMap.keySet()) {

			ClassInfo classInfo = (ClassInfo) this.classMap.get(key);
			//String className = classInfo.getShortName();

			//System.out.println(key.toString() + ":" + value);
			if (classInfo.getShortName().equalsIgnoreCase(inputClassName)) {
				//classId = (Integer) key;
				//break;
				return this.setPlayerClassById(player, (Integer)key);
			}
		}

		//if (classId == -1) {
			LOGGER.debug("failed to pattern match class name.");
			//LOGGER.warn("failed to pattern match class name.");
			//LOGGER.info("failed to pattern match class name.");
			//LOGGER.error("failed to pattern match class name.");
			return false;
		//}

		//return this.setPlayerClassById(player, classId);
	}
}
