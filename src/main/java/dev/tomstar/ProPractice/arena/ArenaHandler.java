package dev.tomstar.ProPractice.arena;

import dev.tomstar.ProPractice.utils.WorldUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class ArenaHandler {

    private final List<PracticeArena> arenas;
    private final List<PracticeGamemode> gamemodes;
    private final List<PracticeMap> maps;

    public ArenaHandler() {
        this.arenas = new ArrayList<>();
        this.gamemodes = new ArrayList<>();
        this.maps = new ArrayList<>();
    }

    public PracticeArena createArena(PracticeGamemode gamemode, PracticeMap map) {
        Location location = new Location(Bukkit.getWorld("world"), WorldUtils.getClosestEmpty(arenas, 5), 100, 0);
        PracticeArena arena = new PracticeArena(location, gamemode, map);

        arenas.add(arena);
        return arena;
    }

    public void removeArena(PracticeArena arena) {
        WorldUtils.clearArea(arena.getMap().getLoc1(), arena.getMap().getLoc2(), arena.getLocation());
        arenas.remove(arena);
    }

    public PracticeArena getArena(UUID player) {
        Optional<PracticeArena> arena = arenas.stream().filter(practiceArena -> practiceArena.hasPlayer(player)).findAny();
        return arena.orElse(null);
    }

    public PracticeGamemode createGamemode(ItemStack[] inventory, ItemStack[] armour, String name) {
        PracticeGamemode gamemode = new PracticeGamemode(inventory, armour, name);
        gamemodes.add(gamemode);

        return gamemode;
    }

    public PracticeGamemode getGamemode(String name) {
        Optional<PracticeGamemode> gamemode = gamemodes.stream().filter(practiceGamemode -> practiceGamemode.getName().equals(name)).findAny();
        return gamemode.orElse(null);
    }

    public PracticeMap createMap(String name, Location loc1, Location loc2, Location firstSpawn, Location secondSpawn, Location spectatorSpawn) {
        PracticeMap map = new PracticeMap(loc1, loc2, name, firstSpawn, secondSpawn, spectatorSpawn);
        maps.add(map);

        return map;
    }

    public PracticeMap createMap(String name) {
        Optional<PracticeMap> map = maps.stream().filter(practiceMap ->practiceMap.getName().equals(name)).findAny();
        return map.orElse(null);
    }

}
