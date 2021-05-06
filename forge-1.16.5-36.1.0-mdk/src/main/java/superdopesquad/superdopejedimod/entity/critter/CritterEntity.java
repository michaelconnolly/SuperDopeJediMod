package superdopesquad.superdopejedimod.entity.critter;


import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.World;


public abstract class CritterEntity extends MonsterEntity {

    protected static double MAX_HEALTH = 16.0D;
    protected static double MOVEMENT_SPEED = 0.3D;
    protected static double ATTACK_DAMAGE = 5.0D;


    public CritterEntity(EntityType<? extends CritterEntity> type, World worldIn) {
        super(type, worldIn);
    }


//    public static AttributeModifierMap.MutableAttribute createAttributes() {
//        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, MAX_HEALTH).add(Attributes.MOVEMENT_SPEED, MOVEMENT_SPEED);
//    }

}
