package superdopesquad.superdopejedimod;


import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;


public class DopeBlock extends Block {


	public DopeBlock(String name, Block.Properties properties) {

		super(properties);

		SuperDopeJediMod.BLOCKS.register(name, () -> this);
		SuperDopeJediMod.ITEMS.register(name, () -> new BlockItem(this,
				new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));
	}


	public DopeBlock(String name, Material material) {

		this(name, AbstractBlock.Properties.of(material));
	}


	public DopeBlock(String name) {

		this(name, AbstractBlock.Properties.of(Material.HEAVY_METAL));
	}
}
