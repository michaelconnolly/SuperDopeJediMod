package superdopesquad.superdopejedimod.weapon;


import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import superdopesquad.superdopejedimod.DopeItem;
import superdopesquad.superdopejedimod.armor.ArmorManager;
import superdopesquad.superdopejedimod.armor.DopeArmor;
import superdopesquad.superdopejedimod.faction.ClassManager;
import superdopesquad.superdopejedimod.faction.ClassPermissions;
import superdopesquad.superdopejedimod.faction.IClassAware;


public class WeaponManager {

    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Constants
     */
    private static final float DEGREES2RADIANS = 0.017453292F;

    // Lightsaber stuff!
    // https://screenrant.com/star-wars-lightsaber-color-meaning-canon/
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
    public static final DopeMeleeWeapon VIBRO_KNIFE = new DopeMeleeWeapon("vibro_knife", ItemTier.IRON);
    public static final DopeMeleeWeapon BESKAR_SPEAR = new DopeMeleeWeapon("beskar_spear", ItemTier.DIAMOND, ClassPermissions.BountyHunterOnly);
    public static final DopeMeleeWeapon GAFFI_STICK = new DopeMeleeWeapon("gaffi_stick", ItemTier.IRON);

    // Blasters.
    // https://www.cbr.com/star-wars-blaster-bolt-colors-explanation/
    // https://starwars.fandom.com/wiki/Blaster#:~:text=Blaster%20bolts%20came%20in%20different,Galactic%20Republic%2C%20and%20the%20Resistance.
    public static final DopeItem BLASTER_PARTS = new DopeItem("blaster_parts");
    public static final Blaster BLASTER = new Blaster("blaster");
    public static final Blaster BLASTER_RIFLE = new Blaster("blaster_rifle", PowerLevel.STANDARD, 20.0F);

    // Projectile items that are rendered later by the projectile entities..
    // public static final EntityType<PlasmaShotEntity> PLASMA_SHOT = register("snowball", EntityType.Builder.<PlasmaShotEntity>of(PlasmaShotEntity::new, EntityClassification.MISC).sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10));

    public static PlasmaShotItem PLASMA_SHOT_ITEM_BLUE = new PlasmaShotItem("blue");
    public static PlasmaShotItem PLASMA_SHOT_ITEM_RED = new PlasmaShotItem("red");
    public static PlasmaShotItem PLASMA_SHOT_ITEM_WHITE = new PlasmaShotItem("white");

    // Projectile entities should be created here, to trigger registration properly.
    //public static PlasmaShotEntity PLASMA_SHOT_ENTITY_BLUE = new PlasmaShotEntity("blue");
    //public static PlasmaShotEntity PLASMA_SHOT_ENTITY_RED = new PlasmaShotEntity("red");

//    public static final RegistryObject<EntityType<PlasmaShotEntity>> registryObject =
//            SuperDopeJediMod.ENTITIES.register(
//            "plasma_shot_what",
//            () -> EntityType.Builder.of(PlasmaShotEntity::new, EntityClassification.MISC)
//                    .size(EntityType.COW.getWidth(), EntityType.COW.getHeight())
//                    .build(new ResourceLocation(SuperDopeJediMod.MODID, "plasma_shot_what").toString())
//    );

//    private static <T extends Entity> EntityType<T> register(String p_200712_0_, EntityType.Builder<T> p_200712_1_) {
//        return Registry.register(Registry.ENTITY_TYPE, p_200712_0_, p_200712_1_.build(p_200712_0_));
//    }


    public WeaponManager() {
    }


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
//    public void ThrowPlasmaShotAtDirection(World world, PlayerEntity thrower, PowerLevel powerLevel, int timeLeft) {
//
//	    //int i = this.getMaxItemUseDuration(null) - timeLeft;
//    	int i = 72000 - timeLeft;
//    	float f = getArrowVelocity(i);
//
//      // PlasmaShotEntity plasmaShotEntity =  this.createPlasmaShotEntity(world, thrower, powerLevel, Optional.empty());
//        PlasmaShotEntity plasmaShotEntity =  this.createPlasmaShotEntity(world, thrower, powerLevel, Optional.empty());
//
//        // MC_TODO:
//        //plasmaShotEntity.setAim(thrower, thrower.rotationPitch, thrower.rotationYaw, 0.0F, f * 3.0F, 1.0F);
//
//       //if (f == 1.0F)
//       //{
//       //    entityarrow.setIsCritical(true);
//       //}
//
//       int j = 1; // EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);
//
//       if (j > 0) {
//    	   plasmaShotEntity.setDamage(plasmaShotEntity.getDamage() + (double)j * 0.5D + 0.5D);
//       }
//
//       //System.out.println("damageAmount: " + plasmaShotEntity.getDamage());
//
//      // int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);
//
////       if (k > 0)
////       {
////           entityarrow.setKnockbackStrength(k);
////       }
//
////       if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0)
////       {
////           entityarrow.setFire(100);
////       }
//
//      // stack.damageItem(1, entityplayer);
//
////       if (flag1 || entityplayer.capabilities.isCreativeMode && (itemstack.getItem() == Items.SPECTRAL_ARROW || itemstack.getItem() == Items.TIPPED_ARROW))
////       {
////           entityarrow.pickupStatus = EntityArrow.PickupStatus.CREATIVE_ONLY;
////       }
//
//       //world.spawnEntityInWorld(plasmaShotEntity);
//       //boolean success = world.spawnEntity(plasmaShotEntity);
//       boolean success = world.addFreshEntity(plasmaShotEntity);
//       if (!success) {
//			System.out.println("Failed to spawn an EntityThrowable!");
//		}
//    }
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
////	/**
////	 * Factory for standard plasma shots. Color chosen by the passed in faction.
////	 */
//	private PlasmaShotEntity createPlasmaShotEntity(World world, PlayerEntity thrower,
//                                                    PowerLevel powerLevel, Optional<Vec3d> startPos) {
//
// 	    FactionInfo factionInfo = SuperDopeJediMod.CLASS_MANAGER.getPlayerFaction(thrower);
//        PlasmaShotEntity ret = null;
//	    String color;
//
// 	  if ((factionInfo == null) || (factionInfo.getId() == ClassManager.REBEL_ALLIANCE.getId())) {
// 		  //ret = new PlasmaShotEntityBlue(world, thrower, powerLevel);
// 		  color = "blue";
// 	  } else {
// 		  //ret = new PlasmaShotEntityRed(world, thrower, powerLevel);
// 		  color = "red";
// 	  }
// 	  ret = new PlasmaShotEntity(world, thrower, powerLevel);
//
//
// 	  if (startPos.isPresent()) {
// 		 ret.setPos(startPos.get().x, startPos.get().y, startPos.get().z);
// 	  }
// 	  //System.out.println("TF: shooting startPos=" +ret.posX + ", " + ret.posY + ", " + ret.posZ);
//       // System.out.println("TF: shooting startPos=" +ret.getPos().getX() + ", " + ret.getPosition().getY() + ", " + ret.getPosition().getZ());
//        return ret;
//    }
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


    public static float getArrowVelocity(int charge) {
        float f = (float) charge / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;

        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }


//
//    // This is called from onPlayerLoggedIn event, to verify that they are wearing legal armor.
//    // This could potentially be called from other places if we feel we need to double-check.
//    // It has to be called on the server-side, since that is the only way player.drop will work.
//    public static void armorSetCheck(PlayerEntity player) {
//
//        ArmorManager.armorItemCheck(player, EquipmentSlotType.CHEST);
//        ArmorManager.armorItemCheck(player, EquipmentSlotType.HEAD);
//        ArmorManager.armorItemCheck(player, EquipmentSlotType.LEGS);
//        ArmorManager.armorItemCheck(player, EquipmentSlotType.FEET);
//
//        return;
//    }
//
//    public static void itemPermissionCheck(PlayerEntity player) {
//
//        WeaponManager.itemPermissionCheck(player, EquipmentSlotType.MAINHAND);
//        WeaponManager.itemPermissionCheck(player, EquipmentSlotType.OFFHAND);
//    }
//
//    public static void itemPermissionCheck(PlayerEntity player, EquipmentSlotType slot) {
//
//        // If there is nothing in the slot, return.
//        ItemStack itemStack = player.getItemBySlot(slot);
//        if (itemStack == null) return;
//
//        // If the item does not implement IClassAware, return.
//        Item item = itemStack.getItem();
//        if (!(item instanceof IClassAware)) return;
//
//        // If they can use it, return.
//        // If you can't, we threw an error in the chat.
//        if (((IClassAware) item).canUse(null, player)) return;
//
//        // If you made it here, you have to get rid of this armor.
//        LOGGER.debug(item.getRegistryName().toString() + " should not be worn!");
//        WeaponManager.toss(player, slot);
//    }
//
//
//    private static void toss(PlayerEntity player, EquipmentSlotType slot) {
//
//        ItemStack itemStack = player.getItemBySlot(slot);
//        ItemStack itemStackToDrop = itemStack.copy();
//
//        // reduce the amount we have by 1.  For equipment slots, this should always reduce to zero.
//        itemStack.shrink(1);
//
//        // drop the stack in that slot onto the ground.  I am not sure what the boolean parameter does.
//        player.drop(itemStackToDrop, false);
//    }
}
