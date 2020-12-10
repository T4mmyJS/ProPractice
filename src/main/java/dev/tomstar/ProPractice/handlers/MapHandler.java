package dev.tomstar.ProPractice.handlers;

import dev.tomstar.ProPractice.practice.PracticeMap;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MapHandler {

    private final List<PracticeMap> maps;

    public MapHandler() {
        this.maps = new ArrayList<>();
    }

    public PracticeMap addMap(String name, Location loc1, Location loc2, Location firstSpawn, Location secondSpawn, Location spectatorSpawn) {
        PracticeMap map = new PracticeMap(loc1, loc2, name, firstSpawn, secondSpawn, spectatorSpawn);
        maps.add(map);

        return map;
    }

    public PracticeMap getMap(String name) {
        Optional<PracticeMap> map = maps.stream().filter(practiceMap ->practiceMap.getName().equals(name)).findAny();
        return map.orElse(null);
    }

}
