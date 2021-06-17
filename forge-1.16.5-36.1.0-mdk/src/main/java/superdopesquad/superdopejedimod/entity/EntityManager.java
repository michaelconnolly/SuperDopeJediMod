package superdopesquad.superdopejedimod.entity;

import java.awt.*;
import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.spi.LoggerRegistry;
import superdopesquad.superdopejedimod.DopeItem;
import superdopesquad.superdopejedimod.SuperDopeJediMod;
import superdopesquad.superdopejedimod.entity.droid.*;
import superdopesquad.superdopejedimod.entity.critter.JawaEntity;
import superdopesquad.superdopejedimod.entity.critter.StormtrooperEntity;
import superdopesquad.superdopejedimod.entity.critter.TuskenRaiderEntity;
import superdopesquad.superdopejedimod.entity.critter.WookieEntity;
import superdopesquad.superdopejedimod.entity.ship.ShipEngine;
import superdopesquad.superdopejedimod.entity.ship.ShipKit;
import superdopesquad.superdopejedimod.entity.ship.TieFighterEntity;
import superdopesquad.superdopejedimod.entity.ship.XWingFighterEntity;
import superdopesquad.superdopejedimod.weapon.PlasmaShotEntity;


public class EntityManager {

	private static final Logger LOGGER = LogManager.getLogger();
	public static ArrayList<EntityType<? extends Entity>> EntityTypes = new ArrayList<>();


	// Entities.
	public static final EntityType<TuskenRaiderEntity> TUSKEN_RAIDER = DopeEntity.createEntity(TuskenRaiderEntity::new,
					"tusken_raider", EntityClassification.MONSTER);

	public static final EntityType<WookieEntity> WOOKIE = DopeEntity.createEntity(WookieEntity::new,
					"wookie", EntityClassification.MONSTER);

	public static final EntityType<JawaEntity> JAWA = DopeEntity.createEntity(JawaEntity::new, "jawa", EntityClassification.MONSTER);

	public static final EntityType<StormtrooperEntity> STORMTROOPER = DopeEntity.createEntity(StormtrooperEntity::new,
					"stormtrooper", EntityClassification.MONSTER);

	public static final EntityType<ProtocolDroidEntity> PROTOCOL_DROID = DopeEntity.createEntity(ProtocolDroidEntity::new,
					"protocol_droid", EntityClassification.MONSTER);

	public static final EntityType<ProbeDroidEntity> PROBE_DROID = DopeEntity.createEntity(ProbeDroidEntity::new,
					"probe_droid", EntityClassification.MONSTER);

	public static final EntityType<AssassinDroidEntity> ASSASSIN_DROID = DopeEntity.createEntity(AssassinDroidEntity::new,
					"assassin_droid", EntityClassification.MONSTER);

	public static final EntityType<AstromechDroidEntity> ASTROMECH_DROID = DopeEntity.createEntity(AstromechDroidEntity::new,
					"astromech_droid", EntityClassification.MONSTER);

	public static final EntityType<XWingFighterEntity> XWING_FIGHTER = DopeEntity.createEntity(XWingFighterEntity::new,
					"xwing_fighter", EntityClassification.MISC);

	public static final EntityType<TieFighterEntity> TIE_FIGHTER = DopeEntity.createEntity(TieFighterEntity::new,
					"tie_fighter", EntityClassification.MISC);

//	public static final EntityType<PlasmaShotEntity> PLASMA_SHOT =
//			(EntityType<PlasmaShotEntity>) EntityManager.createEntity2(PlasmaShotEntity::new,
//					"plasma_shot", EntityClassification.MISC);


		// Droid Kit objects.
    public static final DopeItem DROID_PARTS = new DopeItem("droid_parts");
    public static final DroidKit DROID_KIT = new DroidKit("droid_kit");
	public static final DroidHead PROTOCOL_DROID_HEAD = new DroidHead("protocol_droid_head", PROTOCOL_DROID);
	public static final DroidHead ASTROMECH_DROID_HEAD = new DroidHead("astromech_droid_head", ASTROMECH_DROID);
	public static final DroidHead ASSASSIN_DROID_HEAD = new DroidHead("assassin_droid_head", ASSASSIN_DROID);
	public static final DroidHead PROBE_DROID_HEAD = new DroidHead("probe_droid_head", PROBE_DROID);

	// Ship Kit objects.
	public static final DopeItem SHIP_PARTS = new DopeItem("ship_parts");
	public static final ShipKit SHIP_KIT = new ShipKit("ship_kit");
	public static final ShipEngine XWING_FIGHTER_ENGINE = new ShipEngine("xwing_fighter_engine", XWING_FIGHTER);
	public static final ShipEngine TIE_FIGHTER_ENGINE = new ShipEngine("tie_fighter_engine", TIE_FIGHTER);

//    public static ShuttleEntity shuttle = new ShuttleEntity(null);
//    public static ImperialShuttleEntity imperialShuttle = new ImperialShuttleEntity(null);


	// Eggs for monsters.
	public static final DopeEgg WOOKIE_EGG = new DopeEgg("wookie_egg", WOOKIE, Color.blue.hashCode(), Color.white.hashCode());
	public static final DopeEgg TUSKEN_RAIDER_EGG = new DopeEgg("tusken_raider_egg", TUSKEN_RAIDER, Color.red.hashCode(), Color.white.hashCode());
	public static final DopeEgg JAWA_EGG = new DopeEgg("jawa_egg", JAWA, Color.pink.hashCode(), Color.white.hashCode());
	public static final DopeEgg STORMTROOPER_EGG = new DopeEgg("stormtrooper_egg", STORMTROOPER, Color.GREEN.hashCode(), Color.white.hashCode());



	public interface IFactory<T extends Entity> extends EntityType.IFactory<T> {
		T create(EntityType<T> p_create_1_, World p_create_2_);
	}
//
//	public static <T extends Entity> EntityType.Builder<T> create(EntityType.IFactory<T> factoryIn, EntityClassification classificationIn) {
//		return new EntityType.Builder<>(factoryIn, classificationIn);
//	}
//
//	private Builder(EntityType.IFactory<T> factoryIn, EntityClassification classificationIn) {
////		this.factory = factoryIn;
////		this.classification = classificationIn;
////		this.field_225436_f = classificationIn == EntityClassification.CREATURE || classificationIn == EntityClassification.MISC;
//	}



//
//	private static <T> EntityType<XWingFighterEntity> createEntity2(EntityType.IFactory<T> factoryIn, EntityClassification classificationIn) {
//
//		EntityType<XWingFighterEntity> entity =
//				(EntityType<XWingFighterEntity>) EntityType.Builder.create(XWingFighterEntity::new, EntityClassification.MISC)
//						.size(0.6F, 1.7F).trackingRange(8).build("xwing_fighter")
//						.setRegistryName(new ResourceLocation(SuperDopeJediMod.MODID, "xwing_fighter"));
//
//
//		return entity;
//	}
//
//	private static <T extends ProjectileItemEntity> EntityType<? extends ProjectileItemEntity> createEntity2(EntityManager.IFactory<T> factory,
//																										 String name, EntityClassification classification) {
//		EntityType<? extends Entity> entity =
//				EntityType.Builder.of(factory, classification)
//						.sized(0.6F, 1.7F).setTrackingRange(8).build(name)
//						.setRegistryName(new ResourceLocation(SuperDopeJediMod.MODID, name));
//
//		return (EntityType<? extends ProjectileItemEntity>) entity;
//	}

//
//	public <T extends DopeEntity> void catalogEntity(Class<T> dopeEntity) {
//
//		dopeEntity.setCustomAttributes();
//
//		Alert alert = clazzAlert.newInstance();
//		//use the alert object as you want/need...
//	}

//
//	private static Class<DopeEntity> addEntity3(Class<DopeEntity> entityClass) {
//
//		EntityManager.Entities2.add(entityClass);
//
//		return entityClass;

//		// I'm getting a warning when using our private namespace for registering these entities.
//		// Switching to use 'minecraft', although i bet some bug crops up in this area at some point.
//		String namespace = "minecraft"; //  MC: I feel like this should be: SuperDopeJediMod.MODID;
//
//		// Create the entity.
//		EntityType<? extends Entity> entity = EntityType.Builder.of(factory, classification)
//				.sized(0.6F, 1.7F).setTrackingRange(8).build(name)
//				.setRegistryName(new ResourceLocation(namespace, name));
//
//		// Add this to our list, since we will have to do stuff to it.
//		EntityManager.Entities.add(entity);
//
//		return entity;
//	}



//
//	public static <T extends Entity> EntityType<? extends Entity> createEntity(EntityManager.IFactory<T> factory,
//				String name, EntityClassification classification) {
//
//		// I'm getting a warning when using our private namespace for registering these entities.
//		// Switching to use 'minecraft', although i bet some bug crops up in this area at some point.
//		String namespace = "minecraft"; //  MC: I feel like this should be: SuperDopeJediMod.MODID;
//
//		// Create the entity.
//		EntityType<? extends Entity> entity = EntityType.Builder.of(factory, classification)
//						.sized(0.6F, 1.7F).setTrackingRange(8).build(name)
//						.setRegistryName(new ResourceLocation(namespace, name));
//
//		// Add this to our list, since we will have to do stuff to it.
//		EntityManager.Entities.add(entity);
//
//		return entity;
//	}


	public void registerEntity(RegistryEvent.Register<EntityType<?>> event) {

		LOGGER.debug("EntityManager::registerEntity ...");

		for (int i=0; i<EntityManager.EntityTypes.size(); i++) {
			event.getRegistry().register(EntityManager.EntityTypes.get(i));
		}
	}


	@OnlyIn(Dist.CLIENT)
	public void registerEntityRenderer() {

		LOGGER.debug("EntityManager::registerEntityRenderer");

//		Class<? extends DopeEntity> entityClass = EntityManager.WOOKIE.

		RenderingRegistry.registerEntityRenderingHandler(EntityManager.WOOKIE, new WookieEntity.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(EntityManager.TUSKEN_RAIDER, new TuskenRaiderEntity.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(EntityManager.JAWA, new JawaEntity.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(EntityManager.STORMTROOPER, new StormtrooperEntity.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(EntityManager.PROTOCOL_DROID, new ProtocolDroidEntity.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(EntityManager.PROBE_DROID, new ProbeDroidEntity.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(EntityManager.ASSASSIN_DROID, new AssassinDroidEntity.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(EntityManager.ASTROMECH_DROID, new AstromechDroidEntity.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(EntityManager.XWING_FIGHTER, new XWingFighterEntity.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(EntityManager.TIE_FIGHTER, new TieFighterEntity.RenderFactory());
		//RenderingRegistry.registerEntityRenderingHandler(EntityManager.PLASMA_SHOT, new PlasmaShotEntity.RenderFactory());

	}


	public void createAttributes(EntityAttributeCreationEvent event) {

		event.put(EntityManager.PROTOCOL_DROID, ProtocolDroidEntity.setCustomAttributes().build());
		event.put(EntityManager.PROBE_DROID, ProbeDroidEntity.setCustomAttributes().build());
		event.put(EntityManager.ASSASSIN_DROID, AssassinDroidEntity.setCustomAttributes().build());
		event.put(EntityManager.ASTROMECH_DROID, AstromechDroidEntity.setCustomAttributes().build());
		event.put(EntityManager.JAWA, JawaEntity.setCustomAttributes().build());
		event.put(EntityManager.STORMTROOPER, StormtrooperEntity.setCustomAttributes().build());
		event.put(EntityManager.TUSKEN_RAIDER, TuskenRaiderEntity.setCustomAttributes().build());
		event.put(EntityManager.WOOKIE, WookieEntity.setCustomAttributes().build());
		event.put(EntityManager.TIE_FIGHTER, TieFighterEntity.setCustomAttributes().build());
		event.put(EntityManager.XWING_FIGHTER, XWingFighterEntity.setCustomAttributes().build());
		//event.put(EntityManager.PLASMA_SHOT, PlasmaShotEntity.setCustomAttributes().build());
	}


//	public void setupCommon() {
//
//		LOGGER.debug("EntityManager::setupCommon ...");
//
//		GlobalEntityTypeAttributes.put(EntityManager.PROTOCOL_DROID, ProtocolDroidEntity.setCustomAttributes().build());
//		GlobalEntityTypeAttributes.put(EntityManager.PROBE_DROID, ProbeDroidEntity.setCustomAttributes().build());
//		GlobalEntityTypeAttributes.put(EntityManager.ASSASSIN_DROID, AssassinDroidEntity.setCustomAttributes().build());
//		GlobalEntityTypeAttributes.put(EntityManager.ASTROMECH_DROID, AstromechDroidEntity.setCustomAttributes().build());
//		//GlobalEntityTypeAttributes.put(EntityManager.JAWA, JawaEntity.setCustomAttributes().build());
//		GlobalEntityTypeAttributes.put(EntityManager.STORMTROOPER, StormtrooperEntity.setCustomAttributes().build());
//		GlobalEntityTypeAttributes.put(EntityManager.TUSKEN_RAIDER, TuskenRaiderEntity.setCustomAttributes().build());
//		GlobalEntityTypeAttributes.put(EntityManager.WOOKIE, WookieEntity.setCustomAttributes().build());
//		GlobalEntityTypeAttributes.put(EntityManager.TIE_FIGHTER, TieFighterEntity.setCustomAttributes().build());
//		GlobalEntityTypeAttributes.put(EntityManager.XWING_FIGHTER, XWingFighterEntity.setCustomAttributes().build());
//		//GlobalEntityTypeAttributes.put(EntityManager.PLASMA_SHOT, PlasmaShotEntity.setCustomAttributes().build());
//
////		GlobalEntityTypeAttributes.getSupplier(EntityManager.JAWA);
////		//JawaEntity.setCustomAttributes().build();
////		StormtrooperEntity.setCustomAttributes().build();
////		TuskenRaiderEntity.setCustomAttributes().build();
////		WookieEntity.setCustomAttributes().build();
//	}


	public static void registerEntityWorldSpawns() {

		// MC-TO-DO: below doesn't compile for some reason.
		//registerEntityWorldSpawn(WOOKIE_ENTITY, EntityClassification.CREATURE, Biomes.FOREST, Biomes.JUNGLE);
	}


	public static void registerEntityWorldSpawn(EntityType<?> entity, EntityClassification classification, Biome... biomes) {

		for (Biome biome : biomes) {
			if (biome != null) {
				//biome.ge
				//

				//biome.getSpawns(classification).add(new SpawnListEntry(entity, 10, 0, 10));
				//biome.getMobSpawnInfo().getSpawners(classification).add(new SpawnListEntry(entity, 10, 0, 10));
				//biome.getMobSpawnInfo().getSpawners(classification).add(new MobSpawnInfo.Spawners(entity, 10, 0, 10));

				biome.getMobSettings().getMobs(classification).add(new MobSpawnInfo.Spawners(entity, 10, 0, 10));

			}
		}
	}


	public void initCape() {

		//super.init(e);

		System.out.println("EntityManager::initCape");

//		// Iterate through all our custom objects, and see if we have any models to render.
//		for (SuperDopeObject superDopeObject : SuperDopeJediMod.customObjects) {
//			superDopeObject.registerModel();
//		}

		// Should classes come with capes?  I think so!
		// For now, also including the more experimental ClassIndictor.

		// This sets our additional layers on the "default" player model, also known as Steve.
//		RenderPlayer renderPlayerDefault = Minecraft.getMinecraft().getRenderManager().getSkinMap().get("default");
//		//renderPlayerDefault.addLayer(new LayerClassIndicator(renderPlayerDefault));
//		renderPlayerDefault.addLayer(new LayerClassCape(renderPlayerDefault));
		PlayerRenderer renderPlayerDefault = Minecraft.getInstance().getEntityRenderDispatcher().getSkinMap().get("default");
		//renderPlayerDefault.addLayer(new LayerClassCape(renderPlayerDefault));


		// This sets our additional layers on the "slim" player model, also known as Alex.
		PlayerRenderer renderPlayerSlim = Minecraft.getInstance().getEntityRenderDispatcher().getSkinMap().get("slim");
		//renderPlayerSlim.addLayer(new LayerClassIndicator(renderPlayerSlim));
		//renderPlayerSlim.addLayer(new LayerClassCape(renderPlayerSlim));
	}

//	public static final EntityType<ChickenEntity> CHICKEN = register("chicken",
//			EntityType.Builder.<ChickenEntity>of(ChickenEntity::new,
//					EntityClassification.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10));
//
//
//
//	private static <T extends Entity> EntityType<T> register(String p_200712_0_, EntityType.Builder<T> p_200712_1_) {
//		return Registry.register(Registry.ENTITY_TYPE, p_200712_0_, p_200712_1_.build(p_200712_0_));
//	}

}

