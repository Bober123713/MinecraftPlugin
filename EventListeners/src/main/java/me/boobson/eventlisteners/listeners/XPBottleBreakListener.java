package me.boobson.eventlisteners.listeners;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.ThrownExpBottle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ExpBottleEvent;

public class XPBottleBreakListener implements Listener {
    @EventHandler
    public void onXPBottleBreak(ExpBottleEvent e)
    {
        e.setShowEffect(true);
    }
}
