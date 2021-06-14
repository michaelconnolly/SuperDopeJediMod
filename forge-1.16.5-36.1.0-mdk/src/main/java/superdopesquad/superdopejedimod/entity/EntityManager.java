package superdopesquad.superdopejedimod.entity;

import java.awt.*;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
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
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
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

	// Entities.
	public static final EntityType<TuskenRaiderEntity> TUSKEN_RAIDER =
			(EntityType<TuskenRaiderEntity>) EntityManager.createEntity(TuskenRaiderEntity::new,
					"tusken_raider", EntityClassification.MONSTER);

	public static final EntityType<WookieEntity> WOOKIE =
			(EntityType<WookieEntity>) EntityManager.createEntity(WookieEntity::new,
					"wookie", EntityClassification.MONSTER);

	public static final EntityType<JawaEntity> JAWA =
			(EntityType<JawaEntity>) EntityManager.createEntity(JawaEntity::new,
					"jawa", EntityClassification.MONSTER);

	public static final EntityType<StormtrooperEntity> STORMTROOPER =
			(EntityType<StormtrooperEntity>) EntityManager.createEntity(StormtrooperEntity::new,
					"stormtrooper", EntityClassification.MONSTER);

	public static final EntityType<ProtocolDroidEntity> PROTOCOL_DROID =
			(EntityType<ProtocolDroidEntity>) EntityManager.createEntity(ProtocolDroidEntity::new,
					"protocol_droid", EntityClassification.MONSTER);

	public static final EntityType<ProbeDroidEntity> PROBE_DROID =
			(EntityType<ProbeDroidEntity>) EntityManager.createEntity(ProbeDroidEntity::new,
					"probe_droid", EntityClassification.MONSTER);

	public static final EntityType<AssassinDroidEntity> ASSASSIN_DROID =
			(EntityType<AssassinDroidEntity>) EntityManager.createEntity(AssassinDroidEntity::new,
					"assassin_droid", EntityClassification.MONSTER);

	public static final EntityType<AstromechDroidEntity> ASTROMECH_DROID =
			(EntityType<AstromechDroidEntity>) EntityManager.createEntity(AstromechDroidEntity::new,
					"astromech_droid", EntityClassification.MONSTER);

	public static final EntityType<XWingFighterEntity> XWING_FIGHTER =
			(EntityType<XWingFighterEntity>) EntityManager.createEntity(XWingFighterEntity::new,
					"xwing_fighter", EntityClassification.MISC);

	public static final EntityType<TieFighterEntity> TIE_FIGHTER =
			(EntityType<TieFighterEntity>) EntityManager.createEntity(TieFighterEntity::new,
					"tie_fighter", EntityClassification.MISC);

	public static final EntityType<PlasmaShotEntity> PLASMA_SHOT =
			(EntityType<PlasmaShotEntity>) EntityManager.createEntity2(PlasmaShotEntity::new,
					"plasma_shot", EntityClassification.MISC);



//	public static final EntityType<SnowballEntity> SNOWBALL = register("snowball", EntityType.Builder.<SnowballEntity>of(SnowballEntity::new, EntityClassification.MISC).sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10));

//	private static <T extends Entity> EntityType<T> register(String p_200712_0_, EntityType.Builder<T> p_200712_1_) {
//		return Registry.register(Registry.ENTITY_TYPE, p_200712_0_, p_200712_1_.build(p_200712_0_));
//	}
//

//	public static final EntityType<PlasmaShotEntity> PLASMA_SHOT =
//			Registry.register(Registry.ENTITY_TYPE,
//			"plasma_shot",
//			EntityType.Builder.<PlasmaShotEntity>of(PlasmaShotEntity::new,
//					EntityClassification.MISC).sized(0.25F, 0.25F)
////					.clientTrackingRange(4).updateInterval(10).build("plasma_shot"));
//	public static final RegistryObject<EntityType<PlasmaShotEntity>> PLASMA_SHOT =
//			SuperDopeJediMod.ENTITIES.register(
//					"plasma_shot",
//					() -> EntityType.Builder.<PlasmaShotEntity>of(PlasmaShotEntity::new,
//							EntityClassification.MISC).sized(0.25F, 0.25F)
//							.clientTrackingRange(4).updateInterval(10).build("plasma_shot"));


	// Projectile Entity Types
//	public static final RegistryObject<EntityType<PlasmaShotEntity>> PLASMA_SHOT = SuperDopeJediMod.ENTITIES.register("plasma_shot",
//			() -> EntityType.Builder.of(PlasmaShotEntity::new, EntityClassification.MISC)
//					.size(1.0f,0.5f)
//					.build(new ResourceLocation(SuperDopeJediMod.MODID, "plasma_shot").toString())
//	);
//	public static final RegistryObject<EntityType<PlasmaShotEntity>> CRAWLER_VENOM =
//	SuperDopeJediMod.ENTITIES.register("crawler_venom",
//			() -> EntityType.Builder.<PlasmaShotEntity> <----- create(CrawlerVenomEntity::new, EntityClassification.MISC)
//					.size(1.0f,0.5f)
//					.build(new ResourceLocation(MajCraft.MOD_ID, "crawler_venom").toString())
//	);


//	public static final EntityType<PlasmaShotEntity> PLASMA_SHOT =
//			(EntityType<PlasmaShotEntity>) EntityManager.createEntity(PlasmaShotEntity::new,
//					"plasma_shot", EntityClassification.MISC);

	//public static final EntityType<SnowballEntity> SNOWBALL = register("snowball", EntityType.Builder.<SnowballEntity>of(SnowballEntity::new, EntityClassification.MISC).sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10));
//	public static final EntityType<PlasmaShotEntity> PLASMA_SHOT = register("plasma_shot", EntityType.Builder.<PlasmaShotEntity>of(PlasmaShotEntity::new, EntityClassification.MISC).sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10));
//
//	private static <T extends Entity> EntityType<T> register(String p_200712_0_, EntityType.Builder<T> p_200712_1_) {
//		return Registry.register(Registry.ENTITY_TYPE, p_200712_0_, p_200712_1_.build(p_200712_0_));
//	}


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


//
//
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

	private static <T extends ProjectileItemEntity> EntityType<? extends ProjectileItemEntity> createEntity2(EntityManager.IFactory<T> factory,
																										 String name, EntityClassification classification) {

		EntityType<? extends Entity> entity =
				EntityType.Builder.of(factory, classification)
						.sized(0.6F, 1.7F).setTrackingRange(8).build(name)
						.setRegistryName(new ResourceLocation(SuperDopeJediMod.MODID, name));

		return (EntityType<? extends ProjectileItemEntity>) entity;
	}




	private static <T extends Entity> EntityType<? extends Entity> createEntity(EntityManager.IFactory<T> factory,
				String name, EntityClassification classification) {

		EntityType<? extends Entity> entity =
				EntityType.Builder.of(factory, classification)
						.sized(0.6F, 1.7F).setTrackingRange(8).build(name)
						.setRegistryName(new ResourceLocation(SuperDopeJediMod.MODID, name));

		return entity;
	}



	public EntityManager() {
	}


	public void registerEntity(RegistryEvent.Register<EntityType<?>> event) {

		event.getRegistry().register(EntityManager.WOOKIE);
		event.getRegistry().register(EntityManager.TUSKEN_RAIDER);
		event.getRegistry().register(EntityManager.JAWA);
		event.getRegistry().register(EntityManager.STORMTROOPER);
		event.getRegistry().register(EntityManager.PROTOCOL_DROID);
		event.getRegistry().register(EntityManager.PROBE_DROID);
		event.getRegistry().register(EntityManager.ASSASSIN_DROID);
		event.getRegistry().register(EntityManager.ASTROMECH_DROID);
		event.getRegistry().register(EntityManager.XWING_FIGHTER);
		event.getRegistry().register(EntityManager.TIE_FIGHTER);
		event.getRegistry().register(EntityManager.PLASMA_SHOT);

//		//
//		SuperDopeJediMod.BLOCKS.register(name, () -> this);
//		//
//		public static final EntityType<SnowballEntity> SNOWBALL = register("snowball", EntityType.Builder.<SnowballEntity>of(SnowballEntity::new, EntityClassification.MISC).sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10));
////
//
//		EntityType<SnowballEntity> SNOWBALL_TEST = Registry.register(Registry.ENTITY_TYPE,
//				"snowball_test",
//				EntityType.Builder.<SnowballEntity>of(SnowballEntity::new,
//						EntityClassification.MISC).sized(0.25F, 0.25F)
//						.clientTrackingRange(4).updateInterval(10).build("snowball_test"));
//
//		EntityType<PlasmaShotEntity> PLASMA_SHOT_TEST = Registry.register(Registry.ENTITY_TYPE,
//				"plasma_shot_test",
//				EntityType.Builder.<PlasmaShotEntity>of(PlasmaShotEntity::new,
//						EntityClassification.MISC).sized(0.25F, 0.25F)
//						.clientTrackingRange(4).updateInterval(10).build("snowball_test"));
//
//
//
//		EntityType.Builder.<SnowballEntity>of(SnowballEntity::new,
//						EntityClassification.MISC).sized(0.25F, 0.25F)
//						.clientTrackingRange(4).updateInterval(10);
//
//
//
//		//
//
//		private static <T extends Entity> EntityType<T> register(String p_200712_0_,
//				EntityType.Builder<T> p_200712_1_) {
//			return Registry.register(Registry.ENTITY_TYPE, p_200712_0_, p_200712_1_.build(p_200712_0_));
//		}
//
//		SuperDopeJediMod.ENTITIES.register("plasma_shot_test",
//				)


	}


	@OnlyIn(Dist.CLIENT)
	public void registerEntityRenderer() {

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


	public void setupCommon() {

		GlobalEntityTypeAttributes.put(EntityManager.PROTOCOL_DROID, ProtocolDroidEntity.setCustomAttributes().build());
		GlobalEntityTypeAttributes.put(EntityManager.PROBE_DROID, ProbeDroidEntity.setCustomAttributes().build());
		GlobalEntityTypeAttributes.put(EntityManager.ASSASSIN_DROID, AssassinDroidEntity.setCustomAttributes().build());
		GlobalEntityTypeAttributes.put(EntityManager.ASTROMECH_DROID, AstromechDroidEntity.setCustomAttributes().build());
		GlobalEntityTypeAttributes.put(EntityManager.JAWA, JawaEntity.setCustomAttributes().build());
		GlobalEntityTypeAttributes.put(EntityManager.STORMTROOPER, StormtrooperEntity.setCustomAttributes().build());
		GlobalEntityTypeAttributes.put(EntityManager.TUSKEN_RAIDER, TuskenRaiderEntity.setCustomAttributes().build());
		GlobalEntityTypeAttributes.put(EntityManager.WOOKIE, WookieEntity.setCustomAttributes().build());
		GlobalEntityTypeAttributes.put(EntityManager.TIE_FIGHTER, TieFighterEntity.setCustomAttributes().build());
		GlobalEntityTypeAttributes.put(EntityManager.XWING_FIGHTER, XWingFighterEntity.setCustomAttributes().build());
		//GlobalEntityTypeAttributes.put(EntityManager.PLASMA_SHOT, PlasmaShotEntity.setCustomAttributes().build());

//		GlobalEntityTypeAttributes.getSupplier(EntityManager.JAWA);
//		//JawaEntity.setCustomAttributes().build();
//		StormtrooperEntity.setCustomAttributes().build();
//		TuskenRaiderEntity.setCustomAttributes().build();
//		WookieEntity.setCustomAttributes().build();
	}


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
}

