package superdopesquad.superdopejedimod.entity;

import java.awt.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import superdopesquad.superdopejedimod.BaseItem;
import superdopesquad.superdopejedimod.SuperDopeJediMod;
import superdopesquad.superdopejedimod.entity.droid.*;
import superdopesquad.superdopejedimod.entity.monster.JawaEntity;
import superdopesquad.superdopejedimod.entity.monster.StormtrooperEntity;
import superdopesquad.superdopejedimod.entity.monster.TuskenRaiderEntity;
import superdopesquad.superdopejedimod.entity.monster.WookieEntity;
import superdopesquad.superdopejedimod.entity.ship.ShipEngine;
import superdopesquad.superdopejedimod.entity.ship.ShipKit;
import superdopesquad.superdopejedimod.entity.ship.TieFighterEntity;
import superdopesquad.superdopejedimod.entity.ship.XWingFighterEntity;


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


	// Droid Kit objects.
    public static final BaseItem DROID_PARTS = new BaseItem("droid_parts");
    public static final DroidKit DROID_KIT = new DroidKit("droid_kit");
	public static final DroidHead PROTOCOL_DROID_HEAD = new DroidHead("protocol_droid_head", PROTOCOL_DROID);
	public static final DroidHead ASTROMECH_DROID_HEAD = new DroidHead("astromech_droid_head", ASTROMECH_DROID);
	public static final DroidHead ASSASSIN_DROID_HEAD = new DroidHead("assassin_droid_head", ASSASSIN_DROID);
	public static final DroidHead PROBE_DROID_HEAD = new DroidHead("probe_droid_head", PROBE_DROID);

	// Ship Kit objects.
	public static final BaseItem SHIP_PARTS = new BaseItem("ship_parts");
	public static final ShipKit SHIP_KIT = new ShipKit("ship_kit");
	public static final ShipEngine XWING_FIGHTER_ENGINE = new ShipEngine("xwing_fighter_engine", XWING_FIGHTER);
	public static final ShipEngine TIE_FIGHTER_ENGINE = new ShipEngine("tie_fighter_engine", TIE_FIGHTER);

//    public static ShuttleEntity shuttle = new ShuttleEntity(null);
//    public static ImperialShuttleEntity imperialShuttle = new ImperialShuttleEntity(null);


	// Eggs for monsters.
	public static final GenericEgg WOOKIE_EGG = new GenericEgg("wookie_egg", WOOKIE, Color.blue.hashCode(), Color.white.hashCode());
	public static final GenericEgg TUSKEN_RAIDER_EGG = new GenericEgg("tusken_raider_egg", TUSKEN_RAIDER, Color.red.hashCode(), Color.white.hashCode());
	public static final GenericEgg JAWA_EGG = new GenericEgg("jawa_egg", JAWA, Color.pink.hashCode(), Color.white.hashCode());
	public static final GenericEgg STORMTROOPER_EGG = new GenericEgg("stormtrooper_egg", STORMTROOPER, Color.GREEN.hashCode(), Color.white.hashCode());


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


	private static <T extends Entity> EntityType<? extends Entity> createEntity(EntityManager.IFactory<T> factory,
				String name, EntityClassification classification) {

		EntityType<? extends Entity> entity =
				EntityType.Builder.create(factory, classification)
						.size(0.6F, 1.7F).trackingRange(8).build(name)
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

	}


	public void setupCommon() {

		// https://forums.minecraftforge.net/topic/87597-1161-custom-entity-attributes/
		// In my main class in the setup function I had a deferredWorkQueue where I dealt
		// with the function above like this:
		DeferredWorkQueue.runLater(() -> {

			GlobalEntityTypeAttributes.put(EntityManager.WOOKIE, WookieEntity.setCustomAttributes().create());
			GlobalEntityTypeAttributes.put(EntityManager.TUSKEN_RAIDER, TuskenRaiderEntity.setCustomAttributes().create());
			GlobalEntityTypeAttributes.put(EntityManager.JAWA, JawaEntity.setCustomAttributes().create());
			GlobalEntityTypeAttributes.put(EntityManager.STORMTROOPER, StormtrooperEntity.setCustomAttributes().create());
			GlobalEntityTypeAttributes.put(EntityManager.PROTOCOL_DROID, ProtocolDroidEntity.setCustomAttributes().create());
			GlobalEntityTypeAttributes.put(EntityManager.PROBE_DROID, ProbeDroidEntity.setCustomAttributes().create());
			GlobalEntityTypeAttributes.put(EntityManager.ASSASSIN_DROID, AssassinDroidEntity.setCustomAttributes().create());
			GlobalEntityTypeAttributes.put(EntityManager.ASTROMECH_DROID, AstromechDroidEntity.setCustomAttributes().create());
			GlobalEntityTypeAttributes.put(EntityManager.XWING_FIGHTER, XWingFighterEntity.setCustomAttributes().create());
			GlobalEntityTypeAttributes.put(EntityManager.TIE_FIGHTER, TieFighterEntity.setCustomAttributes().create());

		});
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
				biome.getMobSpawnInfo().getSpawners(classification).add(new MobSpawnInfo.Spawners(entity, 10, 0, 10));

			}
		}
	}
}

