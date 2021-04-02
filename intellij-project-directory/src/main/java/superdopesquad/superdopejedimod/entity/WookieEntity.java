package superdopesquad.superdopejedimod.entity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.IRenderFactory;


public class WookieEntity extends MonsterEntity { // CreatureEntity {

    public WookieEntity(EntityType<? extends WookieEntity> type, World worldIn) {
        super(type, worldIn);
    }


    @Override
    protected void registerGoals()
    {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 1.2d));
        this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
    }


    public static class RenderFactory implements IRenderFactory<WookieEntity> {

        @Override
        public EntityRenderer<? super WookieEntity> createRenderFor(EntityRendererManager manager) {

            return new Renderer(manager,
                    new WookieModel<>(), "textures/entity/wookie.png");
        }
    }


    public static AttributeModifierMap.MutableAttribute func_234188_eI_() {
        return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 10.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, (double)0.2F);
    }


    // https://forums.minecraftforge.net/topic/87597-1161-custom-entity-attributes/
    // In my entity I made a function like this (you can name the function whatever you want since you are not
    // overriding anything):

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {

      //  return MobEntity.func_233666_p_().func_233815_a_(Attributes.MOVEMENT_SPEED, (double)0.5F).func_233815_a_(Attributes.MAX_HEALTH, 20.0D).func_233815_a_(Attributes.ATTACK_DAMAGE, 5.0D);
        return WookieEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, (double)0.5F)
                .createMutableAttribute(Attributes.MAX_HEALTH, 20.0D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 5.0D);
    }
}



//
//
////public class WookieEntity extends BaseEntityTameable {
//    public class WookieEntity extends CreatureEntity {
//
//    @SuppressWarnings("unchecked")
//    public WookieEntity(EntityType<? extends CreatureEntity> type, World world)
//    {
//        super((EntityType<? extends CreatureEntity>) EntityManager.WOOKIE_ENTITY, world);
//    }
//
////
////        public WookieEntity(World world) {
////
////            super((EntityType<? extends CreatureEntity>) EntityManager.WOOKIE_ENTITY, world);
////        }
//
//        @Override
//        protected void registerGoals() {
//
//            this.goalSelector.addGoal(0, new SwimGoal(this));
//            this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 1.2d));
//            this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
//        }
//
//
//
//    public static AttributeModifierMap.MutableAttribute func_234215_eI_() {
//        return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 10.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D);
//    }
//
//
//    // MC-TO-DO: below was officially registerAttributes() in sample code.
//   @Override
//   protected void registerData() {
//
//       super.registerData();
//
//       //this.getAttribute(CreatureAttributes)
//       //this.getAttribute(CreatureAttribute).setBaseValue(20.0d);
//   }
//    //	public WookieEntity(World worldIn) {
////
////		super(worldIn, "wookieEntity", "Wookie");
////
////		this.setupAI();
////
////		this.setSize(1.0F, 0.5F);
////
////		// how much experience do you get it you kill it?
////		this.experienceValue = 5;
////
////		// Properties that we need to have later.
////		this.shadowSize = 1.0F;
////
////		// Put a iron axe in his mainhand slot.
////		this.setHeldItem(EnumHand.MAIN_HAND, new ItemStack(Items.IRON_AXE));
////	}
//
////
////	@Override
////	public void registerEntityRender() {
////
////		Class renderBaseClass = WookieRender.class;
////		Class modelBaseClass = WookieModel.class;
////		EntityRenderFactory factory = new EntityRenderFactory(renderBaseClass, modelBaseClass, 1.0F);
////		RenderingRegistry.registerEntityRenderingHandler(this.getClass(), factory);
////	}
//
////
////	@Override
////	public void registerRecipe() {
////
////		// Recipe for creating a Wookie Egg.
////		ItemStack arrowStack = new ItemStack(Items.ARROW);
////		ItemStack eggStack = new ItemStack(Items.EGG);
////
////		GameRegistry.addShapedRecipe(new ResourceLocation(this.getFullName()), null, new ItemStack(SuperDopeJediMod.entityManager.wookieEgg, 1),
////						"A",
////						"B",
////						'A', arrowStack,
////						'B', eggStack);
////	}
//
////
////	// set up AI tasks
////	protected void setupAI()
////	{
////	   clearAITasks(); // clear any tasks assigned in super classes
////
////	   // Set up the ClassInfo array that defines who Wookies attack.
////	   //ClassInfo[] classes = new ClassInfo[2];
////	   //classes[0] = SuperDopeJediMod.classManager.getClassInfo(SuperDopeJediMod.classManager.SITH);
////	   //classes[1] = SuperDopeJediMod.classManager.getClassInfo(SuperDopeJediMod.classManager.BOUNTYHUNTER);
////	   FactionInfo factionInfo = SuperDopeJediMod.classManager.getFactionInfo(SuperDopeJediMod.classManager.FACTION_EMPIRE);
////
////	   // Main AI task list.
////	   this.tasks.addTask(1, new EntityAIAttackMeleeFactionAware(this, 1.0, false, factionInfo));
////	   //this.tasks.addTask(1, new EntityAIAttackMeleeClassAware(this, 1.0, false, classes));
////	   // tasks.addTask(5, new EntityAIMate(this, 1.0D)); We don't need these guys mating.
////	   //this.tasks.addTask(7, new EntityAIFollowParent(this, 1.25D));
////	   this.tasks.addTask(8, new EntityAIWander(this, 1.0D));
////
////	   // Set up the targetTasks list, which defines who the entity focuses his actions on.
////	   // Priority 0: attack anything that attacked me.
////	   this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, true));
////	   // Priority 1: attack the nearest player I can find.
////	   this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
////	}
//
////
////	@Override
////	public EntityAgeable createChild(EntityAgeable ageable) {
////		// TODO Auto-generated method stub
////		return null;
////	}
//
////
////	@Override
////	public void generateSurface(World world, Random random, int i, int j) {
////
////		// Because BaseEntityAnimal's will only spawn where there is no light, it means they will only spawn
////		// at night, and away from player homes where they have torches.  The weightedProbability below is
////		// the percentage chance after taking that into account, so it should be a high number.
////
////		//System.out.println("Inside generateSurface for Wookies");
////
////		Class entityClass = WookieEntity.class;
////		int weightedProbability = 10;
////		int minimumSpawnCount = 4;
////		int maximumSpawnCount = 8;
////		EnumCreatureType creatureType = EnumCreatureType.MONSTER;
////
////		// add the spawn information to EntityRegistry through the addSpawn call.
////		EntityRegistry.addSpawn(entityClass, weightedProbability, minimumSpawnCount, maximumSpawnCount, creatureType,
////				Biomes.BEACH,
////				Biomes.BIRCH_FOREST,
////				Biomes.BIRCH_FOREST_HILLS,
////				Biomes.COLD_BEACH,
////				Biomes.COLD_TAIGA,
////				Biomes.COLD_TAIGA_HILLS,
////				Biomes.DESERT,
////				Biomes.DESERT_HILLS,
////				Biomes.EXTREME_HILLS,
////				Biomes.EXTREME_HILLS_EDGE,
////				Biomes.EXTREME_HILLS_WITH_TREES,
////				Biomes.FOREST,
////				Biomes.FOREST_HILLS,
////				Biomes.ICE_MOUNTAINS,
////				Biomes.ICE_PLAINS,
////				Biomes.JUNGLE,
////				Biomes.JUNGLE_EDGE,
////				Biomes.JUNGLE_HILLS,
////				Biomes.MESA,
////				Biomes.MESA_CLEAR_ROCK,
////				Biomes.MESA_ROCK,
////				Biomes.MUSHROOM_ISLAND,
////				Biomes.MUSHROOM_ISLAND_SHORE,
////				Biomes.PLAINS,
////				Biomes.REDWOOD_TAIGA,
////				Biomes.REDWOOD_TAIGA_HILLS,
////				Biomes.ROOFED_FOREST,
////				Biomes.SAVANNA,
////				Biomes.SAVANNA_PLATEAU,
////				Biomes.STONE_BEACH,
////				Biomes.SWAMPLAND,
////				Biomes.TAIGA,
////				Biomes.TAIGA_HILLS);
////	}
//
//
////	@Override
////	protected void applyEntityAttributes() {
////
////	    super.applyEntityAttributes();
////
////	    // standard attributes registered to EntityLivingBase
////	   getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
////	   getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20D);
////	   getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.8D);
////	   getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(16.0D);
////
////	    // need to register any additional attributes
////	   getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
////	   getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
////	}
//
//
////	// After it dies, what equipment should it drop?
////	@Override
////	protected void dropEquipment(boolean wasRecentlyHit, int lootingModifier) {
////
////		this.entityDropItem(new ItemStack(Items.IRON_AXE), 0);
//    }
//}