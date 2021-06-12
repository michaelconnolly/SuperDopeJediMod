package superdopesquad.superdopejedimod;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import superdopesquad.superdopejedimod.armor.*;
import superdopesquad.superdopejedimod.building.BuildingManager;
import superdopesquad.superdopejedimod.command.CommandManager;
import superdopesquad.superdopejedimod.entity.EntityManager;
import superdopesquad.superdopejedimod.faction.ClassCapability;
import superdopesquad.superdopejedimod.faction.ClassInfo;
import superdopesquad.superdopejedimod.faction.ClassManager;
import superdopesquad.superdopejedimod.material.*;
import net.minecraft.item.Item;
import superdopesquad.superdopejedimod.packet.PacketManager;
import superdopesquad.superdopejedimod.weapon.WeaponManager;


@Mod("superdopejedimod")
public class SuperDopeJediMod {

    private static final Logger LOGGER = LogManager.getLogger();
    private int tickCounter = 0;
    private final int TICK_CHECK_COUNT = 20;

    // Set the metadata of the mod.
    public static final String MODID = "superdopejedimod";
    private SuperDopeEventHandler superDopeEventHandler = new SuperDopeEventHandler();
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, MODID);

    // Establish proxy classes, so we can do the right stuff client-side only, if necessary.
    //    @SidedProxy(clientSide="superdopesquad.superdopejedimod.SuperDopeClientProxy", serverSide="superdopesquad.superdopejedimod.SuperDopeServerProxy")
    //    public static SuperDopeCommonProxy superDopeCommonProxy;

    // Custom ToolMaterial's.  For a good tutorial on how to define a ToolMaterial, look here:
    // The order of those #'s at the end: harvestLevel, durability, miningSpeed, damageVsEntities, enchantability
    // http://bedrockminer.jimdo.com/modding-tutorials/basic-modding-1-7/custom-tools-swords/
    //	public static ToolItem gaffiStickMaterial = addToolMaterial("GaffiStickMaterial", 3, 1000, 15.0F, 4.0F, 30);
    //	public static ToolMaterial powerCrystalMaterial = EnumHelper.addToolMaterial("LightSaberMaterial", 3, 5000, 0.0F, 9.0F, 0);
    //	public static ToolMaterial doublePowerCrystalMaterial = EnumHelper.addToolMaterial("DoubleLightSaberMaterial", 3, 10000, 0.0F, 12.0F, 0);
    //	public static ToolMaterial brynsAwesomeSwordMaterial = EnumHelper.addToolMaterial("BrynsAwesomeSwordMaterial", 3, 2000, 0.0F, 8.0F, 30);
    //	public static ToolMaterial mandalorianIronToolMaterial = EnumHelper.addToolMaterial("MandalorianIronToolMaterial", 3, 1000, 15.0F, 4.0F, 30);
    //	public static ToolMaterial quadaniumSteelToolMaterial = EnumHelper.addToolMaterial("QuadaniumSteelToolMaterial", 3, 1000, 15.0F, 4.0F, 30);
    //	public static ToolMaterial blasterMaterial = EnumHelper.addToolMaterial("BlasterMaterial", 3, 1000, 0.0F, 7.0F, 30);
    //	public static ToolMaterial lightSaberKnifeMaterial = EnumHelper.addToolMaterial("LightSaberKnifeMaterial", 3, 1000, 0.0F, 6.0F, 0);
    //	public static ToolMaterial drillMaterial = EnumHelper.addToolMaterial("DrillMaterial", 3, 10000, 25.0F, 0.0F, 10);

    // Custom ArmorMaterial's.
    // EnumHelper.addArmorMaterial("NAME", textureName, durability, reductionAmounts, enchantability, soundOnEquip, toughness)
    //		Durability: 5 - leather; 7 - gold; 15 - chain and iron; 33 - diamond
    //		Reduction Amounts: 1,3,2,1 - leather; 2,5,3,1 - gold; 2,5,4,1 - chain; 2,6,5,2 - iron; 3,8,6,3 - diamond
    //		Enchantability: 15 - leather; 12 - chain; 9 - iron; 25 - gold; 10 - diamond

//	public static ArmorMaterial mandalorianIronArmorMaterial = EnumHelper.addArmorMaterial("MandalorianIronArmorMaterial", "superdopejedimod:mandalorianironarmormaterial", 15, new int[]{2,6,5,2}, 9, null, (float) 0.0);
//	public static ArmorMaterial quadaniumSteelArmorMaterial = EnumHelper.addArmorMaterial("QuadaniumSteelArmorMaterial", "superdopejedimod:quadaniumsteelarmormaterial", 15, new int[]{2,6,5,2}, 9, null, (float) 0.0);
//	public static ArmorMaterial sithLordArmorMaterial = EnumHelper.addArmorMaterial("SithLordArmorMaterial", "superdopejedimod:sithlordarmormaterial", 30, new int[]{3,8,6,3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, (float) 0.0);
//	public static ArmorMaterial jediArmorMaterial = EnumHelper.addArmorMaterial("JediArmorMaterial", "superdopejedimod:jediarmormaterial", 30, new int[]{3,8,6,3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, (float) 0.0);
//	public static ArmorMaterial stormTrooperArmorMaterial = EnumHelper.addArmorMaterial("StormTrooperArmor", "superdopejedimod:stormtrooperarmormaterial", 15, new int[]{2,6,5,2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, (float) 0.0);

    public static final MaterialManager MATERIAL_MANAGER = new MaterialManager();
    public static final ClassManager CLASS_MANAGER = new ClassManager(); // Must be early, before objects that need classinfo.
    public static final ArmorManager ARMOR_MANAGER = new ArmorManager();
    public static final WeaponManager WEAPON_MANAGER = new WeaponManager();
    public static final EntityManager ENTITY_MANAGER = new EntityManager();
    public static final CommandManager COMMAND_MANAGER = new CommandManager();
    public static final BuildingManager BUILDING_MANAGER = new BuildingManager();
    public static PacketManager PACKET_MANAGER = new PacketManager();


//    // Miscellaneous items.
//    public static NourishmentCapsule nourishmentCapsule = new NourishmentCapsule("nourishmentCapsule");
//    public static Credit credit = new Credit("credit");
//
//    // Teleporters.
//    public static TeleporterManager teleporterManager = new TeleporterManager();
//
//    // Managing ships and general hanger stuff.
//    public static HangarManager hangarManager = new HangarManager();

//
//    private boolean timeToCheckThings() {
//
//        if (++(this.tickCounter) >= this.TICK_CHECK_COUNT) {
//            this.tickCounter = 0;
//            return true;
//        }
//
//        return false;
//    }


    public SuperDopeJediMod() {

        // Setup our registries for new blocks, items, etc.
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());

        // Adding event listeners.
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupCommon);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupClient);
        FMLJavaModLoadingContext.get().getModEventBus().register(superDopeEventHandler);
        MinecraftForge.EVENT_BUS.register(superDopeEventHandler);
        MinecraftForge.EVENT_BUS.register(this);

        // Register our ore generator.
        // NOTE: I have seen some mods trigger their ore generation management
        // by calling it from this.setup, instead of separate listener here.
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, MATERIAL_MANAGER::GenerateOre);
    }


    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event) {

        Entity entity = event.getObject();
        if (entity == null) {
            LOGGER.debug("inside attachCapability: event.getObject() == NULL");
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
            LOGGER.debug(("inside attachCapability: " + name.getString()));
            final ClassCapability classCapability = new ClassCapability((LivingEntity) event.getObject());
            event.addCapability(new ResourceLocation(SuperDopeJediMod.MODID), ClassManager.createProvider(classCapability));
        }
    }


    @SubscribeEvent
    public void registerCommands(final RegisterCommandsEvent event) {

        LOGGER.debug("registering commands ...");

        COMMAND_MANAGER.registerCommands(event.getDispatcher());
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


    private void setupCommon(final FMLCommonSetupEvent event) {

        LOGGER.debug("SuperDopeJediMod::setupCommon ....");

        ENTITY_MANAGER.setupCommon();
        CLASS_MANAGER.register();
    }


    private void setupClient(final FMLClientSetupEvent event) {

        LOGGER.debug("SuperDopeJediMod::setupClient ...");

        ENTITY_MANAGER.registerEntityRenderer();

        // Let's add capes!
        ENTITY_MANAGER.initCape();
    }


//    @EventHandler
//    public void preInit(FMLPreInitializationEvent event) {
//
//    	// Let's register our eventhandler class.
//    	MinecraftForge.EVENT_BUS.register(new SuperDopeEventHandler());
//
//    	// Call our proxy for any side-specific work.
//    	superDopeCommonProxy.preInit(event);
//    	superDopeCommonProxy.registerTileEntities();
//
//    	// Iterate through all our custom blocks and items, and register them all.
//    	for (SuperDopeObject superDopeObject : this.customObjects) {
//    		superDopeObject.registerObject();
//    	}

//    	// Call the pre-init of ClassManager, which needs to do some registration work.
//    	this.classManager.preInit();
//
//    	// Call the pre-init of TeleporterManager, which needs to do some registration work.
//    	this.teleporterManager.preInit();
}
