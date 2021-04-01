package superdopesquad.superdopejedimod.entity;


import java.awt.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

//import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.block.Block;
import net.minecraft.entity.*;
//import net.minecraft.entity.EntityLivingBase;
//import net.minecraft.init.Items;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import org.apache.commons.codec.binary.Hex;
import superdopesquad.superdopejedimod.SuperDopeJediMod;
import superdopesquad.superdopejedimod.material.MaterialManager;


public class EntityManager {


	// Entities.
	// MC-TO-DO: the first parameter should be a World instance (Minecraft.getMinecraft.theWorld), but i'm concerned
	// that this will crash on the server side.  Putting in null doesn't seem to have a harmful effect.  I need to
	// figure out later the downside of not having it, and if i need it, figure out the best way to get a handle
	// for it that is server-safe.
	//private static int _startEntityId = 300;

	// MC: Snakes were our first example entity we used to learn how to make entities work.  They are not within the spirit
	// of the Star Wars world here, so i should probably comment them out.  Future coders should think this through.

	// Entities.

	public static final EntityType<TuskenRaiderEntity> TUSKEN_RAIDER =
			(EntityType<TuskenRaiderEntity>) EntityType.Builder.create(TuskenRaiderEntity::new, EntityClassification.MONSTER)
					.build("tusken_raider")
					.setRegistryName(new ResourceLocation(SuperDopeJediMod.MODID, "tusken_raider"));

	public static final EntityType<WookieEntity> WOOKIE =
		(EntityType<WookieEntity>) EntityType.Builder.create(WookieEntity::new, EntityClassification.MONSTER)
				.size(0.6F, 1.7F).trackingRange(8).build("wookie")
				.setRegistryName(new ResourceLocation(SuperDopeJediMod.MODID, "wookie"));


//	private static <T extends Entity> EntityType<T> register(String key, EntityType.Builder<T> builder) {
//	//	return Registry.register(Registry.ENTITY_TYPE, key, builder.build(key));
//		//return Registry
//		return SuperDopeJediMod.ENTITIES.register(key, builder);
//		//return Registry.register(SuperDopeJediMod.ENTITIES, key, builder.build(key));
//
//		return Registry.
//	}


//Registry.register(Registry.ENTITY_TYPE, key, builder.build(key));


//	public static final EntityType<WookieEntity> WOOKIE =
//			SuperDopeJediMod.ENTITIES.register("wookie",
//					() -> EntityType.Builder.<WookieEntity>create(WookieEntity::new, EntityClassification.MONSTER))
//					.build(SuperDopeJediMod.MODID + ":wookie")
//					.setRegistryName(new ResourceLocation(SuperDopeJediMod.MODID, "wookie"));

//	ENTITIE
//
//	register("wookie", EntityType.Builder.create(CreeperEntity::new, EntityClassification.MONSTER)
//					.size(0.6F, 1.7F).trackingRange(8));
//
//
//
//	//.ITEMS.register(name, () -> this);
//
//	public static final EntityType<CreeperEntity> CREEPER =
//			register("creeper", EntityType.Builder.<CreeperEntity>create(CreeperEntity::new, EntityClassification.MONSTER)
//					.size(0.6F, 1.7F).trackingRange(8));
//
//	private static <T extends Entity> EntityType<T> register(String key, EntityType.Builder<T> builder) {
//		return Registry.register(Registry.ENTITY_TYPE, key, builder.build(key));
//	}




//	public static EntityType<?> WOOKIE_ENTITY = EntityType.Builder.create(WookieEntity::new, EntityClassification.MONSTER)
//			.build(SuperDopeJediMod.MODID + ":wookie_entity")
//			.setRegistryName(new ResourceLocation(SuperDopeJediMod.MODID, "wookie_entity"));

//
//	public static EntityType<? extends CreatureEntity> TUSKEN_RAIDER_ENTITY =
//			(EntityType<? extends CreatureEntity>) EntityType.Builder.create(TuskenRaiderEntity::new, EntityClassification.CREATURE)
//			.build(SuperDopeJediMod.MODID + ":tusken_raider_entity")
//			.setRegistryName(new ResourceLocation(SuperDopeJediMod.MODID, "tusken_raider_entity"));


//	private EntityType<?> RegisterEntityType(EntityType<? extends CreatureEntity> type, String name) {
//
//		return EntityType.Builder.create(t::new, EntityClassification.CREATURE)
//				.build(SuperDopeJediMod.MODID + ":" + name)
//				.setRegistryName(new ResourceLocation(SuperDopeJediMod.MODID, name));
//	}



//    public static SnakeEntity snake = new SnakeEntity(null);
//    public static TuskanRaiderEntity tuskanRaider = new TuskanRaiderEntity(null);
//    public static JawaEntity jawa = new JawaEntity(null);
//    public static final WookieEntity WOOKIE_ENTITY = new WookieEntity(null);
//    //public static ImperialProbeDroidEntity imperialProbeDroid = new ImperialProbeDroidEntity(null);
	//public static StormTrooperEntity stormTrooper = new StormTrooperEntity(null);

	// Ships!
//    public static TieFighterEntity tieFighter = new TieFighterEntity(null);
//    public static XWingFighterEntity xWingFighter = new XWingFighterEntity(null);
//    public static ShuttleEntity shuttle = new ShuttleEntity(null);
//    public static ImperialShuttleEntity imperialShuttle = new ImperialShuttleEntity(null);
//
	// Republic Utility Droid objects.
//    public static DroidParts droidParts = new DroidParts("droidParts");
//    public static DroidKit droidKit = new DroidKit("droidKit");
////    public static RepublicHunterDroidHead republicHunterDroidHead = new RepublicHunterDroidHead("republicHunterDroidHead");
//    public static RepublicPatrolDroidHead republicPatrolDroidHead = new RepublicPatrolDroidHead("republicPatrolDroidHead");
//    public static RepublicSentryDroidHead republicSentryDroidHead = new RepublicSentryDroidHead("republicSentryDroidHead");
//    public static RepublicHunterDroidEntity republicHunterDroid = new RepublicHunterDroidEntity(null);
//    public static RepublicPatrolDroidEntity republicPatrolDroid = new RepublicPatrolDroidEntity(null);
//    public static RepublicSentryDroidEntity republicSentryDroid = new RepublicSentryDroidEntity(null);
//


	// MC-TO-DO: this egg is working, but the texture for the egg is wrong.  I need to figure out how to use the
	// colors we input as the way to draw the egg.  In the meantime, i am registered this egg like a nomrmal item,
	// and putting in the model json file and texture file, and instead of the texture being greenish, like my
	// texture file, it's coming out pitch black.  Not sure.
	// Watch this video: https://www.youtube.com/watch?v=IAwTCVl9Z4U

	//public static final GenericEgg WOOKIE_EGG = new GenericEgg("wookie_egg", EntityType.PIG, Color.blue.hashCode(), Color.white.hashCode());
	public static final GenericEgg WOOKIE_EGG = new GenericEgg("wookie_egg", WOOKIE, Color.blue.hashCode(), Color.white.hashCode());
	public static final GenericEgg TUSKEN_RAIDER_EGG = new GenericEgg("tusken_raider_egg", TUSKEN_RAIDER, Color.red.hashCode(), Color.white.hashCode());

	// Special eggs that can be used in both creative and survival mode, different from spawn eggs.  More like chicken eggs.
//    public static GenericEgg snakeEgg = new GenericEgg("snakeEgg", SnakeEntity.class);
//    public static GenericEgg tuskanRaiderEgg = new GenericEgg("tuskanRaiderEgg", TuskanRaiderEntity.class);
//    public static GenericEgg jawaEgg = new GenericEgg("jawaEgg", JawaEntity.class);
	// public static GenericEgg wookieEgg = new GenericEgg("wookieEgg", WookieEntity.class);
//    public static GenericEgg imperialProbeDroidEgg = new GenericEgg("imperialProbeDroidEgg", ImperialProbeDroidEntity.class);
//    public static GenericEgg stormTrooperEgg = new GenericEgg("stormTrooperEgg", StormTrooperEntity.class);

//	private static <T extends Entity> EntityType<T> register(String key, EntityType.Builder<T> builder) {
//
//		return Registry.register(Registry.ENTITY_TYPE, key, builder.build(key));
//	}

//	public static final EntityType<WookieEntity> WOOKIE_ENTITY =
//			register("wookie", EntityType.Builder.<WookieEntity>create(WookieEntity::new, EntityClassification.MONSTER)
//					.size(0.6F, 1.95F).trackingRange(8));
//	public static EntityType<?> WOOKIE_ENTITY = EntityType.Builder.create(WookieEntity::new, EntityClassification.MONSTER)
//			.build(SuperDopeJediMod.MODID + ":wookie_entity")
//			.setRegistryName(new ResourceLocation(SuperDopeJediMod.MODID, "wookie_entity"));




	public EntityManager() {
	}


	public void registerEntity(RegistryEvent.Register<EntityType<?>> event) {

		event.getRegistry().register(EntityManager.WOOKIE);
		event.getRegistry().register(EntityManager.TUSKEN_RAIDER);
	}


	@OnlyIn(Dist.CLIENT)
	public void registerEntityRenderer() {

		RenderingRegistry.registerEntityRenderingHandler((EntityType<WookieEntity>) EntityManager.WOOKIE, new WookieRender.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler((EntityType<TuskenRaiderEntity>) EntityManager.TUSKEN_RAIDER, new TuskenRaiderRender.RenderFactory());
	}



	public void setupCommon() {



		// https://forums.minecraftforge.net/topic/87597-1161-custom-entity-attributes/
		// In my main class in the setup function I had a deferredWorkQueue where I dealt
		// with the function above like this:
		DeferredWorkQueue.runLater(() -> {

			// GlobalEntityTypeAttributes.put(MyEntities.myCustomEntity, CrewmanEntity.setCustomAttributes().func_233813_a_());
			//GlobalEntityTypeAttributes.put((EntityType<? extends LivingEntity>) EntityManager.WOOKIE, WookieEntity.setCustomAttributes().create());



			GlobalEntityTypeAttributes.put((EntityType<? extends LivingEntity>) WOOKIE, WookieEntity.setCustomAttributes().create());
			GlobalEntityTypeAttributes.put((EntityType<? extends LivingEntity>) EntityManager.TUSKEN_RAIDER, TuskenRaiderEntity.setCustomAttributes().create());


		});

	}

//
//	//public int getUniqueEntityId() {
//		return this._startEntityId++;
//	}


//    public  void registerEntitySpawnEgg(String name, EntityType<?> entity, int color1, int color2) {
//
//		SpawnEggItem egg = new SpawnEggItem(entity, color1, color2, new Item.Properties().group(ItemGroup.MATERIALS));
//
//		//super(entityType, color1, color2, new Item.Properties().group(ItemGroup.MATERIALS));
//
//		egg.setRegistryName(name);
//
//		SuperDopeJediMod.ITEMS.register(name, () -> this);
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
				biome.getMobSpawnInfo().getSpawners(classification).add(new MobSpawnInfo.Spawners(entity, 10, 0, 10));

			}
		}
	}

//    public void Spawn(final BiomeLoadingEvent event) {
//
//        if (!(event.getCategory().equals(Biome.Category.NETHER) || event.getCategory().equals(Biome.Category.THEEND))) {
//
//
////            MaterialManager.BESKAR_ORE.GenerateOre(event);
////            MaterialManager.QUADANIUM_ORE.GenerateOre(event);
////            MaterialManager.PLASTOID_SCRAPS.GenerateOre(event);
////            MaterialManager.KYBER_CRYSTAL_ORE.GenerateOre(event);
//        }
//    }


//
//    //public static EntityLivingBase createEntity(Class classToMake, World world, BlockPos blockPos) {
//    public static Entity createEntity(Class classToMake, World world, BlockPos blockPos) {
//
//    	// Now, on to the Render object;
//    	// Create an array that defines the type for each parameter.  That is how we
//    	// query for the constructor (we get back the one that matches the parameters we request).
//    	Class parameterTypes[] = new Class[1];
//    	parameterTypes[0] = World.class;
//
//    	// OK, let's query for that render constructor.
//    	Constructor constructor = EntityManager.getConstructor(classToMake, parameterTypes);
//    	if (constructor == null) {
//    		return null;
//    	}
//
//    	// OK, now we create an array that stores the actual parameter values for the render constructor.
//    	Object parameterValues[] = new Object[1];
//    	parameterValues[0] = world;
//
//    	// Last step, let's call the constructor with the array of parameter values.
//    	Object instance = EntityManager.newInstance(constructor, parameterValues);
//    	if (instance == null) {
//    		System.out.println("ERROR! createEntity() failed to create an object.");
//    		return null;
//    	}
//    	//if (!(instance instanceof EntityLivingBase)) {
//    	if (!(instance instanceof Entity)) {
//    	   	    		System.out.println("ERROR! createEntity() created unexpected object.");
//    		return null;
//    	}
//
//    	//EntityLivingBase entity = (EntityLivingBase) instance;
//    	Entity entity = (Entity) instance;
//
//    	// Set the proper location of the entity.
//    	if (blockPos != null) {
//    		double x = blockPos.getX() + 0.5;
//    		double y = blockPos.getY();
//    		double z = blockPos.getZ() + 0.5;
//    		entity.setLocationAndAngles(x, y, z, 0.0F, 0.0F);
//    	}
//    	else {
//    		System.out.println("ERROR: handed null blockPos in EntityManager:createEntity(..)");
//    	}
//
//		// Actually spawn the entity into the world.
//		//world.spawnEntity(entity);
//    	world.addEntity(entity);
//
//		// OK, let's return what we got.
//    	return entity;
//    }


//    public static Constructor getConstructor(Class classToMake, Class parameterTypes[]) {
//
//    	// Let's query for that constructor.
//    	Constructor constructor = null;
//		try {
//			constructor = classToMake.getConstructor(parameterTypes);
//		} catch (NoSuchMethodException e) {
//			System.out.println("EntityManager: sent in a bogus class: " + classToMake.getName());
//			return null;
//		} catch (SecurityException e) {
//			System.out.println("EntityManager: weird security issue.  Bailing.");
//			return null;
//		}
//
//		return constructor;
//    }


//    public static Object newInstance(Constructor constructor, Object parameterValues[]) {
//
//    	// Let's call the constructor with the array of parameter values.
//    	Object newObject = null;
//
//		try {
//			newObject = constructor.newInstance(parameterValues);
//		}
//		catch (InstantiationException e1) {
//				System.out.println("EntityManager: weird instantiation issue.  Bailing.");
//				return null;
//		} catch (IllegalAccessException e1) {
//				System.out.println("EntityManager: weird access issue.  Bailing.");
//				return null;
//		} catch (IllegalArgumentException e1) {
//				System.out.println("EntityManager: weird argument issue.  Bailing.");
//				return null;
//		} catch (InvocationTargetException e1) {
//				System.out.println("EntityManager: weird target issue.  Bailing.");
//				return null;
//		}
//
//		return newObject;
//    }
}

