package superdopesquad.superdopejedimod.entity.monster;


import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


@OnlyIn(Dist.CLIENT)
public abstract class MonsterModel<T extends Entity> extends SegmentedModel<T> {

    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer arms;
	public ModelRenderer rightLeg;
	public ModelRenderer leftLeg;


    public ModelRenderer classEmblem;
    protected static boolean showClassEmblem = false;

    protected static int TEXTURE_WIDTH = 64;
    protected static int TEXTURE_HEIGHT = 64;


    @Override
    public void setupAnim(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {

    }


    @Override
    public Iterable<ModelRenderer> parts() {

        return ImmutableList.of(this.head, this.body, this.arms, this.leftLeg, this.rightLeg);
    }


}
