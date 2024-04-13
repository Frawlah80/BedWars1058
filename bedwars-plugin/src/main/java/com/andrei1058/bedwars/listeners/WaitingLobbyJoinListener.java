package com.andrei1058.bedwars.listeners;

import com.andrei1058.bedwars.BedWars;
import com.andrei1058.bedwars.api.events.player.PlayerJoinArenaEvent;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import static com.andrei1058.bedwars.BedWars.plugin;

public class WaitingLobbyJoinListener implements Listener {
    private final boolean adventureModeOnWaitingLobbyJoin = BedWars.config.getBoolean("GENERAL_CONFIGURATION_ADVENTUREMODE_ON_WAITINGLOBBY_JOIN");


    @EventHandler
    public void onWaitingLobbyJoin(PlayerJoinArenaEvent e) {
        Player p = e.getPlayer();
        if (!adventureModeOnWaitingLobbyJoin) return;
        if (e.isSpectator()) return;
        Bukkit.getScheduler().runTaskLater(plugin, () -> p.setGameMode(GameMode.ADVENTURE), 0L);
    }

}
