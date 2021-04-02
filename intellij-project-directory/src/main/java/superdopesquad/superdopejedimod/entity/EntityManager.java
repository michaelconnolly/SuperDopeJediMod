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
import superdopesquad.superdopejedimod.SuperDopeJediMod;


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

	public static final EntityType<JawaEntity> JAWA =
			(EntityType<JawaEntity>) EntityType.Builder.create(JawaEntity::new, EntityClassification.MONSTER)
					.size(0.6F, 1.7F).trackingRange(8).build("jawa")
					.setRegistryName(new ResourceLocation(SuperDopeJediMod.MODID, "jawa"));

	public static final EntityType<StormtrooperEntity> STORMTROOPER =
			(EntityType<StormtrooperEntity>) EntityType.Builder.create(StormtrooperEntity::new, EntityClassification.MONSTER)
					.size(0.6F, 1.7F).trackingRange(8).build("stormtrooper")
					.setRegistryName(new ResourceLocation(SuperDopeJediMod.MODID, "stormtrooper"));


    //public static ImperialProbeDroidEntity imperialProbeDroid = new ImperialProbeDroidEntity(null);

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
	public static final GenericEgg JAWA_EGG = new GenericEgg("jawa_egg", JAWA, Color.pink.hashCode(), Color.white.hashCode());
	public static final GenericEgg STORMTROOPER_EGG = new GenericEgg("stormtrooper_egg", STORMTROOPER, Color.GREEN.hashCode(), Color.white.hashCode());

	// Special eggs that can be used in both creative and survival mode, different from spawn eggs.  More like chicken eggs.
//    public static GenericEgg imperialProbeDroidEgg = new GenericEgg("imperialProbeDroidEgg", ImperialProbeDroidEntity.class);

	public EntityManager() {
	}


	public void registerEntity(RegistryEvent.Register<EntityType<?>> event) {

		event.getRegistry().register(EntityManager.WOOKIE);
		event.getRegistry().register(EntityManager.TUSKEN_RAIDER);
		event.getRegistry().register(EntityManager.JAWA);
		event.getRegistry().register(EntityManager.STORMTROOPER);

	}


	@OnlyIn(Dist.CLIENT)
	public void registerEntityRenderer() {

		RenderingRegistry.registerEntityRenderingHandler(EntityManager.WOOKIE, new WookieEntity.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(EntityManager.TUSKEN_RAIDER, new TuskenRaiderEntity.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(EntityManager.JAWA, new JawaEntity.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(EntityManager.STORMTROOPER, new StormtrooperEntity.RenderFactory());
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

