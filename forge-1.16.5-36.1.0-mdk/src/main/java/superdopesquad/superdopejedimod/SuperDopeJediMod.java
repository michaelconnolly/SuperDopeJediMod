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
    private final int TICK_CHECK_COUNT =20;

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


@SubscribeEvent
public void attachCapability(AttachCapabilitiesEvent<Entity> event) {

    Entity entity = event.getObject();

    if (entity == null) {
        LOGGER.debug("inside attachCapability: event.getObject() == NULL");
        return;
    }

    ITextComponent name;
    if (entity instanceof PlayerEntity) {
        //name = ((PlayerEntity)entity).getName();
        name = new StringTextComponent("(a player)");
    } else if (entity instanceof LivingEntity) {
        name = entity.getName();
    } else {
        name = entity.getName();
    }

//    if(entity instanceof LivingEntity) {
//
//        if ()
//        = ((LivingEntity)event.getObject()).getDisplayName();


    if (entity instanceof PlayerEntity) {
        LOGGER.debug(("inside attachCapability: " + name.getString()));
        final ClassCapability classCapability = new ClassCapability((LivingEntity) event.getObject());
        event.addCapability(new ResourceLocation(SuperDopeJediMod.MODID), ClassManager.createProvider(classCapability));
    } else {
        //LOGGER.debug("inside attachCapability (NOT ATTACHING): " + name.getString());
    }
}

//
//    @SubscribeEvent
//    public static void attachCapabilities(AttachCapabilitiesEvent<Entity> event) {
//
//      LOGGER.debug("inside attachCapabilities: " + event.getObject().getScoreboardName());
//
//        if (event.getObject() == null)
//            return;
//
//
//        if (event.getObject() instanceof LivingEntity) {
//            final ClassCapability classCapability = new ClassCapability((LivingEntity) event.getObject());
//            event.addCapability(new ResourceLocation(SuperDopeJediMod.MODID), ClassManager.createProvider(classCapability));
//        }
//    }

//
//
//    public void onArmourWear(Equip e) {
//        if (hasSpecial(e.getPlayer(), e.getType(), e.getNewArmor())) {
//            // add effect
//        } else {
//            //  remove effect
//        }
//    }

    @SubscribeEvent
    public void registerCommands(final RegisterCommandsEvent event) {


        System.out.println("inside SuperDopeJediMod:registerCommands");

        //ArgumentTypes.register("research", ResearchArgument.class, new ArgumentSerializer<>(ResearchArgument::research));
        //CommandClass.register(event.getDispatcher());
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


//    private void armorSetCheck(PlayerEntity player) {
//
//        Iterable<ItemStack> armorSlots = player.getArmorSlots();
//
//        ItemStack chest = player.getItemBySlot(EquipmentSlotType.CHEST);
//        //LOGGER.debug("Chest: " + (chest == null ? "null" : chest.getDisplayName().getString()));
//
//        this.armorItemCheck(player, chest);
//        //ItemStack boots =armorSlots.
//
//    }
//
//
//    private void armorItemCheck(PlayerEntity player, ItemStack armorItemStack) {
//
//        // If there is nothing in the slot, return.
//        if (armorItemStack == null) return;
//
//        // If the armor is not a child of DopeArmor, return.
//        Item armorItem = armorItemStack.getItem();
//        if (!(armorItem instanceof DopeArmor)) return;
//
//        // If they can use it, return.
//        //if (((DopeArmor)armorItem).canUse(player)) return;
//
//        //LOGGER.debug("Made it here.");
//        //armorItemStack.getItem().canEquip()
//
//        //player.drop(armorItemStack, false);
//        player.getItemBySlot(EquipmentSlotType.CHEST).onDroppedByPlayer(player);
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

        // We are on the server side; when the player logs in, if they are wearing illegal armor, say something.
        ArmorManager.armorSetCheck(player);
    }

//
//    @SubscribeEvent
//    public void onPlayerLogsIn2(final PlayerEvent.A) {
//
//        String entityName = event.getEntity().getName().getString();
//        System.out.println("Inside PlayerEvent.PlayerLoggedInEvent: " + entityName);
//
//    }



    @SubscribeEvent
    public void onPlayerDoesSomething(final PlayerEvent.ItemPickupEvent event) {

        String entityName = event.getEntity().getName().getString();
        System.out.println("Inside PlayerEvent.ItemPickupEvent: " + entityName);

    }



    private void setupCommon(final FMLCommonSetupEvent event) {

        System.out.println("INSIDE SuperDopeJediMod::setupCommon");

        ENTITY_MANAGER.setupCommon();
        CLASS_MANAGER.register();

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
