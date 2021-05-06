package superdopesquad.superdopejedimod.entity.droid;


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


public class AssassinDroidEntity extends DroidEntity {


    public AssassinDroidEntity(EntityType<AssassinDroidEntity> type, World worldIn) {
        super(type, worldIn);
    }


    @Override
    protected void registerGoals() {

        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 1.2d));
        this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
    }


    public static class RenderFactory implements IRenderFactory<AssassinDroidEntity> {

        @Override
        public EntityRenderer<? super DroidEntity> createRenderFor(EntityRendererManager manager) {

            return new Renderer(manager,
                    new AssassinDroidModel<>(), "textures/entity/assassin_droid.png");
        }
    }


    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {

        return MonsterEntity.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, AssassinDroidEntity.MAX_HEALTH)
                .add(Attributes.MOVEMENT_SPEED, (double)AssassinDroidEntity.MOVEMENT_SPEED)
                .add(Attributes.ATTACK_DAMAGE, AssassinDroidEntity.ATTACK_DAMAGE);
    }
}