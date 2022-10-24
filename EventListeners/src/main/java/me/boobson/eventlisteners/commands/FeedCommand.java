package me.boobson.eventlisteners.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player p) {
            if(p.hasPermission("eventlistener.feed")) {
                //Player p = (Player) sender; - version for older java
                if(args.length == 0) {
                    p.setFoodLevel(20);
                    p.sendMessage(ChatColor.GREEN + "Bon appetit");
                }else{
                    String playerName = args[0];

                    Player target = Bukkit.getServer().getPlayerExact(playerName);

                    if(target == null) {
                        p.sendMessage("This player is not online");
                    }else if (target.getDisplayName() == p.getDisplayName()){
                        p.sendMessage("You fed yourself. Bon appetit!");
                    }else{
                        p.sendMessage("You fed " + ChatColor.YELLOW + target.getDisplayName());
                        target.sendMessage("You have been fed by " + ChatColor.YELLOW + p.getDisplayName());
                        p.setFoodLevel(20);
                    }
                }
            }else {
                p.sendMessage("You don not have permission to execute this command");
            }
        }

        return true;
    }
}
