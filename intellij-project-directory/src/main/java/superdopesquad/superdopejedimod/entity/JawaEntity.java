package superdopesquad.superdopejedimod.entity;//package superdopesquad.superdopejedimod.entity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;


@OnlyIn(Dist.CLIENT)
public class JawaEntity extends MonsterEntity {

    protected JawaEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static class RenderFactory implements IRenderFactory<JawaEntity> {

        @Override
        public EntityRenderer<? super JawaEntity> createRenderFor(EntityRendererManager manager) {

            //return new WookieRender(manager);
            return new Renderer(manager,
                    new JawaModel<>(), "textures/entity/jawa.png");
        }
    }


    public static AttributeModifierMap.MutableAttribute func_234188_eI_() {
        //   return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 10.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, (double) 0.2F);
        return JawaEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 10.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, (double) 0.2F);
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
//public class JawaEntity extends BaseEntityAnimal {
//
//
//	public JawaEntity(World worldIn) {
//
//		super(worldIn, "jawaEntity", "Jawa");
//
//		this.setupAI();
//
//		// This sets the bounding box size, not the actual model that you see rendered.
//		this.setSize(0.7F, 1.4F);
//
//		// how much experience do you get it you kill it?
//		this.experienceValue = 5;
//
//		// Properties that we need to have later.
//		this.shadowSize = 0.5F;
//
//		// Put a gaffi stick in his mainhand slot.
//		//this.setHeldItem(EnumHand.MAIN_HAND, new ItemStack(SuperDopeJediMod.gaffiStick));
//	}
//
//
//	@Override
//	public void registerEntityRender() {
//
//		Class renderBaseClass = JawaRender.class;
//		Class modelBaseClass = JawaModel.class;
//		EntityRenderFactory factory = new EntityRenderFactory(renderBaseClass, modelBaseClass, this.shadowSize);
//		RenderingRegistry.registerEntityRenderingHandler(this.getClass(), factory);
//	}
//
//
//	@Override
//	public void registerRecipe() {
//
//		// Recipe for creating a Jawa Egg.
//		ItemStack carrotStack = new ItemStack(Items.CARROT);
//		ItemStack eggStack = new ItemStack(Items.EGG);
//
//		GameRegistry.addShapedRecipe(new ResourceLocation(this.getFullName()), null, new ItemStack(SuperDopeJediMod.entityManager.jawaEgg, 1),
//						"A",
//						"B",
//						'A', carrotStack,
//						'B', eggStack);
//	}
//
//
//	// set up AI tasks
//	protected void setupAI()
//	{
//	   clearAITasks(); // clear any tasks assigned in super classes
//
//
//	   // Main AI task list.
//	   this.tasks.addTask(0, new EntityAISwimming(this)); // I think this prevents drowning.
//	   // this.tasks.addTask(1, new EntityAIAttackMelee(this, 0.5, false));
//	   // this.tasks.addTask(5, new EntityAIMate(this, 1.0D)); // We don't need these guys mating.
//	   this.tasks.addTask(7, new EntityAIFollowParent(this, 1.25D));
//	   this.tasks.addTask(8, new EntityAIWander(this, 1.0D));
//	   this.tasks.addTask(9, new EntityAIWatchClosest2(this, EntityPlayer.class, 6.0F, 0.02F));
//
//	   // Set up the targetTasks list, which defines who the entity focuses his actions on.
//	   // Priority 0: attack anything that attacked me.
//	   this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, true));
//	   // Priority 1: attack the nearest player I can find.
//	   //this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
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
//		Class entityClass = JawaEntity.class;
//		int weightedProbability = 100;
//		int minimumSpawnCount = 4;
//		int maximumSpawnCount = 8;
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
//		this.entityDropItem(new ItemStack(Items.LEATHER), 0);
//		this.entityDropItem(new ItemStack(SuperDopeJediMod.entityManager.droidParts), 0);
//	}
//}