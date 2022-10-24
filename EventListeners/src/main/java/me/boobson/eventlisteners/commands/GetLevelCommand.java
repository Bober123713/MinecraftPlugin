package me.boobson.eventlisteners.commands;

import me.boobson.eventlisteners.EventListeners;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class GetLevelCommand implements CommandExecutor {

    Plugin plugin = EventListeners.getPlugin(EventListeners.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player p) {
            if(p.hasPermission("eventlisteners.level")) {
                int configAddedLevel = plugin.getConfig().getInt("LevelAmount");
                int currentLevel = p.getLevel();
                if (args.length == 0) {
                    p.setLevel(currentLevel + configAddedLevel);
                    p.sendMessage(ChatColor.GREEN + "Level up!");
                } else if (args.length == 1) {
                    String chatAddedLevel = args[0];
                    p.setLevel(currentLevel + Integer.parseInt(args[0]));
                    p.sendMessage(ChatColor.GREEN + args[0] + " levels up!");
                } else {
                    StringBuilder builder = new StringBuilder();

                    for (int i = 0; i < args.length; i++) {
                        builder.append(args[i]);
                        builder.append(" ");
                    }

                    String finalMessage = builder.toString();
                    finalMessage = finalMessage.stripTrailing();
                }
            }else{
                p.sendMessage( ChatColor.RED + "You do not have a permission to execute this command");
            }

        }


        return true;
    }
}
