package superdopesquad.superdopejedimod.weapon;


import java.util.List;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import superdopesquad.superdopejedimod.SuperDopeObject;
import superdopesquad.superdopejedimod.SuperDopeJediMod;
import superdopesquad.superdopejedimod.entity.EntityManager;
import superdopesquad.superdopejedimod.faction.*;


public class Blaster extends DopeRangedWeapon implements SuperDopeObject, ClassAwareInterface {


	//protected boolean isInstantWeapon = true;
	protected PowerLevel powerLevel; // = PowerLevel.STANDARD;
	protected float range; // = 10.0F;


	public Blaster(String name) {

		//super(name);
		this(name, PowerLevel.STANDARD, 10.0F);
	}

	public Blaster(String name, PowerLevel powerLevel, float range) {

		super(name);
	}

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
//	}

	public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {

		System.out.println("inside Blaster:use");

		if (true) {

			// The item object for the plasma blast we shoot out.
			ItemStack itemstack = WeaponManager.PLASMA_SHOT_ITEM_BLUE.getDefaultInstance();
			ItemStack itemStackInHand = player.getItemInHand(hand);

			// Play a sound.
			world.playSound((PlayerEntity)null, player.getX(), player.getY(), player.getZ(),
					SoundEvents.FIREWORK_ROCKET_SHOOT, SoundCategory.NEUTRAL,
					0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));

			// Create the entity of the plasma blast and set it's trajectory.
			if (!world.isClientSide) {

				// SnowballEntity snowballentity = new SnowballEntity(world, player);
				//PlasmaShotEntity plasmaShotEntity = new PlasmaShotEntity(world, player);

				//PlasmaShotEntity plasmaShotEntity = new EntityManager.PLASMA_SHOT.clone();
				//SnowballEntity plasmaShotEntity = new
				//PlasmaShotEntity plasmaShotEntity = new PlasmaShotEntity(world, player, this.powerLevel.damageLevel());
				PlasmaShotEntity plasmaShotEntity = new PlasmaShotEntity(world, player);

				//plasmaShotEntity.damageAmount = this.powerLevel.damageLevel();

				//snowballentity.setItem(WeaponManager.PLASMA_SHOT_ITEM_BLUE.getDefaultInstance());
				plasmaShotEntity.setItem(WeaponManager.PLASMA_SHOT_ITEM_BLUE.getDefaultInstance());

				//snowballentity.shootFromRotation(player, player.xRot, player.yRot,
				//		0.0F, 1.5F, 1.0F);
				plasmaShotEntity.shootFromRotation(player, player.xRot, player.yRot,
						0.0F, 1.5F, 1.0F);

				//world.addFreshEntity(snowballentity);
				world.addFreshEntity(plasmaShotEntity);
			}

			return ActionResult.sidedSuccess(itemStackInHand, world.isClientSide());
		}


//		RayTraceResult lookingAt = Minecraft.getMinecraft().objectMouseOver;
//		if (lookingAt != null && lookingAt.typeOfHit == RayTraceResult.Type.BLOCK) {
//			BlockPos pos = lookingAt.getBlockPos();
//			// now the coordinates you want are in pos. Example of use:
//			worldIn.setBlockState(pos, Blocks.BEDROCK.getDefaultState());
//			// this is a bit oversimplified - you have to send a packet to the server, since only the client knows the BlockPos, but only the server can change blocks
//		} else {
//			// not looking at a block, or too far away from one to tell
//		}
//

		ItemStack itemStackCurrentItem = player.getItemInHand(hand);

		// MC-TODO: figure out better starting position.
		BlockPos blockPos = player.blockPosition();

		//BlockPos blockPos = itemStackCurrentItem.getFrame().getPos();
		boolean isWorldServer = (!world.isClientSide);
		boolean shouldShoot = ((isWorldServer) && (hand == Hand.MAIN_HAND));

		if (shouldShoot) {


			// Create the new entity.
			//ItemStack itemStackCurrentItem = context.getItemInHand();
			if (EntityManager.PROTOCOL_DROID.spawn((ServerWorld) world, itemStackCurrentItem, player, blockPos, SpawnReason.SPAWN_EGG, false, false) == null) {
				System.out.println("ERROR! Failed to spawn droid.");
				return ActionResult.fail(itemStackCurrentItem);
				//return ActionResultType.FAIL;
			}

			return ActionResult.success(itemStackCurrentItem);

//			// Create the new entity.
//			ItemStack itemStackCurrentItem = context.getItemInHand();
//			if (this.entityType.spawn((ServerWorld) world, itemStackCurrentItem, player, blockPos, SpawnReason.SPAWN_EGG, false, false) == null) {
//				System.out.println("ERROR! Failed to spawn droid.");
//				return ActionResultType.FAIL;
//			}
		}

		return ActionResult.pass(itemStackCurrentItem);

//		ItemStack itemstack = player.getItemInHand(p_77659_3_);
//		boolean flag = !player.getProjectile(itemstack).isEmpty();

//		ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, p_77659_1_, player, p_77659_3_, flag);
//		if (ret != null) return ret;
//
//		if (!player.abilities.instabuild && !flag) {
//			return ActionResult.fail(itemstack);
//		} else {
//			player.startUsingItem(p_77659_3_);
//			return ActionResult.consume(itemstack);
//		}
	}


	public void releaseUsing(ItemStack p_77615_1_, World p_77615_2_, LivingEntity p_77615_3_, int p_77615_4_) {

		System.out.println("inside Blaster:releaseUsing");
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

	/**
	 * Return the enchantability factor of the item, most of the time is based on material.
	 */
//	      public int getItemEnchantability()
//	      {
//	          return 1;
//	      }

	}

