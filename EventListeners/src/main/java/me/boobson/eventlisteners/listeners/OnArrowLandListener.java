package me.boobson.eventlisteners.listeners;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.Dispenser;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.PlayerInventory;

import java.util.Objects;

public class OnArrowLandListener implements Listener {
    @EventHandler
    public void onArrowLand(ProjectileHitEvent projectileHitEventObject){
        Projectile projectile = projectileHitEventObject.getEntity();
        if (projectile instanceof Arrow){
            Block hit = projectileHitEventObject.getHitBlock();
            if(hit == null) return;
            Arrow arrow = (Arrow) projectile;
            Entity shooter = (Entity) arrow.getShooter();
            if (shooter instanceof Player player) {
                broadCastLocation(arrow.getLocation(), hit, player);
                String name = player.getInventory().getItemInMainHand().getItemMeta().getDisplayName();
                String nameToCheck = player.getInventory().getItemInMainHand().getType().name();
                if (name.equals("luk")) {
                    Bukkit.broadcastMessage("Dziala poprawnie" + " " + name + ", "+nameToCheck);
                }
            }
        }
    }
    private void broadCastLocation(Location location, Block block, Player player){
        block.setType(Material.DIAMOND_BLOCK);
        Bukkit.broadcastMessage(ChatColor.BOLD + "" + ChatColor.YELLOW + player.getDisplayName());
        Bukkit.broadcastMessage("x:" + (int)location.getX() + " y:" + (int)location.getY()+" z:" + (int)location.getZ() + "\n");
    }

}
