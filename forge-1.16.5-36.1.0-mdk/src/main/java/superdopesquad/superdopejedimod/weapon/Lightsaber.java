package superdopesquad.superdopejedimod.weapon;

import net.minecraft.item.ItemTier;


public class Lightsaber extends DopeMeleeWeapon {
	
	String color;
	

	public Lightsaber(String color) {
		
		super(("light_saber_" + color), ItemTier.IRON);

		this.color = color;
	}
}
