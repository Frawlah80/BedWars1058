/*
 * BedWars1058 - A bed wars mini-game.
 * Copyright (C) 2021 Andrei Dascălu
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 * Contact e-mail: andrew.dascalu@gmail.com
 */

package com.andrei1058.bedwars.listeners;

import com.andrei1058.bedwars.BedWars;
import com.andrei1058.bedwars.api.arena.IArena;
import com.andrei1058.bedwars.api.arena.team.ITeam;
import com.andrei1058.bedwars.api.configuration.ConfigPath;
import com.andrei1058.bedwars.api.events.gameplay.GameEndEvent;
import com.andrei1058.bedwars.api.events.player.PlayerInvisibilityPotionEvent;
import com.andrei1058.bedwars.api.events.player.PlayerLeaveArenaEvent;
import com.andrei1058.bedwars.arena.Arena;
import com.andrei1058.bedwars.sidebar.SidebarService;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.andrei1058.bedwars.BedWars.nms;
import static com.andrei1058.bedwars.BedWars.plugin;

/**
 * This is used to hide and show player name tag above head when he drinks an invisibility
 * potion or when the potion is gone. It is required because it is related to scoreboards.
 */
public class InvisibilityPotionListener implements Listener {
    private final List<Player> invisPlayers = new ArrayList<>();
    private final HashMap<Player, Integer> steps = new HashMap<>(); // ty bw2023
    private final boolean invisFootstepsEnabled = BedWars.config.getBoolean(ConfigPath.GENERAL_CONFIGURATION_INVIS_FOOTSTEPS_ENABLED);
    private final boolean invisFootstepsSneakDisabled = BedWars.config.getBoolean(ConfigPath.GENERAL_CONFIGURATION_INVIS_FOOTSTEPS_SNEAKDISABLED);
    private final boolean invisFootstepsNotOnGroundDisable = BedWars.config.getBoolean(ConfigPath.GENERAL_CONFIGURATION_INVIS_FOOTSTEPS_DISABLE_IF_NOT_ON_GROUND);
    private int invisFootstepsInterval = 6;

    @EventHandler
    public void onInvisPot(PlayerInvisibilityPotionEvent e) {
        if (!invisFootstepsEnabled) return;
        Player p = e.getPlayer();
        if (e.getType() == PlayerInvisibilityPotionEvent.Type.ADDED) {
            this.invisPlayers.add(p);
            steps.put(e.getPlayer(), 12);
        } else if (e.getType() == PlayerInvisibilityPotionEvent.Type.REMOVED) {
            this.invisPlayers.remove(p);
            steps.remove(e.getPlayer());
        }
    }

    @EventHandler
    public void onGameEnd(GameEndEvent e) {
        for (Player p : e.getArena().getPlayers()) {
            if (this.invisPlayers.contains(p)) {
                this.invisPlayers.remove(p);
                steps.remove(p);
            }
        }
    }

    @EventHandler
    public void onPlayerLeave(PlayerLeaveArenaEvent e) {
        Player p = e.getPlayer();
        if (this.invisPlayers.contains(p)) {
            this.invisPlayers.remove(p);
            steps.remove(p);
        }
    }

    @SuppressWarnings("deprecation")
    @EventHandler
    public void onInvisPlayerMove(PlayerMoveEvent e) {
        if (!invisFootstepsEnabled) return;
        Player p = e.getPlayer();
        if (!this.invisPlayers.contains(p)) return;
        if (nms.getVersion() > 5) return;
        if (invisFootstepsSneakDisabled && p.isSneaking()) return;
        if (invisFootstepsNotOnGroundDisable && !p.isOnGround()) return;
        Location from = e.getFrom();
        Location to = e.getTo();
        if (from.getBlock() == to.getBlock()) {
            p.getWorld().playEffect(p.getLocation().add(0.0D, 0.01D, 0.0D), Effect.FOOTSTEP, 1);
        }
        if (from.getBlock() != to.getBlock()) {
            if (this.invisFootstepsInterval == 3) {
                p.getWorld().playEffect(p.getLocation().add(0.0D, 0.01D, 0.4D), Effect.FOOTSTEP, 1);
                this.invisFootstepsInterval--;
            } else if (this.invisFootstepsInterval <= 0) {
                p.getWorld().playEffect(p.getLocation().add(0.4D, 0.01D, 0.0D), Effect.FOOTSTEP, 1);
                this.invisFootstepsInterval = 6;
            } else {
                this.invisFootstepsInterval--;
            }
        }
    }

    @EventHandler
    public void onPlayerLeaveArena(PlayerLeaveArenaEvent e) {
        Player p = e.getPlayer();
        if (this.invisPlayers.contains(p)) this.invisPlayers.remove(p);
    }

    @EventHandler
    public void onPotion(@NotNull PlayerInvisibilityPotionEvent e) {
        if (e.getTeam() == null) return;
        SidebarService.getInstance().handleInvisibility(
                e.getTeam(), e.getPlayer(), e.getType() == PlayerInvisibilityPotionEvent.Type.ADDED
        );
    }

    @EventHandler
    public void onDrink(PlayerItemConsumeEvent e) {
        IArena a = Arena.getArenaByPlayer(e.getPlayer());
        if (a == null) return;
        if (e.getItem().getType() != Material.POTION) return;
        // remove potion bottle
        Bukkit.getScheduler().runTaskLater(plugin, () ->
                        nms.minusAmount(e.getPlayer(), new ItemStack(Material.GLASS_BOTTLE), 1),
                5L);
        //

        if (nms.isInvisibilityPotion(e.getItem())) {
            Bukkit.getScheduler().runTaskLater(plugin, () -> {
                for (PotionEffect pe : e.getPlayer().getActivePotionEffects()) {
                    if (pe.getType().toString().contains("INVISIBILITY")) {
                        // if is already invisible
                        if (a.getShowTime().containsKey(e.getPlayer())) {
                            ITeam t = a.getTeam(e.getPlayer());
                            // increase invisibility timer
                            // keep trace of invisible players to send hide armor packet when required
                            // because potions do not hide armors
                            a.getShowTime().replace(e.getPlayer(), pe.getDuration() / 20);
                            // call custom event
                            Bukkit.getPluginManager().callEvent(new PlayerInvisibilityPotionEvent(PlayerInvisibilityPotionEvent.Type.ADDED, t, e.getPlayer(), t.getArena()));
                        } else {
                            // if not already invisible
                            ITeam t = a.getTeam(e.getPlayer());
                            // keep trace of invisible players to send hide armor packet when required
                            // because potions do not hide armors
                            a.getShowTime().put(e.getPlayer(), pe.getDuration() / 20);
                            //
                            for (Player p1 : e.getPlayer().getWorld().getPlayers()) {
                                if (a.isSpectator(p1)) {
                                    // hide player armor to spectators
                                    nms.hideArmor(e.getPlayer(), p1);
                                } else if (t != a.getTeam(p1)) {
                                    // hide player armor to other teams
                                    nms.hideArmor(e.getPlayer(), p1);
                                }
                            }
                            // call custom event
                            Bukkit.getPluginManager().callEvent(new PlayerInvisibilityPotionEvent(PlayerInvisibilityPotionEvent.Type.ADDED, t, e.getPlayer(), t.getArena()));
                        }
                        break;
                    }
                }
            }, 5L);
        }
    }
}
