package superdopesquad.superdopejedimod;


import java.util.ArrayList;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
//import net.minecraftforge.common.capabilities.CapabilityManager;
//import net.minecraftforge.common.util.EnumHelper;
//import net.minecraftforge.common.Enum;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import net.minecraftforge.common.IExtensibleEnum;

import net.minecraftforge.event.RegistryEvent;
//import net.minecraftforge.fml.client.registry.RenderingRegistry;
//import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
//import net.minecraftforge.fml.common.event.FMLInitializationEvent;
//import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
//import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
//import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
//import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.fml.common.Mod.EventHandler;
//import net.minecraftforge.fml.common.Mod.Instance;
//import net.minecraftforge.fml.common.SidedProxy;
//import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
//import net.minecraftforge.fml.relauncher.Side;
//import superdopesquad.superdopejedimod.entity.BaseMovingVehicle;
//import superdopesquad.superdopejedimod.entity.EntityManager;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import superdopesquad.superdopejedimod.faction.ClassItem;
//import superdopesquad.superdopejedimod.faction.ClassManager;
//import superdopesquad.superdopejedimod.hangar.HangarManager;
//import superdopesquad.superdopejedimod.teleporter.TeleporterManager;
//import superdopesquad.superdopejedimod.tinkertable.TinkerTable;
//import superdopesquad.superdopejedimod.tools.Drill;
import superdopesquad.superdopejedimod.weapon.BountyHunterLeaderKnife;
import superdopesquad.superdopejedimod.weapon.BrynsAwesomeSword;
import superdopesquad.superdopejedimod.weapon.DoubleLightSaber;
import superdopesquad.superdopejedimod.weapon.GaffiStick;
import superdopesquad.superdopejedimod.weapon.LightSaber;
import superdopesquad.superdopejedimod.weapon.MandalorianIronSword;
import superdopesquad.superdopejedimod.weapon.QuadaniumSteelSword;
//import superdopesquad.superdopejedimod.weapon.WeaponManager;
import net.minecraft.block.Block;
//import net.minecraft.block.material.Material;
//import net.minecraft.creativetab.CreativeTabs;
//import net.minecraft.init.Blocks;
//import net.minecraft.init.Items;
//import net.minecraft.init.SoundEvents;
//import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
//import net.minecraft.item.ItemStack;
//import net.minecraft.item.Item.ToolMaterial;
import  net.minecraft.item.ToolItem;
//import net.minecraft.item.ItemArmor;
//import net.minecraft.item.ItemArmor.ArmorMaterial;
//import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//private static final Logger LOGGER = LogManager.getLogger();


@Mod("superdopejedimod")
//@Mod(modid=SuperDopeJediMod.MODID, name=SuperDopeJediMod.MODNAME, version=SuperDopeJediMod.MODVER) //Tell forge "Oh hey, there's a new mod here to load."
public class SuperDopeJediMod {

    // Set the metadata of the mod.
    public static final String MODID = "superdopejedimod";
    public static final String MODNAME = "SuperDopeJediMod";
    public static final String MODVER = "0.0.1";

    //public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<Block>(ForgeRegistries.BLOCKS, MODID);
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

   // public static final RegistryObject<Item> MANDALORIAN_IRON_INGOT = ITEMS.register("mandarlorian_iron_ingot", () -> new Item(new Item.Properties()));

    //public static final RegistryObject<Item> MANDALORIAN_IRON_INGOT = ITEMS.register("mandalorian_iron_ingot", () -> new MandalorianIronIngot(new Item.Properties()));
    //public static final RegistryObject<Block> MANDALORIAN_IRON_ORE = BLOCKS.register("mandalorianIronOre", () -> new MandalorianIronOre("mandalorianIronOre"));

    // Mandalorian Iron, used to create weapons and armor.
    public static final MandalorianIron MANDALORIAN_IRON = new MandalorianIron("mandalorian_iron");
    public static final MandalorianIronOre MANDALORIAN_IRON_ORE = new MandalorianIronOre("mandalorian_iron_ore");

    //public static final RegistryObject<Block> MANDALORIAN_IRON = BLOCKS.register("mandalorian_iron", () -> new MandalorianIron());
    //public static final RegistryObject<Item> MANDALORIAN_IRON_ITEM = ITEMS.register("mandalorian_iron", () -> new BlockItem(MANDALORIAN_IRON.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
    //public static final RegistryObject<Block> MANDALORIAN_IRON_ORE = BLOCKS.register("mandalorian_iron_ore", () -> new MandalorianIronOre());
    //public static final RegistryObject<Item> MANDALORIAN_IRON_ORE_ITEM = ITEMS.register("mandalorian_iron_ore", () -> new BlockItem(MANDALORIAN_IRON_ORE.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
    public static final RegistryObject<Item> MANDALORIAN_IRON_INGOT = ITEMS.register("mandalorian_iron_ingot", () -> new MandalorianIronIngot(new Item.Properties()));

//    public static final RegistryObject<Block> TUTORIAL_BLOCK = BLOCKS.register("tutorial_block", () -> new Block(Block.Properties.create(Material.ROCK)));
//    public static final RegistryObject<Item> TUTORIAL_BLOCK = ITEMS.register("tutorial_block", () -> new BlockItem(ModBlocks.TUTORIAL_BLOCK.get(), new Item.Properties()));

    // Mandalorian Iron, used to create weapons and armor.
//    public static MandalorianIron mandalorianIron = new MandalorianIron("mandalorianIron");
//    public static MandalorianIronIngot mandalorianIronIngot = new MandalorianIronIngot("mandalorianIronIngot");
//    public static MandalorianIronOre mandalorianIronOre = new MandalorianIronOre("mandalorianIronOre");
//    public static MandalorianIronArmor mandalorianIronHelmet = new MandalorianIronArmor(EquipmentSlotType.HEAD, "mandalorianIronHelmet");
//    public static MandalorianIronArmor mandalorianIronChestplate = new MandalorianIronArmor(EquipmentSlotType.CHEST, "mandalorianIronChestplate");
//    public static MandalorianIronArmor mandalorianIronLeggings = new MandalorianIronArmor(EquipmentSlotType.LEGS, "mandalorianIronLeggings");
//    public static MandalorianIronArmor mandalorianIronBoots = new MandalorianIronArmor(EquipmentSlotType.FEET, "mandalorianIronBoots");
//    public static MandalorianIronSword mandalorianIronSword = new MandalorianIronSword("mandalorianIronSword");

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
//    //Sith Armor
//    public static SithLordArmor sithLordHelmet = new SithLordArmor(EquipmentSlotType.HEAD, "sithLordHelmet");
//    public static SithLordArmor sithLordChestplate = new SithLordArmor(EquipmentSlotType.CHEST, "sithLordChestplate");
//    public static SithLordArmor sithLordLeggings = new SithLordArmor(EquipmentSlotType.LEGS, "sithLordLeggings");
//    public static SithLordArmor sithLordBoots = new SithLordArmor(EquipmentSlotType.FEET, "sithLordBoots");

//    //Jedi Armor
//    public static JediArmor jediHelmet = new JediArmor(EquipmentSlotType.HEAD, "jediHelmet");
//    public static JediArmor jediChestplate = new JediArmor(EquipmentSlotType.CHEST, "jediChestplate");
//    public static JediArmor jediLeggings = new JediArmor(EquipmentSlotType.LEGS, "jediLeggings");
//    public static JediArmor jediBoots = new JediArmor(EquipmentSlotType.FEET, "jediBoots");
//
//    //Storm Trooper
//    public static StormTrooperArmor stormTrooperHelmet = new StormTrooperArmor(EquipmentSlotType.HEAD, "stormTrooperHelmet");
//    public static StormTrooperArmor stormTrooperChestplate = new StormTrooperArmor(EquipmentSlotType.CHEST, "stormTrooperChestplate");
//    public static StormTrooperArmor stormTrooperLeggings = new StormTrooperArmor(EquipmentSlotType.LEGS, "stormTrooperLeggings");
//    public static StormTrooperArmor stormTrooperBoots = new StormTrooperArmor(EquipmentSlotType.FEET, "stormTrooperBoots");

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
    //public static ClassManager classManager = new ClassManager();

    // Entities.
    //public static EntityManager entityManager = new EntityManager();

    // Commands.
//    public static CommandManager commandManager = new CommandManager();
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
        //MinecraftForge.EVENT_BUS.register(this);
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

    // Register ourselves for server and other game events we are interested in
    //MinecraftForge.EVENT_BUS.register(this);
    //  }

    private void setup(final FMLCommonSetupEvent event) {

        // some preinit code
        System.out.println("Hello from SuperDopeJediMod:setup 666");
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
