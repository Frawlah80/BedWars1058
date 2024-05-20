package com.andrei1058.bedwars.listeners;

import com.andrei1058.bedwars.BedWars;
import com.andrei1058.bedwars.api.configuration.ConfigPath;
import com.andrei1058.bedwars.api.events.player.PlayerReJoinEvent;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class LobbyPotionEffectListener implements Listener {

    @EventHandler
    public void onLobbyWorldJoinEvent(PlayerChangedWorldEvent e) {
        Player p = e.getPlayer();
        if (p.getWorld().getName().equals(BedWars.getLobbyWorld())) {
            if (p.hasPermission("bw.lobbyeffect.donator")) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.getByName(BedWars.config.getString(ConfigPath.GENERAL_CONFIGURATION_LOBBY_POTION_EFFECT_DONATOR)), Integer.MAX_VALUE, BedWars.config.getInt(ConfigPath.GENERAL_CONFIGURATION_LOBBY_POTION_EFFECT_DONATOR_AMPLIFIER)));
            } else if (p.hasPermission("bw.lobbyeffect")) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.getByName(BedWars.config.getString(ConfigPath.GENERAL_CONFIGURATION_LOBBY_POTION_EFFECT_NORMAL)), Integer.MAX_VALUE, BedWars.config.getInt(ConfigPath.GENERAL_CONFIGURATION_LOBBY_POTION_EFFECT_NORMAL_AMPLIFIER)));
            }
        }
    }

    @EventHandler
    public void onArenaJoinEvent(PlayerReJoinEvent e) {
        Player p = e.getPlayer();
        if (p.hasPotionEffect(PotionEffectType.getByName(BedWars.config.getString(ConfigPath.GENERAL_CONFIGURATION_LOBBY_POTION_EFFECT_NORMAL)))) {
            p.removePotionEffect(PotionEffectType.getByName(BedWars.config.getString(ConfigPath.GENERAL_CONFIGURATION_LOBBY_POTION_EFFECT_NORMAL)));
        } else if (p.hasPotionEffect(PotionEffectType.getByName(BedWars.config.getString(ConfigPath.GENERAL_CONFIGURATION_LOBBY_POTION_EFFECT_DONATOR)))) {
            p.removePotionEffect(PotionEffectType.getByName(BedWars.config.getString(ConfigPath.GENERAL_CONFIGURATION_LOBBY_POTION_EFFECT_DONATOR)));
        }
    }

}
