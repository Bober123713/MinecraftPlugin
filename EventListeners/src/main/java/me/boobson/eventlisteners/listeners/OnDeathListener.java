package me.boobson.eventlisteners.listeners;

import me.boobson.eventlisteners.EventListeners;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.Plugin;

public class OnDeathListener implements Listener {

    private final EventListeners eventListeners;

    public OnDeathListener(EventListeners eventListeners){
        this.eventListeners = eventListeners;
    } // easiest way of using main class in other classes

    Plugin plugin = EventListeners.getPlugin(EventListeners.class);

    @EventHandler
    public void OnPlayerDeath(PlayerDeathEvent e) {

    }

    @EventHandler
    public void OnEntityDeath(EntityDeathEvent e) {

    }
}
