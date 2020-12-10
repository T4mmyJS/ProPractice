package dev.tomstar.ProPractice.utils;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PlayerUtils {

    public static String getName(UUID uuid) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getUniqueId().equals(uuid)) return player.getName();
        }

        for (OfflinePlayer player : Bukkit.getOfflinePlayers()) {
            if (player.getUniqueId().equals(uuid)) return player.getName();
        }

        return null;
    }

    public static Player getOnlinePlayer(UUID uuid) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getUniqueId().equals(uuid)) return player;
        }

        return null;
    }

}
