package me.boobson.eventlisteners.listeners;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerShearEntityEvent;

public class ShearSheepListener implements Listener {
    @EventHandler
    public void onShearSheep(PlayerShearEntityEvent e)
    {
        Player player = e.getPlayer();
        Entity entity = e.getEntity();
    }
}
