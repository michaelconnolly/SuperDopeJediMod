package superdopesquad.superdopejedimod.material;


//import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import superdopesquad.superdopejedimod.BaseItem;


public class QuadaniumSteelIngot extends BaseItem {

	
	public QuadaniumSteelIngot(String name) {
		
		//super(unlocalizedName);
		super(name, new Item.Properties().group((ItemGroup.MISC)));
		
		//this.setCreativeTab(CreativeTabs.MATERIALS);
	}
}
