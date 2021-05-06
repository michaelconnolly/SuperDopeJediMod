package superdopesquad.superdopejedimod.entity;


import net.minecraft.entity.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.World;


public abstract class DopeEntity extends MonsterEntity {

    protected static double MAX_HEALTH = 16.0D;
    protected static double MOVEMENT_SPEED = 0.3D;


    public DopeEntity(EntityType<? extends DopeEntity> type, World worldIn) {
        super(type, worldIn);
    }
}
