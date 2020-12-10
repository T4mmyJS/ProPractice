package dev.tomstar.ProPractice.handlers;

import dev.tomstar.ProPractice.practice.PracticePlayer;
import dev.tomstar.ProPractice.states.PlayerState;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PlayerHandler {

    private final List<PracticePlayer> players;

    public PlayerHandler() {
        this.players = new ArrayList<>();

        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            createPlayer(player.getUniqueId());
        }
    }

    public PracticePlayer createPlayer(UUID uuid) {
        PracticePlayer player = new PracticePlayer(uuid, PlayerState.ONLINE);
        players.add(player);

        return player;
    }

    public PracticePlayer getPlayer(UUID uuid) {
        Optional<PracticePlayer> player = players.stream().filter(practicePlayer -> practicePlayer.getUUID().equals(uuid)).findAny();
        return player.orElse(null);
    }

    public boolean playerExists(UUID uuid) {
        Optional<PracticePlayer> player = players.stream().filter(practicePlayer -> practicePlayer.getUUID().equals(uuid)).findAny();
        return player.isPresent();
    }

}
