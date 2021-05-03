package superdopesquad.superdopejedimod.entity;


import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.World;


public abstract class BaseEntity extends MonsterEntity {

    protected static double MAX_HEALTH = 16.0D;
    protected static double MOVEMENT_SPEED = 0.3D;




    public BaseEntity(EntityType<? extends BaseEntity> type, World worldIn) {
        super(type, worldIn);
    }

//
//    @Override
//    protected void registerGoals()
//    {
//        this.goalSelector.addGoal(0, new SwimGoal(this));
//        this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 1.2d));
//        this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
//    }


//    public static class RenderFactory implements IRenderFactory<DroidEntity> {
//
//        @Override
//        public EntityRenderer<? super DroidEntity> createRenderFor(EntityRendererManager manager) {
//
//            return new Renderer(manager,
//                    new ProtocolDroidModel<>(), "textures/entity/protocol_droid.png");
//        }
//    }



    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, MAX_HEALTH).add(Attributes.MOVEMENT_SPEED, MOVEMENT_SPEED);
    }

//
//    public static AttributeModifierMap.MutableAttribute createAttributes() {
//        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, 16.0D).add(Attributes.MOVEMENT_SPEED, (double)0.3F);
//    }
//
//    public static AttributeModifierMap.MutableAttribute func_234188_eI_() {
//
//        return
//
//        return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 10.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, (double)0.2F);
//    }


    // https://forums.minecraftforge.net/topic/87597-1161-custom-entity-attributes/
    // In my entity I made a function like this (you can name the function whatever you want since you are not
    // overriding anything):
//
//    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
//
//        //  return MobEntity.func_233666_p_().func_233815_a_(Attributes.MOVEMENT_SPEED, (double)0.5F).func_233815_a_(Attributes.MAX_HEALTH, 20.0D).func_233815_a_(Attributes.ATTACK_DAMAGE, 5.0D);
//        return DroidEntity.func_233666_p_()
//                .createMutableAttribute(Attributes.MOVEMENT_SPEED, (double)0.5F)
//                .createMutableAttribute(Attributes.MAX_HEALTH, 20.0D)
//                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 5.0D);
//    }
}
