package com.andrei1058.bedwars.listeners;

import com.andrei1058.bedwars.api.arena.IArena;
import com.andrei1058.bedwars.api.language.Messages;
import com.andrei1058.bedwars.arena.Arena;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import static com.andrei1058.bedwars.BedWars.plugin;
import static com.andrei1058.bedwars.api.language.Language.getMsg;

public class WaterBucketPlaceEvent implements Listener {

    @EventHandler
    public void onWaterBucketPlaceEvent(PlayerBucketEmptyEvent e) {

        Player p = e.getPlayer();
        IArena a = Arena.getArenaByPlayer(p);

        if (a == null) return;

        new BukkitRunnable() {

            @Override
            public void run() {
                e.getPlayer().getInventory().remove(new ItemStack(Material.BUCKET));
            }

        }.runTaskLater(plugin, 2L); // Gave 2 ticks delay, otherwise something bad happens...

    }

    @EventHandler
    public void onWaterBucketFillEvent(PlayerBucketFillEvent e) {

        Player p = e.getPlayer();
        IArena a = Arena.getArenaByPlayer(p);

        if (a == null) return;

        e.getPlayer().sendMessage(getMsg(p, Messages.INTERACT_WATER_BUCKET_FILL_EVENT));
        e.setCancelled(true);

    }

}
