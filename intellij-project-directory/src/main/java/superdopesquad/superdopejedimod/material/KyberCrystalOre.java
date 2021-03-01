package superdopesquad.superdopejedimod.material;

import net.minecraft.block.material.Material;


public class KyberCrystalOre extends BaseBlockGeneratable {

	public KyberCrystalOre(String name) {

		super(name, (Properties.create(Material.ROCK).harvestLevel(2).hardnessAndResistance(5.0F)));

		this.veinSize = 16;
		this.minHeight = 0;
		this.maxHeight = 60;
		this.amount = 10;
	}
}

