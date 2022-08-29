package me.yiyi1234.skinsystem.commands;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import me.yiyi1234.skinsystem.SkinSystem;
import me.yiyi1234.skinsystem.core.PlayerCore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;


public class SkinSystemCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length < 1) {
            Inventory loadingMenu = Bukkit.createInventory(null, 54, "時裝系統");

        }

        // skinsystem set Bear1314 helmet test
        if (args.length >= 2) {
            if (args[0].equalsIgnoreCase("set")) {
                if (args[2].equalsIgnoreCase("helmet")) {
                    Player player = (Player) sender;
                    PlayerCore playerCore = SkinSystem.getInstance().playerManager.getPlayerCore(player);
                    playerCore.setSkinHelmet(args[3]);
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&6系統&7] &c成功將玩家 helmet 造型設置為: " + args[3]));
                }
                if (args[2].equalsIgnoreCase("chestplate")) {
                    Player player = (Player) sender;
                    PlayerCore playerCore = SkinSystem.getInstance().playerManager.getPlayerCore(player);
                    playerCore.setSkinHelmet(args[3]);
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&6系統&7] &c成功將玩家 chestplate 造型設置為: " + args[3]));
                }
                if (args[2].equalsIgnoreCase("itemmainhand")) {
                    Player player = (Player) sender;
                    PlayerCore playerCore = SkinSystem.getInstance().playerManager.getPlayerCore(player);
                    playerCore.setSkinHelmet(args[3]);
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&6系統&7] &c成功將玩家 itemmainhand 造型設置為: " + args[3]));
                }
                if (args[2].equalsIgnoreCase("itemoffhand")) {
                    Player player = (Player) sender;
                    PlayerCore playerCore = SkinSystem.getInstance().playerManager.getPlayerCore(player);
                    playerCore.setSkinHelmet(args[3]);
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&6系統&7] &c成功將玩家 itemoffhand 造型設置為: " + args[3]));
                }
                if (args[2].equalsIgnoreCase("leggings")) {
                    Player player = (Player) sender;
                    PlayerCore playerCore = SkinSystem.getInstance().playerManager.getPlayerCore(player);
                    playerCore.setSkinHelmet(args[3]);
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&6系統&7] &c成功將玩家 leggings 造型設置為: " + args[3]));
                }
                if (args[2].equalsIgnoreCase("boots")) {
                    Player player = (Player) sender;
                    PlayerCore playerCore = SkinSystem.getInstance().playerManager.getPlayerCore(player);
                    playerCore.setSkinHelmet(args[3]);
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&6系統&7] &c成功將玩家 boots 造型設置為: " + args[3]));
                }
            }

        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            List<String> arguments = new ArrayList<>();
            arguments.add("set");
            return arguments;
        }
        if (args[0].equalsIgnoreCase("set")) {
            List<String> arguments = new ArrayList<>();

            arguments.add("<玩家ID>");

            return arguments;
        }
        if (args.length == 2) {
            if (args[0].equalsIgnoreCase("set")) {
                List<String> arguments = new ArrayList<>();
                arguments.add("helmet");
                arguments.add("chestplate");
                arguments.add("leggings");
                arguments.add("boots");
                arguments.add("itemmainhand");
                arguments.add("itemoffhand");
                return arguments;
            }
        }
        if (args[2].equalsIgnoreCase("helmet")) {
            List<String> arguments = new ArrayList<>();
            for (String key : SkinSystem.getInstance().armorStandSkinItem.skinHelmet.keySet()) {
                arguments.add(key);
            }
            return arguments;
        }
        if (args[2].equalsIgnoreCase("chestplate")) {
            List<String> arguments = new ArrayList<>();
            for (String key : SkinSystem.getInstance().armorStandSkinItem.skinChestPlate.keySet()) {
                arguments.add(key);
            }
            return arguments;
        }
        if (args[2].equalsIgnoreCase("leggings")) {
            List<String> arguments = new ArrayList<>();
            for (String key : SkinSystem.getInstance().armorStandSkinItem.skinLeggings.keySet()) {
                arguments.add(key);
            }
            return arguments;
        }
        if (args[2].equalsIgnoreCase("boots")) {
            List<String> arguments = new ArrayList<>();
            for (String key : SkinSystem.getInstance().armorStandSkinItem.skinBoots.keySet()) {
                arguments.add(key);
            }
            return arguments;
        }
        if (args[2].equalsIgnoreCase("itemmainhand")) {
            List<String> arguments = new ArrayList<>();
            for (String key : SkinSystem.getInstance().armorStandSkinItem.skinItemMainHand.keySet()) {
                arguments.add(key);
            }
            return arguments;
        }
        if (args[2].equalsIgnoreCase("itemoffhand")) {
            List<String> arguments = new ArrayList<>();
            for (String key : SkinSystem.getInstance().armorStandSkinItem.skinItemOffHand.keySet()) {
                arguments.add(key);
            }
            return arguments;
        }

        return null;
    }


}
