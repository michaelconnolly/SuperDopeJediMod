package superdopesquad.superdopejedimod;


import net.minecraft.entity.Entity;
//import net.minecraft.init.Items;
//import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class MandalorianIronArmor extends BaseArmor {
		
	
	public MandalorianIronArmor(ArmorMaterial materialIn, int renderIndexIn, EquipmentSlotType slotType) {
			
		super(materialIn, slotType);
	}
	
	
	public MandalorianIronArmor(EquipmentSlotType slotType, String nameInput) {

		super(ArmorMaterial.IRON, slotType);
		//super(SuperDopeJediMod.mandalorianIronArmorMaterial, slotType, nameInput);
	}
	
	
//	public void registerRecipe() {
//
//		ItemStack mandalorianIronIngotStack = new ItemStack(SuperDopeJediMod.mandalorianIronIngot);
//
//		// Helmet.
//    	GameRegistry.addShapedRecipe(Utilities.GetRegistryNameHelmet(this), null, new ItemStack(SuperDopeJediMod.mandalorianIronHelmet), "xxx", "x x", 'x', mandalorianIronIngotStack);
//		// Chest.
//    	GameRegistry.addShapedRecipe(Utilities.GetRegistryNameChestplate(this), null, new ItemStack(SuperDopeJediMod.mandalorianIronChestplate), "x x", "xxx", "xxx", 'x', mandalorianIronIngotStack);
//    	// Leggings.
//    	GameRegistry.addShapedRecipe(Utilities.GetRegistryNameLeggings(this), null, new ItemStack(SuperDopeJediMod.mandalorianIronLeggings), "xxx", "x x", "x x", 'x', mandalorianIronIngotStack);
//    	// Boots.
//    	GameRegistry.addShapedRecipe(Utilities.GetRegistryNameBoots(this), null, new ItemStack(SuperDopeJediMod.mandalorianIronBoots), "x x", "x x", 'x', mandalorianIronIngotStack);
//	}
}
