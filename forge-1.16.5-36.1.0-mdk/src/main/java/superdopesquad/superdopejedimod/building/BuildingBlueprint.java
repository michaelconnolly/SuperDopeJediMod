package superdopesquad.superdopejedimod.building;


import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import superdopesquad.superdopejedimod.DopeItem;


public abstract class BuildingBlueprint extends DopeItem {


	public BuildingBlueprint(String name) {
		super(name);
	}


	abstract protected void build(World world, BlockPos blockPos);


	@Override
	public ActionResultType useOn(ItemUseContext context) {

		World world = context.getLevel();
		BlockPos blockPos = context.getClickedPos();
		PlayerEntity player = context.getPlayer();
		boolean isWorldServer = (!world.isClientSide);
		Block blockClicked = world.getBlockState(blockPos).getBlock();

		// This is the only unique biz logic as compared to DroidKit.
		boolean isKit = (blockClicked instanceof BuildingKit);
		boolean shouldBuild = (isWorldServer && (context.getHand() == Hand.MAIN_HAND) && isKit);
		System.out.println("DEBUG: inside BuildingBlueprint:onItemUse: shouldBuild? " + (shouldBuild));

		if (shouldBuild) {

			// Destroy the existing target block, which is a Droid Kit.
			world.destroyBlock(blockPos, false);

//			// Create the new building.
			ItemStack itemStackCurrentItem = context.getItemInHand();
			this.build(world, blockPos);

			// Destroy the Droid Head that is in the hand of the player.
			if (!player.isCreative()) {
				itemStackCurrentItem.shrink(1);
			}

			// Return something relevant.
			return ActionResultType.SUCCESS;
		}

		return ActionResultType.PASS;
	}
}
