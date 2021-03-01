package superdopesquad.superdopejedimod.material;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;


public class PlastoidScraps extends BaseBlockGeneratable {

	public PlastoidScraps(String name) {

		super(name, (Block.Properties.create(Material.ROCK).harvestLevel(2).hardnessAndResistance(5.0F)));

		this.veinSize = 16;
		this.minHeight = 0;
		this.maxHeight = 60;
		this.amount = 10;
	}
}
