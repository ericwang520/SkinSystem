package me.yiyi1234.skinsystem.pluginmsg;

import com.google.common.collect.Iterables;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import me.yiyi1234.skinsystem.SkinSystem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.util.ArrayList;
import java.util.List;

public class BungeeCordPluginMessage implements PluginMessageListener {
    public String[] playerList;
    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equals("BungeeCord")) {
            return;
        }
        ByteArrayDataInput in = ByteStreams.newDataInput(message);
        String subchannel = in.readUTF();
        if (subchannel.equals("PlayerList")) {
            // Use the code sample in the 'Response' sections below to read
            // the data.
            String server = in.readUTF(); // The name of the server you got the player list of, as given in args.
            playerList = in.readUTF().split(", ");
        }
    }
    public void askPlayerList() {

        SkinSystem.getInstance().getServer().getScheduler().scheduleSyncRepeatingTask(SkinSystem.getInstance(), () -> {
            ByteArrayDataOutput out = ByteStreams.newDataOutput();
            out.writeUTF("PlayerList");
            out.writeUTF("ALL");
            Player player = Iterables.getFirst(Bukkit.getOnlinePlayers(), null);
            player.sendPluginMessage(SkinSystem.getInstance(), "BungeeCord", out.toByteArray());

        }, 0, 100);

    }

}
