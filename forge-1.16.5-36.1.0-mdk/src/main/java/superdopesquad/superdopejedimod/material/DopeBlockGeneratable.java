package superdopesquad.superdopejedimod.material;


import net.minecraft.block.material.Material;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import superdopesquad.superdopejedimod.DopeBlock;
import superdopesquad.superdopejedimod.SuperDopeJediMod;


public class DopeBlockGeneratable extends DopeBlock {

    public int veinSize = 12;       // How many ore cluster together.  Iron value: 12
    public int minHeight = 0;       // The lowest 'y' level where this ore can be found. Iron value: 0
    public int maxHeight = 64;      // The highest 'y' level where this ore can be found.  Iron value: 64
    public int countPerChunk = 20;  // How many veins are generated in each chunk. Iron value: 20


    public DopeBlockGeneratable(String name, Material material) {

        super(name, material);

        SuperDopeJediMod.MATERIAL_MANAGER.generatableBlocks.add(this);
    }


    public void GenerateOre(final BiomeLoadingEvent event) {

        //System.out.println("Inside GenerateOre: " + this.getName().getString());

        GenerationStage.Decoration decoration = GenerationStage.Decoration.UNDERGROUND_ORES;
        RuleTest fillerType = OreFeatureConfig.FillerBlockType.NATURAL_STONE;
        OreFeatureConfig oreFeatureConfig = new OreFeatureConfig(fillerType, this.defaultBlockState(), this.veinSize);
        TopSolidRangeConfig topSolidRangeConfig = new TopSolidRangeConfig(minHeight, 0, maxHeight);

        event.getGeneration().addFeature(decoration, Feature.ORE.configured(oreFeatureConfig).
                decorated(Placement.RANGE.configured(topSolidRangeConfig).squared().count(this.countPerChunk)));
    }
}
