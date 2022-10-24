package me.boobson.eventlisteners.commands;

import me.boobson.eventlisteners.EventListeners;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.EventListener;

public class SuicideCommand implements CommandExecutor {

    //To get to the config file we write whats below
    Plugin plugin = EventListeners.getPlugin(EventListeners.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // /suicide - kills the player
        if (command.getName().equalsIgnoreCase("suicide")){
            if(sender instanceof Player){
                String suicideMessage = plugin.getConfig().getString("SuicideMessage");
                Player p = (Player) sender;
                p.setHealth(0);
                p.sendMessage(ChatColor.RED + "" + ChatColor.ITALIC + suicideMessage);
            }else if (sender instanceof ConsoleCommandSender){
                System.out.printf("This command cannot be executed by the console");
            }else if (sender instanceof BlockCommandSender){
                System.out.printf("This command cannot be executed by command blocks");
            }
        }

        return true;
    }
}
