package superdopesquad.superdopejedimod.entity.droid;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


@OnlyIn(Dist.CLIENT)
public  class AssassinDroidModel<T extends Entity> extends DroidModel<T> {

    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer arms;
    public ModelRenderer rightLeg;
    public ModelRenderer leftLeg;

//    public ModelRenderer classEmblem;
//    private static boolean _showClassEmblem = false;
//
//    public static int textureWidth = 64;
//    public static int textureHeight = 64;


    public AssassinDroidModel() {

        this(1.0F, 0.0F, TEXTURE_WIDTH, TEXTURE_HEIGHT);
    }
//
//    @Override
//    public void setupAnim(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
//
//    }
//
//    public Iterable<ModelRenderer> parts() {
//        return ImmutableList.of(this.head, this.body, this.arms, this.leftLeg, this.rightLeg);
//    }

//
//    public AssassinDroidModel(float scale) {
//
//        this(scale, 0.0F, textureWidth, textureHeight);
//    }


    public AssassinDroidModel(float scale, float p_i1164_2_, int width, int height) {

        float yOffset = 0.0F;  // this is a grand hack, to push the model down, since at render time, i resize it.

        // Debug info.
        //System.out.println("DEBUG width:" + String.valueOf(width) + ", height:" + String.valueOf(height) + ", p_i1164_2_:" + String.valueOf(p_i1164_2_) + ", scale:" + String.valueOf(scale));

        this.head = (new ModelRenderer(this)).setTexSize(width, height);
        //this.head.setRotationPoint(0.0F, 0.0F + p_i1164_2_, 0.0F);
        this.head.texOffs(0, 0).addBox(-4.0F, (-8.0F + yOffset), -4.0F, 8, 8, 8, scale);
        this.renderers.add((head));


        // x: left (negative) and right (positive)
        // y: up (negative) and down (positive)
        // z: front (negative) and back (positive)
        // width: left to right distance
        // height: up and down distance
        // depth: front to back distance
        //public void addBox(float offX, float offY, float offZ, int width, int height, int depth, float scaleFactor)
        // public void setRotationPoint(float rotationPointXIn, float rotationPointYIn, float rotationPointZIn)

        this.body = (new ModelRenderer(this)).setTexSize(width, height);
       // this.body.setRotationPoint(0.0F, 0.0F + p_i1164_2_, 0.0F);
        this.body.setTexSize(16, 16).addBox(-4.0F, (0.0F + yOffset), -3.0F, 8, 12, 4, scale);
        this.renderers.add(body);

        this.rightLeg = (new ModelRenderer(this, 0, 16)).setTexSize(width, height);
       // this.rightLeg.setRotationPoint(-2.0F, 12.0F + p_i1164_2_, 0.0F);
        this.rightLeg.addBox(-2.0F, (0.0F + yOffset), -2.0F, 4, 12, 4, scale);
        this.renderers.add(rightLeg);

        this.leftLeg = (new ModelRenderer(this, 0, 16)).setTexSize(width, height);
        this.leftLeg.mirror = true;
       // this.leftLeg.setRotationPoint(2.0F, 12.0F + p_i1164_2_, 0.0F);
        this.leftLeg.addBox(-2.0F, (0.0F + yOffset), -2.0F, 4, 12, 4, scale);
        this.renderers.add(leftLeg);


        this.arms = (new ModelRenderer(this)).setTexSize(width, height);
        //this.arms.setRotationPoint(0.0F, 0.0F + p_i1164_2_ + 2.0F, 0.0F);
       // this.arms.setRotationPoint(0.0F, 0.0F + p_i1164_2_, 0.0F);
        this.arms.setTexSize(40, 16).addBox(-8.0F, (-2.0F + yOffset), -2.0F, 6, 12, 4, scale);
        this.arms.setTexSize(40, 16).addBox(4.0F, (-2.0F + yOffset), -2.0F, 4, 12, 4, scale);
        this.renderers.add(arms);



        if (showClassEmblem) {
            this.classEmblem = (new ModelRenderer(this)).setTexSize(width, height);
            //this.factionEmblem.setRotationPoint(0.0F, 0.0F + p_i1164_2_, 0.0F);
            this.classEmblem.setTexSize(16, 16).addBox(-4.0F, (-20.0F + yOffset), -3.0F, 2, 2, 2, scale);
        }
    }


    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
//    @Override
//    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
//
//       // this.head.rotateAngleY = netHeadYaw * 0.017453292F;
//        //this.head.rotateAngleX = headPitch * 0.017453292F;
//        this.head.yRot = netHeadYaw * 0.017453292F;
//        this.head.xRot = headPitch * 0.017453292F;
//
//        //this.arms.rotationPointY = 0.0F;
//        //this.arms.rotationPointZ = 0.0F;
//        //this.arms.rotateAngleX = 0.0F;
//        //this.arms.yRot = 0.0F;
//        //this.arms.ro = 0.0F;
//        this.arms.xRot = 0.0F;
//
////        this.rightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
////        this.leftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount * 0.5F;
////        this.rightLeg.rotateAngleY = 0.0F;
////        this.leftLeg.rotateAngleY = 0.0F;
//        this.rightLeg.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
//        this.leftLeg.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount * 0.5F;
//        this.rightLeg.yRot = 0.0F;
//        this.leftLeg.yRot = 0.0F;
//
//
//    }
}

