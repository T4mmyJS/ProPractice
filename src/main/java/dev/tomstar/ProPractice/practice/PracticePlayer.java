package dev.tomstar.ProPractice.practice;

import dev.tomstar.ProPractice.states.PlayerState;
import dev.tomstar.ProPractice.utils.ChatUtils;
import dev.tomstar.ProPractice.utils.PlayerUtils;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PracticePlayer {

    private final UUID uuid;

    private PlayerState state;
    private PracticeParty party;

    public PracticePlayer(UUID uuid, PlayerState state) {
        this.uuid = uuid;
        this.state = state;
    }

    private Player getPlayer() {
        return PlayerUtils.getOnlinePlayer(uuid);
    }

    public String getName() {
        return PlayerUtils.getName(uuid);
    }

    public UUID getUUID() {
        return uuid;
    }

    public PlayerState getState() {
        return state;
    }

    public void setState(PlayerState state) {
        this.state = state;
    }

    public PracticeParty getParty() {
        return party;
    }

    public void setParty(PracticeParty party) {
        this.party = party;
    }

    public boolean isOnline() {
        return !state.equals(PlayerState.OFFLINE);
    }

    public void sendMessage(String text) {
        if (isOnline()) getPlayer().sendMessage(ChatUtils.parse(text));
    }

    public void teleport(Location location) {
        if (isOnline()) getPlayer().teleport(location);
    }

}
