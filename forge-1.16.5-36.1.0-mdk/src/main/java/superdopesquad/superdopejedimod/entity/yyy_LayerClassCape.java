//package superdopesquad.superdopejedimod.entity;
//
//
//import com.mojang.blaze3d.matrix.MatrixStack;
//import net.minecraft.client.renderer.IRenderTypeBuffer;
//import net.minecraft.client.renderer.entity.PlayerRenderer;
//import net.minecraft.client.renderer.entity.layers.LayerRenderer;
//import net.minecraft.entity.Entity;
//import net.minecraft.entity.LivingEntity;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.util.ResourceLocation;
//import net.minecraft.util.math.MathHelper;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//import superdopesquad.superdopejedimod.SuperDopeJediMod;
//import superdopesquad.superdopejedimod.faction.ClassInfo;
//import com.mojang.blaze3d.vertex.IVertexBuilder;
//import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
//import net.minecraft.client.renderer.RenderType;
//import net.minecraft.client.renderer.entity.IEntityRenderer;
//import net.minecraft.client.renderer.entity.model.PlayerModel;
//import net.minecraft.client.renderer.texture.OverlayTexture;
//import net.minecraft.entity.player.PlayerModelPart;
//import net.minecraft.inventory.EquipmentSlotType;
//import net.minecraft.item.ItemStack;
//import net.minecraft.item.Items;
//import net.minecraft.util.math.vector.Vector3f;
//
//
//@OnlyIn(Dist.CLIENT)
//public class LayerClassCape extends LayerRenderer<AbstractClientPlayerEntity, PlayerModel<AbstractClientPlayerEntity>> {
//
//
//    private final PlayerRenderer playerRenderer;
//
//
////    public LayerClassCape(PlayerRenderer playerRendererIn)
////    {
////        this.playerRenderer = playerRendererIn;
////    }
//
//
//    public LayerClassCape(IEntityRenderer<AbstractClientPlayerEntity,
//            PlayerModel<AbstractClientPlayerEntity>> p_i50950_1_, PlayerRenderer playerRenderer) {
//
//        super(p_i50950_1_);
//
//        this.playerRenderer = playerRenderer;
//    }
//
//
//    public void render(MatrixStack p_225628_1_, IRenderTypeBuffer p_225628_2_, int p_225628_3_,
//                       AbstractClientPlayerEntity p_225628_4_, float p_225628_5_, float p_225628_6_,
//                       float p_225628_7_, float p_225628_8_, float p_225628_9_, float p_225628_10_) {
//
//        if (p_225628_4_.isCapeLoaded() && !p_225628_4_.isInvisible() && p_225628_4_.isModelPartShown(PlayerModelPart.CAPE) && p_225628_4_.getCloakTextureLocation() != null) {
//            ItemStack itemstack = p_225628_4_.getItemBySlot(EquipmentSlotType.CHEST);
//            if (itemstack.getItem() != Items.ELYTRA) {
//                p_225628_1_.pushPose();
//                p_225628_1_.translate(0.0D, 0.0D, 0.125D);
//                double d0 = MathHelper.lerp((double)p_225628_7_, p_225628_4_.xCloakO, p_225628_4_.xCloak) - MathHelper.lerp((double)p_225628_7_, p_225628_4_.xo, p_225628_4_.getX());
//                double d1 = MathHelper.lerp((double)p_225628_7_, p_225628_4_.yCloakO, p_225628_4_.yCloak) - MathHelper.lerp((double)p_225628_7_, p_225628_4_.yo, p_225628_4_.getY());
//                double d2 = MathHelper.lerp((double)p_225628_7_, p_225628_4_.zCloakO, p_225628_4_.zCloak) - MathHelper.lerp((double)p_225628_7_, p_225628_4_.zo, p_225628_4_.getZ());
//                float f = p_225628_4_.yBodyRotO + (p_225628_4_.yBodyRot - p_225628_4_.yBodyRotO);
//                double d3 = (double)MathHelper.sin(f * ((float)Math.PI / 180F));
//                double d4 = (double)(-MathHelper.cos(f * ((float)Math.PI / 180F)));
//                float f1 = (float)d1 * 10.0F;
//                f1 = MathHelper.clamp(f1, -6.0F, 32.0F);
//                float f2 = (float)(d0 * d3 + d2 * d4) * 100.0F;
//                f2 = MathHelper.clamp(f2, 0.0F, 150.0F);
//                float f3 = (float)(d0 * d4 - d2 * d3) * 100.0F;
//                f3 = MathHelper.clamp(f3, -20.0F, 20.0F);
//                if (f2 < 0.0F) {
//                    f2 = 0.0F;
//                }
//
//                float f4 = MathHelper.lerp(p_225628_7_, p_225628_4_.oBob, p_225628_4_.bob);
//                f1 = f1 + MathHelper.sin(MathHelper.lerp(p_225628_7_, p_225628_4_.walkDistO, p_225628_4_.walkDist) * 6.0F) * 32.0F * f4;
//                if (p_225628_4_.isCrouching()) {
//                    f1 += 25.0F;
//                }
//
//                p_225628_1_.mulPose(Vector3f.XP.rotationDegrees(6.0F + f2 / 2.0F + f1));
//                p_225628_1_.mulPose(Vector3f.ZP.rotationDegrees(f3 / 2.0F));
//                p_225628_1_.mulPose(Vector3f.YP.rotationDegrees(180.0F - f3 / 2.0F));
//                IVertexBuilder ivertexbuilder = p_225628_2_.getBuffer(RenderType.entitySolid(p_225628_4_.getCloakTextureLocation()));
//                this.getParentModel().renderCloak(p_225628_1_, ivertexbuilder, p_225628_3_, OverlayTexture.NO_OVERLAY);
//                p_225628_1_.popPose();
//
//                // ***********************
//                // MC
//                // ***********************
//                // Bail if the current entity is not a player.
////                if (!(entitylivingbaseIn instanceof EntityPlayer)) {
////                    if (!(p_225628_4_ instanceof PlayerEntity))
////
////                    System.out.println("DEBUG: FAILURE! Unexpected object in LayerFactionCape.");
////                    return;
////                }
//
//                // figure out the class and the corresponding cape.
//                //EntityPlayer player = (EntityPlayer)entitylivingbaseIn;
//                AbstractClientPlayerEntity player = p_225628_4_;
//                ClassInfo classInfo = SuperDopeJediMod.CLASS_MANAGER.getPlayerClass(player);
//                String resourceName = classInfo.getCapeResource();
//
//                // if resourceName == null, that means FactionManager is telling us this faction doesn't get a cape.
//                if (resourceName == null) {
//                    return;
//                }
//
//                //System.out.println("DEBUG: FACTION: " + factionInfo.getId().toString() + ":" + factionInfo.getName());
//
//                // Bind the texture.
//                ResourceLocation resourceLocation = new ResourceLocation(SuperDopeJediMod.MODID, resourceName);
//                this.playerRenderer.
//                this.playerRenderer.bindTexture(resourceLocation);
//
//
//            }
//        }
//    }
//
//
////
////@OnlyIn(Dist.CLIENT)
////public class LayerClassCape implements LayerRenderer<LivingEntity>
////{
//
//
////    private final PlayerRenderer playerRenderer;
////
////
////    public LayerClassCape(PlayerRenderer playerRendererIn)
////    {
////        this.playerRenderer = playerRendererIn;
////    }
////
////
////    @Override
////    public void render(MatrixStack p_225628_1_, IRenderTypeBuffer p_225628_2_, int p_225628_3_, Entity p_225628_4_, float p_225628_5_, float p_225628_6_, float p_225628_7_, float p_225628_8_, float p_225628_9_, float p_225628_10_) {
////
////    }
//
//        public void doRenderLayer(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)  {
//
//    	 // I don't know what this does yet, it was in the code i stole from the original cape layer code.
//    	 GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
//
//         // Bail if the current entity is not a player.
//    	 if (!(entitylivingbaseIn instanceof EntityPlayer)) {
//
//    		 System.out.println("DEBUG: FAILURE! Unexpected object in LayerFactionCape.");
//    		 return;
//    	 }
//
//         // figure out the class and the corresponding cape.
//    	 EntityPlayer player = (EntityPlayer)entitylivingbaseIn;
//    	 ClassInfo classInfo = SuperDopeJediMod.classManager.getPlayerClass(player);
//    	 String resourceName = classInfo.getCapeResource();
//
//         // if resourceName == null, that means FactionManager is telling us this faction doesn't get a cape.
//         if (resourceName == null) {
//        	 return;
//         }
//
//         //System.out.println("DEBUG: FACTION: " + factionInfo.getId().toString() + ":" + factionInfo.getName());
//
//         // Bind the texture.
//         ResourceLocation resourceLocation = new ResourceLocation(SuperDopeJediMod.MODID, resourceName);
//         this.playerRenderer.bindTexture(resourceLocation);
//
//
//                // The rest of this code is copied from the original layercape.
//                GlStateManager.pushMatrix();
//                GlStateManager.translate(0.0F, 0.0F, 0.125F);
//                double d0 = player.prevChasingPosX + (player.chasingPosX - player.prevChasingPosX) * (double)partialTicks - (player.prevPosX + (player.posX - player.prevPosX) * (double)partialTicks);
//                double d1 = player.prevChasingPosY + (player.chasingPosY - player.prevChasingPosY) * (double)partialTicks - (player.prevPosY + (player.posY - player.prevPosY) * (double)partialTicks);
//                double d2 = player.prevChasingPosZ + (player.chasingPosZ - player.prevChasingPosZ) * (double)partialTicks - (player.prevPosZ + (player.posZ - player.prevPosZ) * (double)partialTicks);
//                float f = player.prevRenderYawOffset + (player.renderYawOffset - player.prevRenderYawOffset) * partialTicks;
//                double d3 = (double)MathHelper.sin(f * 0.017453292F);
//                double d4 = (double)(-MathHelper.cos(f * 0.017453292F));
//                float f1 = (float)d1 * 10.0F;
//                f1 = MathHelper.clamp(f1, -6.0F, 32.0F);
//                float f2 = (float)(d0 * d3 + d2 * d4) * 100.0F;
//                float f3 = (float)(d0 * d4 - d2 * d3) * 100.0F;
//
//                if (f2 < 0.0F)
//                {
//                    f2 = 0.0F;
//                }
//
//                float f4 = player.prevCameraYaw + (player.cameraYaw - player.prevCameraYaw) * partialTicks;
//                f1 = f1 + MathHelper.sin((player.prevDistanceWalkedModified + (player.distanceWalkedModified - player.prevDistanceWalkedModified) * partialTicks) * 6.0F) * 32.0F * f4;
//
//                if (player.isSneaking())
//                {
//                    f1 += 25.0F;
//                }
//
//                GlStateManager.rotate(6.0F + f2 / 2.0F + f1, 1.0F, 0.0F, 0.0F);
//                GlStateManager.rotate(f3 / 2.0F, 0.0F, 0.0F, 1.0F);
//                GlStateManager.rotate(-f3 / 2.0F, 0.0F, 1.0F, 0.0F);
//                GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
//                this.playerRenderer.getMainModel().renderCape(0.0625F);
//                GlStateManager.popMatrix();
//    }
//
//
//    public boolean shouldCombineTextures() {
//
//    	return false;
//    }
//
////    @Override
////    public void render(MatrixStack p_225628_1_, IRenderTypeBuffer p_225628_2_, int p_225628_3_, Entity p_225628_4_, float p_225628_5_, float p_225628_6_, float p_225628_7_, float p_225628_8_, float p_225628_9_, float p_225628_10_) {
////
////    }
//}
