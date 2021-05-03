package superdopesquad.superdopejedimod.faction;


import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import superdopesquad.superdopejedimod.SuperDopeJediMod;


public class ClassManager {

	public static final HashMap factionMap = new HashMap();
	public static final HashMap classMap = new HashMap();
	ArrayList<ClassInfo> _forceWieldingClasses = new ArrayList<ClassInfo>();

	public static final FactionInfo REBEL_ALLIANCE = new FactionInfo(0,"Rebel Alliance");
	public static final FactionInfo THE_EMPIRE = new FactionInfo(1,"The Empire");
	public static final FactionInfo INDEPENDENT_CONTRACTOR = new FactionInfo(2,"Independent Contractor");

	public static final ClassInfo UNAFFILIATED = new ClassInfo(0, "Unaffiliated", Color.white);
	public static final ClassInfo JEDI_KNIGHT = new ClassInfo(1, "Jedi Knight", Color.blue, true, REBEL_ALLIANCE);
	public static final ClassInfo REBEL_CELL_COMMANDER = new ClassInfo(2, "Rebel Cell Commander", Color.cyan, true, REBEL_ALLIANCE);
	public static final ClassInfo SITH_LORD = new ClassInfo(3, "Sith Lord", Color.red, true, THE_EMPIRE);
	public static final ClassInfo STORMTROOPER = new ClassInfo(4, "Stormtrooper", Color.orange, true, THE_EMPIRE);
	public static final ClassInfo BOUNTYHUNTER = new ClassInfo(5, "Bounty Hunter", Color.black, true, INDEPENDENT_CONTRACTOR);
	public static final ClassInfo SMUGGLER = new ClassInfo(6, "Smuggler", Color.green, true, INDEPENDENT_CONTRACTOR);
	public static final ClassInfo TUNNELER = new ClassInfo(7, "Tunneler", Color.lightGray, true, INDEPENDENT_CONTRACTOR);
	public static final ClassInfo TEAMJUDE =  new ClassInfo(8, "Team Jude", Color.pink, true, INDEPENDENT_CONTRACTOR);


//
//	public static final Integer UNAFFILIATED = 0;
//	public static final Integer JEDI = 1;
//	public static final Integer SITH = 2;
//	public static final Integer SMUGGLER = 3;
//	public static final Integer BOUNTYHUNTER = 4;
//	public static final Integer TEAMJUDE = 5;
//	public static final Integer TUNNELER = 6;
//	public static final Integer STORMTROOPERCOMMANDER = 7;
//	public static final Integer SITHPILOT = 8;
//	public static final Integer REPUBLICPILOT = 9;

//	public static final String UNAFFILIATED_NAME = "Unaffiliated";
//	public static final String JEDI_NAME = "Jedi";
//	public static final String SITH_NAME = "Sith";
//	public static final String SMUGGLER_NAME = "Smuggler";
//	public static final String BOUNTYHUNTER_NAME = "Bounty Hunter";
//	public static final String TEAMJUDE_NAME = "Team Jude";
//	public static final String TUNNELER_NAME = "Tunneler";
//	public static final String STORMTROOPERCOMMANDER_NAME = "Storm Trooper Commander";
//	public static final String SITHPILOT_NAME = "Sith Pilot";
//	public static final String REPUBLICPILOT_NAME = "Republic Pilot";

//	public static final Integer FACTION_REPUBLIC = 0;
//	public static final Integer FACTION_EMPIRE = 1;
//	public static final String FACTION_REPUBLIC_NAME = "The Republic";
//	public static final String FACTION_EMPIRE_NAME = "The Empire";



	public ClassManager() {

		// Define our factions.
//		FactionInfo factionInfoRepublic = new FactionInfo(FACTION_REPUBLIC, FACTION_REPUBLIC_NAME);
//		FactionInfo factionInfoEmpire = new FactionInfo(FACTION_EMPIRE, FACTION_EMPIRE_NAME);
//		this._factionMap.put(FACTION_REPUBLIC, factionInfoRepublic);
//		this._factionMap.put(FACTION_EMPIRE, factionInfoEmpire);
//		this._factionMap.put(0, "Independent Contractor");
//		this._factionMap.put(1, "Independent Contractor");

//		this._factionMap.put(0, new FactionInfo(0,"Rebel Alliance"));
//		this._factionMap.put(1, new FactionInfo(1,"The Empire"));
//		this._factionMap.put(2, new FactionInfo(2,"Independent Contractor"));

//		this._factionMap.put(1, new FactionInfo(1,"The Empire"));
//		this._factionMap.put(2, new FactionInfo(2,"Independent Contractor"));

//		this._classMap.put(0, new ClassInfo(0, "Unaffiliated", Color.white));
//		this._classMap.put(1, new ClassInfo(1, "Jedi Knight", Color.blue, true, REBEL_ALLIANCE));
//		this._classMap.put(2, new ClassInfo(2, "Rebel Cell Commander", Color.cyan, true, REBEL_ALLIANCE));
//		this._classMap.put(3, new ClassInfo(3, "Sith Lord", Color.red, true, THE_EMPIRE));
//		this._classMap.put(4, new ClassInfo(4, "Stormtrooper", Color.orange, true, THE_EMPIRE));
//		this._classMap.put(5, new ClassInfo(5, "Bounty Hunter", Color.black, true, INDEPENDENT_CONTRACTOR));
//		this._classMap.put(6, new ClassInfo(6, "Smuggler", Color.green, true, INDEPENDENT_CONTRACTOR));
//		this._classMap.put(7, new ClassInfo(7, "Tunneler", Color.lightGray, true, INDEPENDENT_CONTRACTOR));
//		this._classMap.put(8, new ClassInfo(8, "Team Jude", Color.pink, true, INDEPENDENT_CONTRACTOR));
//

//		// Define our classes.
//		ClassInfo classInfoUnaffiliated = new ClassInfo(UNAFFILIATED, UNAFFILIATED_NAME, Color.white);
//		ClassInfo classInfoJedi = new ClassInfo(JEDI, JEDI_NAME, Color.blue, true, factionInfoRepublic);
//		ClassInfo classInfoSith = new ClassInfo(SITH, SITH_NAME, Color.red, true, factionInfoEmpire);
//		ClassInfo classInfoSmuggler = new ClassInfo(SMUGGLER, SMUGGLER_NAME, Color.green, true, factionInfoRepublic);
//		ClassInfo classInfoBountyHunter = new ClassInfo(BOUNTYHUNTER, BOUNTYHUNTER_NAME, Color.black, true, factionInfoEmpire);
//		ClassInfo classInfoTeamJude = new ClassInfo(TEAMJUDE, TEAMJUDE_NAME, Color.pink, true, null);
//		ClassInfo classInfoTunneler = new ClassInfo(TUNNELER, TUNNELER_NAME, Color.lightGray, true, null);
//		ClassInfo classInfoStormTrooperCommander = new ClassInfo(STORMTROOPERCOMMANDER, STORMTROOPERCOMMANDER_NAME, Color.orange, true, factionInfoEmpire);
//		ClassInfo classInfoSithPilot = new ClassInfo(SITHPILOT, SITHPILOT_NAME, Color.gray, true, factionInfoEmpire);
//		ClassInfo classInfoRepublicPilot = new ClassInfo(REPUBLICPILOT, REPUBLICPILOT_NAME, Color.cyan, true, factionInfoRepublic);

//		this._classMap.put(UNAFFILIATED, classInfoUnaffiliated);
//		this._classMap.put(JEDI, classInfoJedi);
//		this._classMap.put(SITH, classInfoSith);
//		this._classMap.put(SMUGGLER, classInfoSmuggler);
//		this._classMap.put(BOUNTYHUNTER, classInfoBountyHunter);
//		this._classMap.put(TEAMJUDE, classInfoTeamJude);
//		this._classMap.put(TUNNELER, classInfoTunneler);
//		this._classMap.put(STORMTROOPERCOMMANDER, classInfoStormTrooperCommander);
//		this._classMap.put(SITHPILOT, classInfoSithPilot);
//		this._classMap.put(REPUBLICPILOT, classInfoRepublicPilot);

		// Stash the list of force wielding classes for easy access later.
		this._forceWieldingClasses.add(JEDI_KNIGHT);
		this._forceWieldingClasses.add(SITH_LORD);

		// Let's do a shout-out.
		System.out.println("SuperDopeJediMod: initialized " + this.factionMap.size() + " player factions.");
		System.out.println("SuperDopeJediMod: initialized " + this.classMap.size() + " player classes.");
	}


	public void preInit() {

		// Register the 'class' capability.
		//CapabilityManager.INSTANCE.register(ClassCapabilityInterface.class, new ClassCapabilityStorage(), ClassCapability.class);
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

		// We should have the Class capability set on every player.
		// DEBUG CODE ONLY.  Let's verify that fact.
		//boolean hasCapability = player.hasCapability(ClassCapabilityProvider.ClassCapability, null);
		boolean hasCapability = false;

		assert(hasCapability);

		// Let's get the Faction capability that is set on every player.
		//ClassCapabilityInterface classCapability = player.getCapability(ClassCapabilityProvider.ClassCapability, null);
		ClassCapabilityInterface classCapability = null;

		assert(classCapability != null);
		if (classCapability == null) {
			System.out.println("Uh oh! Failed to find class capability.");
			//return (ClassInfo) this.classMap.get(UNAFFILIATED);
			return (ClassInfo) SuperDopeJediMod.CLASS_MANAGER.UNAFFILIATED;
		}

		// Extract the name out of factionInfo, now that we have the proper id.
		Integer classId = classCapability.get();
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

    	//if (classInfo.getId() == this.UNAFFILIATED) {
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

		// Let's get the Faction capability that is set on every player.
		//ClassCapabilityInterface classCapability = player.getCapability(ClassCapabilityProvider.ClassCapability, null);
		ClassCapabilityInterface classCapability = null;

		assert(classCapability != null);
		if (classCapability == null) {
			return false;
		}

		// This sets it on the server.
		boolean setSuccess = classCapability.set(inputClassId);
		if (!setSuccess) {
			return false;
		}

//		// Tell the client what is going on.
//		PacketPlayerSetClass message = new PacketPlayerSetClass(player, inputClassId);
//		SuperDopeJediMod.packetManager.INSTANCE.sendToAll(message);
//
		return true;
	}


	// MC-TO: Instead of having a separate function setPlayerFactionByclientId, i think i can just have a "isWorldRemote"
	// check in the setPlayerFactionById call, just to prevent recursive calling of the client message.
	public boolean setPlayerClassByClientId(PlayerEntity player, Integer inputClassId) {

		// Let's get the Faction capability that is set on every player.
		//ClassCapabilityInterface classCapability = player.getCapability(ClassCapabilityProvider.ClassCapability, null);
		ClassCapabilityInterface classCapability = null;


		assert(classCapability != null);
		if (classCapability == null) {
			return false;
		}

		// This sets it on the client.
		boolean setSuccess = classCapability.set(inputClassId);
		if (!setSuccess) {
			return false;
		}

		return true;
	}


	public boolean setPlayerClassByName(PlayerEntity player, String inputClassName) {

		int classId = -1;

		// Now, let's enumerate our dictionary map and find the faction that the user wants to join.
		for (Object key : this.classMap.keySet()) {

			ClassInfo classInfo = (ClassInfo) this.classMap.get(key);
			String className = classInfo.getShortName();

			//System.out.println(key.toString() + ":" + value);
			if (className.equalsIgnoreCase(inputClassName)) {
				classId = (Integer) key;
				break;
			}
		}

		if (classId == -1) {
			return false;
		}

		return this.setPlayerClassById(player, classId);
	}
}
