package superdopesquad.superdopejedimod;

//import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SithLordArmor extends BaseArmor{
	
	public SithLordArmor(ArmorMaterial materialIn, int renderIndexIn, EquipmentSlotType slotType) {
		
		super(materialIn, slotType);

	}
	public SithLordArmor(EquipmentSlotType slotType, String nameInput) {
		
		//super(SuperDopeJediMod.sithLordArmorMaterial, slotType, nameInput);
		super(ArmorMaterial.IRON, slotType);
	}
	
//	public void registerRecipe() {
//
//		ItemStack rubyStack = new ItemStack(SuperDopeJediMod.ruby);
//
//		// Helmet.
//    	GameRegistry.addShapedRecipe(Utilities.GetRegistryNameHelmet(this), null, new ItemStack(SuperDopeJediMod.sithLordHelmet), "xxx", "x x", 'x', rubyStack);
//		// Chest.
//    	GameRegistry.addShapedRecipe(Utilities.GetRegistryNameChestplate(this), null, new ItemStack(SuperDopeJediMod.sithLordChestplate), "x x", "xxx", "xxx", 'x', rubyStack);
//    	// Leggings.
//    	GameRegistry.addShapedRecipe(Utilities.GetRegistryNameLeggings(this), null, new ItemStack(SuperDopeJediMod.sithLordLeggings), "xxx", "x x", "x x", 'x', rubyStack);
//    	// Boots.
//    	GameRegistry.addShapedRecipe(Utilities.GetRegistryNameBoots(this), null, new ItemStack(SuperDopeJediMod.sithLordBoots), "x x", "x x", 'x', rubyStack);
// 	}
	
}
