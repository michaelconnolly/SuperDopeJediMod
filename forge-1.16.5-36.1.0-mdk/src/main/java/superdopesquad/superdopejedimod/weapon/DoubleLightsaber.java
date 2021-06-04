package superdopesquad.superdopejedimod.weapon;

import net.minecraft.item.ItemTier;
import superdopesquad.superdopejedimod.faction.ClassManager;
import superdopesquad.superdopejedimod.faction.ClassPermissions;


public class DoubleLightsaber extends DopeMeleeWeapon {

	String color;


	public DoubleLightsaber(String color) {

		super(("double_light_saber_" + color), ItemTier.IRON, ClassPermissions.ForceWieldersOnly);

		this.color = color;

		//this.isRepairable();
	}
}
