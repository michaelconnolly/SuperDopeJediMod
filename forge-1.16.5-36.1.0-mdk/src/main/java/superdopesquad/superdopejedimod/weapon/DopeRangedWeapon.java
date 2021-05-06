package superdopesquad.superdopejedimod.weapon;


import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import superdopesquad.superdopejedimod.SuperDopeJediMod;
import superdopesquad.superdopejedimod.SuperDopeObject;
import superdopesquad.superdopejedimod.faction.ClassAwareInterface;
import superdopesquad.superdopejedimod.faction.ClassInfo;
import java.util.ArrayList;
import java.util.List;


public abstract class DopeRangedWeapon extends Item implements SuperDopeObject, ClassAwareInterface {

	
	public DopeRangedWeapon(String name) {

		super(new Properties().tab(ItemGroup.TAB_COMBAT));

		SuperDopeJediMod.ITEMS.register(name, () -> this);
	}


	@Override
	public List<ClassInfo> GetFriendlyClasses() {

		return new ArrayList<ClassInfo>();
	}


	@Override
	public List<ClassInfo> GetUnfriendlyClasses() {

		return new ArrayList<ClassInfo>();
	}


	@Override
	public boolean IsUseFriendlyOnly() {

		return false;
	}


	@Override
	public boolean IsUseUnfriendlyBanned() {

		return false;
	}
}
