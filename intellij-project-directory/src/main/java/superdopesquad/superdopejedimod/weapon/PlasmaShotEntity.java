package superdopesquad.superdopejedimod.weapon;


//import net.minecraft.client.renderer.GlStateManager;
//import net.minecraft.client.renderer.RenderItem;
//import net.minecraft.client.renderer.entity.Render;
//import net.minecraft.client.renderer.entity.RenderManager;
//import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.Entity;
//import net.minecraft.entity.EntityLiving;
//import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.LivingEntity;
//import net.minecraft.entity.monster.EntityBlaze;
//import net.minecraft.entity.projectile.EntitySnowball;
//import net.minecraft.entity.projectile.EntityThrowable;
//import net.minecraft.init.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
//import net.minecraft.util.EnumFacing;
//import net.minecraft.util.EnumParticleTypes;
//import net.minecraft.util.datafix.DataFixer;
		import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
//import net.minecraftforge.fml.relauncher.Side;
//import net.minecraftforge.fml.relauncher.SideOnly;
//import superdopesquad.superdopejedimod.entity.EntityRenderFactory;
//import superdopesquad.superdopejedimod.entity.monster.JawaModel;
//import superdopesquad.superdopejedimod.entity.JawaRender;
//import superdopesquad.superdopejedimod.entity.SuperDopeRenderManager;


public class PlasmaShotEntity extends BaseEntityProjectile {

//	public enum PowerLevel {
//	  STANDARD(2.0D, 1.6D, 12.0D),
//	  RIFLE(4.0D, 1.6D, 12.0D),
//	  CANNON(6.0D, 1.6D, 12.0D),
//	  HEAVY(25.0D, 5.0D, 5.0D);
//
//	  private final double damage;
//	  private final double velocity;
//	  private final double accuracy;
//
//	  public double damage() { return damage; }
//	  public double velocity() { return velocity; }
//	  public double accuracy() { return accuracy; }
//
//	  PowerLevel(double damage, double velocity, double accuracy) {
//		  this.damage = damage;
//		  this.velocity = velocity;
//		  this.accuracy = accuracy;
//	  }
//	}

	// Instance Members
	private PowerLevel _powerLevel;


	/**
	 * constructor
	 */
//	public PlasmaShotEntity(World worldIn) {
//		super(worldIn, (float) PowerLevel.STANDARD.damage());
//		this._powerLevel = PowerLevel.STANDARD;
//	}
	public PlasmaShotEntity(String color) {
		//super(worldIn, (float) PowerLevel.STANDARD.damage());
		super(null, (float) PowerLevel.STANDARD.damage());
		this._powerLevel = PowerLevel.STANDARD;
	}

	/**
	 * constructor
	 */
	public PlasmaShotEntity(World worldIn, LivingEntity throwerIn, PowerLevel pl) {
		super(worldIn, throwerIn, (float) pl.damage());
		this._powerLevel = pl;
	}

//    @Override
//	public String getName() {
//		return "plasmaShotEntity";
//	}


    @Override
    protected void registerData() {

    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void handleStatusUpdate(byte id) {

    	//System.out.println("inside handleStatusUpdate: " + id);

        if (id == 3)
        {
            for (int i = 0; i < 8; ++i)
            {
                //this.world.spawnParticle(EnumParticleTypes.CLOUD, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
                //this.world.addParticle(ParticleTypes.CLOUD, this.getPosX(), this.getPosY(), this.getPosZ(), 0.0D, 0.0D, 0.0D, new int[0]);
                this.world.addParticle(ParticleTypes.CLOUD, this.getPosX(), this.getPosY(), this.getPosZ(), 0.0D, 0.0D, 0.0D);
            }
        }
    }


    protected void onImpact(RayTraceResult result) {

    	// Bail on this 'impact' if it is with the thrower.
    //	if ((result.hitInfo != null) && (result.hitInfo.equals(this.getThrower()))) {
        //    if ((result.hitInfo != null) && (result.hitInfo.equals(this.th()))) {
                //System.out.println("Inside onImpact: bailing, entityHit == this.getThrower()");
    	//	return;
    	//}

//	    	// Debug info.
//	    	BlockPos blockPos = result.getBlockPos();
//	    	Object hitInfo = result.hitInfo;
//	    	String typeOfHit = result.typeOfHit.name();
//	    	EnumFacing sideHit = result.sideHit;
//	    	int subHit = result.subHit;
//	    	System.out.println("Inside onImpact:" + result.toString());
//	    	System.out.println("Inside onImpact: typeOfHit:" + typeOfHit.toString());
//	    	if (sideHit != null) {
//	    		System.out.println("Inside onImpact: sideHit:" + sideHit.getName());
//	    	}
//	    	if (blockPos != null) {
//	    		System.out.println("blockPos:" + blockPos.toString());
//	    	}
//	    	System.out.println("Inside onImpact: subHit:" + subHit);
//	    	if (hitInfo != null) {
//	    		System.out.println("hitInfo:" + hitInfo.toString());
//	    	}

        // If we are on the server, update state information to kill this projectile.
        if (!this.world.isRemote)
        {
        	// if we hit an entity, let's do some damage.
	        if (result.hitInfo != null) {
		    	System.out.println("BUG: Inside onImpact; need to implement damage: entityHit:" + result.hitInfo.toString());
	            //result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float) this.getDamage());
	        }

            this.world.setEntityState(this, (byte)3);
            this.setDead();
        }
    }


    public void setAim(Entity shooter, float pitch, float yaw, float p_184547_4_, float velocity, float inaccuracy)
    {
        float f = -MathHelper.sin(yaw * 0.017453292F) * MathHelper.cos(pitch * 0.017453292F);
        float f1 = -MathHelper.sin(pitch * 0.017453292F);
        float f2 = MathHelper.cos(yaw * 0.017453292F) * MathHelper.cos(pitch * 0.017453292F);

        //System.out.print(("NYI! PlasmaShotEntity:setAim()"));
        ///this.set
        //this.setThrowableHeading((double)f, (double)f1, (double)f2, velocity, inaccuracy);
        //this.setT
        //this.motionX += shooter.motionX;
        //this.motionZ += shooter.motionZ;

        double motionX = shooter.getMotion().x;
        double motionY = ((shooter.isOnGround()) ? 0 : shooter.getMotion().y);
        double motionZ = shooter.getMotion().z;


        // making this shit up lets see what happens.
        System.out.println("MC-TO-DO: test PlasmaShotEntity::setAim()");
        this.setMotion(motionX, motionY, motionZ);
        this.setVelocity(f, f1, f2);

//     //   if (!shooter.onGround) {
//            if (!(shooter.isOnGround())) {
//
//                this.mo += shooter.motionY;
//            }
    }
}
