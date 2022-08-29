package me.yiyi1234.skinsystem.yml;

import me.yiyi1234.skinsystem.SkinSystem;
import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Menu {
    private FileConfiguration menuMain;
    private FileConfiguration menuShop;
    private FileConfiguration menuShowCase;

    public void createMenu() {
        setMenuMain();
        setMenuShop();
        setMenuShowCase();
    }

    private void setMenuMain() {
        File menuFile = new File(SkinSystem.getInstance().getDataFolder().getAbsolutePath() + "/Menu/MenuMain.yml");
        if (!menuFile.exists()) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7<&6SkinSystem&7> &f正在生成 Menu/MenuMain.yml"));

            try {
                FileUtils.copyInputStreamToFile(SkinSystem.getInstance().getResource("MenuMain.yml"), new File(SkinSystem.getInstance().getDataFolder().getAbsolutePath() + "/Menu/MenuMain.yml"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        menuMain = YamlConfiguration.loadConfiguration(menuFile);
    }

    private void setMenuShop() {
        File menuFile = new File(SkinSystem.getInstance().getDataFolder().getAbsolutePath() + "/Menu/MenuShop.yml");
        if (!menuFile.exists()) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7<&6SkinSystem&7> &f正在生成 Menu/MenuShop.yml"));

            try {
                FileUtils.copyInputStreamToFile(SkinSystem.getInstance().getResource("MenuShop.yml"), new File(SkinSystem.getInstance().getDataFolder().getAbsolutePath() + "/Menu/MenuShop.yml"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        menuShop = YamlConfiguration.loadConfiguration(menuFile);
    }

    private void setMenuShowCase() {
        File menuFile = new File(SkinSystem.getInstance().getDataFolder().getAbsolutePath() + "/Menu/MenuShowCase.yml");
        if (!menuFile.exists()) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7<&6SkinSystem&7> &f正在生成 Menu/MenuShowCase.yml"));

            try {
                FileUtils.copyInputStreamToFile(SkinSystem.getInstance().getResource("MenuShowCase.yml"), new File(SkinSystem.getInstance().getDataFolder().getAbsolutePath() + "/Menu/MenuShowCase.yml"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        menuShowCase = YamlConfiguration.loadConfiguration(menuFile);
    }

    public FileConfiguration getMenuMain() {
        return menuMain;
    }

    public FileConfiguration getMenuShop() {
        return menuShop;
    }

    public FileConfiguration getMenuShowCase() {
        return menuShowCase;
    }

}
