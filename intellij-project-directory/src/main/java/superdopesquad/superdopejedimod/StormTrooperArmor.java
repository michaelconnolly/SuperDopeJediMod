package superdopesquad.superdopejedimod;

//import net.minecraft.init.Items;
//import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class StormTrooperArmor extends BaseArmor {

	public StormTrooperArmor(ArmorMaterial materialIn, int renderIndexIn, EquipmentSlotType slotType) {

		super(materialIn, slotType);

	}

	public StormTrooperArmor(EquipmentSlotType slotType, String nameInput) {

		super(ArmorMaterial.IRON, slotType);

//		super(SuperDopeJediMod.stormTrooperArmorMaterial, equipmentSlotIn, nameInput);
	}

//	public void registerRecipe() {
//
//		ItemStack quartzStack = new ItemStack(Items.QUARTZ);
//		ItemStack chromateStack = new ItemStack(SuperDopeJediMod.chromateIngot);
//
//		// Helmet.
//		GameRegistry.addShapedRecipe(Utilities.GetRegistryNameHelmet(this), null, new ItemStack(SuperDopeJediMod.stormTrooperHelmet), "xxx", "y y", 'x', quartzStack, 'y', chromateStack);
//		// Chest.
//		GameRegistry.addShapedRecipe(Utilities.GetRegistryNameChestplate(this), null, new ItemStack(SuperDopeJediMod.stormTrooperChestplate), "x x", "yxy", "xyx", 'x', quartzStack, 'y', chromateStack);
//		// Leggings.
//		GameRegistry.addShapedRecipe(Utilities.GetRegistryNameLeggings(this), null, new ItemStack(SuperDopeJediMod.stormTrooperLeggings), "yxy", "x x", "y y", 'x', quartzStack, 'y', chromateStack);
//		// Boots.
//		GameRegistry.addShapedRecipe(Utilities.GetRegistryNameBoots(this), null, new ItemStack(SuperDopeJediMod.stormTrooperBoots), "x x", "y y", 'x', quartzStack, 'y', chromateStack);
//	}
}
