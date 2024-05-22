package com.andrei1058.bedwars.listeners;

import com.andrei1058.bedwars.BedWars;
import com.andrei1058.bedwars.api.configuration.ConfigPath;
import com.andrei1058.bedwars.api.events.player.PlayerReJoinEvent;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import static com.andrei1058.bedwars.BedWars.plugin;

public class LobbyPotionEffectListener implements Listener {

    @EventHandler
    public void onLobbyWorldJoinEvent(PlayerChangedWorldEvent e) {
        Player player = e.getPlayer();
        if (player.getWorld().getName().equals(BedWars.getLobbyWorld())) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    applyLobbyPotionEffect(player);
                }
            }.runTaskLater(plugin, 20L);
        }
    }

    @EventHandler
    public void onArenaReJoinEvent(PlayerReJoinEvent e) {
        Player player = e.getPlayer();
        new BukkitRunnable() {
            @Override
            public void run() {
                removeLobbyPotionEffects(player);
            }
        }.runTaskLater(plugin, 20L);
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if (player.getWorld().getName().equals(BedWars.getLobbyWorld())) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    applyLobbyPotionEffect(player);
                }
            }.runTaskLater(plugin, 20L);
        }
    }

    private void applyLobbyPotionEffect(Player player) {
        PotionEffectType effectType = null;
        int amplifier = 0;

        if (player.hasPermission("bw.lobbyeffect.donator")) {
            effectType = PotionEffectType.getByName(BedWars.config.getString(ConfigPath.GENERAL_CONFIGURATION_LOBBY_POTION_EFFECT_DONATOR));
            amplifier = BedWars.config.getInt(ConfigPath.GENERAL_CONFIGURATION_LOBBY_POTION_EFFECT_DONATOR_AMPLIFIER);
        } else if (player.hasPermission("bw.lobbyeffect")) {
            effectType = PotionEffectType.getByName(BedWars.config.getString(ConfigPath.GENERAL_CONFIGURATION_LOBBY_POTION_EFFECT_NORMAL));
            amplifier = BedWars.config.getInt(ConfigPath.GENERAL_CONFIGURATION_LOBBY_POTION_EFFECT_NORMAL_AMPLIFIER);
        }

        if (effectType != null) {
            player.addPotionEffect(new PotionEffect(effectType, Integer.MAX_VALUE, amplifier));
        }
    }

    private void removeLobbyPotionEffects(Player player) {
        PotionEffectType normalEffect = PotionEffectType.getByName(BedWars.config.getString(ConfigPath.GENERAL_CONFIGURATION_LOBBY_POTION_EFFECT_NORMAL));
        PotionEffectType donatorEffect = PotionEffectType.getByName(BedWars.config.getString(ConfigPath.GENERAL_CONFIGURATION_LOBBY_POTION_EFFECT_DONATOR));

        if (normalEffect != null && player.hasPotionEffect(normalEffect)) {
            player.removePotionEffect(normalEffect);
        }

        if (donatorEffect != null && player.hasPotionEffect(donatorEffect)) {
            player.removePotionEffect(donatorEffect);
        }
    }
}
