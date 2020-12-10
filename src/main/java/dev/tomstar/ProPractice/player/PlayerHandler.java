package dev.tomstar.ProPractice.player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.*;

public class PlayerHandler {

    private final Map<UUID, PlayerState> players;

    public PlayerHandler() {
        this.players = new HashMap<>();

        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            setPlayerState(player.getUniqueId(), PlayerState.ONLINE);
        }
    }

    public void setPlayerState(UUID uuid, PlayerState state) {
        players.put(uuid, state);
    }

    public boolean playerOnline(UUID uuid) {
        return !players.get(uuid).equals(PlayerState.OFFLINE);
    }

}
