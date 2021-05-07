package superdopesquad.superdopejedimod.weapon;


import java.util.ArrayList;
import java.util.List;
import net.minecraft.item.*;
import superdopesquad.superdopejedimod.SuperDopeJediMod;
import superdopesquad.superdopejedimod.SuperDopeObject;
import superdopesquad.superdopejedimod.faction.ClassAwareInterface;
import superdopesquad.superdopejedimod.faction.ClassInfo;


public class DopeMeleeWeapon extends SwordItem implements SuperDopeObject, ClassAwareInterface {


	public DopeMeleeWeapon(String name, ItemTier itemTier) {

		super (itemTier, 1, 1.0F, new Properties().tab(ItemGroup.TAB_COMBAT));

		SuperDopeJediMod.ITEMS.register(name, () -> this);
	}


//	@Override
//    public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
//
//		SuperDopeJediMod.classManager.onUpdateHandlerClassAware(stack, world, entity, itemSlot, isSelected);
//	}
	

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
