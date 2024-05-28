package com.andrei1058.bedwars.listeners;

import com.andrei1058.bedwars.BedWars;
import com.andrei1058.bedwars.api.configuration.ConfigPath;
import com.andrei1058.bedwars.api.events.gameplay.GameEndEvent;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class GameEndListener implements Listener {

    @EventHandler
    public void cleanInventoriesAndDroppedItems(@NotNull GameEndEvent event) {
        if (event.getArena().getPlayers().isEmpty()) {
            return;
        }

        for (UUID p : event.getAliveWinners()) {
            if (BedWars.config.getBoolean(ConfigPath.GENERAL_CONFIGURATION_CLEAR_INVENTORY_ON_WIN)) {
                Bukkit.getPlayer(p).getInventory().clear();
            }
        }


        // clear dropped items
        World game = event.getArena().getWorld();
        for (Entity item : game.getEntities()) {
            if (item instanceof Item || item instanceof ItemStack){
                item.remove();
            }
        }
    }
}
