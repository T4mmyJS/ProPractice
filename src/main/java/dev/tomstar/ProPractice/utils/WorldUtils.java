package dev.tomstar.ProPractice.utils;

import dev.tomstar.ProPractice.practice.PracticeArena;
import org.bukkit.Location;
import org.bukkit.Material;

import java.util.List;

public class WorldUtils {

    public static void pasteArea(Location loc1, Location loc2, Location position) {
        position = getMiddle(loc1, loc2, position);
        for (int x : MathUtils.getValues(loc1.getBlockX(), loc2.getBlockX())) {
            for (int y : MathUtils.getValues(loc1.getBlockY(), loc2.getBlockY())) {
                for (int z : MathUtils.getValues(loc1.getBlockZ(), loc2.getBlockZ())) {
                    Location paste = new Location(position.getWorld(), x + position.getBlockX(), y + position.getBlockY(), z + position.getBlockZ());
                    Location block = new Location(loc1.getWorld(), loc1.getBlockX() + x, loc1.getBlockY() + y, loc1.getBlockZ() + z);

                    paste.getBlock().setType(block.getBlock().getType());
                    paste.getBlock().setData(block.getBlock().getData());
                }
            }
        }
    }

    public static void clearArea(Location loc1, Location loc2, Location position) {
        position = getMiddle(loc1, loc2, position);
        for (int x : MathUtils.getValues(loc1.getBlockX(), loc2.getBlockX())) {
            for (int y : MathUtils.getValues(loc1.getBlockY(), loc2.getBlockY())) {
                for (int z : MathUtils.getValues(loc1.getBlockZ(), loc2.getBlockZ())) {
                    Location paste = new Location(position.getWorld(), x + position.getBlockX(), y + position.getBlockY(), z + position.getBlockZ());
                    paste.getBlock().setType(Material.AIR);
                }
            }
        }
    }

    public static Location getMiddle(Location loc1, Location loc2, Location position) {
        int x = position.getBlockX() + loc1.getBlockX() - (loc1.getBlockX() + loc2.getBlockX()) / 2;
        int y = position.getBlockY() + loc1.getBlockY() - (loc1.getBlockY() + loc2.getBlockY()) / 2;
        int z = position.getBlockZ() + loc1.getBlockZ() - (loc1.getBlockZ() + loc2.getBlockZ()) / 2;

        return new Location(position.getWorld(), x, y, z);
    }

    public static int getClosestEmpty(List<PracticeArena> arenas, int distance) {
        int x = 0;
        while (true) {
            boolean free = true;
            for (PracticeArena arena : arenas) {
                if (arena.getLocation().getBlockX() == x) free = false;
            }

            if (free) return x;
            x += distance;
        }
    }

}
