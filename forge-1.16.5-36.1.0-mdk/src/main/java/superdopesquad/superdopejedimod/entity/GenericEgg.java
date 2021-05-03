package superdopesquad.superdopejedimod.entity;


import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import superdopesquad.superdopejedimod.SuperDopeJediMod;
import superdopesquad.superdopejedimod.SuperDopeObject;


public class GenericEgg extends SpawnEggItem implements SuperDopeObject {


	public GenericEgg(String name, EntityType<?> entityType, int color1, int color2) {

		super(entityType, color1, color2, new Properties().tab(ItemGroup.TAB_MATERIALS));

		SuperDopeJediMod.ITEMS.register(name, () -> this);
	}
}
