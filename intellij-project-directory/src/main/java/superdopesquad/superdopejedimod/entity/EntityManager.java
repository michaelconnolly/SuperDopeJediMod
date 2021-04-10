package superdopesquad.superdopejedimod.entity;


import java.awt.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import superdopesquad.superdopejedimod.BaseBlock;
import superdopesquad.superdopejedimod.BaseItem;
import superdopesquad.superdopejedimod.SuperDopeJediMod;
import superdopesquad.superdopejedimod.entity.droid.*;
import superdopesquad.superdopejedimod.entity.monster.JawaEntity;
import superdopesquad.superdopejedimod.entity.monster.StormtrooperEntity;
import superdopesquad.superdopejedimod.entity.monster.TuskenRaiderEntity;
import superdopesquad.superdopejedimod.entity.monster.WookieEntity;


public class EntityManager {

	// Entities.

	public static final EntityType<TuskenRaiderEntity> TUSKEN_RAIDER =
			(EntityType<TuskenRaiderEntity>) EntityType.Builder.create(TuskenRaiderEntity::new, EntityClassification.MONSTER)
					.build("tusken_raider")
					.setRegistryName(new ResourceLocation(SuperDopeJediMod.MODID, "tusken_raider"));

	public static final EntityType<WookieEntity> WOOKIE =
		(EntityType<WookieEntity>) EntityType.Builder.create(WookieEntity::new, EntityClassification.MONSTER)
				.size(0.6F, 1.7F).trackingRange(8).build("wookie")
				.setRegistryName(new ResourceLocation(SuperDopeJediMod.MODID, "wookie"));

	public static final EntityType<JawaEntity> JAWA =
			(EntityType<JawaEntity>) EntityType.Builder.create(JawaEntity::new, EntityClassification.MONSTER)
					.size(0.6F, 1.7F).trackingRange(8).build("jawa")
					.setRegistryName(new ResourceLocation(SuperDopeJediMod.MODID, "jawa"));

	public static final EntityType<StormtrooperEntity> STORMTROOPER =
			(EntityType<StormtrooperEntity>) EntityType.Builder.create(StormtrooperEntity::new, EntityClassification.MONSTER)
					.size(0.6F, 1.7F).trackingRange(8).build("stormtrooper")
					.setRegistryName(new ResourceLocation(SuperDopeJediMod.MODID, "stormtrooper"));

	public static final EntityType<ProtocolDroidEntity> PROTOCOL_DROID =
			(EntityType<ProtocolDroidEntity>) EntityType.Builder.create(ProtocolDroidEntity::new, EntityClassification.MONSTER)
					.size(0.6F, 1.7F).trackingRange(8).build("protocol_droid")
					.setRegistryName(new ResourceLocation(SuperDopeJediMod.MODID, "protocol_droid"));

	public static final EntityType<ProbeDroidEntity> PROBE_DROID =
			(EntityType<ProbeDroidEntity>) EntityType.Builder.create(ProbeDroidEntity::new, EntityClassification.MONSTER)
					.size(0.6F, 1.7F).trackingRange(8).build("probe_droid")
					.setRegistryName(new ResourceLocation(SuperDopeJediMod.MODID, "probe_droid"));

	public static final EntityType<AssassinDroidEntity> ASSASSIN_DROID =
			(EntityType<AssassinDroidEntity>) EntityType.Builder.create(AssassinDroidEntity::new, EntityClassification.MONSTER)
					.size(0.6F, 1.7F).trackingRange(8).build("assassin_droid")
					.setRegistryName(new ResourceLocation(SuperDopeJediMod.MODID, "assassin_droid"));

	public static final EntityType<AstromechDroidEntity> ASTROMECH_DROID =
			(EntityType<AstromechDroidEntity>) EntityType.Builder.create(AstromechDroidEntity::new, EntityClassification.MONSTER)
					.size(0.6F, 1.7F).trackingRange(8).build("astromech_droid")
					.setRegistryName(new ResourceLocation(SuperDopeJediMod.MODID, "astromech_droid"));

	// Ships!
//    public static TieFighterEntity tieFighter = new TieFighterEntity(null);
//    public static XWingFighterEntity xWingFighter = new XWingFighterEntity(null);
//    public static ShuttleEntity shuttle = new ShuttleEntity(null);
//    public static ImperialShuttleEntity imperialShuttle = new ImperialShuttleEntity(null);

	// Droid kit objects.
    public static final BaseItem DROID_PARTS = new BaseItem("droid_parts");
    public static final BaseBlock DROID_KIT = new DroidKit("droid_kit");
	public static final DroidHead PROTOCOL_DROID_HEAD = new DroidHead("protocol_droid_head", PROTOCOL_DROID);
	public static final DroidHead ASTROMECH_DROID_HEAD = new DroidHead("astromech_droid_head", ASTROMECH_DROID);
	public static final DroidHead ASSASSIN_DROID_HEAD = new DroidHead("assassin_droid_head", ASSASSIN_DROID);
	public static final DroidHead PROBE_DROID_HEAD = new DroidHead("probe_droid_head", PROBE_DROID);

	// Eggs for monsters.
	public static final GenericEgg WOOKIE_EGG = new GenericEgg("wookie_egg", WOOKIE, Color.blue.hashCode(), Color.white.hashCode());
	public static final GenericEgg TUSKEN_RAIDER_EGG = new GenericEgg("tusken_raider_egg", TUSKEN_RAIDER, Color.red.hashCode(), Color.white.hashCode());
	public static final GenericEgg JAWA_EGG = new GenericEgg("jawa_egg", JAWA, Color.pink.hashCode(), Color.white.hashCode());
	public static final GenericEgg STORMTROOPER_EGG = new GenericEgg("stormtrooper_egg", STORMTROOPER, Color.GREEN.hashCode(), Color.white.hashCode());


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

