package superdopesquad.superdopejedimod.entity.ship;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import superdopesquad.superdopejedimod.BaseBlock;


public class ShipKit extends BaseBlock {

    public ShipKit(String name) {

        super(name, (Block.Properties.create(Material.IRON)));
    }
}
