package superdopesquad.superdopejedimod.armor;


import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import superdopesquad.superdopejedimod.faction.*;
import java.util.ArrayList;


public class ArmorManager {

    private static final Logger LOGGER = LogManager.getLogger();

    public static final ArrayList<DopeArmor> MandalorianArmorSet = buildArmorSet("mandalorian", ArmorMaterial.IRON, ClassPermissions.BountyHunterOnly);
    public static final ArrayList<DopeArmor> JediArmorSet = buildArmorSet("jedi", ArmorMaterial.IRON, ClassPermissions.JediOnly);
    public static final ArrayList<DopeArmor> SithArmorSet = buildArmorSet("sith", ArmorMaterial.IRON, ClassPermissions.SithOnly);
    public static final ArrayList<DopeArmor> SmugglerArmorSet = buildArmorSet("smuggler", ArmorMaterial.IRON, ClassPermissions.SmugglerOnly);
    public static final ArrayList<DopeArmor> StormtrooperArmorSet = buildArmorSet("stormtrooper", ArmorMaterial.IRON, ClassPermissions.StormtrooperOnly);
    public static final ArrayList<DopeArmor> RebelArmorSet = buildArmorSet("rebel", ArmorMaterial.IRON, ClassPermissions.RebelOnly);


    private static ArrayList<DopeArmor> buildArmorSet(String armorType, ArmorMaterial material, ClassPermissions classPermissions) {

        ArrayList<DopeArmor> armorSet = new ArrayList<>();

        armorSet.add(new DopeArmor(armorType + "_helmet", material, EquipmentSlotType.HEAD, classPermissions));
        armorSet.add(new DopeArmor(armorType + "_chestplate", material, EquipmentSlotType.CHEST, classPermissions));
        armorSet.add(new DopeArmor(armorType + "_leggings", material, EquipmentSlotType.LEGS, classPermissions));
        armorSet.add(new DopeArmor(armorType + "_boots", material, EquipmentSlotType.FEET, classPermissions));

        return armorSet;
    }


//    // This is called from onPlayerLoggedIn event, to verify that they are wearing legal armor.
//    // This could potentially be called from other places if we feel we need to double-check.
//    // It has to be called on the server-side, since that is the only way player.drop will work.
//    public static void armorSetCheck(PlayerEntity player) {
//
//        ArmorManager.armorItemCheck(player, EquipmentSlotType.CHEST);
//        ArmorManager.armorItemCheck(player, EquipmentSlotType.HEAD);
//        ArmorManager.armorItemCheck(player, EquipmentSlotType.LEGS);
//        ArmorManager.armorItemCheck(player, EquipmentSlotType.FEET);
//
//        return;
//    }

//
//    private static void armorItemCheck(PlayerEntity player, EquipmentSlotType slot) {
//
//        // If there is nothing in the slot, return.
//        ItemStack armorItemStack = player.getItemBySlot(slot);
//
//        if (armorItemStack == null) return;
//
//        // If the armor is not a child of DopeArmor, return.
//        Item armorItem = armorItemStack.getItem();
//        if (!(armorItem instanceof DopeArmor)) return;
//
//        // If they can use it, return.
//        // If you can't, we threw an error in the chat.
//        if (((DopeArmor)armorItem).canUse(null, player)) return;
//
//        // If you made it here, you have to get rid of this armor.
//        LOGGER.debug(armorItem.getRegistryName().toString() + " should not be worn!");
//        ArmorManager.toss(player, slot);
//    }


//    private static void toss(PlayerEntity player, EquipmentSlotType slot) {
//
//        ItemStack itemStack = player.getItemBySlot(slot);
//        ItemStack itemStackToDrop = itemStack.copy();
//
//        // reduce the amount we have by 1.  For armor slots, this should always reduce to zero.
//        itemStack.shrink(1);
//
//        // drop the stack in that slot onto the ground.  I am not sure what the boolean parameter does.
//        player.drop(itemStackToDrop, false);
//    }
}


