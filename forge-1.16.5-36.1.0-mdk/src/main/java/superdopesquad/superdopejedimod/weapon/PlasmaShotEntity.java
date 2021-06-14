package superdopesquad.superdopejedimod.weapon;


import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


public class PlasmaShotEntity extends ProjectileItemEntity {


	public float damageAmount = 5.0F;

	// MC-TODO -- this is a hack because i can't get plasmashot workign properly, so
	// i'm using a snowball, and then just pasting the right item texture on top of it.

//	public PlasmaShotEntity(World p_i1774_1_, LivingEntity p_i1774_2_) {
//		//super(EntityManager.PLASMA_SHOT, p_i1774_2_, p_i1774_1_);
//		super(EntityManager.PLASMA_SHOT, p_i1774_2_, p_i1774_1_);
//	}
	public PlasmaShotEntity(World p_i1774_1_, LivingEntity p_i1774_2_) {
		super(EntityType.SNOWBALL, p_i1774_2_, p_i1774_1_);
	}

//	public PlasmaShotEntity(EntityType<? extends  ProjectileItemEntity> projectileEntityEntityType, World world) {
//		super(projectileEntityEntityType, world);
//	}
	public PlasmaShotEntity(EntityType<? extends ProjectileItemEntity> p_i50159_1_, World p_i50159_2_) {
		super(p_i50159_1_, p_i50159_2_);
	}


	// MC-TODO:
//	public static final EntityType<PlasmaShotEntity> TYPE =
//			EntityType.Builder.<PlasmaShotEntity>of(PlasmaShotEntity::new, EntityClassification.MISC)
//			.sized(0.98F, 0.7F)
//			.clientTrackingRange(8) //<--Problem area
//			.build(REG);
//	public static final AttributeModifierMap MAP = AttributeModifierMap.builder().add(Attributes.MAX_HEALTH, 20.0)
//			.add(Attributes.MOVEMENT_SPEED, 20.0)
//			.add(Attributes.FOLLOW_RANGE, 20.0)
//			.build();


//
//	public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
//
//		return MonsterEntity.createMonsterAttributes()
//				.add(Attributes.MAX_HEALTH, 0.0)
//				.add(Attributes.MOVEMENT_SPEED, 0.0)
//				.add(Attributes.ATTACK_DAMAGE, 0.0);
//	}


	protected Item getDefaultItem() {

		return Items.SNOWBALL;
		//return WeaponManager.PLASMA_SHOT_ITEM_BLUE;
	}


	@OnlyIn(Dist.CLIENT)
	private IParticleData getParticle() {
		ItemStack itemstack = this.getItemRaw();
		return (IParticleData) (itemstack.isEmpty() ? ParticleTypes.ITEM_SNOWBALL : new ItemParticleData(ParticleTypes.ITEM, itemstack));
	}


	@OnlyIn(Dist.CLIENT)
	public void handleEntityEvent(byte p_70103_1_) {
		if (p_70103_1_ == 3) {
			IParticleData iparticledata = this.getParticle();

			for (int i = 0; i < 8; ++i) {
				this.level.addParticle(iparticledata, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
			}
		}

	}


	protected void onHitEntity(EntityRayTraceResult p_213868_1_) {

		super.onHitEntity(p_213868_1_);
		Entity entity = p_213868_1_.getEntity();
		entity.hurt(DamageSource.thrown(this, this.getOwner()), this.damageAmount);
	}


	protected void onHit(RayTraceResult p_70227_1_) {

		super.onHit(p_70227_1_);
		if (!this.level.isClientSide) {
			this.level.broadcastEntityEvent(this, (byte) 3);
			this.remove();
		}
	}
}
