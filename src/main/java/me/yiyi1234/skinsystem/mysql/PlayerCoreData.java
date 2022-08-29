package me.yiyi1234.skinsystem.mysql;

import me.yiyi1234.skinsystem.SkinSystem;
import me.yiyi1234.skinsystem.core.PlayerCore;
import org.bukkit.Bukkit;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class PlayerCoreData {
    private SkinSystem plugin;

    public PlayerCoreData(SkinSystem plugin) {
        this.plugin = plugin;
    }

    public void createTable() {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS SkinSystem_PlayerCoreData (playerid VARCHAR(35), playeruuid VARCHAR(40), viewparticles VARCHAR(5), viewselfparticles VARCHAR(5), viewarmorstand VARCHAR(5), viewselfarmorstand VARCHAR (5), skinhelmet VARCHAR(30), skinchestplate VARCHAR(30), skinleggings VARCHAR(30), skinboots VARCHAR(30), skinitemmainhand VARCHAR(30), skinitemoffhand VARCHAR(30));");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createPlayer(UUID uuid) {
        try {
            // 新增玩家
            if (!exists(uuid)) {
                PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("INSERT INTO SkinSystem_PlayerCoreData VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1, Bukkit.getOfflinePlayer(uuid).getName());
                ps.setString(2, uuid.toString());
                ps.setString(3, "true");
                ps.setString(4, "true");
                ps.setString(5, "true");
                ps.setString(6, "true");
                ps.setString(7, null);
                ps.setString(8, null);
                ps.setString(9, null);
                ps.setString(10, null);
                ps.setString(11, null);
                ps.setString(12, null);
                ps.executeUpdate();
                return;
            }
            // 更新 name
            if (exists(uuid)) {

                PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE SkinSystem_PlayerCoreData SET playerid=? WHERE playeruuid=?;");
                ps.setString(1, Bukkit.getOfflinePlayer(uuid).getName());
                ps.setString(1, uuid.toString());
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean exists(UUID uuid) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT * FROM SkinSystem_PlayerCoreData WHERE playerUUID=?");
            ps.setString(1, uuid.toString());
            ResultSet results = ps.executeQuery();
            if (results.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean getBoolean(UUID uuid, String column) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT " + column + " FROM SkinSystem_PlayerCoreData WHERE playerUUID=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Boolean columnBoolean = rs.getBoolean(column);
                return columnBoolean;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public String getString(UUID uuid, String column) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT " + column + " FROM SkinSystem_PlayerCoreData WHERE playerUUID=?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String columnString = rs.getString(column);
                return columnString;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setString(UUID uuid, String column, String string) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE SkinSystem_PlayerCoreData SET " + column + "=? WHERE playerUUID=?");
            ps.setString(1, string);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void savePlayerCore(UUID uuid, PlayerCore playerCore) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("UPDATE SkinSystem_PlayerCoreData SET viewparticles=?, viewarmorstand=?, viewselfparticles=?, viewselfarmorstand=?, skinHelmet=?, skinChestPlate=?, skinLeggings=?, skinBoots=?, skinItemMainHand=?, skinItemOffHand=? WHERE playerUUID=?");
            ps.setString(1, playerCore.canViewParticles().toString());
            ps.setString(2, playerCore.canViewArmorStand().toString());
            ps.setString(3, playerCore.canViewSelfParticles().toString());
            ps.setString(4, playerCore.canViewSelfArmorStand().toString());
            ps.setString(5, playerCore.getSkinHelmet());
            ps.setString(6, playerCore.getSkinChestPlate());
            ps.setString(7, playerCore.getSkinLeggings());
            ps.setString(8, playerCore.getSkinBoots());
            ps.setString(9, playerCore.getSkinItemMainHand());
            ps.setString(10, playerCore.getSkinItemOffHand());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
