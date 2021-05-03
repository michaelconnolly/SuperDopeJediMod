package superdopesquad.superdopejedimod.entity.ship;


import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.ArrayList;
import java.util.List;


@OnlyIn(Dist.CLIENT)
public abstract class ShipModel<T extends Entity> extends SegmentedModel<T> {

    public static final int TEXTURE_WIDTH = 256;
    public static final int TEXTURE_HEIGHT = 256;

    //public ModelRenderer cockpit;
    public List<ModelRenderer> renderers = new ArrayList<ModelRenderer>();


//    public ModelRenderer head;
//    public ModelRenderer body;
//    public ModelRenderer arms;
//	public ModelRenderer rightLeg;
//	public ModelRenderer leftLeg;


//    public ModelRenderer classEmblem;
//    protected static boolean showClassEmblem = false;
//
//    protected static int TEXTURE_WIDTH = 64;
//    protected static int TEXTURE_HEIGHT = 64;


    @Override
    public void setupAnim(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {

    }


    @Override
    public Iterable<ModelRenderer> parts() {
        return this.renderers;

//        return ImmutableList.of(this.head, this.body, this.arms, this.leftLeg, this.rightLeg);
    }


}
