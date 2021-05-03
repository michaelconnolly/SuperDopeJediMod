package superdopesquad.superdopejedimod.weapon;


import java.util.ArrayList;
import java.util.List;
//import java.util.Random;
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.renderer.RenderItem;
//import net.minecraft.client.renderer.block.model.ModelResourceLocation;
//import net.minecraft.creativetab.CreativeTabs;
//import net.minecraft.entity.Entity;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.*;
//import net.minecraft.item.
//import net.minecraft.item.ItemBow;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import superdopesquad.superdopejedimod.SuperDopeJediMod;
import superdopesquad.superdopejedimod.SuperDopeObject;
import superdopesquad.superdopejedimod.faction.ClassAwareInterface;
import superdopesquad.superdopejedimod.faction.ClassInfo;


public abstract class BaseMeleeWeapon extends SwordItem implements SuperDopeObject, ClassAwareInterface {


	public BaseMeleeWeapon(String name, ItemTier itemTier) {

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
