package superdopesquad.superdopejedimod.entity.droid;


import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.World;
import superdopesquad.superdopejedimod.armor.DopeArmor;
import superdopesquad.superdopejedimod.entity.DopeEntity;


public abstract class DroidEntity extends DopeEntity {

    protected static double MAX_HEALTH = 16.0D;
    protected static double MOVEMENT_SPEED = 0.3D;
    protected static double ATTACK_DAMAGE = 5.0D;


    public DroidEntity(EntityType<? extends DroidEntity> type, World worldIn) {
        super(type, worldIn);
    }


//    public static AttributeModifierMap.MutableAttribute createAttributes() {
//        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, MAX_HEALTH).add(Attributes.MOVEMENT_SPEED, MOVEMENT_SPEED);
//    }

}
