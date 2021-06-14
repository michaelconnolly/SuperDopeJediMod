package superdopesquad.superdopejedimod.weapon;


import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.World;
import superdopesquad.superdopejedimod.SuperDopeJediMod;
import superdopesquad.superdopejedimod.faction.*;


public class Blaster extends DopeRangedWeapon {

	protected PowerLevel powerLevel = PowerLevel.STANDARD;
	protected float range = 10.0F;


	public Blaster(String name) {

		this(name, PowerLevel.STANDARD, 10.0F);
	}


	public Blaster(String name, PowerLevel powerLevel, float range) {

		super(name, ClassPermissions.NonForceWieldersOnly);

		this.powerLevel = powerLevel;
		this.range = range;
	}


	@Override
	public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {

		ActionResult<ItemStack> superReturn = super.use(world, player, hand);
		LOGGER.debug("superReturn: " + superReturn.getResult().toString());

		// If our base class says we need to eat this, then eat it.
		if (superReturn.getResult() == ActionResultType.CONSUME)
			return superReturn;

		// We need to return this, but don't really use it for anything ourselves.
		ItemStack itemStackInHand = player.getItemInHand(hand);

		// The plasma shot color is dynamic, based on player faction.
		ItemStack itemstack = this.getPlasmaShot(player);

		// Let's play a sound!
		world.playSound(null, player.getX(), player.getY(), player.getZ(),
				SoundEvents.DRAGON_FIREBALL_EXPLODE, SoundCategory.NEUTRAL, 0.5F,
				0.4F / (random.nextFloat() * 0.4F + 0.8F));


		// Server side logic for creating and shooting the projectile entity in a direction.
		if (!world.isClientSide) {

			PlasmaShotEntity plasmaShotEntity = new PlasmaShotEntity(world, player);
			plasmaShotEntity.setItem(itemstack);
			plasmaShotEntity.shootFromRotation(player, player.xRot, player.yRot, 0.0F,
					1.5F, 1.0F);
			world.addFreshEntity(plasmaShotEntity);
		}

		return ActionResult.sidedSuccess(itemStackInHand, world.isClientSide());
	}



	public void releaseUsing(ItemStack p_77615_1_, World p_77615_2_, LivingEntity p_77615_3_, int p_77615_4_) {

		LOGGER.debug("Blaster:releaseUsing ...");
	}


	private ItemStack getPlasmaShot(PlayerEntity player) {

		if (SuperDopeJediMod.CLASS_MANAGER.isPlayerInFaction(player, ClassManager.REBEL_ALLIANCE))
			return WeaponManager.PLASMA_SHOT_ITEM_BLUE.getDefaultInstance();

		else if (SuperDopeJediMod.CLASS_MANAGER.isPlayerInFaction(player, ClassManager.THE_EMPIRE))
			return WeaponManager.PLASMA_SHOT_ITEM_RED.getDefaultInstance();

		return WeaponManager.PLASMA_SHOT_ITEM_WHITE.getDefaultInstance();
	}



//
//	/**
//	 * Called when the player stops using an Item (stops holding the right mouse button).
//	*/
//	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {
//
//		System.out.println("inside onPlayerStoppedUsing: timeLeft:" + timeLeft);
//
//		if (entityLiving instanceof EntityPlayer) {
//
//			if (this.isInstantWeapon) {
//
//				//System.out.println("onItemRightClick: skipped doing anything due to isInstantWeapon==true");
//				return;
//			}
//
//			EntityPlayer entityplayer = (EntityPlayer)entityLiving;
//			int i = this.getMaxItemUseDuration(stack) - timeLeft;
//	        boolean hasAmmo = true;
//
//	        i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, (EntityPlayer)entityLiving, i, hasAmmo);
//	  	    if (i < 0) return;
//
//	             // if (!itemstack.func_190926_b() || flag)
//	              //{
//	              //    if (itemstack.func_190926_b())
//	              //    {
//	               //       itemstack = new ItemStack(Items.ARROW);
//	              //    }
////
//	                  float f = WeaponManager.getArrowVelocity(i);
//
//	                  if ((double)f >= 0.1D)
//	                  {
//	                      //boolean flag1 = entityplayer.capabilities.isCreativeMode || (itemstack.getItem() instanceof ItemArrow ? ((ItemArrow)itemstack.getItem()).isInfinite(itemstack, stack, entityplayer) : false);
//
//
//	                     // this.shootBlasterRound(worldIn, entityplayer, timeLeft);
//	                	  SuperDopeJediMod.weaponManager.ThrowPlasmaShotAtDirection(worldIn, entityplayer, this.powerLevel, 0);
//
////	                      if (!worldIn.isRemote)
////	                      {
////	                          ItemArrow itemarrow = (ItemArrow)((ItemArrow)(itemstack.getItem() instanceof ItemArrow ? itemstack.getItem() : Items.ARROW));
////
////	                          //EntityArrow entityarrow = itemarrow.createArrow(worldIn, itemstack, entityplayer);
////	                          PlasmaShotEntityBase entityarrow =  new PlasmaShotEntityBlue(worldIn, entityplayer, 1.0F);
////
////
////	                          entityarrow.setAim(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F, f * 3.0F, 1.0F);
////
////	                          //if (f == 1.0F)
////	                          //{
////	                          //    entityarrow.setIsCritical(true);
////	                          //}
////
////	                          int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);
////
////	                          if (j > 0)
////	                          {
////	                              entityarrow.setDamage(entityarrow.getDamage() + (double)j * 0.5D + 0.5D);
////	                          }
////
////	                          int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);
////
//////	                          if (k > 0)
//////	                          {
//////	                              entityarrow.setKnockbackStrength(k);
//////	                          }
////
////	                          if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0)
////	                          {
////	                              entityarrow.setFire(100);
////	                          }
////
////	                          stack.damageItem(1, entityplayer);
////
//////	                          if (flag1 || entityplayer.capabilities.isCreativeMode && (itemstack.getItem() == Items.SPECTRAL_ARROW || itemstack.getItem() == Items.TIPPED_ARROW))
//////	                          {
//////	                              entityarrow.pickupStatus = EntityArrow.PickupStatus.CREATIVE_ONLY;
//////	                          }
////
////	                          worldIn.spawnEntityInWorld(entityarrow);
////	                      }
//
////	                      worldIn.playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
////
////	                      if (!flag1 && !entityplayer.capabilities.isCreativeMode)
////	                      {
////	                          itemstack.func_190918_g(1);
////
////	                          if (itemstack.func_190926_b())
////	                          {
////	                              entityplayer.inventory.deleteStack(itemstack);
////	                          }
////	                      }
////
////	                      entityplayer.addStat(StatList.getObjectUseStats(this));
//	                  }
//	              }
//	          //}
//	      }
//
////	      /**
////	       * Gets the velocity of the arrow entity from the bow's charge
////	       */
////	      public static float getArrowVelocity(int charge)
////	      {
////	          float f = (float)charge / 20.0F;
////	          f = (f * f + f * 2.0F) / 3.0F;
////
////	          if (f > 1.0F)
////	          {
////	              f = 1.0F;
////	          }
////
////	          return f;
////	      }
//
//	      /**
//	       * How long it takes to use or consume an item
//	       */
//	      public int getMaxItemUseDuration(ItemStack stack)
//	      {
//	          return 72000;
//	      }
//
//	      /**
//	       * returns the action that specifies what animation to play when the items is being used
//	       */
//	      public EnumAction getItemUseAction(ItemStack stack)
//	      {
//	          return EnumAction.BOW;
//	      }
//
//
//
//	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
//
//		ItemStack itemstack = player.getItemInHand(hand);
//
//		if (this.isInstantWeapon) {
//
//			System.out.println("BaseBlaster:onItemRightClick: isInstantWeapon==true");
//
//			int timeLeft = 0;
//			SuperDopeJediMod.WEAPON_MANAGER.ThrowPlasmaShotAtDirection(world, player, this.powerLevel, 0);
//
//			return new ActionResult(ActionResultType.SUCCESS, itemstack);
//		} else {
//			System.out.println("onItemRightClick: isInstantWeapon==false");
//
//			boolean hasAmmo = true;
////	          ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, world, player, hand, hasAmmo);
////	          if (ret != null) return ret;
////
////	          if (!player.capabilities.isCreativeMode && !hasAmmo)
//			//if (true){
//
//			return hasAmmo ? new ActionResult(ActionResultType.PASS, itemstack) : new ActionResult(ActionResultType.FAIL, itemstack);
//			//   }
////	          else
////	          {
////	              player.setActiveHand(hand);
////	              return new ActionResult(EnumActionResult.SUCCESS, itemstack);
////	          }
//		}

	}

