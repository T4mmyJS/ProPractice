package dev.tomstar.ProPractice.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PlayerUtils {

    public static Player getOnline(UUID uuid) {
        return Bukkit.getPlayer(uuid);
    }

    public static void sendMessage(UUID uuid, String text) {
        Player player = Bukkit.getPlayer(uuid);
        if (player != null) player.sendMessage(ChatUtils.parse(text));
    }

}
