package com.andrei1058.bedwars.listeners.dropshandler;

import com.andrei1058.bedwars.BedWars;
import com.andrei1058.bedwars.api.arena.GameState;
import com.andrei1058.bedwars.api.arena.IArena;
import com.andrei1058.bedwars.api.configuration.ConfigPath;
import com.andrei1058.bedwars.arena.Arena;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.List;

public class PlayerVoidDropListener implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onItemDropWhileVoiding(PlayerDropItemEvent e) {
        Player player = e.getPlayer();
        IArena a = Arena.getArenaByPlayer(player);

        if (!a.isPlayer(player)) return;
        if (a.getStatus() != GameState.playing) return;

        List<Block> blocks = new ArrayList<>();
        blocks.add(player.getLocation().clone().subtract(0.0D, 0.1D, 0.0D).getBlock());
        for (int i = 1; i <= 4; i++) {
            blocks.add(player.getLocation().clone().subtract(0.0D, i, 0.0D).getBlock());
        }
        for (Block block : blocks) {
            if (block.getType().equals(Material.AIR)) {
                continue;
            }
            return;
        }
        e.setCancelled(true);
    }
}
