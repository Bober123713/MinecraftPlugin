package me.boobson.eventlisteners.listeners;

import me.boobson.eventlisteners.EventListeners;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

public class OnPlayerJoinLeave implements Listener {

    EventListeners plugin;

    public OnPlayerJoinLeave(EventListeners plugin) {
        this.plugin = plugin;
    }

    // Plugin plugin = EventListeners.getPlugin(EventListeners.class);

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String firstWelcomeMessage1 = plugin.getConfig().getString("FirstWelcomeMessage1");
        String firstWelcomeMessage2 = plugin.getConfig().getString("FirstWelcomeMessage2");
        String welcomeMessage1 = plugin.getConfig().getString("WelcomeMessage1");
        String welcomeMessage2 = plugin.getConfig().getString("WelcomeMessage2");

        for (int i = 0; i < plugin.invisibleList.size(); i++){
            player.hidePlayer(plugin, plugin.invisibleList.get(i));
        }

        if(player.hasPlayedBefore()) {
            event.setJoinMessage( "\n" + welcomeMessage1 + ChatColor.YELLOW + player.getDisplayName() + ChatColor.RESET + welcomeMessage2 + "\n");
        }
        else {
            event.setJoinMessage( "\n" + firstWelcomeMessage1 + ChatColor.YELLOW + player.getDisplayName() + firstWelcomeMessage2 + "\n");
        }


    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.setQuitMessage(ChatColor.YELLOW + player.getDisplayName() + ChatColor.RESET + " poszedł sobie");
    }
}
