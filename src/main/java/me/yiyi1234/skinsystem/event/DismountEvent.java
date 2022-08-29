package me.yiyi1234.skinsystem.event;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.spigotmc.event.entity.EntityDismountEvent;

public class DismountEvent implements Listener {
    @EventHandler
    public void onDismount(EntityDismountEvent event) {
        if (event.getEntityType() == EntityType.ARMOR_STAND) {
            event.setCancelled(true);
        }
    }
}
