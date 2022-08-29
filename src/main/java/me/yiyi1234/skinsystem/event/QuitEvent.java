package me.yiyi1234.skinsystem.event;

import me.yiyi1234.skinsystem.SkinSystem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitEvent implements Listener {
    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        SkinSystem.getInstance().playerManager.deletePlayerCore(event.getPlayer());
    }
}