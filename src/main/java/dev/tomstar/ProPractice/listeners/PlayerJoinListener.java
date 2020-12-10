package dev.tomstar.ProPractice.listeners;

import dev.tomstar.ProPractice.player.PlayerHandler;
import dev.tomstar.ProPractice.ProPractice;
import dev.tomstar.ProPractice.player.PlayerState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

public class PlayerJoinListener implements Listener {

    private final ProPractice plugin;

    public PlayerJoinListener(ProPractice plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

   /* @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        PlayerHandler handler = plugin.getPlayerHandler();
        UUID player = event.getPlayer().getUniqueId();

        if (handler.playerExists(player)) {
            handler.getPlayer(player).setState(PlayerState.ONLINE);
        } else {
             handler.createPlayer(player);
        }

        handler.getPlayer(player).sendMessage("&6Welcome to the server!");
    } */

}
