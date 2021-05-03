package superdopesquad.superdopejedimod.entity.droid;


import net.minecraft.block.Block;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import superdopesquad.superdopejedimod.DopeItem;


public class DroidHead extends DopeItem {

	private EntityType<?> entityType = null;
	private SegmentedModel<? extends Entity> model = null;


	public DroidHead(String name, EntityType<?> entityType) {

		super(name);

		this.entityType = entityType;
	}


	@Override
	public ActionResultType useOn(ItemUseContext context) {

		//public ActionResultType onItemUse(ItemUseContext context) {

		World world = context.getLevel();
		BlockPos blockPos = context.getClickedPos();
		PlayerEntity player = context.getPlayer();
		boolean isWorldServer = (!world.isClientSide);
		Block blockClicked = world.getBlockState(blockPos).getBlock();
		boolean isDroidKit = (blockClicked instanceof DroidKit);
		boolean shouldBuildDroid = (isWorldServer && (context.getHand() == Hand.MAIN_HAND) && isDroidKit);
		//System.out.println("DEBUG: inside DroidHead:onItemUse: shouldBuildDroid? " + (shouldBuildDroid));

		if (shouldBuildDroid) {

			// Destroy the existing target block, which is a Droid Kit.
			world.destroyBlock(blockPos, false);

			// Create the new entity.
			ItemStack itemStackCurrentItem = context.getItemInHand();
			if (this.entityType.spawn((ServerWorld) world, itemStackCurrentItem, player, blockPos, SpawnReason.SPAWN_EGG, false, false) == null) {
				System.out.println("ERROR! Failed to spawn droid.");
				return ActionResultType.FAIL;
			}

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
