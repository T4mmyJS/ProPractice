package dev.tomstar.ProPractice.arena;

import dev.tomstar.ProPractice.ProPractice;
import dev.tomstar.ProPractice.player.PlayerState;
import dev.tomstar.ProPractice.player.PlayerTeam;
import dev.tomstar.ProPractice.utils.PlayerUtils;
import dev.tomstar.ProPractice.utils.WorldUtils;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class PracticeArena {
    
    private ArenaState state;
    private final Location location;
    private final PracticeMap map;
    private final PracticeGamemode gamemode;

    private final List<UUID> firstTeam;
    private final List<UUID> secondTeam;

    private final Map<UUID, ItemStack[]> inventories;
    private final Map<UUID, ItemStack[]> armours;
    
    public PracticeArena(Location location, PracticeGamemode gamemode, PracticeMap map) {
        this.firstTeam = new ArrayList<>();
        this.secondTeam = new ArrayList<>();
        this.location = location;
        this.map = map;
        this.gamemode = gamemode;
        this.state = ArenaState.STARTING;

        this.inventories = new HashMap<>();
        this.armours = new HashMap<>();

        WorldUtils.pasteArea(map.getLoc1(), map.getLoc2(), location);
    }

    public ArenaState getState() {
        return state;
    }

    public void addPlayer(UUID uuid, PlayerTeam team) {
        ProPractice.getPlayerHandler().setPlayerState(uuid, PlayerState.STARTING);
        Player player = PlayerUtils.getOnline(uuid);

        if (team.equals(PlayerTeam.FIRST)) {
            firstTeam.add(uuid);
            WorldUtils.teleportPlayer(map.getLoc1(), map.getFirstSpawn(), location, uuid);

            setupPlayer(uuid);
        }

        if (team.equals(PlayerTeam.SECOND)) {
            secondTeam.add(uuid);
            WorldUtils.teleportPlayer(map.getLoc1(), map.getSecondSpawn(), location, uuid);

            setupPlayer(uuid);
        }
    }

    private void setupPlayer(UUID uuid) {
        Player player = PlayerUtils.getOnline(uuid);

        inventories.put(uuid, player.getInventory().getContents());
        player.getInventory().setContents(gamemode.getInventory());

        armours.put(uuid, player.getInventory().getArmorContents());
        player.getInventory().setArmorContents(gamemode.getArmour());
    }

    public void startMatch() {
        this.state = ArenaState.PLAYING;
    }

    /* public void addSpectator(UUID player) {
        playerStates.put(player, FighterState.SPECTATING);
        player.teleport(map.getSpectatorSpawn());
    } */

    public PlayerTeam getPlayerTeam(UUID player) {
        if (firstTeam.contains(player)) return PlayerTeam.FIRST;
        if (secondTeam.contains(player)) return PlayerTeam.SECOND;

        return null;
    }

    public boolean hasPlayer(UUID player) {
        return firstTeam.contains(player) || secondTeam.contains(player);
    }

    public Location getLocation() {
        return location;
    }

    public PracticeMap getMap() {
        return map;
    }

    public PracticeGamemode getGamemode() {
        return gamemode;
    }

}
