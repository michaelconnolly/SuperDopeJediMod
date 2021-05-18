package superdopesquad.superdopejedimod.entity;


import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import superdopesquad.superdopejedimod.SuperDopeJediMod;


public class DopeEgg extends SpawnEggItem  {


	public DopeEgg(String name, EntityType<?> entityType, int color1, int color2) {

		super(entityType, color1, color2, new Properties().tab(ItemGroup.TAB_MATERIALS));

		SuperDopeJediMod.ITEMS.register(name, () -> this);
	}
}
