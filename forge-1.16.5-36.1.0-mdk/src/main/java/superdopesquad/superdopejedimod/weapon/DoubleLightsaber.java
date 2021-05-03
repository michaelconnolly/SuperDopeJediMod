package superdopesquad.superdopejedimod.weapon;

import net.minecraft.item.ItemTier;


public class DoubleLightsaber extends BaseMeleeWeapon {

	String color;


	public DoubleLightsaber(String color) {

		super(("double_light_saber_" + color), ItemTier.IRON);

		this.color = color;

		//this.isRepairable();
	}
}
