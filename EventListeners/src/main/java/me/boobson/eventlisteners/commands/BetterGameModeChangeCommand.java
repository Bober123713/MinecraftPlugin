package me.boobson.eventlisteners.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BetterGameModeChangeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player p){
            if(p.hasPermission("eventlisteners.bettergamemodechangecommand")) {
                if (args.length == 0) {
                    p.sendMessage("You have to specify a gamemode" + "\n0 - survival\n1 - creative\n2 - adventure\n3 - spectator");
                } else if (args.length == 1) {
                    int mode = Integer.parseInt(args[0]);
                    if (mode == 0) {
                        p.setGameMode(GameMode.SURVIVAL);
                        p.sendMessage(ChatColor.GREEN + "Gamemode survival");
                    } else if (mode == 1) {
                        p.setGameMode(GameMode.CREATIVE);
                        p.sendMessage(ChatColor.GREEN + "Gamemode creative");
                    } else if (mode == 2) {
                        p.setGameMode(GameMode.ADVENTURE);
                        p.sendMessage(ChatColor.GREEN + "Gamemode adventure");
                    } else if (mode == 3) {
                        p.setGameMode(GameMode.SPECTATOR);
                        p.sendMessage(ChatColor.GREEN + "Gamemode spectator");
                    } else {
                        p.sendMessage("Wrong gamemode chosen (0-3)");
                    }
                }
            }else{
                p.sendMessage( ChatColor.RED + "You do not have a permission to execute this command");
            }
        }
        return true;
    }
}
