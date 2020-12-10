package dev.tomstar.ProPractice.practice;

import org.bukkit.inventory.ItemStack;

public class PracticeGamemode {

    private final ItemStack[] inventory;
    private final ItemStack[] armour;
    private final String name;

    public PracticeGamemode(ItemStack[] inventory, ItemStack[] armour, String name) {
        this.inventory = inventory;
        this.armour = armour;
        this.name = name;
    }

    public ItemStack[] getInventory() {
        return inventory;
    }

    public ItemStack[] getArmour() {
        return armour;
    }

    public String getName() {
        return name;
    }

}
