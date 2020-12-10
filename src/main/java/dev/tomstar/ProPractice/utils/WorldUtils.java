package dev.tomstar.ProPractice.utils;

import dev.tomstar.ProPractice.arena.PracticeArena;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public class WorldUtils {

    public static void pasteArea(Location loc1, Location loc2, Location position) {
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
        for (int x : MathUtils.getValues(loc1.getBlockX(), loc2.getBlockX())) {
            for (int y : MathUtils.getValues(loc1.getBlockY(), loc2.getBlockY())) {
                for (int z : MathUtils.getValues(loc1.getBlockZ(), loc2.getBlockZ())) {
                    Location paste = new Location(position.getWorld(), x + position.getBlockX(), y + position.getBlockY(), z + position.getBlockZ());
                    paste.getBlock().setType(Material.AIR);
                }
            }
        }
    }

    public static int getClosestEmpty(List<PracticeArena> arenas, int distance) {
        int pos = 0;
        while (true) {
            if (emptyArea(arenas, pos)) return pos;
        }
    }

    public static boolean emptyArea(List<PracticeArena> arenas, int area) {
        return (arenas.stream().noneMatch(practiceArena -> practiceArena.getLocation().getBlockX() == area));
    }

    public static void teleportPlayer(Location baseLocation, Location baseTeleport, Location arenaLocation, UUID uuid) {
        Player player = PlayerUtils.getOnline(uuid);
        int x = arenaLocation.getBlockX() + (baseTeleport.getBlockX() - baseLocation.getBlockX());
        int y = arenaLocation.getBlockY() + (baseTeleport.getBlockY() - baseLocation.getBlockY());
        int z = arenaLocation.getBlockZ() + (baseTeleport.getBlockZ() - baseLocation.getBlockZ());
        Location teleport = new Location(arenaLocation.getWorld(), x, y, z);

        player.teleport(teleport);
    }

}
