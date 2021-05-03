package superdopesquad.superdopejedimod;

import net.minecraft.block.Block;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import superdopesquad.superdopejedimod.armor.*;
import superdopesquad.superdopejedimod.entity.EntityManager;
import superdopesquad.superdopejedimod.faction.ClassManager;
import superdopesquad.superdopejedimod.material.*;
import net.minecraft.item.Item;
import superdopesquad.superdopejedimod.weapon.WeaponManager;


@Mod("superdopejedimod")
public class SuperDopeJediMod {

    // Set the metadata of the mod.
    public static final String MODID = "superdopejedimod";
    //public static final String MODNAME = "SuperDopeJediMod";
    //public static final String MODVER = "0.0.1";

    private SuperDopeEventHandler superDopeEventHandler = new SuperDopeEventHandler();

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, MODID);

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

    public static final MaterialManager MATERIAL_MANAGER = new MaterialManager();
    public static final ArmorManager ARMOR_MANAGER = new ArmorManager();
    public static final WeaponManager WEAPON_MANAGER = new WeaponManager();


//    // Vehicle parts.
//    public static VehicleSeat vehicleSeat = new VehicleSeat("vehicleSeat");
//

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
    public static final EntityManager ENTITY_MANAGER = new EntityManager();

    // Commands.
 //   public static CommandManager commandManager = new CommandManager();
//
//    // Our packet manager; this is where we manage custom packets to keep the client and server in-sync.
//    public static SuperDopePacketManager packetManager = new SuperDopePacketManager();
//
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
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());

        // Register the setup method for modloading
        //FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
//        // Register the enqueueIMC method for modloading
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
//        // Register the processIMC method for modloading
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
//        // Register the doClientStuff method for modloading
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupCommon);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupClient);
        FMLJavaModLoadingContext.get().getModEventBus().register(superDopeEventHandler);
        MinecraftForge.EVENT_BUS.register(superDopeEventHandler);
        //FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(this::registerEntities);

        //FMLJavaModLoadingContext.get().getModEventBus().addGenericListener()


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register our ore generator.
        // NOTE: I have seen some mods trigger their ore generation management
        // by calling it from this.setup, instead of separate listener here.
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, MATERIAL_MANAGER::GenerateOre);

        //MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, this::registerEntities);


        // Register our mobs.
        // https://github.com/MinecraftForge/MinecraftForge/issues/6911
        //GlobalEntityTypeAttributes.put(EntityManager.WOOKIE_ENTITY, MobEntity.func_233666_p_().func_233813_a_()/*(or your own)*/);
        //GlobalEntityTypeAttributes.put(EntityManager.WOOKIE_ENTITY, WookieEntity.func_233666_p_().create()); //*(or your own)*/);

        //MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, ENTITY_MANAGER::GenerateMobs);
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



    private void setupCommon(final FMLCommonSetupEvent event) {

        System.out.println("INSIDE SuperDopeJediMod::setupCommon");

        ENTITY_MANAGER.setupCommon();

//        // https://forums.minecraftforge.net/topic/87597-1161-custom-entity-attributes/
//        // In my main class in the setup function I had a deferredWorkQueue where I dealt
//        // with the function above like this:
//         DeferredWorkQueue.runLater(() -> {
//
//            // GlobalEntityTypeAttributes.put(MyEntities.myCustomEntity, CrewmanEntity.setCustomAttributes().func_233813_a_());
//            GlobalEntityTypeAttributes.put((EntityType<? extends LivingEntity>) EntityManager.WOOKIE_ENTITY, WookieEntity.setCustomAttributes().create());
//            GlobalEntityTypeAttributes.put((EntityType<? extends LivingEntity>) EntityManager.TUSKEN_RAIDER_ENTITY, TuskenRaiderEntity.setCustomAttributes().create());
//
//
//         });

        // some preinit code
        //System.out.println("Hello from SuperDopeJediMod:setup!");
        //LOGGER.info("HELLO FROM PREINIT");
        //LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
//
//    @SubscribeEvent
//    public void registerBlocks(RegistryEvent.Register<Block> event) {
////        event.getRegistry().registerAll(new Block(...), new Block(...), ...);
////  we don't use this for blocks/items: we use deferred registry insteadd.
//        System.out.println("INSIDE SuperDopeJediMod::registerBlocks");
//
//    }

//    @SubscribeEvent
//   // public void registerEntities(final RegistryEvent.Register<EntityType<WookieEntity>> event) {
//        public void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
//
//        System.out.println("INSIDE SuperDopeJediMod::registerEntities");
//
//        // MC: FIND ME :
//        event.getRegistry().register(EntityManager.WOOKIE);
//
////        event.getRegistry().register(EntityType.Builder.create(WookieEntity::new, EntityClassification.MONSTER)
////                .build(SuperDopeJediMod.MODID + ":wookie")
////                .setRegistryName(new ResourceLocation(SuperDopeJediMod.MODID, "wookie")));
////
//        //event.getRegistry().registerAll(new Block(...), new Block(...), ...);
//
////        public static final RegistryObject<EntityType<?>> WOOKIE =
////                SuperDopeJediMod.ENTITIES.register("wookie",
////                        () -> EntityType.Builder.create(WookieEntity::new, EntityClassification.MONSTER)
////                                .build(SuperDopeJediMod.MODID + ":wookie")
////                                .setRegistryName(new ResourceLocation(SuperDopeJediMod.MODID, "wookie")));
//
//
//
//
//    }



    private void setupClient(final FMLClientSetupEvent event) {

        System.out.println("INSIDE SuperDopeJediMod::setupClient");

        ENTITY_MANAGER.registerEntityRenderer();
        //EntityRenderRegistry.register();
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
//}
