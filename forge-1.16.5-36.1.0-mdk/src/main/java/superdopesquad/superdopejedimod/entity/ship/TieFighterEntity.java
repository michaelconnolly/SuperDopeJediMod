package superdopesquad.superdopejedimod.entity.ship;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import superdopesquad.superdopejedimod.entity.Renderer;
import superdopesquad.superdopejedimod.entity.critter.JawaEntity;

import javax.rmi.CORBA.Tie;

/**
 * No AI: only moves when there is a passenger.
 */
public class TieFighterEntity extends ShipEntity {

	// Constants
	private static final float DEGREES2RADIANS = 0.017453292F;
	private static final int DROP_DELAY = 2000;

	// Global Class Members
	private static int s_vehicleId = 0;

	// Instance Members.
	protected int vehicleId; 		// unique id; not guaranteed to be the same between saves. todo: move to base class
	protected boolean everBoarded;  // todo: move to base class
	protected boolean parked;		// todo: move to base class
	protected boolean dismountAnalyzed;
	protected boolean spinDrop;
	protected double spinDropBeginTime;
	protected float spinDropRotationIncrement;


    public TieFighterEntity(EntityType<TieFighterEntity> type, World worldIn) {

        super(type, worldIn);

        // This sets the bounding box size, not the actual model that you see rendered.
        //this.setSiz(0.6F, 2.0F);

        // how much experience do you get it you kill it?
        //this.experienceValue = 1;

        // Properties that we need to have later.
//		this.shadowSize = 0.5F;
//		this.sha

        // prevent motiony degrade
        this.setNoGravity(true);
    }



    public static class RenderFactory implements IRenderFactory<TieFighterEntity> {

        @Override
        public EntityRenderer<? super ShipEntity> createRenderFor(EntityRendererManager manager) {

            return new Renderer(manager,
                    new TieFighterModel<>(), "textures/entity/xwing_fighter.png");
        }
    }


	public static AttributeModifierMap.MutableAttribute setCustomAttributes() {

		return MonsterEntity.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, TieFighterEntity.MAX_HEALTH)
				.add(Attributes.MOVEMENT_SPEED, TieFighterEntity.MOVEMENT_SPEED)
				.add(Attributes.ATTACK_DAMAGE, TieFighterEntity.ATTACK_DAMAGE);
	}


//
//    public static AttributeModifierMap.MutableAttribute func_234188_eI_() {
//        return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 10.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, (double)0.2F);
//    }


    // https://forums.minecraftforge.net/topic/87597-1161-custom-entity-attributes/
    // In my entity I made a function like this (you can name the function whatever you want since you are not
    // overriding anything):

//    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
//
//        //  return MobEntity.func_233666_p_().func_233815_a_(Attributes.MOVEMENT_SPEED, (double)0.5F).func_233815_a_(Attributes.MAX_HEALTH, 20.0D).func_233815_a_(Attributes.ATTACK_DAMAGE, 5.0D);
//        return MobEntity.func_233666_p_()
//                .createMutableAttribute(Attributes.MOVEMENT_SPEED, (double)0.5F)
//                .createMutableAttribute(Attributes.MAX_HEALTH, 20.0D)
//                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 5.0D);
//    }
}


//
//    /**
//	 * constructor
//	 */
//	public TieFighterEntity(World worldIn) {
//		super(worldIn, "tieFighterEntity", "Tie Fighter", TieFighterRender.class, TieFighterModel.class);
//		vehicleId = getNextId();
//
//		// This sets the bounding box size, not the actual model that you see rendered.
//		this.setSize(0.6F, 2.0F);
//
//		// How much experience do you get it you kill it?
//		this.experienceValue = 1;
//
//		// Properties that we need to have later.
//		this.shadowSize = 0.5F;
//
//		// Prevent motion-y degrade.
//		this.setNoGravity(true);
//		this.onGround = false;
//	}
//
//
//	/**
//	 * Returns the next vehicle id; used in debug logs.
//	 * todo: move to base class
//	 */
//	protected static synchronized int getNextId() {
//		return ++s_vehicleId;
//	}
//
//
//	/**
//	 * NOTE: To dismount, we can:
//	 * 	(a) manually call dismountRidingEntity() here in this class (which we don't yet)
//	 *  (b) If the user hits left-shift, there is code in EntityPlayer::updateRidden() that detects this (isSneaking)
//	 *      and calls dismountRidingEntity() for us.
//	 */
//	@Override // from EntityLiving
//    public boolean processInteract(EntityPlayer player, EnumHand hand) {
//
//		if (!this.isBeingRidden()) {
//			// Start the riding state machine.
//			player.startRiding(this);
//
//			// Reset the internal state.
//			everBoarded = true;
//			dismountAnalyzed = false;
//			spinDrop = false;
//			spinDropBeginTime = 0;
//			spinDropRotationIncrement = 0.0F;
//			return true;
//		}
//
//		/* Otherwise, let the system handle the interaction. */
//	    return super.processInteract(player, hand);
//	}
//
//	/**
//	 * Called every tick to update animation.
//	 * Here, we use this callback to transfer forward-signals from the driver to the ship. The player entity will automatically have
//	 * its moveForward and moveStrafe properties set when they press w/a/s/z. We only respond to the w key for now
//	 * (tie fighters only go forward).
//	 */
//	@Override // from EntityLivingBase
//	public void onLivingUpdate() {
//
//		// Update the parked status.
//		boolean detectParked = detectOnGround();
//		if (detectParked != this.parked) {
//			// System.out.println("TF (" + vehicleId + "): parked now is " + detectParked);
//			this.parked = detectParked;
//		}
//
//		EntityLivingBase driver = getControllingLivingPassenger();
//		if (driver != null) {
//
//			// Someone is driving this thing!
//
//			//System.out.println("TF (" + vehicleId + "): CCC airborne=" + this.isAirBorne + "detect=" + detect + ", motion=" +
//			//		this.posX + ", " + this.posY + ", " + this.posZ);
//
//			// Record the direction we are facing. pitch=up and down angle, yaw=left and right
//			//this.prevRotationYaw = this.rotationYaw;
//		    //this.prevRotationPitch = this.rotationPitch;
//		    this.setRotation(driver.rotationYaw, driver.rotationPitch); // also normalizes the angle (between 0 and 360).
//		    this.renderYawOffset = this.rotationYaw;
//
//		    // Copy over our forward movement. For a playerEntity, moveForward is set to 1.0 (and then decayed to .98)
// 			// for the duration that the "w" key is pressed.
// 			if (driver.moveForward > 0.0) {
// 				this.setMoveForward(driver.moveForward);
// 			}
//
//		    // Hitting the "a" key shoots the primary weapon. Note that this normally means sideways movement, but if you're in
// 			// a tie fighter, that key now shoots the gun.
//		    if (driver.moveStrafing > 0.0f) {
//		    	// Use some 3d trigonometry to have the laser blasts emerge from approximately where the gun turrets are, taking
//		    	// into consideration that the ship is already slanted in some specific direction.
//		    	float offset_vertical = 6.0f; // middle of cockpit
//				float offset_forward = 3.0f; // directly forward of cockpit
//		    	float pitch = this.rotationPitch;
//				float yaw = this.rotationYaw;
//		    	float xvector = -MathHelper.sin(yaw * DEGREES2RADIANS) * MathHelper.cos(pitch * DEGREES2RADIANS);
//			    float yvector = -MathHelper.sin(pitch * DEGREES2RADIANS);
//			    float zvector = MathHelper.cos(yaw * DEGREES2RADIANS) * MathHelper.cos(pitch * DEGREES2RADIANS);
//			    float deltax = (xvector * offset_forward);
//			    float deltay = (yvector * offset_forward);
//			    float deltaz = (zvector * offset_forward);
//
//			    //System.out.println("TF: shooting vehicle=" +this.posX + ", " + this.posY + ", " + this.posZ);
//		    	Vec3d startPos = new Vec3d(this.posX + deltax, this.posY + deltay + offset_vertical, this.posZ + deltaz);
//		    	SuperDopeJediMod.weaponManager.ThrowForwardPlasmaShotRed(world, this, PowerLevel.HEAVY, Optional.of(startPos));
//		    }
//
//	    } else if (!dismountAnalyzed) {
//
//	    	// Someone recently dismounted!
//	    	// System.out.println("TF (" + vehicleId + "): DISMOUNT detected with parked=" + this.parked);
//
//	    	if (!this.parked) {
//	    		// Someone jumped out when the ship was in mid air. Time to start the crash state machine.
//	    		// System.out.println("TF (" + vehicleId + "): DISMOUNT will cause wreck");
//	    		spinDropBeginTime = System.currentTimeMillis() + DROP_DELAY;
//	    		spinDropRotationIncrement = (new Random().nextInt(50) - 25); // angle between -25 and +24
//	    	} else {
//	    		// Someone jumped out while safely on ground. cool!
//	    		// System.out.println("TF (" + vehicleId + "): DISMOUNT will NOT cause wreck; safely parked.");
//	    	}
//
//	    	// Only analyze once, the first time this is called after the dismount happens.
//	    	dismountAnalyzed = true;
//
//	    } else if (spinDropBeginTime != 0) {
//	    	// Let's see if the delay between the dismount and the beginning of the crash has ended.
//	    	long now = System.currentTimeMillis();
//	    	if (now > spinDropBeginTime) {
//	    		// System.out.println("TF (" + vehicleId + "): time to drop");
//	    		spinDrop = true;
//	    		spinDropBeginTime = 0;
//	    	}
//	    } else if (spinDrop) {
//
//	    	if (this.parked) {
//
//	    		// We hit the ground! Ka-boom!
//   			 	spinDrop = false;
//   			 	this.attackEntityFrom(DamageSource.FALL, Float.MAX_VALUE);
//
//   		 	} else {
//
//		    	// We are now spinning out of control. The travel() routine will handle the drop, here we do the spin.
//	   		 	if (!this.world.isRemote) {
//	   		 		// System.out.println("TF (" + vehicleId + "): time to spin=" + this.renderYawOffset + ",new=" + (this.renderYawOffset + spinDropRotationIncrement) % 360.0F);
//			    	this.setRenderYawOffset((this.renderYawOffset + spinDropRotationIncrement) % 360.0F);
//	   		 	}
//   		 	}
//	    }
//
//		// Continue to do all the updates in the parent class.
//	    super.onLivingUpdate();
//	}
//
//
//
//	/**
//	 * Called by onLivingUpdate() to translate the direction controls (moveForward, moveStrafing, moveVertical)
//	 * to actual movement (motionX, motionY, motionZ), and then a call to the system move() routine.
//	 */
//	@Override // from EntityLivingBase
//	public void travel(float inMoveStrafing, float inMoveVertical, float inMoveForward) {
//
//		EntityLivingBase driver = getControllingLivingPassenger();
//		if (driver != null) {
//			//System.out.println("TF (" + vehicleId + "): BBB-pre moveForward=" + this.moveForward + ", motion=" +
//			//		this.motionX + ", " + this.motionY + ", " + this.motionZ);
//		}
//
//	    if (this.isBeingRidden() && this.canBeSteered() && this.canPassengerSteer() && (inMoveForward > 0.0)) {
//	    	// Someone is piloting the ship, and they hit the "w" key. Note that when the release the "w" key, this value will
//	    	// not immediately clear to 0, but instead degrade by 2% per update, slowly approaching 0.
//        	// Calculate velocity.
//            float v = (float) this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue();
//            v *= 10.0f;
//            v *= inMoveForward; // this will be a value from 0.0 to 1.0 in the client, always 0.0 on server.
//
//            // Map the forward velocity to its individual x, y, and z components according to the direction we are looking
//            // (using a little trigonometry).
//            Vec3d vec3d = this.getLookVec();
//            this.motionX = v * vec3d.x;
//            this.motionY = v * vec3d.y;
//            this.motionZ = v * vec3d.z;
//            this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
//
//            // Did we collide with something? Tie fighters are weak, and explode on any collision.
//            // todo: this doesnt work for some reason.
//            /* if (this.isCollidedHorizontally && !this.world.isRemote) {
//                double horizontalVelocity = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
//                float f5 = (float)(horizontalVelocity * 10.0D - 3.0D);
//                if (f5 > 0.0F) {
//                    this.playSound(this.getFallSound((int)f5), 1.0F, 1.0F);
//                    this.attackEntityFrom(DamageSource.FLY_INTO_WALL, f5);
//                }
//            } */
//
//            //System.out.println("TF (" + vehicleId + "): BBB-post-gas moveForward=" + this.moveForward + ", motion=" +
//			//		this.motionX + ", " + this.motionY + ", " + this.motionZ);
//
//	    } else if (spinDrop) {
//
//	    	// Drop to the ground.
//			this.motionX = 0.0D;
//			this.motionY += -0.02D;
//	    	this.motionZ = 0.0D;
//	    	this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
//
//	     } else {
//			// We are safely parked, or we are flying but no controls have been pressed for awhile.
//			this.motionX = 0.0D;
//			this.motionY = 0.0D;
//			this.motionZ = 0.0D;
//	 	    super.travel(inMoveStrafing, inMoveVertical, inMoveForward);
//
// 	       if (everBoarded) {
//		        //System.out.println("TF (" + vehicleId + "): BBB-post-no moveForward=" + this.moveForward + ", motion=" +
//				//		this.motionX + ", " + this.motionY + ", " + this.motionZ);
//	        }
//	    }
//	}
//
//
//	/**
//     * Returns the Y offset from the entity's position for any entity riding this one.
//     * should return the yoffset of the cockpit area.
//     */
//	@Override // from Entity
//    public double getMountedYOffset() {
//	  // TODO: this is hard coded to sit on top of the cockpit, so you can see, Lower once i figure out how to have
//	  // transparent pixels in the cockpit window.
//	  return 9.0;
//    }
//
//	/**
//	 * EntityAnimal overrides this, so back to default of 0.
//	 */
//	@Override // from Entity
//	public double getYOffset() {
//		return 0.0D;
//	}
//}