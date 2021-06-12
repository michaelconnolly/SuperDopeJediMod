package superdopesquad.superdopejedimod.weapon;


import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import superdopesquad.superdopejedimod.SuperDopeJediMod;
import superdopesquad.superdopejedimod.faction.ClassManager;
import superdopesquad.superdopejedimod.faction.ClassPermissions;
import superdopesquad.superdopejedimod.faction.IClassAware;


public class DopeMeleeWeapon extends SwordItem implements IClassAware {

	protected static final Logger LOGGER = LogManager.getLogger();
	protected ClassPermissions classPermissions;


	public DopeMeleeWeapon(String name, ItemTier itemTier, ClassPermissions classPermissions) {

		super (itemTier, 1, 1.0F, new Properties().tab(ItemGroup.TAB_COMBAT).stacksTo(1));

		SuperDopeJediMod.ITEMS.register(name, () -> this);

		this.classPermissions = classPermissions;
	}


	public DopeMeleeWeapon(String name, ItemTier itemTier) {

		this(name, itemTier, null);
	}


	@Override
	public ClassPermissions getClassPermissions() {
		return this.classPermissions;
	}


	@Override
	public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {

		World world = entity.getCommandSenderWorld();
		boolean canUse = ClassManager.canUse(this, world, player);
		LOGGER.debug("DopeMeleeWeapon::onLeftClickEntity - canUse? " + canUse);
		return (!canUse);
	}


	@Override
	public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {

		boolean canUse = ClassManager.canUse(this, world, player);
		LOGGER.debug("DopeMeleeWeapon::use - canUse? " + canUse);

		if (!canUse) {
			return ActionResult.consume(player.getItemInHand(hand));
		}
		return ActionResult.pass(player.getItemInHand(hand));
	}


	@Override
	public boolean canEquip(ItemStack stack, EquipmentSlotType slotType, Entity entity) {

		boolean canEquip = ClassManager.canEquip(this, slotType, entity);
		LOGGER.debug("DopeMeleeWeapon::canEquip - canEquip? " + canEquip);

		if (!canEquip)
			return false;

		return super.canEquip(stack, slotType, entity);
	}


//	@Override
//	public ActionResultType useOn(ItemUseContext context) {
//
//		System.out.println("inside useOn");
//		boolean shouldUse = ((this.classAwareInfo == null) || this.classAwareInfo.canUse());
//		if (shouldUse) {
//			System.out.println(("should fail"));
//			return ActionResultType.CONSUME;
//		}
//
//		System.out.println(("should succeed"));
//		return ActionResultType.PASS;
//	}

}
