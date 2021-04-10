package superdopesquad.superdopejedimod.entity.monster;


import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import superdopesquad.superdopejedimod.entity.Renderer;


public class TuskenRaiderEntity extends MonsterEntity  {


    public  TuskenRaiderEntity(EntityType<? extends TuskenRaiderEntity> type, World worldIn){  super(type,worldIn);}


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 1.2d));
        this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
    }


    public static class RenderFactory implements IRenderFactory<TuskenRaiderEntity> {

        @Override
        public EntityRenderer<? super TuskenRaiderEntity> createRenderFor(EntityRendererManager manager) {

            //return new WookieRender(manager);
            return new Renderer(manager,
                    new TuskenRaiderModel<>(), "textures/entity/tusken_raider.png");
        }
    }


    public static AttributeModifierMap.MutableAttribute func_234188_eI_() {
     //   return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 10.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, (double) 0.2F);
        return TuskenRaiderEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 10.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, (double) 0.2F);
    }




    // https://forums.minecraftforge.net/topic/87597-1161-custom-entity-attributes/
    // In my entity I made a function like this (you can name the function whatever you want since you are not
    // overriding anything):

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {

        //  return MobEntity.func_233666_p_().func_233815_a_(Attributes.MOVEMENT_SPEED, (double)0.5F).func_233815_a_(Attributes.MAX_HEALTH, 20.0D).func_233815_a_(Attributes.ATTACK_DAMAGE, 5.0D);
        return TuskenRaiderEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, (double) 0.5F)
                .createMutableAttribute(Attributes.MAX_HEALTH, 20.0D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 5.0D);
    }
}

//
//    public TuskanRaiderEntity(World worldIn) {
//
//		super(worldIn, "tuskanRaiderEntity", "Tuskan Raider");
//
//		this.setupAI();
//
//		// This sets the bounding box size, not the actual model that you see rendered.
//		this.setSize(1.0F, 2.0F);
//
//		// how much experience do you get it you kill it?
//		this.experienceValue = 5;
//
//		// Properties that we need to have later.
//		this.shadowSize = 1.0F;
//
//		// Put a gaffi stick in his mainhand slot.
//		this.setHeldItem(EnumHand.MAIN_HAND, new ItemStack(SuperDopeJediMod.weaponManager.gaffiStick));
//	}
//
//
//	@Override
//	public void registerEntityRender() {
//
//    	//System.out.println("inisde TuskanRaiderEntity:registerEntityRender");
//
//		Class renderBaseClass = TuskanRaiderRender.class;
//		Class modelBaseClass = TuskanRaiderModel.class;
//		EntityRenderFactory factory = new EntityRenderFactory(renderBaseClass, modelBaseClass, this.shadowSize);
//		RenderingRegistry.registerEntityRenderingHandler(this.getClass(), factory);
//	}
//
//
//	@Override
//	public void registerRecipe() {
//
//		// Recipe for creating a TuskanRaider Egg.
//		ItemStack featherStack = new ItemStack(Items.FEATHER);
//		ItemStack eggStack = new ItemStack(Items.EGG);
//
//		GameRegistry.addShapedRecipe(new ResourceLocation(this.getFullName()), null, new ItemStack(SuperDopeJediMod.entityManager.tuskanRaiderEgg, 1),
//						"A",
//						"B",
//						'A', featherStack,
//						'B', eggStack);
//	}
//
//
//	// set up AI tasks
//	protected void setupAI() {
//
//		// clear any tasks assigned in super classes.
//	   clearAITasks();
//
//	   // Main AI task list.
//	   this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.0, false));
//	   // tasks.addTask(5, new EntityAIMate(this, 1.0D)); We don't need these guys mating.
//	   this.tasks.addTask(7, new EntityAIFollowParent(this, 1.25D));
//	   this.tasks.addTask(8, new EntityAIWander(this, 1.0D));
//
//	   // Set up the targetTasks list, which defines who the entity focuses his actions on.
//	   // Priority 0: attack anything that attacked me.
//	   this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, true));
//	   // Priority 1: attack the nearest player I can find.
//	   this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
//	}
//
//
//	@Override
//	public EntityAgeable createChild(EntityAgeable ageable) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	@Override
//	public void generateSurface(World world, Random random, int i, int j) {
//
//		// Because BaseEntityAnimal's will only spawn where there is no light, it means they will only spawn
//		// at night, and away from player homes where they have torches.  The weightedProbability below is
//		// the percentage chance after taking that into account, so it should be a high number.
//
//		Class entityClass = TuskanRaiderEntity.class;
//		int weightedProbability = 100;
//		int minimumSpawnCount = 2;
//		int maximumSpawnCount = 4;
//		EnumCreatureType creatureType = EnumCreatureType.MONSTER;
//
//		// add the spawn information to EntityRegistry through the addSpawn call.
//		EntityRegistry.addSpawn(entityClass, weightedProbability, minimumSpawnCount, maximumSpawnCount, creatureType,
//				Biomes.BEACH,
//				Biomes.BIRCH_FOREST,
//				Biomes.BIRCH_FOREST_HILLS,
//				Biomes.COLD_BEACH,
//				Biomes.COLD_TAIGA,
//				Biomes.COLD_TAIGA_HILLS,
//				Biomes.DESERT,
//				Biomes.DESERT_HILLS,
//				Biomes.EXTREME_HILLS,
//				Biomes.EXTREME_HILLS_EDGE,
//				Biomes.EXTREME_HILLS_WITH_TREES,
//				Biomes.FOREST,
//				Biomes.FOREST_HILLS,
//				Biomes.ICE_MOUNTAINS,
//				Biomes.ICE_PLAINS,
//				Biomes.JUNGLE,
//				Biomes.JUNGLE_EDGE,
//				Biomes.JUNGLE_HILLS,
//				Biomes.MESA,
//				Biomes.MESA_CLEAR_ROCK,
//				Biomes.MESA_ROCK,
//				Biomes.MUSHROOM_ISLAND,
//				Biomes.MUSHROOM_ISLAND_SHORE,
//				Biomes.PLAINS,
//				Biomes.REDWOOD_TAIGA,
//				Biomes.REDWOOD_TAIGA_HILLS,
//				Biomes.ROOFED_FOREST,
//				Biomes.SAVANNA,
//				Biomes.SAVANNA_PLATEAU,
//				Biomes.STONE_BEACH,
//				Biomes.SWAMPLAND,
//				Biomes.TAIGA,
//				Biomes.TAIGA_HILLS);
//	}
//
//
//	@Override
//	protected void applyEntityAttributes() {
//
//	    super.applyEntityAttributes();
//
//	    // standard attributes registered to EntityLivingBase
//	   getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
//	   getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20D);
//	   getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.8D);
//	   getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(16.0D);
//
//	    // need to register any additional attributes
//	   getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
//	   getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
//	}
//
//
//	// After it dies, what equipment should it drop?
//	@Override
//	protected void dropEquipment(boolean wasRecentlyHit, int lootingModifier) {
//
//		this.entityDropItem(new ItemStack(SuperDopeJediMod.weaponManager.gaffiStick), 0);
//    }
//}