//package superdopesquad.superdopejedimod;
//
//
//import net.minecraft.client.Minecraft;
//import superdopesquad.superdopejedimod.entity.LayerClassCape;
//
//
//public class SuperDopeClientProxy extends SuperDopeCommonProxy {
//
//
//	@Override
//    public void preInit(FMLPreInitializationEvent e) {
//
//		super.preInit(e);
//
//		// Iterate through all our custom objects, and see if we have any entity models to render.
//    	// We only want to call this method for instances of SuperDopeEntity.
//        for (SuperDopeObject superDopeObject : SuperDopeJediMod.customObjects) {
//        	if(superDopeObject instanceof SuperDopeEntity) {
//        		((SuperDopeEntity)superDopeObject).registerEntityRender();
//            }
//        }
//    }
//
//
//	@Override
//	public void init(FMLInitializationEvent e){
//
//		super.init(e);
//
//		//System.out.println("I'm on the client!  init event.");
//
//    	// Iterate through all our custom objects, and see if we have any models to render.
//        for (SuperDopeObject superDopeObject : SuperDopeJediMod.customObjects) {
//        	superDopeObject.registerModel();
//        }
//
//        // Should classes come with capes?  I think so!
//        // For now, also including the more experimental ClassIndictor.
//
//        // This sets our additional layers on the "default" player model, also known as Steve.
//        RenderPlayer renderPlayerDefault = Minecraft.getMinecraft().getRenderManager().getSkinMap().get("default");
//        //renderPlayerDefault.addLayer(new LayerClassIndicator(renderPlayerDefault));
//        renderPlayerDefault.addLayer(new LayerClassCape(renderPlayerDefault));
//
//        // This sets our additional layers on the "slim" player model, also known as Alex.
//        RenderPlayer renderPlayerSlim = Minecraft.getMinecraft().getRenderManager().getSkinMap().get("slim");
//        //renderPlayerSlim.addLayer(new LayerClassIndicator(renderPlayerSlim));
//        renderPlayerSlim.addLayer(new LayerClassCape(renderPlayerSlim));
//
//        // WeaponManager needs to be called at onInit time, to properly register some projectile entities.
//        SuperDopeJediMod.weaponManager.onInit();
//	}
////
////
////    @Override
////    public void postInit(FMLPostInitializationEvent e) {
////
////    	super.postInit(e);
////
////     	//System.out.println("I'm in the client proxy! post init event.");
////    }
////
////
////    @Override
////	public void displayCreditGui(int stackSize) {
////
////    	Minecraft.getMinecraft().displayGuiScreen(new CreditGUI(stackSize));
////	}
////
////
////    @Override
////    public void displayClassGui(EntityPlayer player) {
////
////    	Minecraft.getMinecraft().displayGuiScreen(new ClassGUI(player));
////    }
////}
////
////
