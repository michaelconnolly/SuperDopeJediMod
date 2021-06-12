package superdopesquad.superdopejedimod.armor;


import net.minecraft.entity.Entity;
import net.minecraft.entity.MobEntity;
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


public class DopeArmor extends ArmorItem implements IClassAware {

	private static final Logger LOGGER = LogManager.getLogger();
	private ClassPermissions classPermissions;


	public DopeArmor(String name, ArmorMaterial material, EquipmentSlotType slotType) {

		this(name, material, slotType, new ClassPermissions());
	}


	public DopeArmor(String name, ArmorMaterial material, EquipmentSlotType slotType, ClassPermissions classPermissions) {

		this(name, material, slotType, classPermissions, new Item.Properties());
	}


	public DopeArmor(String name, ArmorMaterial material, EquipmentSlotType slotType,
			ClassPermissions classPermissions, Item.Properties properties) {

		super(material, slotType, properties.tab(ItemGroup.TAB_COMBAT));

		SuperDopeJediMod.ITEMS.register(name, () -> this);

		this.classPermissions = classPermissions;
	}


	@Override
	public ClassPermissions getClassPermissions() {
		return this.classPermissions;
	}


	@Override
	public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {

		boolean canUse = ClassManager.canUse(this, world, player);
		LOGGER.debug("DopeArmor::use - canUse? " + canUse);

		if (!canUse) {
			return ActionResult.consume(player.getItemInHand(hand));
		}
		return ActionResult.pass(player.getItemInHand(hand));
	}


	@Override
	public boolean canEquip(ItemStack stack, EquipmentSlotType slotType, Entity entity) {

		boolean canEquip = ClassManager.canEquip(this, slotType, entity);
		LOGGER.debug("DopeArmor::canEquip - canEquip? " + canEquip);

		if (!canEquip)
			return false;

		return super.canEquip(stack, slotType, entity);
	}
}
