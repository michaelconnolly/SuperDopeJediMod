package superdopesquad.superdopejedimod.weapon;


import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import superdopesquad.superdopejedimod.SuperDopeJediMod;
import superdopesquad.superdopejedimod.faction.ClassPermissions;


public abstract class DopeRangedWeapon extends Item {

	protected ClassPermissions classPermissions;


	public DopeRangedWeapon(String name, ClassPermissions classPermissions) {

		super(new Properties().tab(ItemGroup.TAB_COMBAT));

		SuperDopeJediMod.ITEMS.register(name, () -> this);

		this.classPermissions = classPermissions;
	}


	public DopeRangedWeapon(String name) {

		this(name, null);
	}


	public boolean canUse(World world, PlayerEntity player) {

		return ((this.classPermissions == null) || this.classPermissions.canUse(world, player));
	}


	@Override
	public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {

		System.out.println("inside use: returning " + this.canUse(world, player));

		if (!this.canUse(world, player)) {
			return ActionResult.consume(player.getItemInHand(hand));
		}
		return ActionResult.pass(player.getItemInHand(hand));
	}

}
