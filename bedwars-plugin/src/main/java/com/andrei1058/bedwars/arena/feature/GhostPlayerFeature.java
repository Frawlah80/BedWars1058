package com.andrei1058.bedwars.arena.feature;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

@SuppressWarnings("deprecation")
public class GhostPlayerFeature {
    public static void addPlayerAsGhost(Player p) {
        ScoreboardManager sbMgr = Bukkit.getScoreboardManager();
        Scoreboard board = sbMgr.getNewScoreboard();
        Team sbTeam = board.registerNewTeam("team");
        sbTeam.setAllowFriendlyFire(true);
        sbTeam.setCanSeeFriendlyInvisibles(true);
        sbTeam.setDisplayName("Ghost");
        p.setScoreboard(board);
        sbTeam.addPlayer(p);
    }
    public static void removePlayerAsGhost(Player p) {
        ScoreboardManager sbMgr = Bukkit.getScoreboardManager();
        Scoreboard board = sbMgr.getNewScoreboard();
        Team sbTeam = board.getTeam("team");
        sbTeam.removePlayer(p);
    }
}
