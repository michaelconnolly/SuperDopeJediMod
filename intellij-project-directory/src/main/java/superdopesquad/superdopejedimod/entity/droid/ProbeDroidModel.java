package superdopesquad.superdopejedimod.entity.droid;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.ArrayList;
import java.util.List;


@OnlyIn(Dist.CLIENT)
public class ProbeDroidModel<T extends Entity> extends SegmentedModel<T> {

    /* Constants */
    public static int TEXTURE_WIDTH = 64; // The texture we are importing is a 64x64 PNG
    public static int TEXTURE_HEIGHT = 64;

    protected enum ArmDirection {FORWARD, BACKWARD, LEFTWARD, RIGHTWARD};

    /* Instance Members  */
    public ModelRenderer head;
    public ModelRenderer body;
    public List<ModelRenderer> arms = new ArrayList<ModelRenderer>();
    public List<ModelRenderer> arms2 = new ArrayList<ModelRenderer>();


    // CHEAT SHEET
    // x: left (negative) and right (positive)
    // y: up (negative) and down (positive)
    // z: front (negative) and back (positive)
    // width: left to right distance
    // height: up and down distance
    // depth: front to back distance
    // angles are in radians!


    /* */
    private void modelArms(ModelRenderer parent, float xOffset, float zOffset, boolean longStyle, ProbeDroidModel.ArmDirection armDirection, float angle, int i) {
        // hardcoded y offset, upperArms hanging right underneath the body.
        float yOffset = -1.5F;

        // Build the upper arm.
        int upperArmLength = 0;
        ModelRenderer upperArm = new ModelRenderer(this);
        upperArm.setTextureSize(TEXTURE_WIDTH, TEXTURE_HEIGHT);
        if (longStyle) {
            upperArmLength = 6;
            upperArm.setTextureOffset(4, 53);
        } else {
            upperArmLength = 4;
            upperArm.setTextureOffset(0, 53);
        }
        upperArm.addBox(0.0F, 0.0F, 0.0F, 1, upperArmLength, 1);
        upperArm.setRotationPoint(xOffset, yOffset, zOffset);  	// global space coordinate, upper arm is anchored right under the body,
        //  with xOffset and zOffset scattered across the edge on the yOffset plane.

        // Build the lower arm.
        ModelRenderer lowerArm = new ModelRenderer(this);
        lowerArm.setTextureSize(TEXTURE_WIDTH, TEXTURE_HEIGHT);
        lowerArm.setTextureOffset(0, 53);
        if (longStyle ) {
            lowerArm.setTextureOffset(4, 53);
        } else {
            lowerArm.setTextureOffset(0, 53);
        }
        lowerArm.addBox(0.0F, 0.0F, 0.0F, 1, upperArmLength, 1);

        float xCoord = 0.0F;
        float yCoord = 0.0F;
        float zCoord = 0.0F;
        switch (armDirection) {
            case BACKWARD:
                upperArm.rotateAngleX = angle;
                yCoord = (float) (((float) upperArmLength) * Math.cos(upperArm.rotateAngleX));
                zCoord = (float) (((float) upperArmLength) * Math.sin(upperArm.rotateAngleX));
                break;

            case FORWARD:
                upperArm.rotateAngleX = -angle;
                yCoord = (float) (((float) upperArmLength) * Math.cos(upperArm.rotateAngleX));
                zCoord = (float) (((float) upperArmLength) * Math.sin(upperArm.rotateAngleX));
                break;

            case RIGHTWARD:
                upperArm.rotateAngleZ = -angle;
                yCoord = (float) (((float) upperArmLength) * Math.cos(upperArm.rotateAngleZ));
                xCoord = (float) (((float) -upperArmLength) * Math.sin(upperArm.rotateAngleZ));
                break;

            case LEFTWARD:
                upperArm.rotateAngleZ = angle;
                yCoord = (float) (((float) upperArmLength) * Math.cos(upperArm.rotateAngleZ));
                xCoord = (float) (((float) -upperArmLength) * Math.sin(upperArm.rotateAngleZ));
                break;
        }
        lowerArm.setRotationPoint(xOffset + xCoord, yOffset + yCoord, zOffset + zCoord);

        this.arms.add(upperArm);
        this.arms2.add(lowerArm);
    }


    public ProbeDroidModel() {

        this(1.0F);
    }

    public Iterable<ModelRenderer> getParts() {

        List<ModelRenderer> listToReturn = new ArrayList<ModelRenderer>();

        listToReturn.add(this.head);
        listToReturn.add(this.body);

        for (int i=0; i< this.arms.size(); i++) {
            listToReturn.add(this.arms.get(i));
        }
        for (int i=0; i< this.arms2.size(); i++) {
            listToReturn.add(this.arms2.get(i));
        }

        return listToReturn;
    }


    public ProbeDroidModel(float scale) {

        this(scale, 0.0F, TEXTURE_WIDTH, TEXTURE_HEIGHT);
    }


    public ProbeDroidModel(float scale, float p_i1164_2_, int width, int height) {

            ModelRenderer subpart;

            // head, main
            subpart = new ModelRenderer(this, 0, 32);
            subpart.setTextureSize(TEXTURE_WIDTH, TEXTURE_HEIGHT);
            subpart.setRotationPoint(0.0F, 0.0F, 0.0F);
            subpart.addBox(-3.0F, -8.0F, -3.0F, 6, 4, 6);
            this.head = subpart;

            // head part 2
            subpart = new ModelRenderer(this, 24, 32);
            subpart.setTextureSize(TEXTURE_WIDTH, TEXTURE_HEIGHT);
            subpart.setRotationPoint(0.0F, 0.0F, 0.0F);
            subpart.addBox(-4.0F, -7.0F, -4.0F, 8, 2, 8);
            this.head.addChild(subpart);

            // body, main
            subpart = new ModelRenderer(this, 0, 20);
            subpart.setTextureSize(TEXTURE_WIDTH, TEXTURE_HEIGHT);
            subpart.setRotationPoint(0.0F, 0.0F, 0.0F);
            subpart.addBox(-5.0F, -4.0F, -5.0F, 10, 2, 10);
            this.body = subpart;

            // body part2
            subpart = new ModelRenderer(this, 32, 42);
            subpart.setTextureSize(TEXTURE_WIDTH, TEXTURE_HEIGHT);
            subpart.setRotationPoint(0.0F, 0.0F, 0.0F);
            subpart.addBox(-3.0F, -2.0F, -3.0F, 6, 1, 6);
            this.body.addChild(subpart);

            // arms
            modelArms(this.body, -1.0F, 2.0F, false,ProbeDroidModel.ArmDirection.BACKWARD,  0.8F, 0);
            modelArms(this.body, -2.0F, 1.0F, true,ProbeDroidModel.ArmDirection.LEFTWARD, 1.0F, 1);
            modelArms(this.body, -2.0F, -2.0F, false,ProbeDroidModel.ArmDirection.FORWARD, 0.9F, 2);
            modelArms(this.body, 0.0F, -2.0F, true,ProbeDroidModel.ArmDirection.FORWARD, .4F, 3);
            modelArms(this.body, 2.0F, -1.0F, false,ProbeDroidModel.ArmDirection.RIGHTWARD, 0.9F, 4);
            modelArms(this.body, 2.0F, 2.0F, true,ProbeDroidModel.ArmDirection.BACKWARD,  0.6F, 5);
        }

    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        // We allow the head to move left and right, but not up-and-down (this probe does not have a neck)
        if (this.head != null) {
            this.head.rotateAngleY = netHeadYaw * 0.017453292F; // degrees to radians
        }

        int i = 0;
        for (ModelRenderer subrenderer : arms2) {

            subrenderer.rotateAngleY = 0.0F;
            subrenderer.rotateAngleX = 0.0F;
            subrenderer.rotateAngleZ = 0.0F;

            // TODO: make this more random.
            if (i == 0) {
                subrenderer.rotateAngleX = .75F + MathHelper.cos(limbSwing /* * 0.6662F */) * 1.4F * limbSwingAmount * 1.0F;
            } else if (i < 3) {
                subrenderer.rotateAngleZ = MathHelper.cos(limbSwing /* * 0.6662F */) * 1.4F * limbSwingAmount * 1.0F;
            } else if (i < 4) {
                subrenderer.rotateAngleX = .75F + MathHelper.cos(limbSwing/* * 0.6662F*/ + (float)Math.PI) * 1.4F * limbSwingAmount * 1.0F;
            } else {
                subrenderer.rotateAngleZ = MathHelper.cos(limbSwing /** 0.6662F*/ + (float)Math.PI) * 1.4F * limbSwingAmount * 1.0F;
            }

            i++;
        }
    }
}

