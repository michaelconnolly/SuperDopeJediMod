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
import superdopesquad.superdopejedimod.entity.Renderer;


public class ProtocolDroidEntity extends DroidEntity {

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
        public EntityRenderer<? super DroidEntity> createRenderFor(EntityRendererManager manager) {

            return new Renderer(manager,
                    new ProtocolDroidModel<>(), "textures/entity/protocol_droid.png");
        }
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {

        return MonsterEntity.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, ProtocolDroidEntity.MAX_HEALTH)
                .add(Attributes.MOVEMENT_SPEED, ProtocolDroidEntity.MAX_HEALTH)
                .add(Attributes.ATTACK_DAMAGE, ProtocolDroidEntity.ATTACK_DAMAGE);
    }
}