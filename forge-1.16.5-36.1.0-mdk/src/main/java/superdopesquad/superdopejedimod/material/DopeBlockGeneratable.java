package superdopesquad.superdopejedimod.material;

import net.minecraft.block.material.Material;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import superdopesquad.superdopejedimod.DopeBlock;


public class DopeBlockGeneratable extends DopeBlock {

    public int veinSize = 64;  // How many ore cluster together
    public int minHeight = 0;  // The lowest 'y' level where this ore can be found.
    public int maxHeight = 60; // The highest 'y' level where this ore can be found.
    public int amount = 64;    // MC-TODO: I am not sure what this value does.


    public DopeBlockGeneratable(String name, Material material) {
        super(name, material);
    }

//
//    public BaseBlockGeneratable(String name, Properties properties) {
//
//        super(name, properties);
//    }


    public void GenerateOre(final BiomeLoadingEvent event) {

//        OreFeatureConfig oreFeatureConfig = new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
//                this.getDefaultState(), this.veinSize);
//
//        event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(oreFeatureConfig)
//                .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(minHeight, 0, maxHeight)))
//                .square().func_242731_b(amount));

//        OreFeatureConfig oreFeatureConfig = new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
//                this.getDefaultState(), this.veinSize);
//
//        event.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.configured(oreFeatureConfig)
//                .decorated(Placement.RANGE.configured(new TopSolidRangeConfig(minHeight, 0, maxHeight)))
//                .squared().(amount));

    }


//    @Override
//    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
//        if (!world.isClient) {
//            player.sendMessage(new LiteralText("Hello, world!"), false);
//        }
//
//        return ActionResult.SUCCESS;
//    }
}
