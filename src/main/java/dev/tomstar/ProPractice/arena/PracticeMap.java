package dev.tomstar.ProPractice.arena;

import org.bukkit.Location;

public class PracticeMap {

    private final Location loc1;
    private final Location loc2;
    private final String name;

    private final Location firstSpawn;
    private final Location secondSpawn;
    private final Location spectatorSpawn;

    public PracticeMap(Location loc1, Location loc2, String name, Location firstSpawn, Location secondSpawn, Location spectatorSpawn) {
        this.loc1 = loc1;
        this.loc2 = loc2;
        this.name = name;
        this.firstSpawn = firstSpawn;
        this.secondSpawn = secondSpawn;
        this.spectatorSpawn = spectatorSpawn;
    }

    public Location getLoc1() {
        return loc1;
    }

    public Location getLoc2() {
        return loc2;
    }

    public Location getFirstSpawn() {
        return firstSpawn;
    }

    public Location getSecondSpawn() {
        return secondSpawn;
    }

    public Location getSpectatorSpawn() {
        return spectatorSpawn;
    }

    public String getName() {
        return name;
    }

}
