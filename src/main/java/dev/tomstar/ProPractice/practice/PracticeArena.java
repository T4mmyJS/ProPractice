package dev.tomstar.ProPractice.practice;

import dev.tomstar.ProPractice.states.ArenaState;
import dev.tomstar.ProPractice.states.FighterState;
import dev.tomstar.ProPractice.states.TeamState;
import dev.tomstar.ProPractice.utils.WorldUtils;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PracticeArena {
    
    private ArenaState state;
    private final Location location;
    private final PracticeMap map;

    private final Map<PracticePlayer, FighterState> playerStates;
    private final List<PracticePlayer> firstTeam;
    private final List<PracticePlayer> secondTeam;
    
    public PracticeArena(Location location, PracticeGamemode gamemode, PracticeMap map) {
        this.playerStates = new HashMap<>();
        this.firstTeam = new ArrayList<>();
        this.secondTeam = new ArrayList<>();
        this.location = location;
        this.map = map;

        WorldUtils.pasteArea(map.getLoc1(), map.getLoc2(), location);
        setState(ArenaState.STARTING);
    }

    public ArenaState getState() {
        return state;
    }
    
    private void setState(ArenaState state) {
        this.state = state;
    }

    public void addPlayer(PracticePlayer player, TeamState team) {
        playerStates.put(player, FighterState.STARTING);

        if (team.equals(TeamState.FIRST)) {
            firstTeam.add(player);
            player.teleport(map.getFirstSpawn());
        }

        if (team.equals(TeamState.SECOND)) {
            secondTeam.add(player);
            player.teleport(map.getSecondSpawn());
        }
    }

    /* public void addSpectator(PracticePlayer player) {
        playerStates.put(player, FighterState.SPECTATING);
        player.teleport(map.getSpectatorSpawn());
    } */

    public TeamState getPlayerTeam(PracticePlayer player) {
        if (firstTeam.contains(player)) return TeamState.FIRST;
        if (secondTeam.contains(player)) return TeamState.SECOND;

        return null;
    }

    public FighterState getPlayerState(PracticePlayer player) {
        return playerStates.get(player);
    }

    public void setPlayerState(PracticePlayer player, FighterState state) {
        playerStates.put(player, state);
    }

    public boolean hasPlayer(PracticePlayer player) {
        return playerStates.containsKey(player);
    }

    public Location getLocation() {
        return location;
    }

    public PracticeMap getMap() {
        return map;
    }

}
