package superdopesquad.superdopejedimod.material;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import superdopesquad.superdopejedimod.BaseBlock;


public class Beskar extends BaseBlock {

	public Beskar(String name) {

		super(name, (Block.Properties.create(Material.IRON)));
	}
}
	
//	public Item getItemDropped(int metadata, Random random, int fortune) {
//
//		return Item.getItemFromBlock(SuperDopeJediMod.mandalorianIron);
//	}
