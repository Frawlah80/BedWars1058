package com.andrei1058.bedwars.levels.internal;

import com.andrei1058.bedwars.BedWars;
import com.andrei1058.bedwars.api.arena.GameState;
import com.andrei1058.bedwars.api.arena.team.ITeam;
import com.andrei1058.bedwars.api.events.gameplay.GameEndEvent;
import com.andrei1058.bedwars.api.events.player.PlayerLeaveArenaEvent;
import com.andrei1058.bedwars.api.events.player.PlayerXpGainEvent;
import com.andrei1058.bedwars.api.server.ServerType;
import com.andrei1058.bedwars.arena.BedWarsTeam;
import com.andrei1058.bedwars.configuration.LevelsConfig;
import com.andrei1058.bedwars.api.language.Language;
import com.andrei1058.bedwars.api.language.Messages;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.UUID;

public class LevelListeners implements Listener {

    public static LevelListeners instance;

    public LevelListeners() {
        instance = this;
    }

    //create new level data on player join
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerJoin(PlayerJoinEvent e) {
        final UUID u = e.getPlayer().getUniqueId();
        // create empty level first
        new PlayerLevel(u, 1, 0);
        Bukkit.getScheduler().runTaskAsynchronously(BedWars.plugin, () -> {
            //if (PlayerLevel.getLevelByPlayer(e.getPlayer().getUniqueId()) != null) return;
            Object[] levelData = BedWars.getRemoteDatabase().getLevelData(u);
            PlayerLevel.getLevelByPlayer(u).lazyLoad((Integer) levelData[0], (Integer) levelData[1]);
            //new PlayerLevel(e.getPlayer().getUniqueId(), (Integer)levelData[0], (Integer)levelData[1]);
            //Bukkit.broadcastMessage("LAZY LOAD");
        });
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerQuit(PlayerQuitEvent e) {
        final UUID u = e.getPlayer().getUniqueId();
        Bukkit.getScheduler().runTaskAsynchronously(BedWars.plugin, () -> {
            PlayerLevel pl = PlayerLevel.getLevelByPlayer(u);
            pl.destroy();
        });
    }

    @EventHandler
    public void onGameEnd(GameEndEvent e) {
        for (UUID p : e.getWinners()) {
            if (PlayerLevel.getLevelByPlayer(p) != null) {
                Player p1 = Bukkit.getPlayer(p);
                if (p1 == null) continue;
                PlayerLevel.getLevelByPlayer(p).addXp(LevelsConfig.levels.getInt("xp-rewards.game-win"), PlayerXpGainEvent.XpSource.GAME_WIN);
                p1.sendMessage(Language.getMsg(p1, Messages.XP_REWARD_WIN).replace("{xp}", String.valueOf(LevelsConfig.levels.getInt("xp-rewards.game-win"))));
                ITeam bwt = e.getArena().getExTeam(p1.getUniqueId());
                if (bwt != null) {
                    if (bwt.getMembersCache().size() > 1) {
                        int tr = LevelsConfig.levels.getInt("xp-rewards.per-teammate") * bwt.getMembersCache().size();
                        PlayerLevel.getLevelByPlayer(p).addXp(tr, PlayerXpGainEvent.XpSource.PER_TEAMMATE);
                        p1.sendMessage(Language.getMsg(p1, "xp-reward-per-teammate").replace("{xp}", String.valueOf(tr)));
                    }
                }
            }
        }
        for (UUID p : e.getLosers()) {
            if (PlayerLevel.getLevelByPlayer(p) != null) {
                Player p1 = Bukkit.getPlayer(p);
                if (p1 == null) continue;
                ITeam bwt = e.getArena().getExTeam(p1.getUniqueId());
                if (bwt != null) {
                    if (bwt.getMembersCache().size() > 1) {
                        int tr = LevelsConfig.levels.getInt("xp-rewards.per-teammate") * bwt.getMembersCache().size();
                        PlayerLevel.getLevelByPlayer(p).addXp(tr, PlayerXpGainEvent.XpSource.PER_TEAMMATE);
                        p1.sendMessage(Language.getMsg(p1, Messages.XP_REWARD_PER_TEAMMATE).replace("{xp}", String.valueOf(tr)));
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onArenaLeave(PlayerLeaveArenaEvent e) {
        final UUID u = e.getPlayer().getUniqueId();
        Bukkit.getScheduler().runTaskAsynchronously(BedWars.plugin, () -> {
            PlayerLevel pl = PlayerLevel.getLevelByPlayer(u);
            if (pl != null) pl.updateDatabase();
        });
    }
}