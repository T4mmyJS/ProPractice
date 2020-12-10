package dev.tomstar.ProPractice.handlers;

import dev.tomstar.ProPractice.practice.PracticeGamemode;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GamemodeHandler {

    private final List<PracticeGamemode> gamemodes;

    public GamemodeHandler() {
        this.gamemodes = new ArrayList<>();
    }

    public PracticeGamemode addGamemode(ItemStack[] inventory, ItemStack[] armour, String name) {
        PracticeGamemode gamemode = new PracticeGamemode(inventory, armour, name);
        gamemodes.add(gamemode);

        return gamemode;
    }

    public PracticeGamemode getGamemode(String name) {
        Optional<PracticeGamemode> gamemode = gamemodes.stream().filter(practiceGamemode -> practiceGamemode.getName().equals(name)).findAny();
        return gamemode.orElse(null);
    }

}
