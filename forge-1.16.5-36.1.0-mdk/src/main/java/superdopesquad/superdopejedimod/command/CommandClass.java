package superdopesquad.superdopejedimod.command;


import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerList;
import net.minecraft.util.text.*;
import superdopesquad.superdopejedimod.SuperDopeJediMod;
import superdopesquad.superdopejedimod.faction.ClassInfo;
import superdopesquad.superdopejedimod.faction.ClassManager;
import java.util.ArrayList;


public class CommandClass {


    public static void register(CommandDispatcher<CommandSource> dispatcher) {

        // /class - returns the player's class
        // /class set 'className' - sets the player's class
        // /class list - lists all classes
        // /class players - lists the current logged on players and shows their class.
        // /class clear - removes the player's class
        // /class refresh - debugging purposes, forces a sync between client and server.

        dispatcher.register(Commands.literal("class")

                .requires((commandSource) -> { return commandSource.hasPermission(2); })

                // Logic for 'set'
                .then(Commands.literal("set")
                .then(Commands.argument("className", StringArgumentType.string()).executes((command) -> {

                    String className = StringArgumentType.getString(command, "className");
                    ServerPlayerEntity player = (ServerPlayerEntity) command.getSource().getEntity();
                    return CommandClass.setPlayerClass(player, className);

                 })))
                        .then(Commands.literal("list")
                                .executes((command) -> {

                                    ServerPlayerEntity player = (ServerPlayerEntity) command.getSource().getEntity();
                                    return CommandClass.listPlayerClasses(player);
                                }))

                        .then(Commands.literal("players")
                           .executes((command) -> {

                               ServerPlayerEntity player = (ServerPlayerEntity) command.getSource().getEntity();
                               MinecraftServer server = command.getSource().getServer();
                               return CommandClass.listPlayers(server, player);
                           }))

                   .then(Commands.literal("refresh")
                           .executes((command) -> {

                               ServerPlayerEntity player = (ServerPlayerEntity) command.getSource().getEntity();
                               return CommandClass.refreshPlayerClasses(player);
                           }))

                   .then(Commands.literal("clear")
                           .executes((command) -> {

                               ServerPlayerEntity player = (ServerPlayerEntity) command.getSource().getEntity();
                               return CommandClass.clearCurrentPlayerClass(player);
                           }))

                    .executes((command) -> {

                        ServerPlayerEntity player = (ServerPlayerEntity) command.getSource().getEntity();
                        player.sendMessage(new StringTextComponent("Your class is "
                                + (SuperDopeJediMod.CLASS_MANAGER.getPlayerClassName(player))), null);

                        return 1;
                    })
           );
    }


    public static int setPlayerClass(ServerPlayerEntity player, String className) {

        // First let's set the faction, then, let's refetch it.
        if (!(SuperDopeJediMod.CLASS_MANAGER.setPlayerClassByName(player, className))) {
            player.sendMessage(new StringTextComponent("Failed to set your class."), null);
            return 1;
        }

        player.sendMessage(new StringTextComponent("You are now a member of the "
                + SuperDopeJediMod.CLASS_MANAGER.getPlayerClassName(player) + " class."), null);

        return 1;
    }


    public static int clearCurrentPlayerClass(ServerPlayerEntity player) {

        if (SuperDopeJediMod.CLASS_MANAGER.setPlayerClassById(player, ClassManager.UNAFFILIATED.getId())) {
            player.sendMessage(new StringTextComponent("Successfully cleared your class."), null);
            return 1;
        }

        player.sendMessage(new StringTextComponent("Failed to clear your class."), null);
        return 1;
    }


    public static int listPlayers(MinecraftServer server, ServerPlayerEntity player) {

        PlayerList playerList = server.getPlayerList();

        for (ServerPlayerEntity aPlayer : playerList.getPlayers()) {

            String message = aPlayer.getName().getString();
            ClassInfo classInfo = SuperDopeJediMod.CLASS_MANAGER.getPlayerClass(aPlayer);
            if (classInfo != null && (classInfo.getId() != ClassManager.UNAFFILIATED.getId())) {
                message += " - " + classInfo.getDescription();
            }

            player.sendMessage(new StringTextComponent(message), null);
        }

        return 1;
    }


    public static int listPlayerClasses(ServerPlayerEntity player) {

        ArrayList<ClassInfo> classes = SuperDopeJediMod.CLASS_MANAGER.getClasses();

        for (ClassInfo classInfo : classes) {

            if (classInfo.getId() != ClassManager.UNAFFILIATED.getId()) {
                String message = classInfo.getDescription();
                player.sendMessage(new StringTextComponent(message), null);
            }
        }

        return 1;
    }


    public static int refreshPlayerClasses(ServerPlayerEntity player) {

        player.sendMessage(new StringTextComponent("NYI!"), null);

        // Let's start a conversation with the client about faction/classes, since we need to make
//			// sure all connected clients get refreshed on the current faction/class info of this user.
//			PacketServerPokingClientAboutClass packet = new PacketServerPokingClientAboutClass();
//			System.out.println("SENDING PacketServerPokingClientAboutClass");
//			SuperDopeJediMod.packetManager.INSTANCE.sendTo(packet, player);
//
//	    	sender.sendMessage(new TextComponentString("Class refresh request initiated."));
//
        return 1;
    }
}