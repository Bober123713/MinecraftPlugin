package me.boobson.eventlisteners;

import me.boobson.eventlisteners.commands.*;
import me.boobson.eventlisteners.listeners.*;
import org.bukkit.ChatColor;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.Console;
import java.util.ArrayList;
import java.util.Optional;

public final class EventListeners extends JavaPlugin implements Listener {

    private static EventListeners plugin;

    public ArrayList<Player> invisibleList = new ArrayList<>(); // for vanish command

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("EventListeners plugin working.");

        //***
        //plugin = this; - another option for using main class functions in other classes
        //***

        getConfig().options().copyDefaults();
        saveDefaultConfig();
        //***************************************************************************************
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new XPBottleBreakListener(), this);
        getServer().getPluginManager().registerEvents(new OnLeaveBedListener(), this);
        getServer().getPluginManager().registerEvents(new OnPlayerJoinLeave(this), this);
        getServer().getPluginManager().registerEvents(new ShearSheepListener(), this);
        getServer().getPluginManager().registerEvents(new OnArrowLandListener(), this);
        //***************************************************************************************
        getCommand("god").setExecutor(new GodCommand());
        getCommand("vanish").setExecutor(new VanishCommand(this));
        getCommand("suicide").setExecutor(new SuicideCommand());
        getCommand("invisible").setExecutor(new InvisibleCommand());
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("fart").setExecutor(new FartCommand());
        getCommand("speed").setExecutor(new WalkSpeedCommand());
        getCommand("level").setExecutor(new GetLevelCommand()); // make simple add level
        getCommand("gmod").setExecutor(new BetterGameModeChangeCommand()); // faster gamemode change
    }

    //Command from YT tutorial below

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("printMessageFromConfig")){
            Player p = (Player) sender;
            String food = getConfig().getString("Food");
            p.sendMessage(food);
        }

        return false;
    }

    /*
    public static EventListeners getPlugin() {
        return plugin; - another way of using main class in other classes
    }
     */
}
