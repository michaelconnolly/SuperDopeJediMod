package superdopesquad.superdopejedimod.armor;


import net.minecraft.entity.Entity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import superdopesquad.superdopejedimod.SuperDopeJediMod;
import superdopesquad.superdopejedimod.faction.ClassPermissions;


public class DopeArmor extends ArmorItem  {

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
	public boolean canEquip(ItemStack stack, EquipmentSlotType armorType, Entity entity) {

		if (!(entity instanceof PlayerEntity)) return true;

		System.out.println("Inside onEquip: " + this.canUse((PlayerEntity) entity));

		if (!(this.canUse((PlayerEntity) entity))) return false;

		return super.canEquip(stack, armorType, entity);
//		return ((MobEntity.getEquipmentSlotForItem(stack) == armorType)
//				&& (this.canUse((PlayerEntity)entity)));
	}


	public boolean canUse(PlayerEntity player) {
		return this.canUse(null, player);
	}


	public boolean canUse(World world, PlayerEntity player) {

		//System.out.println("is classPermissions NULL? " + (this.classPermissions == null));

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
