package superdopesquad.superdopejedimod.command;


import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class CommandManager {

    private static final Logger LOGGER = LogManager.getLogger();


    public static void registerCommands(CommandDispatcher<CommandSource> dispatcher) {

        LOGGER.debug("CommandManager::registerCommands ...");

        CommandClass.register(dispatcher);
    }
}
