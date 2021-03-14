package superdopesquad.superdopejedimod.weapon;


import com.sun.javafx.geom.Vec3d;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import superdopesquad.superdopejedimod.SuperDopeJediMod;
import superdopesquad.superdopejedimod.faction.ClassManager;
import superdopesquad.superdopejedimod.faction.FactionInfo;
import java.util.Optional;


public class WeaponManager {

	/** Constants */
    private static final float DEGREES2RADIANS = 0.017453292F;

    // Lightsaber stuff!
    public static Lightsaber lightSaberRed = new Lightsaber("red");
    public static Lightsaber lightSaberBlue = new Lightsaber("blue");
    public static Lightsaber lightSaberGreen = new Lightsaber("green");
    public static Lightsaber lightSaberPurple = new Lightsaber("purple");

    // Double Lightsaber stuff!
    public static DoubleLightsaber doubleLightsaberRed = new DoubleLightsaber("red");
    public static DoubleLightsaber doubleLightsaberBlue = new DoubleLightsaber("blue");
    public static DoubleLightsaber doubleLightsaberGreen = new DoubleLightsaber("green");
    public static DoubleLightsaber doubleLightsaberPurple = new DoubleLightsaber("purple");

    // Other hand-held weapons.
    public static final VibroKnife VIBRO_KNIFE = new VibroKnife("vibro_knife");
    public static final BeskarSpear BESKAR_SPEAR = new BeskarSpear("beskar_spear");
    public static final GaffiStick GAFFI_STICK = new GaffiStick("gaffi_stick");

    // Blasters.
    public static final BlasterParts BLASTER_PARTS = new BlasterParts("blaster_parts");
    public static final Blaster BLASTER = new Blaster("blaster");
    public static final BlasterRifle BLASTER_RIFLE = new BlasterRifle("blaster_rifle");

    // Projectile items that are rendered later by the projectile entities..
    public static PlasmaShotItem PLASMA_SHOT_ITEM_BLUE = new PlasmaShotItem("blue");
    public static PlasmaShotItem PLASMA_SHOT_ITEM_RED = new PlasmaShotItem("red");

    // Projectile entities should be created here, to trigger registration properly.
    public static PlasmaShotEntity PLASMA_SHOT_ENTITY_BLUE = new PlasmaShotEntity("blue");
    public static PlasmaShotEntity PLASMA_SHOT_ENTITY_RED = new PlasmaShotEntity("red");


    public WeaponManager() {}


//    public void onInit() {
//
//    	// Handles to some render objects we need.
//    	RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
//    	RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
//
//    	// Register red plasma shot.
//    	PlasmaShotRender plasmaShotRenderRed = new PlasmaShotRender(renderManager, SuperDopeJediMod.weaponManager.plasmaShotItemRed, renderItem);
//    	Minecraft.getMinecraft().getRenderManager().entityRenderMap.put(PlasmaShotEntityRed.class, plasmaShotRenderRed);
//
//    	// Register red plasma shot.
//    	PlasmaShotRender plasmaShotRenderBlue = new PlasmaShotRender(renderManager, SuperDopeJediMod.weaponManager.plasmaShotItemBlue, renderItem);
//    	Minecraft.getMinecraft().getRenderManager().entityRenderMap.put(PlasmaShotEntityBlue.class, plasmaShotRenderBlue);
//
//    	// TEST CODE.
//     	//System.out.println((Minecraft.getMinecraft() == null));
//    	//System.out.println((Minecraft.getMinecraft().getRenderManager() == null));
//    	//System.out.println((Minecraft.getMinecraft().getRenderItem() == null));
//    	//System.out.println((Minecraft.getMinecraft().getRenderManager().entityRenderMap == null));
//		//Object o = Minecraft.getMinecraft().getRenderManager().entityRenderMap.get(PlasmaShotEntity.class);
//		//System.out.println("DEBUG: " + o.getClass().getName());
//    }
//
//
    public void ThrowPlasmaShotAtDirection(World world, PlayerEntity thrower, PowerLevel powerLevel, int timeLeft) {

	    //int i = this.getMaxItemUseDuration(null) - timeLeft;
    	int i = 72000 - timeLeft;
    	float f = getArrowVelocity(i);

      // PlasmaShotEntity plasmaShotEntity =  this.createPlasmaShotEntity(world, thrower, powerLevel, Optional.empty());
        PlasmaShotEntity plasmaShotEntity =  this.createPlasmaShotEntity(world, thrower, powerLevel, Optional.empty());
        plasmaShotEntity.setAim(thrower, thrower.rotationPitch, thrower.rotationYaw, 0.0F, f * 3.0F, 1.0F);

       //if (f == 1.0F)
       //{
       //    entityarrow.setIsCritical(true);
       //}

       int j = 1; // EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);

       if (j > 0) {
    	   plasmaShotEntity.setDamage(plasmaShotEntity.getDamage() + (double)j * 0.5D + 0.5D);
       }

       //System.out.println("damageAmount: " + plasmaShotEntity.getDamage());

      // int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);

//       if (k > 0)
//       {
//           entityarrow.setKnockbackStrength(k);
//       }

//       if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0)
//       {
//           entityarrow.setFire(100);
//       }

      // stack.damageItem(1, entityplayer);

//       if (flag1 || entityplayer.capabilities.isCreativeMode && (itemstack.getItem() == Items.SPECTRAL_ARROW || itemstack.getItem() == Items.TIPPED_ARROW))
//       {
//           entityarrow.pickupStatus = EntityArrow.PickupStatus.CREATIVE_ONLY;
//       }

       //world.spawnEntityInWorld(plasmaShotEntity);
       //boolean success = world.spawnEntity(plasmaShotEntity);
       boolean success = world.addEntity(plasmaShotEntity);
       if (!success) {
			System.out.println("Failed to spawn an EntityThrowable!");
		}
    }
//
//
//    public void ThrowPlasmaShotBlue(World world, EntityLivingBase thrower, EntityLivingBase target, PowerLevel powerLevel) {
//    	this.ThrowAtTargetPlasmaShot(world, thrower, SuperDopeJediMod.classManager.getFactionInfo(ClassManager.FACTION_REPUBLIC),
//    			target, powerLevel, Optional.empty());
//    }
//
//    public void ThrowForwardPlasmaShotBlue(World world, EntityLivingBase thrower, PowerLevel powerLevel) {
//       	this.ThrowForwardPlasmaShot(world, thrower, SuperDopeJediMod.classManager.getFactionInfo(ClassManager.FACTION_REPUBLIC),
//       			powerLevel, Optional.empty());
//    }
//
//    public void ThrowForwardPlasmaShotBlue(World world, EntityLivingBase thrower, PowerLevel powerLevel, Optional<Vec3d> startPos) {
//       	this.ThrowForwardPlasmaShot(world, thrower, SuperDopeJediMod.classManager.getFactionInfo(ClassManager.FACTION_REPUBLIC),
//       			powerLevel, startPos);
//    }
//
//
//    public void ThrowPlasmaShotRed(World world, EntityLivingBase thrower, EntityLivingBase target, PowerLevel powerLevel) {
//       	this.ThrowAtTargetPlasmaShot(world, thrower, SuperDopeJediMod.classManager.getFactionInfo(ClassManager.FACTION_EMPIRE),
//       			target, powerLevel, Optional.empty());
//    }
//
//    public void ThrowForwardPlasmaShotRed(World world, EntityLivingBase thrower, PowerLevel powerLevel) {
//       	this.ThrowForwardPlasmaShot(world, thrower, SuperDopeJediMod.classManager.getFactionInfo(ClassManager.FACTION_EMPIRE),
//       			powerLevel, Optional.empty());
//    }
//
//    public void ThrowForwardPlasmaShotRed(World world, EntityLivingBase thrower, PowerLevel powerLevel, Optional<Vec3d> startPos) {
//       	this.ThrowForwardPlasmaShot(world, thrower, SuperDopeJediMod.classManager.getFactionInfo(ClassManager.FACTION_EMPIRE),
//       			powerLevel, startPos);
//    }
//
//
//    private void ThrowAtTargetPlasmaShot(World world, EntityLivingBase thrower, FactionInfo factionInfo, EntityLivingBase target,
//    		PowerLevel powerLevel, Optional<Vec3d> startPos) {
//    	EntityThrowable entityThrowable = this.createPlasmaShotEntity(world, thrower, factionInfo, powerLevel, startPos);
//    	this.ThrowSomethingAtTarget(entityThrowable, world, thrower, target, powerLevel);
//    }
//
//
//    private void ThrowForwardPlasmaShot(World world, EntityLivingBase thrower, FactionInfo factionInfo,
//    		PowerLevel powerLevel, Optional<Vec3d> startPos) {
//    	EntityThrowable entityThrowable = this.createPlasmaShotEntity(world, thrower, factionInfo, powerLevel, startPos);
//    	this.ThrowSomethingForward(entityThrowable, world, thrower, powerLevel);
//    }
//
//
//	private void ThrowSomethingAtTarget(EntityThrowable entityThrowable, World world, EntityLivingBase thrower, EntityLivingBase target, PowerLevel powerLevel) {
//		// Some complicated math to figure out what direction to throw.
//		double deltax = target.posX - entityThrowable.posX;
//		double deltay =  (target.posY + (double) target.getEyeHeight() - 1.1D) - entityThrowable.posY;
//		double deltaz = target.posZ - entityThrowable.posZ;
//		float f = MathHelper.sqrt(deltax * deltax + deltaz * deltaz) * 0.2F;
//		entityThrowable.setThrowableHeading(deltax, deltay + (double)f, deltaz,
//				(float) powerLevel.velocity(), (float) powerLevel.accuracy());
//
//		ThrowSomethingFinish(entityThrowable, world, thrower);
//	}
//
//	private void ThrowSomethingForward(EntityThrowable entityThrowable, World world, EntityLivingBase thrower, PowerLevel powerLevel) {
//		// 3 dimensional trigonometry to covert the angle we are pointing in, to its x,y,and z vectors.
//		float pitch = thrower.rotationPitch;
//		float yaw = thrower.rotationYaw;
//		float xvector = -MathHelper.sin(yaw * DEGREES2RADIANS) * MathHelper.cos(pitch * DEGREES2RADIANS);
//	    float yvector = -MathHelper.sin(pitch * DEGREES2RADIANS);
//	    float zvector = MathHelper.cos(yaw * DEGREES2RADIANS) * MathHelper.cos(pitch * DEGREES2RADIANS);
//	    entityThrowable.setThrowableHeading((double) xvector, (double) yvector, (double) zvector,
//	    		(float) powerLevel.velocity(), (float) powerLevel.accuracy());
//
//	    ThrowSomethingFinish(entityThrowable, world, thrower);
//	}
//
//	private void ThrowSomethingFinish(EntityThrowable entityThrowable, World world, EntityLivingBase thrower) {
//		// Add in the thrower's own velocity,.
//		entityThrowable.motionX += thrower.motionX;
//		entityThrowable.motionZ += thrower.motionZ;
//		if (!thrower.onGround) {
//			entityThrowable.motionY += thrower.motionY;
//		}
//
//		//this.playSound(SoundEvents.ENTITY_SNOWMAN_SHOOT, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
//
//		// Actually throw!
//		boolean success = world.spawnEntity(entityThrowable);
//		if (!success) {
//			System.out.println("Failed to spawn an EntityThrowable!");
//		}
//	}
//
//he
//	/**
//	 * Factory for standard plasma shots. Color chosen by the passed in faction.
//	 */
	private PlasmaShotEntity createPlasmaShotEntity(World world, PlayerEntity thrower,
                                                    PowerLevel powerLevel, Optional<Vec3d> startPos) {

 	    FactionInfo factionInfo = SuperDopeJediMod.CLASS_MANAGER.getPlayerFaction(thrower);
        PlasmaShotEntity ret = null;
	    String color;

 	  if ((factionInfo == null) || (factionInfo.getId() == ClassManager.REBEL_ALLIANCE.getId())) {
 		  //ret = new PlasmaShotEntityBlue(world, thrower, powerLevel);
 		  color = "blue";
 	  } else {
 		  //ret = new PlasmaShotEntityRed(world, thrower, powerLevel);
 		  color = "red";
 	  }
 	  ret = new PlasmaShotEntity(world, thrower, powerLevel);


 	  if (startPos.isPresent()) {
 		 ret.setPosition(startPos.get().x, startPos.get().y, startPos.get().z);
 	  }
 	  //System.out.println("TF: shooting startPos=" +ret.posX + ", " + ret.posY + ", " + ret.posZ);
        System.out.println("TF: shooting startPos=" +ret.getPosition().getX() + ", " + ret.getPosition().getY() + ", " + ret.getPosition().getZ());
        return ret;
    }
//
//
//	/**
//	 * Factory for standard plasma shots. Color chosen by the faction of the shooter.
//	 */
//    private PlasmaShotEntityBase createPlasmaShotEntity(World world, EntityPlayer thrower,
//    		PowerLevel powerLevel, Optional<Vec3d> startPos) {
// 	   return this.createPlasmaShotEntity(world, thrower, SuperDopeJediMod.classManager.getPlayerClass(thrower).getFaction(),
// 			  powerLevel, startPos);
//    }
//
//
//    /**
//     *
//     */


    public static float getArrowVelocity(int charge)
    {
        float f = (float)charge / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;

        if (f > 1.0F)
        {
            f = 1.0F;
        }

        return f;
    }
}
