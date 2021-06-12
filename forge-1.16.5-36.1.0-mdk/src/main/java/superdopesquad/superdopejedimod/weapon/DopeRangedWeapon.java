package superdopesquad.superdopejedimod.weapon;


import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import superdopesquad.superdopejedimod.SuperDopeJediMod;
import superdopesquad.superdopejedimod.faction.ClassManager;
import superdopesquad.superdopejedimod.faction.ClassPermissions;
import superdopesquad.superdopejedimod.faction.IClassAware;


public abstract class DopeRangedWeapon extends Item implements IClassAware {

	protected static final Logger LOGGER = LogManager.getLogger();
	protected ClassPermissions classPermissions;


	public DopeRangedWeapon(String name, ClassPermissions classPermissions) {

		super(new Properties().tab(ItemGroup.TAB_COMBAT).stacksTo(1));

		SuperDopeJediMod.ITEMS.register(name, () -> this);

		this.classPermissions = classPermissions;
	}


	public DopeRangedWeapon(String name) {

		this(name, null);
	}


	@Override
	public ClassPermissions getClassPermissions() {
		return this.classPermissions;
	}


	@Override
	public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {

		World world = entity.getCommandSenderWorld();
		boolean canUse = ClassManager.canUse(this, world, player);
		LOGGER.debug("DopeRangedWeapon::onLeftClickEntity - canUse? " + canUse);
		return (!canUse);
	}


	@Override
	public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {

		boolean canUse = ClassManager.canUse(this, world, player);
		LOGGER.debug("DopeRangedWeapon::use - canUse? " + canUse);

		if (!canUse) {
			return ActionResult.consume(player.getItemInHand(hand));
		}
		return ActionResult.pass(player.getItemInHand(hand));
	}


	@Override
	public boolean canEquip(ItemStack stack, EquipmentSlotType slotType, Entity entity) {

		boolean canEquip = ClassManager.canEquip(this, slotType, entity);
		LOGGER.debug("DopeRangedWeapon::canEquip - canEquip? " + canEquip);

		if (!canEquip)
			return false;

		return super.canEquip(stack, slotType, entity);
	}
}
