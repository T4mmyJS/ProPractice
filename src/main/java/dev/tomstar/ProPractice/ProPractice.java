package dev.tomstar.ProPractice;

import dev.tomstar.ProPractice.handlers.*;
import dev.tomstar.ProPractice.listeners.PlayerJoinListener;
import dev.tomstar.ProPractice.listeners.PlayerQuitListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class ProPractice extends JavaPlugin {

    private static PlayerHandler playerHandler;
    private static PartyHandler partyHandler;
    private static ArenaHandler arenaHandler;
    private static GamemodeHandler gamemodeHandler;
    private static MapHandler mapHandler;

    @Override
    public void onEnable() {
        playerHandler = new PlayerHandler();
        partyHandler = new PartyHandler();
        arenaHandler = new ArenaHandler();
        gamemodeHandler = new GamemodeHandler();
        mapHandler = new MapHandler();

        new PlayerJoinListener(this);
        new PlayerQuitListener(this);
    }

    @Override
    public void onDisable() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return true;
    }

    public static PlayerHandler getPlayerHandler() {
        return playerHandler;
    }

    public static PartyHandler getPartyHandler() {
        return partyHandler;
    }

    public static ArenaHandler getArenaHandler() {
        return arenaHandler;
    }

    public static GamemodeHandler getGamemodeHandler() {
        return gamemodeHandler;
    }

    public static MapHandler getMapHandler() {
        return mapHandler;
    }

}
