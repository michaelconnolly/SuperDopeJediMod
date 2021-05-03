//package superdopesquad.superdopejedimod.entity;//package superdopesquad.superdopejedimod.entity;
////
////
////import net.minecraft.client.model.ModelBase;
////import net.minecraft.client.renderer.entity.RenderLiving;
////import net.minecraft.client.renderer.entity.RenderManager;
////import net.minecraft.entity.Entity;
////import net.minecraft.entity.EntityLivingBase;
////import net.minecraft.util.ResourceLocation;
////import net.minecraftforge.fml.relauncher.Side;
////import net.minecraftforge.fml.relauncher.SideOnly;
////import superdopesquad.superdopejedimod.SuperDopeJediMod;
////
//
//
//import com.mojang.blaze3d.matrix.MatrixStack;
//import net.minecraft.client.renderer.entity.EntityRendererManager;
//import net.minecraft.client.renderer.entity.MobRenderer;
//import net.minecraft.client.renderer.entity.layers.CreeperChargeLayer;
//import net.minecraft.client.renderer.entity.model.CreeperModel;
//import net.minecraft.entity.monster.CreeperEntity;
//import net.minecraft.util.ResourceLocation;
//import net.minecraft.util.math.MathHelper;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//
//@OnlyIn(Dist.CLIENT)
//public class JawaRender  extends MobRenderer<CreeperEntity, CreeperModel<CreeperEntity>> {
//    private static final ResourceLocation CREEPER_TEXTURES = new ResourceLocation("textures/entity/creeper/creeper.png");
//
//    public JawaRender(EntityRendererManager renderManagerIn) {
//        super(renderManagerIn, new CreeperModel<>(), 0.5F);
//        this.addLayer(new CreeperChargeLayer(this));
//    }
//
//    protected void preRenderCallback(CreeperEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
//        float f = entitylivingbaseIn.getCreeperFlashIntensity(partialTickTime);
//        float f1 = 1.0F + MathHelper.sin(f * 100.0F) * f * 0.01F;
//        f = MathHelper.clamp(f, 0.0F, 1.0F);
//        f = f * f;
//        f = f * f;
//        float f2 = (1.0F + f * 0.4F) * f1;
//        float f3 = (1.0F + f * 0.1F) / f1;
//        matrixStackIn.scale(f2, f3, f2);
//    }
//
//    protected float getOverlayProgress(CreeperEntity livingEntityIn, float partialTicks) {
//        float f = livingEntityIn.getCreeperFlashIntensity(partialTicks);
//        return (int)(f * 10.0F) % 2 == 0 ? 0.0F : MathHelper.clamp(f, 0.5F, 1.0F);
//    }
//
//    /**
//     * Returns the location of an entity's texture.
//     */
//    public ResourceLocation getEntityTexture(CreeperEntity entity) {
//        return CREEPER_TEXTURES;
//    }
//}
//
//
//
//
////
////@OnlyIn(Dist.CLIENT)
////public class JawaRender extends BaseRenderLiving {
////
////
////	public JawaRender(RenderManager renderManager, ModelBase par1ModelBase, float parShadowSize) {
////
////        super(renderManager, par1ModelBase, parShadowSize, "jawa");
////    }
////
////
////    @Override
////    protected void preRenderCallback(EntityLivingBase entity, float f) {
////
////    }
////}