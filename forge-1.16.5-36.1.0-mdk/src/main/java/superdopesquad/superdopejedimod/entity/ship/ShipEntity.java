package superdopesquad.superdopejedimod.entity.ship;


import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import superdopesquad.superdopejedimod.entity.BaseEntity;


public abstract class ShipEntity extends BaseEntity {


//	private Class _renderBaseClass = null;
//	private Class _modelBaseClass = null;


	public ShipEntity(EntityType<? extends ShipEntity> type, World worldIn) {
		super(type, worldIn);
	}


//
//	public ShipEntity(World worldIn, String name, String displayName, Class renderBaseClass, Class modelBaseClass) {
//		this(worldIn, name, displayName, renderBaseClass, modelBaseClass, true);
//	}

//
//	public ShipEntity(World worldIn, String name, String displayName, Class renderBaseClass, Class modelBaseClass,
//                      boolean hasCreativeModeEgg) {
//		super(worldIn, name, displayName, hasCreativeModeEgg);
//
//		this._renderBaseClass = renderBaseClass;
//		this._modelBaseClass = modelBaseClass;
//	}


//	/**
//	 * Called during startup, so the engine knows about our custom rendering (drawing) code.
//	 */
//	@Override // from SuperDopeEntity
//	public void registerEntityRender() {
//
//		if (this._renderBaseClass == null || this._modelBaseClass == null) {
//			System.out.println("Failure in BaseEntityShip:registerEntityRender!  Ran into a null.");
//			return;
//		}
//
//		EntityRenderFactory factory = new EntityRenderFactory(this._renderBaseClass, this._modelBaseClass, this.shadowSize);
//		RenderingRegistry.registerEntityRenderingHandler(this.getClass(), factory);
//	}

	// Make sure that Minecraft doesn't destroy any ships when
	// it does memory cleanup and despawns out-of-sight entities.
	@Override
	public boolean shouldDespawnInPeaceful() {

		return false;
	}


	/**
	 * Called when the mob's health reaches 0. Not currently doing anything, but perhaps in the future
	 * this ship should explode in a firey explosion.
	 */
	@Override // from EntityLivingBase
	public void die(DamageSource cause) {
		 // TODO: Explode!
		// System.out.println("TF (" + vehicleId + "): onDeath");
		super.die(cause);
	}


	/**
	 *  Copied from EntityFlying; do we need this?
	 */
//	@Override // from EntityLivingBase
//	public boolean isOnLadder() {
//		return false;
//	}

//
//	@Override // EntityLivingBase
//	protected void applyEntityAttributes() {
//	   super.applyEntityAttributes();
//
//	    // standard attributes registered to EntityLivingBase
//	   getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50.0D);
//	   getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
//	   getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.8D);
//	   getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(32.0D);
//
//	   // need to register any additional attributes
//	   getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
//	   getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1.0D);
//	}


	/*
	 * PASSENGER STUFF: some of this code could go to a generic vehicle class.
	 */

	/**
	 * NOTE: To dismount, we can:
	 * 	(a) manually call dismountRidingEntity() here in this class.
	 *  (b) If the user hits left-shift, there is code in EntityPlayer::updateRidden() that detects this (isSneaking)
	 *      and calls dismountRidingEntity() for us.
	 */

	// MC_TODO:
//	@Override // from EntityLiving
//	public final ActionResultType processInteract(PlayerEntity player, Hand hand) {
//
//	//public final ActionResultType processInitialInteract(PlayerEntity player, Hand hand) {
//
//
//		if (!this.isBeingRidden()) {
//			player.startRiding(this);
//			this.onGround = false;
//			return true;
//		}
//
//		/* otherwise, let the system handle the interaction. */
//	    return super.pr(player, hand);
//	}


    /**
     * For vehicles, the first passenger is generally considered the controller and "drives" the vehicle. For example,
     * Pigs, Horses, and Boats are generally "steered" by the controlling passenger.
     */
	@Override // from Entity
    @Nullable
    public Entity getControllingPassenger() {
        List<Entity> list = this.getPassengers();
        if (list.isEmpty()) {
        	return null;
        }

        return (Entity) list.get(0);
    }

	@Nullable
    public LivingEntity getControllingLivingPassenger() {
	    Entity driver = getControllingPassenger();
		return (driver instanceof LivingEntity) ? (LivingEntity) driver : null;
    }


	/**
	 * TODO: only empire can drive this thing.
	 */
//	@Override // for Entity
//    public boolean canPassengerSteer() {
//		//public boolean canPassengerSteer() {
//		LivingEntity entity = this.getControllingLivingPassenger();
//        return entity instanceof PlayerEntity ? ((PlayerEntity)entity).isUser() : !this.world.isRemote;
//    }

    /**
     * Returns true if all the conditions for steering the entity are met. For pigs, this is true if it is being ridden
     * by a player and the player is holding a carrot-on-a-stick
     */
//	@Override // EntityLiving
//    public boolean canBeSteered() {
//        return canPassengerSteer();
//    }

	/**
     * If the rider should be dismounted from the entity when the entity goes under water
     *
    // * @param rider The entity that is riding
     * @return if the entity should be dismounted when under water
     */
	// MC-TODO
//	@Override // for Entity
//    public boolean shouldDismountInWater(Entity rider) {
//        return false;
//    }

//	@Override // for Entity
//    protected boolean canFitPassenger(Entity passenger) {
//        return this.getPassengers().size() < 1;
//    }

    /**
     * If a rider of this entity can interact with this entity. Should return true on the
     * ridden entity if so.
     *
     * @return if the entity can be interacted with from a rider
     */
	@Override
    public boolean canRiderInteract() {
        return false;
    }

	/**
	 *  do we need this?
	 */
//	@Override // from Entity
//	public void fall(float distance, float damageMultiplier) {
//    }

	/**
	 * do we need this?
	 */
//	@Override // from Entity
//    protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos) {
//    }


	/**
	 * are we on the ground?
	 */
//	protected boolean detectOnGround() {
//		return !this.world.isAirBlock(this.getPosition().down());
//	}
}
