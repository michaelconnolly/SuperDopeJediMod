package superdopesquad.superdopejedimod.entity.ship;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import superdopesquad.superdopejedimod.DopeBlock;


public class ShipKit extends DopeBlock {

    public ShipKit(String name) {

        super(name, (Block.Properties.of(Material.HEAVY_METAL)));
    }
}
