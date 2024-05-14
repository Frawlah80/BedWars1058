package com.andrei1058.bedwars.ghostfactory.listener;

import com.andrei1058.bedwars.api.configuration.ConfigPath;
import com.andrei1058.bedwars.api.events.player.PlayerKillEvent;
import com.andrei1058.bedwars.api.events.player.PlayerLeaveArenaEvent;
import com.andrei1058.bedwars.api.events.player.PlayerReJoinEvent;
import com.andrei1058.bedwars.ghostfactory.GhostFactory;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
//import org.bukkit.event.player.PlayerChangedWorldEvent;
//import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import static com.andrei1058.bedwars.BedWars.config;
import static com.andrei1058.bedwars.BedWars.plugin;

public class GhostListener implements Listener {

    @EventHandler
    public void onKillEvent(PlayerKillEvent e) {
        if (e.getCause().isFinalKill()) {
            GhostFactory.addPlayerAsGhost(e.getVictim());
        }
        if (!e.getCause().isFinalKill()) {
            GhostFactory.addPlayerAsGhost(e.getVictim());
            new BukkitRunnable() {
                @Override
                public void run() {
                    GhostFactory.removePlayerAsGhost(e.getVictim());
                }
            }.runTaskLater(plugin, config.getInt(ConfigPath.GENERAL_CONFIGURATION_RE_SPAWN_COUNTDOWN) * 20L);
        }
    }

    @EventHandler
    public void onRejoinArenaEvent(PlayerReJoinEvent e) {
        GhostFactory.addPlayerAsGhost(e.getPlayer());
        new BukkitRunnable() {
            @Override
            public void run() {
                GhostFactory.removePlayerAsGhost(e.getPlayer());
            }
        }.runTaskLater(plugin, config.getInt(ConfigPath.GENERAL_CONFIGURATION_REJOIN_RE_SPAWN_COUNTDOWN) * 20L);
    }

    @EventHandler
    public void onArenaLeaveEvent(PlayerLeaveArenaEvent e) {
        GhostFactory.removePlayerAsGhost(e.getPlayer());
    }

    /*
    @EventHandler
    public void onArenaJoinEvent(PlayerJoinEvent e) {
        GhostFactory.removePlayerAsGhost(e.getPlayer());
    }

    @EventHandler
    public void onWorldChangeEvent(PlayerChangedWorldEvent e) {
        GhostFactory.removePlayerAsGhost(e.getPlayer());
    }
     */
}
