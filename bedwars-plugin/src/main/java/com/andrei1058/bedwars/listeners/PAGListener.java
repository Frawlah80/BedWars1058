package com.andrei1058.bedwars.listeners;

import com.andrei1058.bedwars.BedWars;
import com.andrei1058.bedwars.api.arena.GameState;
import com.andrei1058.bedwars.api.arena.generator.GeneratorType;
import com.andrei1058.bedwars.api.arena.generator.IGenerator;
import com.andrei1058.bedwars.api.arena.team.ITeam;
import com.andrei1058.bedwars.api.events.gameplay.GameStateChangeEvent;
import com.andrei1058.bedwars.api.events.upgrades.UpgradeBuyEvent;
import com.andrei1058.bedwars.api.upgrades.TeamUpgrade;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PAGListener implements Listener {

    @EventHandler
    public void onGameStart(GameStateChangeEvent e) {

        if (e.getNewState().equals(GameState.playing)) {

            int ironAmount = BedWars.pagConfig.getInt("Arenas." + e.getArena().getArenaName() + ".iron.amount");
            int ironDelay = BedWars.pagConfig.getInt("Arenas." + e.getArena().getArenaName() + ".iron.delay");
            int ironSpawnAmount = BedWars.pagConfig.getInt("Arenas." + e.getArena().getArenaName() + ".iron.spawn-limit");

            int goldAmount = BedWars.pagConfig.getInt("Arenas." + e.getArena().getArenaName() + ".gold.amount");
            int goldDelay = BedWars.pagConfig.getInt("Arenas." + e.getArena().getArenaName() + ".gold.delay");
            int goldSpawnAmount = BedWars.pagConfig.getInt("Arenas." + e.getArena().getArenaName() + ".gold.spawn-limit");

            for (ITeam team : e.getArena().getTeams()) {

                for (IGenerator gen : team.getGenerators()) {

                    if (gen.getType() == GeneratorType.IRON) {

                        if (ironAmount != 0) {
                            gen.setAmount(ironAmount);
                        }

                        if (ironDelay != 0) {
                            gen.setDelay(ironDelay);
                        }

                        if (ironSpawnAmount != 0) {
                            gen.setSpawnLimit(ironSpawnAmount);
                        }

                    } else if (gen.getType() == GeneratorType.GOLD) {

                        if (goldAmount != 0) {
                            gen.setAmount(goldAmount);
                        }

                        if (goldDelay != 0) {
                            gen.setDelay(goldDelay);
                        }

                        if (goldSpawnAmount != 0) {
                            gen.setSpawnLimit(goldSpawnAmount);
                        }

                    }

                }

            }

        }

    }

    @EventHandler
    public void onForgePurchase(UpgradeBuyEvent e) {

        TeamUpgrade upgrade = e.getTeamUpgrade();

        if (upgrade.getName().equals("forge")) {

            if (upgrade.getTierCount() == 1) {

                BedWars.debug("Forge Tier-1 Purchase detected!");

                int ironAmount1 = BedWars.pagConfig.getInt("Arenas." + e.getArena().getArenaName() + ".iron-forge.iron.amount");
                int ironDelay1 = BedWars.pagConfig.getInt("Arenas." + e.getArena().getArenaName() + ".iron-forge.iron.delay");
                int ironSpawnAmount1 = BedWars.pagConfig.getInt("Arenas." + e.getArena().getArenaName() + ".iron-forge.iron.spawn-limit");

                int goldAmount1 = BedWars.pagConfig.getInt("Arenas." + e.getArena().getArenaName() + ".iron-forge.gold.amount");
                int goldDelay1 = BedWars.pagConfig.getInt("Arenas." + e.getArena().getArenaName() + ".iron-forge.gold.delay");
                int goldSpawnAmount1 = BedWars.pagConfig.getInt("Arenas." + e.getArena().getArenaName() + ".iron-forge.gold.spawn-limit");

                ITeam team = e.getTeam();

                for (IGenerator gen : team.getGenerators()) {

                    if (gen.getType() == GeneratorType.IRON) {

                        if (ironDelay1 != 0) {
                            gen.setDelay(ironDelay1);
                        }

                        if (ironAmount1 != 0) {
                            gen.setAmount(ironAmount1);
                        }

                        if (ironSpawnAmount1 != 0) {
                            gen.setSpawnLimit(ironSpawnAmount1);
                        }

                    } else if (gen.getType() == GeneratorType.GOLD) {

                        if (goldDelay1 != 0) {
                            gen.setDelay(goldDelay1);
                        }

                        if (goldAmount1 != 0) {
                            gen.setAmount(goldAmount1);
                        }

                        if (goldSpawnAmount1 != 0) {
                            gen.setSpawnLimit(goldSpawnAmount1);
                        }

                    }

                }

            }

        }

    }

}
