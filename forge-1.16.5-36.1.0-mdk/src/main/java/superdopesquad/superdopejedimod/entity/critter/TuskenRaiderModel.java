package superdopesquad.superdopejedimod.entity.critter;


import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


// Note: if you want to have items in your entity's hands get rendered for you,
// you should be a daughter class of ModelBiped, not ModelBase.

@OnlyIn(Dist.CLIENT)
public class TuskenRaiderModel<T extends Entity> extends CritterModel<T> {

     ModelRenderer head;
     ModelRenderer body;
     ModelRenderer arms;
     ModelRenderer rightLeg;
     ModelRenderer leftLeg;
     ModelRenderer spikeForeheadLeft;
     ModelRenderer spikeForeheadRight;
     ModelRenderer spikeBackheadLeft;
     ModelRenderer spikeBackheadRight;

//    public static int textureWidth = 64;
//    public static int textureHeight = 64;


    public TuskenRaiderModel() {

    	this(1.0F, 0.0F, TEXTURE_WIDTH, TEXTURE_HEIGHT);
    }


    public TuskenRaiderModel(float scale, float p_i1164_2_, int width, int height) {

        float yOffsetHeadSpike = -10.0F;
    	int textureOffsetSpikeX = 0;
    	int textureOffsetSpikeY = 32;

    	// Debug info.
    	//System.out.println("DEBUG width:" + String.valueOf(width) + ", height:" + String.valueOf(height) + ", p_i1164_2_:" + String.valueOf(p_i1164_2_) + ", scale:" + String.valueOf(scale));

        this.head = (new ModelRenderer(this)).setTexSize(width, height);
        //this.head.setRotationPoint(0.0F, 0.0F + p_i1164_2_, 0.0F);
        this.head.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, scale);
        this.renderers.add(head);


        // x: left (negative) and right (positive)
        // y: up (negative) and down (positive)
        // z: front (negative) and back (positive)
        // width: left to right distance
        // height: up and down distance
        // depth: front to back distance
        //public void addBox(float offX, float offY, float offZ, int width, int height, int depth, float scaleFactor)
        // public void setRotationPoint(float rotationPointXIn, float rotationPointYIn, float rotationPointZIn)

        this.spikeForeheadLeft = (new ModelRenderer(this)).setTexSize(width, height);
       // this.spikeForeheadLeft.setRotationPoint(0.0F, p_i1164_2_, 0.0F);
        this.spikeForeheadLeft.texOffs(textureOffsetSpikeX, textureOffsetSpikeY).addBox(-3.5F, yOffsetHeadSpike, -3.5F, 1, 1, 1, scale);
        this.head.addChild(this.spikeForeheadLeft);

        this.spikeForeheadRight = (new ModelRenderer(this)).setTexSize(width, height);
        //this.spikeForeheadRight.setRotationPoint(0.0F, p_i1164_2_, 0.0F);
        this.spikeForeheadRight.texOffs(textureOffsetSpikeX, textureOffsetSpikeY).addBox(2.5F, yOffsetHeadSpike, -3.5F, 1, 1, 1, scale);
        this.head.addChild(this.spikeForeheadRight);

        this.spikeBackheadLeft = (new ModelRenderer(this)).setTexSize(width, height);
        //this.spikeBackheadLeft.setRotationPoint(0.0F, p_i1164_2_, 0.0F);
        this.spikeBackheadLeft.texOffs(textureOffsetSpikeX, textureOffsetSpikeY).addBox(-3.5F, yOffsetHeadSpike, 2.50F, 1, 1, 1, scale);
        this.head.addChild(this.spikeBackheadLeft);

        this.spikeBackheadRight = (new ModelRenderer(this)).setTexSize(width, height);
       // this.spikeBackheadRight.setRotationPoint(0.0F, p_i1164_2_, 0.0F);
        this.spikeBackheadRight.texOffs(textureOffsetSpikeX, textureOffsetSpikeY).addBox(2.5F, yOffsetHeadSpike, 2.50F, 1, 1, 1, scale);
        this.head.addChild(this.spikeBackheadRight);


//        // spikeFaceLeft
//        this.spikeFaceLeft = (new ModelRenderer(this)).setTextureSize(width, height);
//        this.spikeFaceLeft.setRotationPoint(0.0F, p_i1164_2_, 0.0F);
//        this.spikeFaceLeft.setTextureOffset(24, 0).addBox(-3.5F, yOffsetHeadSpike, -6.0F, 1, 1, 1, scale);
//        this.villagerHead.addChild(this.spikeFaceLeft);
//
//        this.spikeFaceRight = (new ModelRenderer(this)).setTextureSize(width, height);
//        this.spikeFaceRight.setRotationPoint(0.0F, p_i1164_2_, 0.0F);
//        this.spikeFaceRight.setTextureOffset(24, 0).addBox(2.5F, yOffsetHeadSpike, -6.0F, 1, 1, 1, scale);
//        this.villagerHead.addChild(this.spikeFaceRight);
//
//        this.mouth = (new ModelRenderer(this)).setTextureSize(width, height);
//        this.mouth.setRotationPoint(0.0F, p_i1164_2_, 0.0F);
//        this.mouth.setTextureOffset(24, 0).addBox(-5.0F, yOffsetHeadSpike, 2.50F, 1, 1, 1, scale);
//        this.villagerHead.addChild(this.mouth);



//        this.villagerNose = (new ModelRenderer(this)).setTextureSize(width, height);
//        this.villagerNose.setRotationPoint(0.0F, p_i1164_2_ - 2.0F, 0.0F);
//        this.villagerNose.setTextureOffset(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2, 4, 2, scale);
//        this.villagerHead.addChild(this.villagerNose);


        this.body = (new ModelRenderer(this)).setTexSize(width, height);
        //this.body.setRotationPoint(0.0F, 0.0F + p_i1164_2_, 0.0F);
        this.body.texOffs(16, 16).addBox(-4.0F, 0.0F, -3.0F, 8, 12, 4, scale);
        //this.villagerBody.setTextureOffset(0, 38).addBox(-4.0F, 0.0F, -3.0F, 8, 18, 6, scale + 0.5F);
        this.renderers.add(body);


        this.rightLeg = (new ModelRenderer(this, 0, 16)).setTexSize(width, height);
        //this.rightLeg.setRotationPoint(-2.0F, 12.0F + p_i1164_2_, 0.0F);
        this.rightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, scale);
        this.renderers.add(rightLeg);


        this.leftLeg = (new ModelRenderer(this, 0, 16)).setTexSize(width, height);
        this.leftLeg.mirror = true;
        //this.leftLeg.setRotationPoint(2.0F, 12.0F + p_i1164_2_, 0.0F);
        this.leftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, scale);
        this.renderers.add(leftLeg);


        this.arms = (new ModelRenderer(this)).setTexSize(width, height);
    	//this.arms.setRotationPoint(0.0F, 0.0F + p_i1164_2_ + 2.0F, 0.0F);
     	this.arms.texOffs(40, 16).addBox(-8.0F, -2.0F, -2.0F, 4, 8, 4, scale);
    	this.arms.texOffs(40, 16).addBox(4.0F, -2.0F, -2.0F, 4, 8, 4, scale);
        this.renderers.add(arms);

        //this.villagerArms.setTextureOffset(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4, 8, 4, scale);
    	//this.villagerArms.setTextureOffset(44, 22).addBox(4.0F, -2.0F, -2.0F, 4, 8, 4, scale);
    	//this.villagerArms.setTextureOffset(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8, 4, 4, scale);
    }


//
//    public Iterable<ModelRenderer> getParts() {
//        return ImmutableList.of(this.head, this.body, this.arms, this.leftLeg, this.rightLeg,
//                this.spikeForeheadLeft, this.spikeForeheadRight, this.spikeBackheadLeft, this.spikeBackheadRight);
//    }


    /**
     * Sets the models various rotation angles then renders the model.
     */
//    @Override
//    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
//
//    	this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
//        this.head.render(scale);
//        this.body.render(scale);
//        this.rightLeg.render(scale);
//        this.leftLeg.render(scale);
//        this.arms.render(scale);
//    }


    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
//    @Override
//    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
//
//    }

//    @Override
//    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
//    {
//        this.head.rotateAngleY = netHeadYaw * 0.017453292F;
//        this.head.rotateAngleX = headPitch * 0.017453292F;
//
//        this.arms.rotationPointY = 3.0F;
//    	this.arms.rotationPointZ = -1.0F;
//    	this.arms.rotateAngleX = -0.75F;
//
//        this.rightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
//        this.leftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount * 0.5F;
//        this.rightLeg.rotateAngleY = 0.0F;
//        this.leftLeg.rotateAngleY = 0.0F;
//    }
}