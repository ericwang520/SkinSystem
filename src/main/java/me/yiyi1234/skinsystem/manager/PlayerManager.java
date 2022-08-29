package me.yiyi1234.skinsystem.manager;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.StructureModifier;
import me.yiyi1234.skinsystem.SkinSystem;
import me.yiyi1234.skinsystem.core.PlayerCore;
import me.yiyi1234.skinsystem.itemstacks.ArmorStandSkinItem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EntityEquipment;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class PlayerManager {
    public static HashMap<Player, PlayerCore> playerMap = new HashMap<>();
    public static HashMap<Player, ArmorStand> playerArmorStandHashMap = new HashMap<>();
    public static List<ArmorStand> activeArmorStand = new ArrayList<>();

    public void createPlayerCore(Player player) {
        if (playerMap.containsKey(player))
            playerMap.remove(player);

        if (!SkinSystem.getInstance().playerCoreData.exists(player.getUniqueId())) {
            PlayerCore playerCore = new PlayerCore(player);
            playerMap.put(player, playerCore);
            SkinSystem.getInstance().playerCoreData.createPlayer(player.getUniqueId());
        }

        if (SkinSystem.getInstance().playerCoreData.exists(player.getUniqueId())) {
            boolean viewParticles = SkinSystem.getInstance().playerCoreData.getBoolean(player.getUniqueId(), "viewparticles");
            boolean viewArmorStand = SkinSystem.getInstance().playerCoreData.getBoolean(player.getUniqueId(), "viewarmorstand");
            boolean viewSelfParticles = SkinSystem.getInstance().playerCoreData.getBoolean(player.getUniqueId(), "viewselfparticles");
            boolean viewSelfArmorStand = SkinSystem.getInstance().playerCoreData.getBoolean(player.getUniqueId(), "viewselfarmorstand");
            String skinHelmet = SkinSystem.getInstance().playerCoreData.getString(player.getUniqueId(), "skinHelmet");
            String skinChestPlate = SkinSystem.getInstance().playerCoreData.getString(player.getUniqueId(), "skinChestPlate");
            String skinLeggings = SkinSystem.getInstance().playerCoreData.getString(player.getUniqueId(), "skinLeggings");
            String skinBoots = SkinSystem.getInstance().playerCoreData.getString(player.getUniqueId(), "skinBoots");
            String skinItemMainHand = SkinSystem.getInstance().playerCoreData.getString(player.getUniqueId(), "skinItemMainHand");
            String skinItemOffHand = SkinSystem.getInstance().playerCoreData.getString(player.getUniqueId(), "skinItemOffHand");

            PlayerCore playerCore = new PlayerCore(player, viewParticles, viewArmorStand, viewSelfParticles, viewSelfArmorStand, skinHelmet, skinChestPlate, skinLeggings, skinBoots, skinItemMainHand, skinItemOffHand);
            playerMap.put(player, playerCore);

        }

        PlayerCore playerCore = playerMap.get(player);
        Entity armorStandEntity = player.getWorld().spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
        ArmorStand armorStand = (ArmorStand) armorStandEntity;
        armorStand.setInvulnerable(true);
//        armorStand.setInvisible(true);
        armorStand.setMarker(true);
        player.addPassenger(armorStand);


        EntityEquipment entityEquipment = armorStand.getEquipment();
        if (playerCore.getSkinHelmet() != null) {
            if (SkinSystem.getInstance().armorStandSkinItem.skinHelmet.get(playerCore.getSkinHelmet()) != null) {
                entityEquipment.setHelmet(SkinSystem.getInstance().armorStandSkinItem.skinHelmet.get(playerCore.getSkinHelmet()));
            } else {
                String warning_nullSkin = SkinSystem.getInstance().getConfig().getString("warning.nullSkin").replace("%skin_name%", playerCore.getSkinHelmet()).replace("%skin_type%", "SkinHelmet");
                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', warning_nullSkin));
            }
        }
        if (playerCore.getSkinChestPlate() != null) {
            if (SkinSystem.getInstance().armorStandSkinItem.skinChestPlate.get(playerCore.getSkinChestPlate()) != null) {
                entityEquipment.setChestplate(SkinSystem.getInstance().armorStandSkinItem.skinChestPlate.get(playerCore.getSkinChestPlate()));
            } else {
                String warning_nullSkin = SkinSystem.getInstance().getConfig().getString("warning.nullSkin").replace("%skin_name%", playerCore.getSkinChestPlate()).replace("%skin_type%", "SkinChestPlate");
                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', warning_nullSkin));
            }
        }

        if (playerCore.getSkinLeggings() != null) {
            if (SkinSystem.getInstance().armorStandSkinItem.skinLeggings.get(playerCore.getSkinLeggings()) != null) {
                entityEquipment.setLeggings(SkinSystem.getInstance().armorStandSkinItem.skinLeggings.get(playerCore.getSkinLeggings()));
            } else {
                String warning_nullSkin = SkinSystem.getInstance().getConfig().getString("warning.nullSkin").replace("%skin_name%", playerCore.getSkinLeggings()).replace("%skin_type%", "SkinLeggings");
                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', warning_nullSkin));
            }
        }
        if (playerCore.getSkinBoots() != null) {
            if (SkinSystem.getInstance().armorStandSkinItem.skinBoots.get(playerCore.getSkinBoots()) != null) {
                entityEquipment.setBoots(SkinSystem.getInstance().armorStandSkinItem.skinBoots.get(playerCore.getSkinBoots()));
            } else {
                String warning_nullSkin = SkinSystem.getInstance().getConfig().getString("warning.nullSkin").replace("%skin_name%", playerCore.getSkinBoots()).replace("%skin_type%", "SkinBoots");
                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', warning_nullSkin));
            }
        }
        if (playerCore.getSkinItemMainHand() != null) {
            if (SkinSystem.getInstance().armorStandSkinItem.skinItemMainHand.get(playerCore.getSkinItemMainHand()) != null) {
                entityEquipment.setItemInMainHand(SkinSystem.getInstance().armorStandSkinItem.skinItemMainHand.get(playerCore.getSkinItemMainHand()));
            } else {
                String warning_nullSkin = SkinSystem.getInstance().getConfig().getString("warning.nullSkin").replace("%skin_name%", playerCore.getSkinItemMainHand()).replace("%skin_type%", "SkinItemMainHand");
                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', warning_nullSkin));
            }
        }
        if (playerCore.getSkinItemOffHand() != null) {
            if (SkinSystem.getInstance().armorStandSkinItem.skinItemOffHand.get(playerCore.getSkinItemOffHand()) != null) {
                entityEquipment.setItemInOffHand(SkinSystem.getInstance().armorStandSkinItem.skinItemOffHand.get(playerCore.getSkinItemOffHand()));
            } else {
                String warning_nullSkin = SkinSystem.getInstance().getConfig().getString("warning.nullSkin").replace("%skin_name%", playerCore.getSkinItemOffHand()).replace("%skin_type%", "SkinItemOffHand");
                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', warning_nullSkin));
            }
        }

        playerArmorStandHashMap.put(player, armorStand);
        activeArmorStand.add(armorStand);
        armorStand_CanSee(player);

        SkinSystem.getInstance().getServer().getScheduler().runTaskTimer(SkinSystem.getInstance(), () -> {
            armorStand.setRotation(player.getLocation().getYaw(), player.getLocation().getPitch());
        }, 0, 1);

        return;
    }
    public void armorStand_CanSee(Player player) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (!SkinSystem.getInstance().playerManager.getPlayerCore(p).canViewArmorStand()) {
                if (p != player) {
                    SkinSystem.getInstance().entityHider.hideEntity(p, SkinSystem.getInstance().playerManager.playerArmorStandHashMap.get(player));
                }
            }
        }
        if (!SkinSystem.getInstance().playerManager.getPlayerCore(player).canViewArmorStand()){
            for (ArmorStand armorStand : SkinSystem.getInstance().playerManager.activeArmorStand) {
                if (armorStand != SkinSystem.getInstance().playerManager.playerArmorStandHashMap.get(player)) {
                    SkinSystem.getInstance().entityHider.hideEntity(player, armorStand);
                }
            }
        }
        if (!SkinSystem.getInstance().playerManager.getPlayerCore(player).canViewSelfArmorStand()) {
            SkinSystem.getInstance().entityHider.hideEntity(player, SkinSystem.getInstance().playerManager.playerArmorStandHashMap.get(player));
        }
    }
    public void savePlayerCore(Player player) {
        SkinSystem.getInstance().playerCoreData.savePlayerCore(player.getUniqueId(), getPlayerCore(player));
    }

    public void deletePlayerCore(Player player) {
        savePlayerCore(player);
        playerArmorStandHashMap.get(player).remove();
        activeArmorStand.remove(playerArmorStandHashMap.get(player));
        playerArmorStandHashMap.remove(player);
        playerMap.remove(player);
    }

    public PlayerCore getPlayerCore(Player player) {
        return playerMap.get(player);
    }


}
