package me.yiyi1234.skinsystem;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import me.yiyi1234.skinsystem.commands.SkinSystemCommand;

import me.yiyi1234.skinsystem.entityhide.EntityHider;
import me.yiyi1234.skinsystem.event.DeathEvent;
import me.yiyi1234.skinsystem.event.DismountEvent;
import me.yiyi1234.skinsystem.event.JoinEvent;
import me.yiyi1234.skinsystem.event.QuitEvent;
import me.yiyi1234.skinsystem.itemstacks.ArmorStandSkinItem;
import me.yiyi1234.skinsystem.manager.PlayerManager;
import me.yiyi1234.skinsystem.mysql.MySQL;
import me.yiyi1234.skinsystem.mysql.PlayerCoreData;
import me.yiyi1234.skinsystem.pluginmsg.BungeeCordPluginMessage;
import me.yiyi1234.skinsystem.yml.ArmorStandSkin;
import me.yiyi1234.skinsystem.yml.Menu;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public final class SkinSystem extends JavaPlugin {
    private static SkinSystem instance;
    public ProtocolManager protocolManager;
    public EntityHider entityHider;
    public PlayerManager playerManager;
    public MySQL SQL;
    public PlayerCoreData playerCoreData;
    private FileConfiguration config;
    public ArmorStandSkin armorStandSkin;
    public ArmorStandSkinItem armorStandSkinItem;
    public BungeeCordPluginMessage bungeeCordPluginMessage;
    public Menu menu;


    @Override
    public void onEnable() {
        // Plugin startup logic
        setInstance(this);
        this.SQL = new MySQL();
        this.playerManager = new PlayerManager();
        this.playerCoreData = new PlayerCoreData(this);
        this.armorStandSkinItem = new ArmorStandSkinItem();
        this.armorStandSkin = new ArmorStandSkin();
        this.bungeeCordPluginMessage = new BungeeCordPluginMessage();
        this.menu = new Menu();
        armorStandSkin.createSkin();
        menu.createMenu();
        config();
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", new BungeeCordPluginMessage());
        protocolManager = ProtocolLibrary.getProtocolManager();
        entityHider = new EntityHider(this, EntityHider.Policy.BLACKLIST);

        try {
            SQL.connect();
        } catch (SQLException throwables) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7<&6SkinSystem&7> &c資料庫連線失敗"));
            this.getServer().getPluginManager().disablePlugin(this);
        }

        if (SQL.isConnected()) {
            Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
            Bukkit.getPluginManager().registerEvents(new QuitEvent(), this);
            Bukkit.getPluginManager().registerEvents(new DeathEvent(), this);
            Bukkit.getPluginManager().registerEvents(new DismountEvent(),this);
            getCommand("SkinSystem").setExecutor(new SkinSystemCommand());
            playerCoreData.createTable();
            armorStandSkinItem.createItem();
            bungeeCordPluginMessage.askPlayerList();
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&aSkinSystem &6成功啟動 依依#1350 製作"));

        }
    }


    public void config() {
        // 判斷是否有資料夾
        File file = new File(SkinSystem.getInstance().getDataFolder().getAbsolutePath() + "/config.yml");
        if (!file.exists()) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7<&6SkinSystem&7> &f正在生成 config.yml"));
            SkinSystem.getInstance().getDataFolder().mkdir();
            SkinSystem.getInstance().saveResource("config.yml", false);
        }


        config = YamlConfiguration.loadConfiguration(file);

        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    private void setInstance(SkinSystem instance) {
        SkinSystem.instance = instance;
    }
    public static SkinSystem getInstance() {
        return instance;
    }


}
