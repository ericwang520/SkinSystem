package me.yiyi1234.skinsystem.core;

import me.yiyi1234.skinsystem.SkinSystem;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerCore {
    private Player player;
    private boolean viewParticles;
    private boolean viewArmorStand;
    private boolean viewSelfParticles;
    private boolean viewSelfArmorStand;
    private String skinHelmet;
    private String skinChestPlate;
    private String skinLeggings;
    private String skinBoots;
    private String skinItemMainHand;
    private String skinItemOffHand;
    private Inventory main_Page;

    public PlayerCore(Player player) {
        this(player, true, true, true, true, null, null, null, null, null, null);
    }

    public PlayerCore(Player player, Boolean viewParticles, Boolean viewArmorStand, Boolean viewSelfParticles, Boolean viewSelfArmorStand, String skinHelmet, String skinChestPlate, String skinLeggings, String skinBoots, String skinItemMainHand, String skinItemOffHand) {
        this.player = player;
        this.viewParticles = viewParticles;
        this.viewArmorStand = viewArmorStand;
        this.viewSelfParticles = viewSelfParticles;
        this.viewSelfArmorStand = viewSelfArmorStand;
        this.skinHelmet = skinHelmet;
        this.skinChestPlate = skinChestPlate;
        this.skinLeggings = skinLeggings;
        this.skinBoots = skinBoots;
        this.skinItemMainHand = skinItemMainHand;
        this.skinItemOffHand = skinItemOffHand;
    }


    public Boolean canViewParticles() {
        return viewParticles;
    }

    public void setViewParticles(Boolean viewParticles) {
        this.viewParticles = viewParticles;
    }

    public Boolean canViewArmorStand() {
        return viewArmorStand;
    }

    public void setViewArmorStand(Boolean viewArmorStand) {
        this.viewArmorStand = viewArmorStand;
    }

    public Boolean canViewSelfParticles() {
        return viewSelfParticles;
    }

    public void setViewSelfParticles(Boolean viewSelfParticles) {
        this.viewSelfParticles = viewSelfParticles;
    }

    public Boolean canViewSelfArmorStand() {
        return viewSelfArmorStand;
    }

    public void setViewSelfArmorStand(Boolean viewSelfArmorStand) {
        this.viewSelfArmorStand = viewSelfArmorStand;
    }

    public String getSkinHelmet() {
        return skinHelmet;
    }

    public void setSkinHelmet(String skinHelmet) {
        this.skinHelmet = skinHelmet;
    }

    public String getSkinChestPlate() {
        return skinHelmet;
    }

    public void setSkinChestPlate(String chestPlate) {
        this.skinChestPlate = chestPlate;
    }

    public String getSkinLeggings() {
        return skinLeggings;
    }

    public void setSkinLeggings(String skinLeggings) {
        this.skinLeggings = skinLeggings;
    }

    public String getSkinBoots() {
        return skinBoots;
    }

    public void setSkinBoots(String skinBoots) {
        this.skinBoots = skinBoots;
    }

    public String getSkinItemMainHand() {
        return skinItemMainHand;
    }

    public void setSkinItemMainHand(String itemMainHand) {
        this.skinItemMainHand = itemMainHand;
    }

    public String getSkinItemOffHand() {
        return skinHelmet;
    }

    public void setSkinItemOffHand(String itemOffHand) {
        this.skinItemOffHand = itemOffHand;
    }


}

