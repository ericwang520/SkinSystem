package me.yiyi1234.skinsystem.event;

import me.yiyi1234.skinsystem.SkinSystem;
import org.bukkit.Bukkit;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        if (event.getPlayer().isDead()) {
            event.getPlayer().spigot().respawn();
        }
        SkinSystem.getInstance().playerManager.createPlayerCore(event.getPlayer());

    }

}
