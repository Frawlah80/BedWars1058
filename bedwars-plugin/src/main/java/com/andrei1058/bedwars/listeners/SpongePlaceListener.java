package com.andrei1058.bedwars.listeners;

import com.andrei1058.bedwars.BedWars;
import com.andrei1058.bedwars.api.arena.IArena;
import com.andrei1058.bedwars.arena.Arena;
import com.andrei1058.bedwars.arena.tasks.SpongeAnimationTask;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class SpongePlaceListener implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onSpongePlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        IArena a = Arena.getArenaByPlayer(p);

        if (a == null || !a.isPlayer(p)) return;

        Block block = e.getBlock();
        if (block.getType() != Material.SPONGE) return;

        new SpongeAnimationTask(block).runTaskTimer(BedWars.plugin , 0L, 8L);
    }

}
