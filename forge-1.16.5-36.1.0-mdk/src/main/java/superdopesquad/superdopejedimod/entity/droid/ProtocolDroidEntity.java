package superdopesquad.superdopejedimod.entity.droid;


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
import superdopesquad.superdopejedimod.entity.BaseEntity;
import superdopesquad.superdopejedimod.entity.Renderer;


public class ProtocolDroidEntity extends BaseEntity {

    public ProtocolDroidEntity(EntityType<ProtocolDroidEntity> type, World worldIn) {
        super(type, worldIn);
    }


    @Override
    protected void registerGoals() {

        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 1.2d));
        this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
    }


    public static class RenderFactory implements IRenderFactory<ProtocolDroidEntity> {

        @Override
        public EntityRenderer<? super BaseEntity> createRenderFor(EntityRendererManager manager) {

            return new Renderer(manager,
                    new ProtocolDroidModel<>(), "textures/entity/protocol_droid.png");
        }
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {

        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, 16.0D).add(Attributes.MOVEMENT_SPEED, (double)0.3F);
    }

//
//    public static AttributeModifierMap.MutableAttribute func_234188_eI_() {
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