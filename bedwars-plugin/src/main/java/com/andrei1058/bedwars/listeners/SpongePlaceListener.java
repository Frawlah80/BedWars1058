package com.andrei1058.bedwars.listeners;

import com.andrei1058.bedwars.api.arena.GameState;
import com.andrei1058.bedwars.api.arena.IArena;
import com.andrei1058.bedwars.arena.Arena;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.scheduler.BukkitRunnable;

import static com.andrei1058.bedwars.BedWars.plugin;

public class SpongePlaceListener implements Listener {

    @EventHandler
    public void onSpongePlaceEvent(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        IArena a = Arena.getArenaByPlayer(p);

        if (a == null) return;
        if (a.getStatus() != GameState.playing) return;

        if (e.getBlock().getType() != Material.SPONGE) return;

        playSmokeEffect(e.getBlock().getLocation());

        removeSpongeBlock(e.getBlock());
    }

    private void playSmokeEffect(Location loc) {
        loc.getWorld().playSound(loc, Sound.SPLASH, 1, 1);
        new BukkitRunnable() {
            @Override
            public void run() {
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        for (int z = -1; z <= 1; z++) {
                            Location effectLoc = loc.clone().add(x, y, z);
                            loc.getWorld().playEffect(effectLoc, Effect.CLOUD, 0);
                        }
                    }
                }
            }
        }.runTaskTimer(plugin, 10L, 60L);
    }

    private void removeSpongeBlock(Block spongeBlock) {
        new BukkitRunnable() {
            @Override
            public void run() {
                spongeBlock.setType(Material.AIR);
            }
        }.runTaskLater(plugin, 40L);
    }
}
