package dev.tomstar.ProPractice.listeners;

import dev.tomstar.ProPractice.handlers.PlayerHandler;
import dev.tomstar.ProPractice.ProPractice;
import dev.tomstar.ProPractice.states.PlayerState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.UUID;

public class PlayerQuitListener implements Listener {

    private final ProPractice plugin;

    public PlayerQuitListener(ProPractice plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        PlayerHandler handler = plugin.getPlayerHandler();
        UUID player = event.getPlayer().getUniqueId();

        handler.getPlayer(player).setState(PlayerState.OFFLINE);
    }

}
