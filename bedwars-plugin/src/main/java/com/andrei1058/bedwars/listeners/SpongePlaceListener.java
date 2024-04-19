package com.andrei1058.bedwars.listeners;

import com.andrei1058.bedwars.api.arena.GameState;
import com.andrei1058.bedwars.api.arena.IArena;
import com.andrei1058.bedwars.arena.Arena;

import com.andrei1058.bedwars.arena.tasks.SpongeAnimationTask;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import static com.andrei1058.bedwars.BedWars.plugin;

public class SpongePlaceListener implements Listener {

    @EventHandler
    public void onSpongePlaceEvent(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        IArena a = Arena.getArenaByPlayer(p);

        if (a == null) return;
        if (a.getStatus() != GameState.playing) return;

        Block b = e.getBlock();

        if (b.getType() != Material.SPONGE) return;

        new SpongeAnimationTask(b).runTaskTimer(plugin, 0L, 8L);
    }

}
