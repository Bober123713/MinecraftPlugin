package me.boobson.eventlisteners.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission("eventlisteners.god")){
                if(p.isInvulnerable()) {
                    p.setInvulnerable(false);
                    p.sendMessage(ChatColor.RED + "God mode disabled!");
                }else{
                    p.setInvulnerable(true);
                    p.sendMessage(ChatColor.GREEN + "God mode enabled!");
                }
            }else{
                p.sendMessage( ChatColor.RED + "You do not have a permission to execute this command");
            }
        }else{
            System.out.printf("You have to be a player to execute this command");
        }

        return true;
    }
}
