package superdopesquad.superdopejedimod.entity.droid;


import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.ModelHelper;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.monster.AbstractIllagerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.entity.Entity;


@OnlyIn(Dist.CLIENT)
public class ProtocolDroidModel<T extends Entity> extends DroidModel<T> {

    private ModelRenderer head = (new ModelRenderer(this));
    private ModelRenderer body = (new ModelRenderer(this));
    private ModelRenderer arms = (new ModelRenderer(this));
    private ModelRenderer rightLeg = (new ModelRenderer(this));
    private ModelRenderer leftLeg = (new ModelRenderer(this));


    public ProtocolDroidModel() {

        this(1.0F, 0.0F, TEXTURE_WIDTH, TEXTURE_HEIGHT);
    }


    public ProtocolDroidModel(float scale, float p_i1164_2_, int width, int height) {

        float yOffset = 0.0F;  // this is a grand hack, to push the model down, since at render time, i resize it.



        // Debug info.
        //System.out.println("DEBUG width:" + String.valueOf(width) + ", height:" + String.valueOf(height) + ", p_i1164_2_:" + String.valueOf(p_i1164_2_) + ", scale:" + String.valueOf(scale));

        // x: left (negative) and right (positive)
        // y: up (negative) and down (positive)
        // z: front (negative) and back (positive)
        // width: left to right distance
        // height: up and down distance
        // depth: front to back distance
        // addBox: (float offX, float offY, float offZ, int width, int height, int depth, float scaleFactor)
        // public void setRotationPoint(float rotationPointXIn, float rotationPointYIn, float rotationPointZIn)

        this.head.setTexSize(width, height);
        this.head.setPos(0.0F, 0.0F + p_i1164_2_, 0.0F);
        this.head.texOffs(0, 0);
        this.head.addBox(-4.0F, (-8.0F + yOffset), -4.0F, 8, 8, 8, scale);
        this.renderers.add(head);

        this.body.setTexSize(width, height);
        this.body.setPos(0.0F, 0.0F + p_i1164_2_, 0.0F);
        this.body.texOffs(16, 16);
        this.body.addBox(-4.0F, (0.0F + yOffset), -3.0F, 8, 12, 4, scale);
        this.renderers.add(body);

//        this.rightLeg = (new ModelRenderer(this, 0, 16)).setTextureSize(width, height);
//        this.rightLeg.setRotationPoint(-2.0F, 12.0F + p_i1164_2_, 0.0F);
//        this.rightLeg.addBox(-2.0F, (0.0F + yOffset), -2.0F, 4, 12, 4, scale);
//        this.leftLeg = (new ModelRenderer(this, 0, 16)).setTextureSize(width, height);
//        this.leftLeg.mirror = true;
//        this.leftLeg.setRotationPoint(2.0F, 12.0F + p_i1164_2_, 0.0F);
//        this.leftLeg.addBox(-2.0F, (0.0F + yOffset), -2.0F, 4, 12, 4, scale);


        this.rightLeg.setTexSize(width, height);
        //this.rightLeg.setPos(-2.0F, 12.0F + p_i1164_2_, 0.0F);
        this.rightLeg.addBox(-2.0F, (0.0F + yOffset), -2.0F, 4, 12, 4, scale);
        this.renderers.add(rightLeg);

        this.leftLeg.setTexSize(width, height);
        this.leftLeg.mirror = true;
        //this.leftLeg.setPos(2.0F, 12.0F + p_i1164_2_, 0.0F);
        this.leftLeg.addBox(-2.0F, (0.0F + yOffset), -2.0F, 4, 12, 4, scale);
        this.renderers.add(leftLeg);

        this.arms.setTexSize(width, height);
        //this.arms.setPos(0.0F, 0.0F + p_i1164_2_ + 2.0F, 0.0F);
       // this.arms.setRotationPoint(0.0F, 0.0F + p_i1164_2_, 0.0F);
        this.arms.texOffs(40, 16);
        this.arms.addBox(-8.0F, (-2.0F + yOffset), -2.0F, 6, 12, 4, scale);
        this.arms.texOffs(40, 16);
        this.arms.addBox(4.0F, (-2.0F + yOffset), -2.0F, 4, 12, 4, scale);
        this.renderers.add(arms);

        if (showClassEmblem) {
            this.classEmblem = (new ModelRenderer(this)).setTexSize(width, height);
            //this.factionEmblem.setRotationPoint(0.0F, 0.0F + p_i1164_2_, 0.0F);
            this.classEmblem.texOffs(16, 16).addBox(-4.0F, (-20.0F + yOffset), -3.0F, 2, 2, 2, scale);
        }
    }

    @Override
    public void setupAnim(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {

        this.head.yRot = p_225597_5_ * ((float) Math.PI / 180F);
        this.head.xRot = p_225597_6_ * ((float) Math.PI / 180F);

        //this.arms.y = 3.0F;
        //this.arms.z = -1.0F;
        this.arms.xRot = -0.75F;

        this.leftLeg.xRot = MathHelper.cos(p_225597_2_ * 0.6662F) * 1.4F * p_225597_3_ * 0.5F;
        this.leftLeg.yRot = 0.0F;
        this.leftLeg.zRot = 0.0F;

        this.rightLeg.xRot = MathHelper.cos(p_225597_2_ * 0.6662F + (float) Math.PI) * 1.4F * p_225597_3_ * 0.5F;
        this.rightLeg.yRot = 0.0F;
        this.rightLeg.zRot = 0.0F;
    }

    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
//    @Override
//    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
//
//        this.head.rotateAngleY = netHeadYaw * 0.017453292F;
//        this.head.rotateAngleX = headPitch * 0.017453292F;
//
//        this.arms.rotationPointY = 0.0F;
//        this.arms.rotationPointZ = 0.0F;
//        this.arms.rotateAngleX = 0.0F;
//
//        this.rightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
//        this.leftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount * 0.5F;
//        this.rightLeg.rotateAngleY = 0.0F;
//        this.leftLeg.rotateAngleY = 0.0F;
//    }



}

