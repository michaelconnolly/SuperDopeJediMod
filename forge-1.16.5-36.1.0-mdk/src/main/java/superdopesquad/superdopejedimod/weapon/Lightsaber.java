package superdopesquad.superdopejedimod.weapon;

import net.minecraft.item.ItemTier;
import superdopesquad.superdopejedimod.faction.ClassManager;
import superdopesquad.superdopejedimod.faction.ClassPermissions;


public class Lightsaber extends DopeMeleeWeapon {
	
	String color;
	

	public Lightsaber(String color) {
		
		super(("light_saber_" + color), ItemTier.IRON, ClassPermissions.ForceWieldersOnly);

		this.color = color;
	}
}
