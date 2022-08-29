package me.yiyi1234.skinsystem.itemstacks;

import me.yiyi1234.skinsystem.SkinSystem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.Locale;

public class ArmorStandSkinItem {
    public HashMap<String, ItemStack> skinHelmet = new HashMap<>();
    public HashMap<String, ItemStack> skinChestPlate = new HashMap<>();
    public HashMap<String, ItemStack> skinLeggings = new HashMap<>();
    public HashMap<String, ItemStack> skinBoots = new HashMap<>();
    public HashMap<String, ItemStack> skinItemMainHand = new HashMap<>();
    public HashMap<String, ItemStack> skinItemOffHand = new HashMap<>();

    public void createItem() {

        if (SkinSystem.getInstance().armorStandSkin.getSkinHelmetFile().getConfigurationSection("") != null) {
            int times=0;
            for (String s : SkinSystem.getInstance().armorStandSkin.getSkinHelmetFile().getConfigurationSection("").getKeys(false)) {
                String material = SkinSystem.getInstance().armorStandSkin.getSkinHelmetFile().getString(s + ".armorStand_material").toUpperCase(Locale.ROOT);
                int customModelData = SkinSystem.getInstance().armorStandSkin.getSkinHelmetFile().getInt(s + ".armorStand_customModelData");
                ItemStack itemStack = new ItemStack(Material.getMaterial(material));
                ItemMeta itemMeta = itemStack.getItemMeta();
                itemMeta.setCustomModelData(customModelData);
                itemStack.setItemMeta(itemMeta);
                skinHelmet.put(s, itemStack);
                times++;

            }
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&6系統&7] &6成功載入 " + times + " 種 skinHelmet"));
        }
        if (SkinSystem.getInstance().armorStandSkin.getSkinChestPlate().getConfigurationSection("") != null) {
            int times=0;
            for (String s : SkinSystem.getInstance().armorStandSkin.getSkinChestPlate().getConfigurationSection("").getKeys(false)) {
                String material = SkinSystem.getInstance().armorStandSkin.getSkinChestPlate().getString(s + ".armorStand_material").toUpperCase(Locale.ROOT);
                int customModelData = SkinSystem.getInstance().armorStandSkin.getSkinChestPlate().getInt(s + ".armorStand_customModelData");
                ItemStack itemStack = new ItemStack(Material.getMaterial(material));
                ItemMeta itemMeta = itemStack.getItemMeta();
                itemMeta.setCustomModelData(customModelData);
                itemStack.setItemMeta(itemMeta);
                skinChestPlate.put(s, itemStack);
                times++;
            }
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&6系統&7] &6成功載入 " + times + " 種 SkinChestPlate"));

        }
        if (SkinSystem.getInstance().armorStandSkin.getSkinLeggings().getConfigurationSection("") != null) {
            int times=0;
            for (String s : SkinSystem.getInstance().armorStandSkin.getSkinLeggings().getConfigurationSection("").getKeys(false)) {
                String material = SkinSystem.getInstance().armorStandSkin.getSkinLeggings().getString(s + ".armorStand_material").toUpperCase(Locale.ROOT);
                int customModelData = SkinSystem.getInstance().armorStandSkin.getSkinLeggings().getInt(s + ".armorStand_customModelData");
                ItemStack itemStack = new ItemStack(Material.getMaterial(material));
                ItemMeta itemMeta = itemStack.getItemMeta();
                itemMeta.setCustomModelData(customModelData);
                itemStack.setItemMeta(itemMeta);
                skinLeggings.put(s, itemStack);
                times++;
            }
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&6系統&7] &6成功載入 " + times + " 種 SkinLeggings"));

        }
        if (SkinSystem.getInstance().armorStandSkin.getSkinBoots().getConfigurationSection("") != null) {
            int times=0;
            for (String s : SkinSystem.getInstance().armorStandSkin.getSkinBoots().getConfigurationSection("").getKeys(false)) {
                String material = SkinSystem.getInstance().armorStandSkin.getSkinBoots().getString(s + ".armorStand_material").toUpperCase(Locale.ROOT);
                int customModelData = SkinSystem.getInstance().armorStandSkin.getSkinBoots().getInt(s + ".armorStand_customModelData");
                ItemStack itemStack = new ItemStack(Material.getMaterial(material));
                ItemMeta itemMeta = itemStack.getItemMeta();
                itemMeta.setCustomModelData(customModelData);
                itemStack.setItemMeta(itemMeta);
                skinBoots.put(s, itemStack);
                times++;
            }
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&6系統&7] &6成功載入 " + times + " 種 SkinBoots"));

        }
        if (SkinSystem.getInstance().armorStandSkin.getSkinItemMainHand().getConfigurationSection("") != null) {
            int times=0;
            for (String s : SkinSystem.getInstance().armorStandSkin.getSkinItemMainHand().getConfigurationSection("").getKeys(false)) {
                String material = SkinSystem.getInstance().armorStandSkin.getSkinItemMainHand().getString(s + ".armorStand_material").toUpperCase(Locale.ROOT);
                int customModelData = SkinSystem.getInstance().armorStandSkin.getSkinItemMainHand().getInt(s + ".armorStand_customModelData");
                ItemStack itemStack = new ItemStack(Material.getMaterial(material));
                ItemMeta itemMeta = itemStack.getItemMeta();
                itemMeta.setCustomModelData(customModelData);
                itemStack.setItemMeta(itemMeta);
                skinItemMainHand.put(s, itemStack);
                times++;
            }
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&6系統&7] &6成功載入 " + times + " 種 SkinItemMainHand"));

        }
        if ( SkinSystem.getInstance().armorStandSkin.getSkinItemOffHand().getConfigurationSection("") != null) {
            int times=0;
            for (String s : SkinSystem.getInstance().armorStandSkin.getSkinItemOffHand().getConfigurationSection("").getKeys(false)) {
                String material = SkinSystem.getInstance().armorStandSkin.getSkinItemOffHand().getString(s + ".armorStand_material").toUpperCase(Locale.ROOT);
                int customModelData = SkinSystem.getInstance().armorStandSkin.getSkinItemOffHand().getInt(s + ".armorStand_customModelData");
                ItemStack itemStack = new ItemStack(Material.getMaterial(material));
                ItemMeta itemMeta = itemStack.getItemMeta();
                itemMeta.setCustomModelData(customModelData);
                itemStack.setItemMeta(itemMeta);
                skinItemOffHand.put(s, itemStack);
                times++;
            }
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&6系統&7] &6成功載入 " + times + " 種 SkinItemOffHand "));

        }

    }
}
