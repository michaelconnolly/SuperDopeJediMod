//package superdopesquad.superdopejedimod.entity;
//
//
////import net.minecraft.client.model.ModelBase;
////import net.minecraft.client.renderer.entity.LivingRenderer;
////import net.minecraft.client.renderer.entity.RenderLiving;
////import net.minecraft.client.renderer.entity.RenderManager;
////import net.minecraft.entity.Entity;
////import net.minecraft.entity.EntityLivingBase;
//import com.mojang.blaze3d.matrix.MatrixStack;
//import net.minecraft.client.renderer.entity.EntityRenderer;
//import net.minecraft.client.renderer.entity.EntityRendererManager;
//import net.minecraft.client.renderer.entity.LivingRenderer;
//import net.minecraft.client.renderer.entity.MobRenderer;
//import net.minecraft.client.renderer.entity.layers.CreeperChargeLayer;
//import net.minecraft.client.renderer.entity.model.CreeperModel;
//import net.minecraft.entity.monster.CreeperEntity;
//import net.minecraft.util.ResourceLocation;
//import net.minecraft.util.math.MathHelper;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//import net.minecraftforge.fml.client.registry.IRenderFactory;
//import superdopesquad.superdopejedimod.SuperDopeJediMod;
////import net.minecraftforge.fml.relauncher.Side;
////import net.minecraftforge.fml.relauncher.SideOnly;
////import superdopesquad.superdopejedimod.SuperDopeJediMod;
//
//
////@OnlyIn(Dist.CLIENT)
////public class CreeperRenderer extends MobRenderer<CreeperEntity, CreeperModel<CreeperEntity>> {
////    private static final ResourceLocation CREEPER_TEXTURES = new ResourceLocation("textures/entity/creeper/creeper.png");
////
////    public CreeperRenderer(EntityRendererManager renderManagerIn) {
////        super(renderManagerIn, new CreeperModel<>(), 0.5F);
////        this.addLayer(new CreeperChargeLayer(this));
////    }
////
////    protected void preRenderCallback(CreeperEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
////        float f = entitylivingbaseIn.getCreeperFlashIntensity(partialTickTime);
////        float f1 = 1.0F + MathHelper.sin(f * 100.0F) * f * 0.01F;
////        f = MathHelper.clamp(f, 0.0F, 1.0F);
////        f = f * f;
////        f = f * f;
////        float f2 = (1.0F + f * 0.4F) * f1;
////        float f3 = (1.0F + f * 0.1F) / f1;
////        matrixStackIn.scale(f2, f3, f2);
////    }
//
////    protected float getOverlayProgress(CreeperEntity livingEntityIn, float partialTicks) {
////        float f = livingEntityIn.getCreeperFlashIntensity(partialTicks);
////        return (int)(f * 10.0F) % 2 == 0 ? 0.0F : MathHelper.clamp(f, 0.5F, 1.0F);
////    }
//
//    /**
//     * Returns the location of an entity's texture.
//     */
////   // public ResourceLocation getEntityTexture(CreeperEntity entity) {
////        return CREEPER_TEXTURES;
////    }
////}
//
//
//@OnlyIn(Dist.CLIENT)
////public class WookieRender extends BaseRenderLiving {
//public class WookieRender extends MobRenderer<WookieEntity, WookieModel<WookieEntity>> {
//
//
//	public WookieRender(EntityRendererManager manager) { //}, ModelBase par1ModelBase, float parShadowSize) {
//
//	    super(manager, new WookieModel<>(), 0F);
//        //super(renderManager, par1ModelBase, parShadowSize, "wookie");
//    }
//
//
////    @Override
////    protected void preRenderCallback(EntityLivingBase entity, float f) {}
//
//    @Override
//    public ResourceLocation getEntityTexture(WookieEntity entity) {
//        //return null;
//        return new ResourceLocation(SuperDopeJediMod.MODID, "textures/entity/wookie.png");
//    }
////
////    public static class RenderFactory implements IRenderFactory<WookieEntity> {
////
////	    @Override
////        public EntityRenderer<? super WookieEntity> createRenderFor(EntityRendererManager manager) {
////	        return new WookieRender(manager);
////        }
////    }
//}