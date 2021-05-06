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


public class AstromechDroidEntity extends DroidEntity {


    public AstromechDroidEntity(EntityType<AstromechDroidEntity> type, World worldIn) {
        super(type, worldIn);
    }


    @Override
    protected void registerGoals() {

        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 1.2d));
        this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
    }


    public static class RenderFactory implements IRenderFactory<AstromechDroidEntity> {

        @Override
        public EntityRenderer<? super DroidEntity> createRenderFor(EntityRendererManager manager) {

            return new Renderer(manager,
                    new AstromechDroidModel<>(), "textures/entity/astromech_droid.png");
        }
    }


    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {

        return MonsterEntity.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, AstromechDroidEntity.MAX_HEALTH)
                .add(Attributes.MOVEMENT_SPEED, AstromechDroidEntity.MOVEMENT_SPEED)
                .add(Attributes.ATTACK_DAMAGE, AstromechDroidEntity.ATTACK_DAMAGE);
    }
}