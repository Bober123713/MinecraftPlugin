package me.boobson.eventlisteners.commands;

import me.boobson.eventlisteners.EventListeners;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class VanishCommand implements CommandExecutor {

    EventListeners plugin;

    public VanishCommand(EventListeners plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player player){
            if(plugin.invisibleList.contains(player)){
                for(Player people : Bukkit.getOnlinePlayers()){
                    people.showPlayer(plugin, player);
                }
                plugin.invisibleList.remove(player);
                player.sendMessage(ChatColor.RED + "Vanish mode disabled");
            }else if(!plugin.invisibleList.contains(player)){
                for(Player people : Bukkit.getOnlinePlayers()){
                    people.hidePlayer(plugin, player);
                }
                plugin.invisibleList.add(player);
                player.sendMessage(ChatColor.GREEN + "Vanish mode enabled");
            }
        }

        return true;

/*
OLD VERSION
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission("eventlisteners.vanish")){
                if(p.isInvisible()) {
                    p.setInvisible(false);
                    p.sendMessage(ChatColor.RED + "Vanish mode disabled!");
                }else{
                    p.setInvisible(true);
                    p.sendMessage(ChatColor.GREEN + "Vanish mode enabled!");
                }
            }else{
                p.sendMessage( ChatColor.RED + "You do not have a permission to execute this command");
            }
        }else{
            System.out.printf("You have to be a player to execute this command");
        }
*/
    }
}
