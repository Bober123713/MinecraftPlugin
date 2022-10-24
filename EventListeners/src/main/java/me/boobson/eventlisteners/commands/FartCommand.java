package me.boobson.eventlisteners.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FartCommand implements CommandExecutor {

    // /fart <PlayerName>

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p) {
            if(args.length == 0) {
                p.sendMessage("You just fated on yourself");
                p.damage(10);;
            }else{
                String playerName = args[0];

                Player target = Bukkit.getServer().getPlayerExact(playerName);

                if(target == null) {
                    p.sendMessage("This player is not online");
                }else if(target.getDisplayName() == p.getDisplayName()){
                    p.sendMessage("You really tyin to fart on yourself?!");
                    p.damage(19);
                }else{
                    p.sendMessage("You farted on " + ChatColor.YELLOW + target.getDisplayName());
                    target.sendMessage("You have just been fated on by " + ChatColor.YELLOW + p.getDisplayName());
                    target.damage(19);;
                }
            }
        }

        return true;
    }
}
