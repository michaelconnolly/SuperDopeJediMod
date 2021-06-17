package superdopesquad.superdopejedimod.entity;


import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.World;
import superdopesquad.superdopejedimod.entity.droid.AssassinDroidEntity;


public abstract class DopeEntity extends MonsterEntity {

    protected static double MAX_HEALTH = 16.0D;
    protected static double MOVEMENT_SPEED = 0.3D;


    public DopeEntity(EntityType<? extends DopeEntity> type, World worldIn) {
        super(type, worldIn);
    }


//    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
//
//        return MonsterEntity.createMonsterAttributes()
//                .add(Attributes.MAX_HEALTH, AssassinDroidEntity.MAX_HEALTH)
//                .add(Attributes.MOVEMENT_SPEED, (double)AssassinDroidEntity.MOVEMENT_SPEED)
//                .add(Attributes.ATTACK_DAMAGE, AssassinDroidEntity.ATTACK_DAMAGE);
//    }
}
