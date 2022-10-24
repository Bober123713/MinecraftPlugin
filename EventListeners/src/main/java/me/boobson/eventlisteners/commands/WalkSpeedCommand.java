package me.boobson.eventlisteners.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WalkSpeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            float baseSpeed = (float) 0.2;
            if(p.hasPermission("eventlisteners.speed")){
                if(args.length == 0){
                    if(p.getWalkSpeed() == 0.2){
                        p.sendMessage("Your speed is already default. Try it like this: /speed [value] ");
                    }else {
                        p.sendMessage("Speed reset");
                        p.setWalkSpeed((float) 0.2);
                    }
                }else if(args.length == 1){
                    float speedValue = Float.parseFloat(args[0]);
                    if(speedValue > 1){
                        speedValue = 1;
                        p.setWalkSpeed(speedValue);
                        p.sendMessage("Walking speed set to: " + ChatColor.YELLOW + speedValue);
                    }else if(speedValue <= 0){
                        speedValue = (float) 0.01;
                        p.setWalkSpeed(speedValue);
                        p.sendMessage("Walking speed set to: " + ChatColor.YELLOW + speedValue);
                    }else {
                        p.sendMessage("Walking speed set to: " + ChatColor.YELLOW + speedValue);
                        p.setWalkSpeed(speedValue);
                    }
                }else{
                    p.sendMessage(ChatColor.RED + "Wrong command arguments");
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
