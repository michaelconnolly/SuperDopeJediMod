package superdopesquad.superdopejedimod.material;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;


public class QuadaniumOre extends BaseBlockGeneratable {

	public QuadaniumOre(String name) {

		super(name, (Block.Properties.create(Material.ROCK).harvestLevel(2).hardnessAndResistance(5.0F)));

		this.veinSize = 16;
		this.minHeight = 0;
		this.maxHeight = 60;
		this.amount = 10;
	}
}

//
//    public Item getItemDropped(int metadata, Random random, int fortune) {
//
//    	return Item.getItemFromBlock(SuperDopeJediMod.quadaniumSteelOre);
//    }
  

