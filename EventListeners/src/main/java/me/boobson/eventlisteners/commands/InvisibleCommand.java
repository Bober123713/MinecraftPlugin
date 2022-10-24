package me.boobson.eventlisteners.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InvisibleCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission("eventlisteners.insvisible")){
                if(p.isInvisible()) {
                    p.setInvisible(false);
                    p.sendMessage(ChatColor.RED + "VISIBLE");
                }else{
                    p.setInvisible(true);
                    p.sendMessage(ChatColor.GREEN + "INVISIBLE");
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
