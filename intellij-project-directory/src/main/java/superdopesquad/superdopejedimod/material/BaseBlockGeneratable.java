package superdopesquad.superdopejedimod.material;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import superdopesquad.superdopejedimod.BaseBlock;


public class BaseBlockGeneratable extends BaseBlock {

    public int veinSize = 64;  // How many ore cluster together
    public int minHeight = 0;  // The lowest 'y' level where this ore can be found.
    public int maxHeight = 60; // The highest 'y' level where this ore can be found.
    public int amount = 64;    // MC-TODO: I am not sure what this value does.


    public BaseBlockGeneratable(String name, Properties properties) {

        super(name, properties);
    }


    public void GenerateOre(final BiomeLoadingEvent event) {

        OreFeatureConfig oreFeatureConfig = new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
                this.getDefaultState(), this.veinSize);

        event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(oreFeatureConfig)
                .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(minHeight, 0, maxHeight)))
                .square().func_242731_b(amount));
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
