package dev.tomstar.ProPractice.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class ChatUtils {

    public static String parse(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static void sendConsole(String text) {
        Bukkit.getConsoleSender().sendMessage(parse(text));
    }

}
