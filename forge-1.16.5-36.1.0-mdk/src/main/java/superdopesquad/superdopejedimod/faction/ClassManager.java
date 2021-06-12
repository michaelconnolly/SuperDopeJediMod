package superdopesquad.superdopejedimod.faction;


import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.network.PacketDistributor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import superdopesquad.superdopejedimod.SuperDopeJediMod;
import superdopesquad.superdopejedimod.packet.PlayerSetClassPacket;
import superdopesquad.superdopejedimod.packet.PacketManager;


public class ClassManager {

	private static final Logger LOGGER = LogManager.getLogger();

	public static final HashMap factionMap = new HashMap();
	public static final HashMap classMap = new HashMap();

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

		System.out.println("SuperDopeJediMod: initialized " + this.classMap.size() + " player classes.");
	}


	public void register() {

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


	public boolean isPlayerInFaction(PlayerEntity player, FactionInfo factionInfoInput) {

		ClassInfo classInfo = this.getPlayerClass(player);
		FactionInfo factionInfo = (classInfo == null) ? null : classInfo.getFaction();

		if ((factionInfoInput == null) || (factionInfo == null)) {
			return false;
		}

		return (factionInfoInput.getId() == factionInfo.getId());
	}


	public ClassInfo getPlayerClass(PlayerEntity player) {

		LazyOptional<ClassCapabilityInterface> capability = player.getCapability(INSTANCE, null);
		if (!(capability.isPresent())) {
			LOGGER.error("failed to find className Capability.");
			return null;
		}

		ClassCapabilityInterface classCapabilityInterface = capability.orElse(new ClassCapability(player));

		// Extract the name out of factionInfo, now that we have the proper id.
		Integer classId = classCapabilityInterface.getClassId();
		ClassInfo classInfo = (ClassInfo) this.classMap.get(classId);

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

		return this.setPlayerClassById(player, inputClassId, true);
	}


	public boolean setPlayerClassById(PlayerEntity player, Integer inputClassId, boolean fanOut) {

		// If we can't find this capability, that there is a bad error!
		LazyOptional<ClassCapabilityInterface> capability = player.getCapability(INSTANCE, null);
		if (!(capability.isPresent())) {
			LOGGER.error("failed to find className Capability.");
			return false;
		}

		// Grab the capability and set it to the new value.
		ClassCapabilityInterface classCapabilityInterface = capability.orElse(new ClassCapability(player));
		classCapabilityInterface.setClassId(inputClassId);

		// Send a message to all clients that a player changed their class.
		// Also, verify that the current player is still wearing legal gear.
		if (fanOut) {

			this.communicateToClients(player, inputClassId);
			ClassManager.itemPermissionCheck(player);
		}

		return true;
	}


	public void communicateToClients(PlayerEntity player, int inputClassId) {

		// Tell the client what is going on.
		PlayerSetClassPacket msg = new PlayerSetClassPacket(player.getUUID(), inputClassId);
		// Sending to all connected players
		PacketManager.CHANNEL.send(PacketDistributor.ALL.noArg(), msg);
	}


	public boolean setPlayerClassByName(PlayerEntity player, String inputClassName) {

		// Enumerate our dictionary map and find the faction that the user wants to join.
		for (Object key : this.classMap.keySet()) {

			ClassInfo classInfo = (ClassInfo) this.classMap.get(key);
			if (classInfo.getShortName().equalsIgnoreCase(inputClassName)) {
				return this.setPlayerClassById(player, (Integer) key);
			}
		}

		LOGGER.debug("failed to pattern match class name.");
		return false;
	}


	public static void itemPermissionCheck(PlayerEntity player) {

		// It is illegal to wear armor not meant for your class.  If so, toss it.
		ClassManager.itemPermissionCheck(player, EquipmentSlotType.CHEST);
		ClassManager.itemPermissionCheck(player, EquipmentSlotType.HEAD);
		ClassManager.itemPermissionCheck(player, EquipmentSlotType.LEGS);
		ClassManager.itemPermissionCheck(player, EquipmentSlotType.FEET);

		// Current design: it's ok to hold weapons that aren't meant for you, you just can't use them.
		//ClassManager.itemPermissionCheck(player, EquipmentSlotType.MAINHAND);
		//ClassManager.itemPermissionCheck(player, EquipmentSlotType.OFFHAND);
	}


	public static void itemPermissionCheck(PlayerEntity player, EquipmentSlotType slot) {

		// If there is nothing in the slot, return.
		ItemStack itemStack = player.getItemBySlot(slot);
		if (itemStack == null) return;

		// If the item does not implement IClassAware, return.
		Item item = itemStack.getItem();
		if (!(item instanceof IClassAware)) return;

		// If they can use it, return.
		// If you can't, we threw an error in the chat.
		if (ClassManager.canUse((IClassAware) item, null, player)) return;

		// If you made it here, you have to get rid of this armor.
		LOGGER.debug(item.getRegistryName().toString() + " should not be worn!");
		ClassManager.toss(player, slot);
	}


	private static void toss(PlayerEntity player, EquipmentSlotType slot) {

		ItemStack itemStack = player.getItemBySlot(slot);
		ItemStack itemStackToDrop = itemStack.copy();

		// reduce the amount we have by 1.  For equipment slots, this should always reduce to zero.
		itemStack.shrink(1);

		// drop the stack in that slot onto the ground.  I am not sure what the boolean parameter does.
		player.drop(itemStackToDrop, false);
	}


	public static boolean canEquip(IClassAware thing, EquipmentSlotType armorType, Entity entity) {

		if (!(entity instanceof PlayerEntity)) return true;

		boolean canUse = ClassManager.canUse(thing, null, (PlayerEntity) entity);
		LOGGER.debug("ClassManager::canEquip: " + canUse);
		return canUse;
	}


	public static boolean canUse(IClassAware item, World world, PlayerEntity player) {

		boolean canUse = ((item.getClassPermissions() == null) || item.getClassPermissions().canUse(world, player));
		LOGGER.debug("ClassManager::canUse: " + canUse + "; was classPermissions null? " + (item.getClassPermissions() == null));
		return (canUse);
	}
}
