package superdopesquad.superdopejedimod.armor;


import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import superdopesquad.superdopejedimod.SuperDopeJediMod;


public class DopeArmor extends ArmorItem  {


	public DopeArmor(String name, ArmorMaterial material, EquipmentSlotType slotType) {

		this(name, material, slotType, new Item.Properties());
	}


	public DopeArmor(String name, ArmorMaterial material, EquipmentSlotType slotType, Item.Properties properties) {

		super(material, slotType, properties.tab(ItemGroup.TAB_COMBAT));

		SuperDopeJediMod.ITEMS.register(name, () -> this);
	}
}
