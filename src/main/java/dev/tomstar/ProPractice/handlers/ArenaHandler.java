package dev.tomstar.ProPractice.handlers;

import dev.tomstar.ProPractice.practice.PracticeArena;
import dev.tomstar.ProPractice.practice.PracticeGamemode;
import dev.tomstar.ProPractice.practice.PracticeMap;
import dev.tomstar.ProPractice.practice.PracticePlayer;
import dev.tomstar.ProPractice.utils.WorldUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.*;

public class ArenaHandler {

    private final List<PracticeArena> arenas;

    public ArenaHandler() {
        this.arenas = new ArrayList<>();
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

    public PracticeArena getArena(PracticePlayer player) {
        Optional<PracticeArena> arena = arenas.stream().filter(practiceArena -> practiceArena.hasPlayer(player)).findAny();
        return arena.orElse(null);
    }

}
