package me.yiyi1234.skinsystem.yml;

import me.yiyi1234.skinsystem.SkinSystem;
import me.yiyi1234.skinsystem.itemstacks.ArmorStandSkinItem;
import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;


public class ArmorStandSkin {
    private FileConfiguration skinHelmet;
    private FileConfiguration skinChestPlate;
    private FileConfiguration skinLeggings;
    private FileConfiguration skinBoots;
    private FileConfiguration skinItemMainHand;
    private FileConfiguration skinItemOffHand;
    private ArmorStandSkinItem armorStandSkinItem;
    public void createSkin() {
        setSkinHelmet();
        setSkinChestPlate();
        setSkinLeggings();
        setSkinBoots();
        setSkinItemMainHand();
        setSkinItemOffHand();
    }
    private void setSkinHelmet() {
        File skinFile = new File(SkinSystem.getInstance().getDataFolder().getAbsolutePath() + "/ArmorStand/SkinHelmet.yml");
        if (!skinFile.exists()) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7<&6SkinSystem&7> &f正在生成 ArmorStand/SkinHelmet.yml"));

            try {
                FileUtils.copyInputStreamToFile(SkinSystem.getInstance().getResource("SkinHelmet.yml"), new File(SkinSystem.getInstance().getDataFolder().getAbsolutePath() + "/ArmorStand/SkinHelmet.yml"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        skinHelmet = YamlConfiguration.loadConfiguration(skinFile);

    }
    private void setSkinChestPlate() {
        File skinFile = new File(SkinSystem.getInstance().getDataFolder().getAbsolutePath() + "/ArmorStand/SkinChestPlate.yml");
        if (!skinFile.exists()) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7<&6SkinSystem&7> &f正在生成 ArmorStand/SkinChestPlate.yml"));

            try {
                FileUtils.copyInputStreamToFile(SkinSystem.getInstance().getResource("SkinChestPlate.yml"), new File(SkinSystem.getInstance().getDataFolder().getAbsolutePath() + "/ArmorStand/SkinChestPlate.yml"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        skinChestPlate = YamlConfiguration.loadConfiguration(skinFile);

    }
    private void setSkinLeggings() {
        File skinFile = new File(SkinSystem.getInstance().getDataFolder().getAbsolutePath() + "/ArmorStand/SkinLeggings.yml");
        if (!skinFile.exists()) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7<&6SkinSystem&7> &f正在生成 ArmorStand/SkinLeggings.yml"));

            try {
                FileUtils.copyInputStreamToFile(SkinSystem.getInstance().getResource("SkinLeggings.yml"), new File(SkinSystem.getInstance().getDataFolder().getAbsolutePath() + "/ArmorStand/SkinLeggings.yml"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        skinLeggings = YamlConfiguration.loadConfiguration(skinFile);

    }
    private void setSkinBoots() {
        File skinFile = new File(SkinSystem.getInstance().getDataFolder().getAbsolutePath() + "/ArmorStand/SkinBoots.yml");
        if (!skinFile.exists()) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7<&6SkinSystem&7> &f正在生成 ArmorStand/SkinBoots.yml"));

            try {
                FileUtils.copyInputStreamToFile(SkinSystem.getInstance().getResource("SkinBoots.yml"), new File(SkinSystem.getInstance().getDataFolder().getAbsolutePath() + "/ArmorStand/SkinBoots.yml"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        skinBoots = YamlConfiguration.loadConfiguration(skinFile);

    }
    private void setSkinItemMainHand() {
        File skinFile = new File(SkinSystem.getInstance().getDataFolder().getAbsolutePath() + "/ArmorStand/SkinItemMainHand.yml");
        if (!skinFile.exists()) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7<&6SkinSystem&7> &f正在生成 ArmorStand/SkinItemMainHand.yml"));

            try {
                FileUtils.copyInputStreamToFile(SkinSystem.getInstance().getResource("SkinItemMainHand.yml"), new File(SkinSystem.getInstance().getDataFolder().getAbsolutePath() + "/ArmorStand/SkinItemMainHand.yml"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        skinItemMainHand = YamlConfiguration.loadConfiguration(skinFile);

    }
    private void setSkinItemOffHand () {
        File skinFile = new File(SkinSystem.getInstance().getDataFolder().getAbsolutePath() + "/ArmorStand/SkinItemOffHand.yml");
        if (!skinFile.exists()) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7<&6SkinSystem&7> &f正在生成 ArmorStand/SkinItemOffHand.yml"));

            try {
                FileUtils.copyInputStreamToFile(SkinSystem.getInstance().getResource("SkinItemOffHand.yml"), new File(SkinSystem.getInstance().getDataFolder().getAbsolutePath() + "/ArmorStand/SkinItemOffHand.yml"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        skinItemOffHand  = YamlConfiguration.loadConfiguration(skinFile);

    }
    public FileConfiguration getSkinHelmetFile() { return skinHelmet; }
    public FileConfiguration getSkinChestPlate() { return skinChestPlate; }
    public FileConfiguration getSkinLeggings() { return skinLeggings; }
    public FileConfiguration getSkinBoots() { return skinBoots; }
    public FileConfiguration getSkinItemMainHand() { return skinItemMainHand; }
    public FileConfiguration getSkinItemOffHand () { return skinItemOffHand; }
}
