package superdopesquad.superdopejedimod.faction;


import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import superdopesquad.superdopejedimod.SuperDopeJediMod;
import java.util.ArrayList;


public class ClassPermissions {


    public static final ClassPermissions ForceWieldersOnly = new ClassPermissions()
            .addAllowClass(ClassManager.JEDI_KNIGHT)
            .addAllowClass(ClassManager.SITH_LORD);
    public static final ClassPermissions NonForceWieldersOnly = new ClassPermissions()
            .addDenyClass(ClassManager.JEDI_KNIGHT)
            .addDenyClass(ClassManager.SITH_LORD)
            .addDenyClass(ClassManager.UNAFFILIATED);
    public static final ClassPermissions BountyHunterOnly = new ClassPermissions()
            .addAllowClass(ClassManager.BOUNTYHUNTER);
    public static final ClassPermissions SmugglerOnly = new ClassPermissions()
            .addAllowClass(ClassManager.SMUGGLER);
    public static final ClassPermissions RebelOnly = new ClassPermissions()
            .addAllowClass(ClassManager.REBEL_CELL_COMMANDER);
    public static final ClassPermissions StormtrooperOnly = new ClassPermissions()
            .addAllowClass(ClassManager.STORMTROOPER);
    public static final ClassPermissions SithOnly = new ClassPermissions()
            .addAllowClass(ClassManager.SITH_LORD);
    public static final ClassPermissions JediOnly = new ClassPermissions()
            .addAllowClass(ClassManager.JEDI_KNIGHT);

    ArrayList<FactionInfo> allowFactions = new ArrayList<>();
    ArrayList<FactionInfo> denyFactions = new ArrayList<>();
    ArrayList<ClassInfo> allowClasses = new ArrayList<>();
    ArrayList<ClassInfo> denyClasses = new ArrayList<>();


    public ClassPermissions() { }


    public ClassPermissions addAllowFaction(FactionInfo factionInfo) {

        allowFactions.add(factionInfo);
        return this;
    }


    public ClassPermissions addDenyFaction(FactionInfo factionInfo) {

        denyFactions.add(factionInfo);
        return this;
    }


    public ClassPermissions addAllowClass(ClassInfo classInfo) {

        allowClasses.add(classInfo);
        return this;
    }


    public ClassPermissions addDenyClass(ClassInfo classInfo) {

        denyClasses.add(classInfo);
        return this;
    }


    private void postMessage(World world, PlayerEntity player, String message) {

        if ((world == null) || (!(world.isClientSide))) {
            player.sendMessage(new StringTextComponent(message), null);
        }
    }


    public boolean canUse(World world, PlayerEntity player) {

        if (!(this.canPlayerFactionUse(player))) {
            String message = "You can't use this object, because of your faction.";
            this.postMessage(world, player, message);
            return false;
        }

        if (!(this.canPlayerClassUse(player))) {
            String message = "You can't use this object, because of your class.";
            this.postMessage(world, player, message);
            return false;
        }

        return true;
    }


    private boolean canPlayerFactionUse(PlayerEntity player) {

        FactionInfo factionInfo = SuperDopeJediMod.CLASS_MANAGER.getPlayerFaction(player);

        // If any allow classes were set, and we are in there, we are all good.
        if (this.allowFactions.size() > 0) {
            return this.allowFactions.contains(factionInfo);
        }

        // If any deny classes were set, if you are in there, you are OUT.  Otherwise, IN.
        if (this.denyFactions.size() > 0) {
            return (!(this.denyFactions.contains(factionInfo)));
        }

        // Otherwise, we all good here.
        return true;
    }


    private boolean canPlayerClassUse(PlayerEntity player) {

        ClassInfo classInfo = SuperDopeJediMod.CLASS_MANAGER.getPlayerClass(player);

        // If any allow classes were set, and we are in there, we are all good.
        if (this.allowClasses.size() > 0) {
            return this.allowClasses.contains(classInfo);
        }

        // If any deny classes were set, if you are in there, you are OUT.  Otherwise, IN.
        if (this.denyClasses.size() > 0) {
            return (!(this.denyClasses.contains(classInfo)));
        }

        // If you made it here, we have no allow or deny set, so return true.
        return true;
    }
}
