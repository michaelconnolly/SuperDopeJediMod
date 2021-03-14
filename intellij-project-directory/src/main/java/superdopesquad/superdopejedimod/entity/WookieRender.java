package superdopesquad.superdopejedimod.entity;


//import net.minecraft.client.model.ModelBase;
//import net.minecraft.client.renderer.entity.LivingRenderer;
//import net.minecraft.client.renderer.entity.RenderLiving;
//import net.minecraft.client.renderer.entity.RenderManager;
//import net.minecraft.entity.Entity;
//import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import superdopesquad.superdopejedimod.SuperDopeJediMod;
//import net.minecraftforge.fml.relauncher.Side;
//import net.minecraftforge.fml.relauncher.SideOnly;
//import superdopesquad.superdopejedimod.SuperDopeJediMod;


@OnlyIn(Dist.CLIENT)
//public class WookieRender extends BaseRenderLiving {
public class WookieRender extends LivingRenderer<WookieEntity, WookieModel> {


	public WookieRender(EntityRendererManager manager) { //}, ModelBase par1ModelBase, float parShadowSize) {

	    super(manager, new WookieModel(), 0F);
        //super(renderManager, par1ModelBase, parShadowSize, "wookie");
    }


//    @Override
//    protected void preRenderCallback(EntityLivingBase entity, float f) {}

    @Override
    public ResourceLocation getEntityTexture(WookieEntity entity) {
        //return null;
        return new ResourceLocation(SuperDopeJediMod.MODID, "textures/entity/wookie_entity.png");
    }

    public static class RenderFactory implements IRenderFactory<WookieEntity> {
	    @Override
        public EntityRenderer<? super WookieEntity> createRenderFor(EntityRendererManager manager) {
	        return new WookieRender(manager);
        }
    }
}