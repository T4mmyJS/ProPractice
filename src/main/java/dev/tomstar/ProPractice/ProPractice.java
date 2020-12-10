package dev.tomstar.ProPractice;

import dev.tomstar.ProPractice.arena.ArenaHandler;
import dev.tomstar.ProPractice.arena.PracticeArena;
import dev.tomstar.ProPractice.arena.PracticeGamemode;
import dev.tomstar.ProPractice.arena.PracticeMap;
import dev.tomstar.ProPractice.listeners.PlayerJoinListener;
import dev.tomstar.ProPractice.listeners.PlayerQuitListener;
import dev.tomstar.ProPractice.player.PlayerHandler;
import dev.tomstar.ProPractice.player.PlayerTeam;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class ProPractice extends JavaPlugin {

    private static PlayerHandler playerHandler;
    private static ArenaHandler arenaHandler;

    @Override
    public void onEnable() {
        playerHandler = new PlayerHandler();
        arenaHandler = new ArenaHandler();

        new PlayerJoinListener(this);
        new PlayerQuitListener(this);
    }

    @Override
    public void onDisable() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        ItemStack[] inventory = new ItemStack[]{new ItemStack(Material.DIAMOND_AXE), new ItemStack(Material.COBBLESTONE, 64)};
        ItemStack[] armour = new ItemStack[]{new ItemStack(Material.DIAMOND_BOOTS), new ItemStack(Material.IRON_CHESTPLATE)};
        Location location1 = new Location(((Player) sender).getWorld(), Double.parseDouble(args[0]), Double.parseDouble(args[1]), Double.parseDouble(args[2]));
        Location location2 = new Location(((Player) sender).getWorld(), Double.parseDouble(args[3]), Double.parseDouble(args[4]), Double.parseDouble(args[5]));

        PracticeGamemode gamemode = ProPractice.arenaHandler.createGamemode(inventory, armour, "Scout");
        PracticeMap map = ProPractice.getArenaHandler().createMap("Shift", location1, location2, location1, location2, location1);


        PracticeArena arena = ProPractice.getArenaHandler().createArena(gamemode, map);
        arena.addPlayer(((Player) sender).getUniqueId(), PlayerTeam.FIRST);
        arena.startMatch();

        return true;
    }

    public static PlayerHandler getPlayerHandler() {
        return playerHandler;
    }

    public static ArenaHandler getArenaHandler() {
        return arenaHandler;
    }

}
