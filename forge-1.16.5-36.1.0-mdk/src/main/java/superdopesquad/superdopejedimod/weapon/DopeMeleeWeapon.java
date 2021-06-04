package superdopesquad.superdopejedimod.weapon;


import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import superdopesquad.superdopejedimod.SuperDopeJediMod;
import superdopesquad.superdopejedimod.faction.ClassPermissions;


public class DopeMeleeWeapon extends SwordItem {

	protected ClassPermissions classPermissions;


	public DopeMeleeWeapon(String name, ItemTier itemTier, ClassPermissions classPermissions) {

		super (itemTier, 1, 1.0F, new Properties().tab(ItemGroup.TAB_COMBAT));

		SuperDopeJediMod.ITEMS.register(name, () -> this);

		this.classPermissions = classPermissions;
	}


	public DopeMeleeWeapon(String name, ItemTier itemTier) {

		this(name, itemTier, null);
	}


	public boolean canUse(World world, PlayerEntity player) {

		return ((this.classPermissions == null) || this.classPermissions.canUse(world, player));
	}


	@Override
	public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {

		World world = entity.getCommandSenderWorld();
		System.out.println("Inside onLeftClickEntity.  Returning " + (!this.canUse(world, player)));
		return (!this.canUse(world, player));
	}


	@Override
	public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {

		System.out.println("inside use: returning " + this.canUse(world, player));

		if (!this.canUse(world, player)) {
			return ActionResult.consume(player.getItemInHand(hand));
		}
		return ActionResult.pass(player.getItemInHand(hand));
	}

//
//	@Override
//	public ActionResultType useOn(ItemUseContext context) {
//
//		System.out.println("inside useOn");
//
//		World world = context.getLevel();
//		BlockPos blockPos = context.getClickedPos();
//		PlayerEntity player = context.getPlayer();
//		boolean isWorldServer = (!world.isClientSide);
//		Block blockClicked = world.getBlockState(blockPos).getBlock();
//		//boolean isDroidKit = (blockClicked instanceof DroidKit);
//		//boolean shouldBuildDroid = (isWorldServer && (context.getHand() == Hand.MAIN_HAND) && isDroidKit);
//		//System.out.println("DEBUG: inside DroidHead:onItemUse: shouldBuildDroid? " + (shouldBuildDroid));
//
//		boolean shouldUse = ((this.classAwareInfo == null) || this.classAwareInfo.canUse());
//		if (shouldUse) {
//			System.out.println(("should fail"));
//			return ActionResultType.CONSUME;
//		}
//
//		System.out.println(("should succeed"));
//		return ActionResultType.PASS;
//	}


//	@Override
//    public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
//
//		SuperDopeJediMod.classManager.onUpdateHandlerClassAware(stack, world, entity, itemSlot, isSelected);
//	}
	
//
//	@Override
//	public List<ClassInfo> GetFriendlyClasses() {
//
//		return new ArrayList<ClassInfo>();
//	}

//
//	@Override
//	public List<ClassInfo> GetUnfriendlyClasses() {
//
//		return new ArrayList<ClassInfo>();
//	}
//
//
//	@Override
//	public boolean IsUseFriendlyOnly() {
//
//		return false;
//	}
//
//
//	@Override
//	public boolean IsUseUnfriendlyBanned() {
//
//		return false;
//	}
}
