package superdopesquad.superdopejedimod;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ArmorMaterial;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class JediArmor extends BaseArmor{

	public JediArmor(ArmorMaterial materialIn, int renderIndexIn, EquipmentSlotType slotType) {

		super(materialIn, slotType);

	}
	public JediArmor(EquipmentSlotType slotType, String nameInput) {

		//super(SuperDopeJediMod.jediArmorMaterial, equipmentSlotIn, nameInput);
        super(ArmorMaterial.IRON, slotType);

    }

//	public void registerRecipe() {
//
//		ItemStack saphireStack = new ItemStack(SuperDopeJediMod.saphire);
//
//		// Helmet.
//    	GameRegistry.addShapedRecipe(Utilities.GetRegistryNameHelmet(this), null, new ItemStack(SuperDopeJediMod.jediHelmet), "xxx", "x x", 'x', saphireStack);
//		// Chest.
//    	GameRegistry.addShapedRecipe(Utilities.GetRegistryNameChestplate(this), null, new ItemStack(SuperDopeJediMod.jediChestplate), "x x", "xxx", "xxx", 'x', saphireStack);
//    	// Leggings.
//    	GameRegistry.addShapedRecipe(Utilities.GetRegistryNameLeggings(this), null, new ItemStack(SuperDopeJediMod.jediLeggings), "xxx", "x x", "x x", 'x', saphireStack);
//    	// Boots.
//    	GameRegistry.addShapedRecipe(Utilities.GetRegistryNameBoots(this), null, new ItemStack(SuperDopeJediMod.jediBoots), "x x", "x x", 'x', saphireStack);
//  	}

}
