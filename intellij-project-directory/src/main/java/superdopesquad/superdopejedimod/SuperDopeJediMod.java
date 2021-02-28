package superdopesquad.superdopejedimod;


//import net.minecraftforge.common.capabilities.CapabilityManager;
//import net.minecraftforge.common.util.EnumHelper;
//import net.minecraftforge.common.Enum;

import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.fml.common.Mod;
        import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
        import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


import superdopesquad.superdopejedimod.armor.*;
import superdopesquad.superdopejedimod.faction.ClassManager;
import superdopesquad.superdopejedimod.material.*;
import net.minecraft.item.Item;
//private static final Logger LOGGER = LogManager.getLogger();


@Mod("superdopejedimod")
public class SuperDopeJediMod {

    // Set the metadata of the mod.
    public static final String MODID = "superdopejedimod";
    public static final String MODNAME = "SuperDopeJediMod";
    public static final String MODVER = "0.0.1";

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    // Establish proxy classes, so we can do the right stuff client-side only, if necessary.
//    @SidedProxy(clientSide="superdopesquad.superdopejedimod.SuperDopeClientProxy", serverSide="superdopesquad.superdopejedimod.SuperDopeServerProxy")
//    public static SuperDopeCommonProxy superDopeCommonProxy;
//
    // This is our collection of custom objects and custom entities we will maintain.
  //  public static ArrayList<SuperDopeObject> customObjects = new ArrayList<SuperDopeObject>();

    // this is the world generator that adds our custom objects to newly spawned world chunks.
    //public static SuperDopeWorldGenerator superDopeWorldGenerator = new SuperDopeWorldGenerator();

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
//
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
//
    // instance variable.
    //   @Instance(value = SuperDopeJediMod.MODID) //Tell Forge what instance to use.
    //  public static SuperDopeJediMod instance;

//    // Beskar, used to create heavy weapons and heavy armor.
//    public static final Beskar BESKAR = new Beskar("beskar");
//    public static final BeskarOre BESKAR_ORE = new BeskarOre("beskar_ore");
//    public static final BeskarIngot BESKAR_INGOT = new BeskarIngot("beskar_ingot");
//
//    // Quadanium, used to create vehicles and other big things.
//    public static final Quadanium QUADANIUM = new Quadanium("quadanium");
//    public static final QuadaniumOre QUADANIUM_ORE = new QuadaniumOre("quadanium_ore");
//    public static final QuadaniumIngot QUADANIUM_INGOT = new QuadaniumIngot("quadanium_ingot");
//
//    // Plastoid, used to create medium weapons and medium armor.
//    public static final Plastoid PLASTOID = new Plastoid("plastoid");
//    public static final PlastoidScraps PLASTOID_SCRAPS = new PlastoidScraps("plastoid_scraps");
//    public static final PlastoidSheet PLASTOID_SHEET = new PlastoidSheet("plastoid_sheet");
    public static final MaterialManager MATERIAL_MANAGER = new MaterialManager();

    public static final MandalorianArmor MANDALORIAN_HELMET = new MandalorianArmor("mandalorian_helmet", EquipmentSlotType.HEAD);
    public static final MandalorianArmor MANDALORIAN_CHESTPLATE = new MandalorianArmor("mandalorian_chestplate",EquipmentSlotType.CHEST);
    public static final MandalorianArmor MANDALORIAN_LEGGINGS = new MandalorianArmor("mandalorian_leggings",EquipmentSlotType.LEGS);
    public static final MandalorianArmor MANDALORIAN_BOOTS = new MandalorianArmor("mandalorian_boots",EquipmentSlotType.FEET);

    public static final JediArmor JEDI_HELMET = new JediArmor("jedi_helmet", EquipmentSlotType.HEAD);
    public static final JediArmor JEDI_CHESTPLATE = new JediArmor("jedi_chestplate",EquipmentSlotType.CHEST);
    public static final JediArmor JEDI_LEGGINGS = new JediArmor("jedi_leggings",EquipmentSlotType.LEGS);
    public static final JediArmor JEDI_BOOTS = new JediArmor("jedi_boots",EquipmentSlotType.FEET);

    public static final SithLordArmor SITH_LORD_HELMET = new SithLordArmor("sith_lord_helmet", EquipmentSlotType.HEAD);
    public static final SithLordArmor SITH_LORD_CHESTPLATE = new SithLordArmor("sith_lord_chestplate",EquipmentSlotType.CHEST);
    public static final SithLordArmor SITH_LORD_LEGGINGS = new SithLordArmor("sith_lord_leggings",EquipmentSlotType.LEGS);
    public static final SithLordArmor SITH_LORD_BOOTS = new SithLordArmor("sith_lord_boots",EquipmentSlotType.FEET);

    public static final SmugglerArmor SMUGGLER_HELMET = new SmugglerArmor("smuggler_helmet", EquipmentSlotType.HEAD);
    public static final SmugglerArmor SMUGGLER_CHESTPLATE = new SmugglerArmor("smuggler_chestplate",EquipmentSlotType.CHEST);
    public static final SmugglerArmor SMUGGLER_LEGGINGS = new SmugglerArmor("smuggler_leggings",EquipmentSlotType.LEGS);
    public static final SmugglerArmor SMUGGLER_BOOTS = new SmugglerArmor("smuggler_boots",EquipmentSlotType.FEET);

    public static final StormTrooperArmor STORMTROOPER_HELMET = new StormTrooperArmor("stormtrooper_helmet", EquipmentSlotType.HEAD);
    public static final StormTrooperArmor STORMTROOPER_CHESTPLATE = new StormTrooperArmor("stormtrooper_chestplate",EquipmentSlotType.CHEST);
    public static final StormTrooperArmor STORMTROOPER_LEGGINGS = new StormTrooperArmor("stormtrooper_leggings",EquipmentSlotType.LEGS);
    public static final StormTrooperArmor STORMTROOPER_BOOTS = new StormTrooperArmor("stormtrooper_boots",EquipmentSlotType.FEET);

    public static final RebelArmor REBEL_HELMET = new RebelArmor("rebel_helmet", EquipmentSlotType.HEAD);
    public static final RebelArmor REBEL_CHESTPLATE = new RebelArmor("rebel_chestplate",EquipmentSlotType.CHEST);
    public static final RebelArmor REBEL_LEGGINGS = new RebelArmor("rebel_leggings",EquipmentSlotType.LEGS);
    public static final RebelArmor REBEL_BOOTS = new RebelArmor("rebel_boots",EquipmentSlotType.FEET);


    //public static MandalorianIronSword mandalorianIronSword = new MandalorianIronSword("mandalorianIronSword");

  //  public static final RegistryObject<Block> MANDALORIAN_IRON_ORE = BLOCKS.register("mandalorianIronOre", () -> new MandalorianIronOre("mandalorianIronOre"));
  //  public static final RegistryObject<Block> MANDALORIAN_IRON_ORE = BLOCKS.register("mandalorianIronOre", mandalorianIronOre);


//    // Vehicle parts.
//    public static VehicleSeat vehicleSeat = new VehicleSeat("vehicleSeat");
//
//    // Lightsaber stuff!
//    public static LightSaber lightSaberRed = new LightSaber("lightSaberRed", "Red");
//    public static LightSaber lightSaberBlue = new LightSaber("lightSaberBlue", "Blue");
//    public static LightSaber lightSaberGreen = new LightSaber("lightSaberGreen", "Green");
//    public static LightSaber lightSaberPurple = new LightSaber("lightSaberPurple", "Purple");
//    public static DoubleLightSaber doubleLightSaberRed = new DoubleLightSaber("doubleLightSaberRed", "Red");
//    public static DoubleLightSaber doubleLightSaberBlue = new DoubleLightSaber("doubleLightSaberBlue", "Blue");
//    public static DoubleLightSaber doubleLightSaberGreen = new DoubleLightSaber("doubleLightSaberGreen", "Green");
//    public static DoubleLightSaber doubleLightSaberPurple = new DoubleLightSaber("doubleLightSaberPurple", "Purple");
//    public static PowerCrystal redPowerCrystal = new PowerCrystal("redPowerCrystal", "Red");
//    public static PowerCrystal bluePowerCrystal = new PowerCrystal("bluePowerCrystal", "Blue");
//    public static PowerCrystal greenPowerCrystal = new PowerCrystal("greenPowerCrystal", "Green");
//    public static PowerCrystal purplePowerCrystal = new PowerCrystal("purplePowerCrystal", "Purple");
//    public static PowerCrystalOre redPowerCrystalOre = new PowerCrystalOre("redPowerCrystalOre", "Red");
//    public static PowerCrystalOre bluePowerCrystalOre = new PowerCrystalOre("bluePowerCrystalOre", "Blue");
//    public static PowerCrystalOre greenPowerCrystalOre = new PowerCrystalOre("greenPowerCrystalOre", "Green");
//    public static PowerCrystalOre purplePowerCrystalOre = new PowerCrystalOre("purplePowerCrystalOre", "Purple");
//
//    // Miscellaneous items.
//    public static NourishmentCapsule nourishmentCapsule = new NourishmentCapsule("nourishmentCapsule");
//    public static Credit credit = new Credit("credit");
//    public static SithMark sithMark = new SithMark("sithMark");
//    public static JediMark jediMark = new JediMark("jediMark");
//    public static ClassItem classItem = new ClassItem("classItem");
//    public static OHUMBlock ohumBlock = new OHUMBlock("OHUMBlock");
//    public static StarBlock starBlock = new StarBlock("StarBlock");
//
//    // Blocks and Items Used for a Spaceship
//    public static Engine engine = new Engine("engine");
//    public static ChromateOre chromateOre = new ChromateOre("chromateOre");
//    public static ChromateIngot chromateIngot = new ChromateIngot("chromateIngot");
//    public static CompressedMetalPlate compressedMetalPlate = new CompressedMetalPlate("compressedMetalPlate");
//    public static CompressedMetalBits compressedMetalBits = new CompressedMetalBits("compressedMetalBits");
//    //public static TinkerTable tinkerTable = new TinkerTable("tinkerTable");
//    public static ChromateShard chromateShard = new ChromateShard("chromateShard");
//    public static ElectricTransmitter electricTransmitter = new ElectricTransmitter("electricTransmitter");
//    public static ElectricFluxIngot electricFluxIngot = new ElectricFluxIngot("electricFluxIngot");
//    public static ElectricFluxOre electricFluxOre = new ElectricFluxOre("electricFluxOre");
//    public static ControlPanel controlPanel = new ControlPanel("controlPanel");
//    public static CompressedMetalMesh compressedMetalMesh = new CompressedMetalMesh("compressedMetalMesh");
//    public static BitsOfCompressedMetalMesh bitsOfCompressedMetalMesh = new BitsOfCompressedMetalMesh("bitsOfCompressedMetalMesh");

    //Spaceship Entitys


    //    // Mandalorian Iron, used to create weapons and armor.
//    public static MandalorianIron mandalorianIron = new MandalorianIron("mandalorianIron");
//    public static MandalorianIronIngot mandalorianIronIngot = new MandalorianIronIngot("mandalorianIronIngot");
//    public static MandalorianIronOre mandalorianIronOre = new MandalorianIronOre("mandalorianIronOre");
//    public static MandalorianIronArmor mandalorianIronHelmet = new MandalorianIronArmor(EntityEquipmentSlot.HEAD, "mandalorianIronHelmet");
//    public static MandalorianIronArmor mandalorianIronChestplate = new MandalorianIronArmor(EntityEquipmentSlot.CHEST, "mandalorianIronChestplate");
//    public static MandalorianIronArmor mandalorianIronLeggings = new MandalorianIronArmor(EntityEquipmentSlot.LEGS, "mandalorianIronLeggings");
//    public static MandalorianIronArmor mandalorianIronBoots = new MandalorianIronArmor(EntityEquipmentSlot.FEET, "mandalorianIronBoots");
//    public static MandalorianIronSword mandalorianIronSword = new MandalorianIronSword("mandalorianIronSword");
//            
    // Quadanium Steel, used to create vehicles.
//    public static QuadaniumSteel quadaniumSteel = new QuadaniumSteel("quadaniumSteel");
//    public static QuadaniumSteelIngot quadaniumSteelIngot = new QuadaniumSteelIngot("quadaniumSteelIngot");
//    public static QuadaniumSteelOre quadaniumSteelOre = new QuadaniumSteelOre("quadaniumSteelOre");
//    public static QuadaniumSteelArmor quadaniumSteelHelmet = new QuadaniumSteelArmor(EquipmentSlotType.HEAD, "quadaniumSteelHelmet");
//    public static QuadaniumSteelArmor quadaniumSteelChestplate = new QuadaniumSteelArmor(EquipmentSlotType.CHEST, "quadaniumSteelChestplate");
//    public static QuadaniumSteelArmor quadaniumSteelLeggings = new QuadaniumSteelArmor(EquipmentSlotType.LEGS, "quadaniumSteelLeggings");
//    public static QuadaniumSteelArmor quadaniumSteelBoots = new QuadaniumSteelArmor(EquipmentSlotType.FEET, "quadaniumSteelBoots");
//    public static QuadaniumSteelSword quadaniumSteelSword = new QuadaniumSteelSword("quadaniumSteelSword");
//
    //Bounty Hunter stuff
//    public static BountyHunterLeaderKnife bountyHunterLeaderKnife = new BountyHunterLeaderKnife("bountyHunterLeaderKnife");
//
//    // Peoples Custom Items
//    public static BrynsAwesomeSword brynsAwesomeSword = new BrynsAwesomeSword("brynsAwesomeSword");
//
//    //drills + other tools
//    //public static Drill drill = new Drill("drill");
//
//    //Items for Custom Items
//    public static Ruby ruby = new Ruby("ruby");
//    public static RubyOre rubyOre = new RubyOre("rubyOre");
//    public static SaphireOre saphireOre = new SaphireOre("saphireOre");
//    public static Saphire saphire = new Saphire("saphire");

    // Classes.  Must be before EntityManager.
    public static final ClassManager CLASS_MANAGER = new ClassManager();

    // Entities.
    //public static EntityManager entityManager = new EntityManager();

    // Commands.
 //   public static CommandManager commandManager = new CommandManager();
//
//    // Our packet manager; this is where we manage custom packets to keep the client and server in-sync.
//    public static SuperDopePacketManager packetManager = new SuperDopePacketManager();
//
//    // Weapons.
//    public static WeaponManager weaponManager = new WeaponManager();
//
//    // Teleporters.
//    public static TeleporterManager teleporterManager = new TeleporterManager();
//
//    // Managing ships and general hanger stuff.
//    public static HangarManager hangarManager = new HangarManager();
//
    public SuperDopeJediMod() {

        System.out.println("Hello from SuperDopeJediMod:constructor 666");

        // New way to do it: make sure the BLOCKS registry is getting  init events.
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

        // Register the setup method for modloading
        //FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
//        // Register the enqueueIMC method for modloading
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
//        // Register the processIMC method for modloading
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
//        // Register the doClientStuff method for modloading
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register our ore generator.
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, MATERIAL_MANAGER::GenerateOre);
    }
//    public ExampleMod() {
//        // Register the setup method for modloading

    //FMLJavaModLoadingContext.get().getModEventBus().a

//        // Register the enqueueIMC method for modloading
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
//        // Register the processIMC method for modloading
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
//        // Register the doClientStuff method for modloading
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);



    private void setup(final FMLCommonSetupEvent event) {

        // some preinit code
        System.out.println("Hello from SuperDopeJediMod:setup!");
        //LOGGER.info("HELLO FROM PREINIT");
        //LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());



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
//
//
//    @SubscribeEvent
//    public void registerBlocks(RegistryEvent.Register<Block> event) {
//
//    	System.out.println("Inside SuperDopeJediMod:registerBlocks");
//
//    	// Iterate through all our custom blocks and items, and register them all.
//    	for (SuperDopeObject superDopeObject : this.customObjects) {
//
//    		superDopeObject.registerBlocks(event);
//    	}
//
//    	// MC: hack: placing this here for now.
//        //GameRegistry.registerTileEntity(GeneratorTileEntity.class, "TileEntityGenerator");
//    }
//
//
//    @SubscribeEvent
//    public void registerItems(RegistryEvent.Register<Item> event) {
//
//    	// Iterate through all our custom items, and register them all.
//    	for (SuperDopeObject superDopeObject : this.customObjects) {
//
//    		superDopeObject.registerItems(event);
//    	}
//    }
//
//
//    @EventHandler
//    public void load(FMLInitializationEvent event) {
//
//    }
//
//
//    @EventHandler
//	public void serverLoad(FMLServerStartingEvent event) {
//
//    	commandManager.serverLoad(event);
//	}
//
//
//    @EventHandler
//    public void init(FMLInitializationEvent event) {
//
//    	// Call our proxy for any side-specific work.
//    	// Looking for where we register models?  Check in SuperDopeClientProxy.init(e).
//    	superDopeCommonProxy.init(event);
//
//    	// Iterate through all our custom blocks and items,
//    	// and see if we have any recipes to register.
//    	for (SuperDopeObject superDopeObject : this.customObjects) {
//    		superDopeObject.registerRecipe();
//    	}
//
//    	// Register our custom world generator, so our ore gets generated.
//    	GameRegistry.registerWorldGenerator(SuperDopeJediMod.superDopeWorldGenerator, 0);
//
//
////    	// Let's register our eventhandler class.
////    	MinecraftForge.EVENT_BUS.register(new SuperDopeEventHandler());
//    }
//
//
//    @EventHandler
//    public void postInit(FMLPostInitializationEvent event) {
//
//    	// Call our proxy for any side-specific work.
//    	superDopeCommonProxy.postInit(event);
//    }
//
}
