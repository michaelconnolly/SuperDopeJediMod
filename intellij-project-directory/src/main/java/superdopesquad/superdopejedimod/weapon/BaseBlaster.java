package superdopesquad.superdopejedimod.weapon;


import java.util.List;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import superdopesquad.superdopejedimod.SuperDopeJediMod;
import superdopesquad.superdopejedimod.SuperDopeObject;
import superdopesquad.superdopejedimod.faction.*;


public abstract class BaseBlaster  extends BaseRangedWeapon implements SuperDopeObject, ClassAwareInterface {


	protected boolean isInstantWeapon = true;
	protected PowerLevel powerLevel = PowerLevel.STANDARD;
	protected float range = 10.0F;


	public BaseBlaster(String name) {

		super(name);

//		 this.maxStackSize = 1;
//
		//this.setDamage();
         //this.setMaxDamage(384);
//         //this.setCreativeTab(CreativeTabs.COMBAT);
//         this.addPropertyOverride(new ResourceLocation("pull"), new IItemPropertyGetter()
//         {
//             @OnlyIn(Dist.CLIENT)
//             public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
//             {
//                 return entityIn == null ? 0.0F : (entityIn.getActiveItemStack().getItem() != Items.BOW ? 0.0F : (float)(stack.getMaxItemUseDuration() - entityIn.getItemInUseCount()) / 20.0F);
//             }
//         });
//         this.addPropertyOverride(new ResourceLocation("pulling"), new IItemPropertyGetter()
//         {
//             @OnlyIn(Dist.CLIENT)
//             public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
//             {
//                 return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
//             }
//         });
	}


//	@Override
//	public void registerRecipe() {
//		return;
//	}


	@Override
	public List<ClassInfo> GetUnfriendlyClasses() {

		// By default, we do not let force-wielding classes use blasters.
		return SuperDopeJediMod.CLASS_MANAGER.getForceWieldingClasses();
	}


	@Override
	public boolean IsUseUnfriendlyBanned() {

		// By default, all blasters are banned from the unfriendly classes, namely, the force-wielding classes.
		return true;
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
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {

		ItemStack itemstack = player.getHeldItem(hand);

		if (this.isInstantWeapon) {

			System.out.println("BaseBlaster:onItemRightClick: isInstantWeapon==true");

			int timeLeft = 0;
			SuperDopeJediMod.WEAPON_MANAGER.ThrowPlasmaShotAtDirection(world, player, this.powerLevel, 0);

			return new ActionResult(ActionResultType.SUCCESS, itemstack);
		} else {
			System.out.println("onItemRightClick: isInstantWeapon==false");

			boolean hasAmmo = true;
//	          ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, world, player, hand, hasAmmo);
//	          if (ret != null) return ret;
//
//	          if (!player.capabilities.isCreativeMode && !hasAmmo)
			//if (true){

			return hasAmmo ? new ActionResult(ActionResultType.PASS, itemstack) : new ActionResult(ActionResultType.FAIL, itemstack);
			//   }
//	          else
//	          {
//	              player.setActiveHand(hand);
//	              return new ActionResult(EnumActionResult.SUCCESS, itemstack);
//	          }
		}

		/**
		 * Return the enchantability factor of the item, most of the time is based on material.
		 */
//	      public int getItemEnchantability()
//	      {
//	          return 1;
//	      }

	}
}
