package superdopesquad.superdopejedimod.entity.droid;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import superdopesquad.superdopejedimod.DopeBlock;


public class DroidKit extends DopeBlock {

	public DroidKit(String name) {

		super(name, (Block.Properties.of(Material.HEAVY_METAL)));
	}
}
