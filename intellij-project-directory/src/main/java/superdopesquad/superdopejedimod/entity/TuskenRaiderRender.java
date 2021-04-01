package superdopesquad.superdopejedimod.entity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import superdopesquad.superdopejedimod.SuperDopeJediMod;

@OnlyIn(Dist.CLIENT)
//public class WookieRender extends BaseRenderLiving {
//public class WookieRender extends LivingRenderer<WookieEntity, WookieModel> {
public class TuskenRaiderRender extends LivingRenderer<TuskenRaiderEntity, TuskenRaiderModel> {
   // public class WookieRender extends LivingRenderer<WookieEntity, WookieModel> {


    public TuskenRaiderRender(EntityRendererManager manager) { //}, ModelBase par1ModelBase, float parShadowSize) {

        super(manager, new TuskenRaiderModel(), 0F);
        //super(renderManager, par1ModelBase, parShadowSize, "wookie");
    }


//    @Override
//    protected void preRenderCallback(EntityLivingBase entity, float f) {}

    @Override
    public ResourceLocation getEntityTexture(TuskenRaiderEntity entity) {
        //return null;
        return new ResourceLocation(SuperDopeJediMod.MODID, "textures/entity/wookie_entity.png");
    }


    public static class RenderFactory implements IRenderFactory<TuskenRaiderEntity> {

        @Override
        public EntityRenderer<? super TuskenRaiderEntity> createRenderFor(EntityRendererManager manager) {
            return new TuskenRaiderRender(manager);
        }
    }

//
//    public static class RenderFactory implements IRenderFactory<TuskenRaiderEntity> {
//
//        @Override
//        public EntityRenderer<? super TuskenRaiderEntity> createRenderFor(EntityRendererManager manager) {
//            return new superdopesquad.superdopejedimod.entity.TuskenRaiderRender(manager);
//        }
//    }
}



//package superdopesquad.superdopejedimod.entity;
//
//import net.minecraft.client.model.ModelBase;
//import net.minecraft.client.renderer.entity.RenderLiving;
//import net.minecraft.client.renderer.entity.RenderManager;
//import net.minecraft.entity.Entity;
//import net.minecraft.entity.EntityLivingBase;
//import net.minecraft.util.ResourceLocation;
//import net.minecraftforge.fml.relauncher.Side;
//import net.minecraftforge.fml.relauncher.SideOnly;
//import superdopesquad.superdopejedimod.SuperDopeJediMod;
//
//
//@OnlyIn(Dist.CLIENT)
//public class TuskanRaiderRender extends BaseRenderLiving {
//
//
//	public TuskanRaiderRender(RenderManager renderManager, ModelBase par1ModelBase, float parShadowSize) {
//
//        super(renderManager, par1ModelBase, parShadowSize, "tuskanraider3");
//    }
//
//
//    @Override
//    protected void preRenderCallback(EntityLivingBase entity, float f) {
//
//    }
//}