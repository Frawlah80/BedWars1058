package com.andrei1058.bedwars.arena.feature;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

@SuppressWarnings("deprecation")
public class GhostPlayerFeature {

    public static ScoreboardManager sbMgr;
    public static Scoreboard board;
    public static Team sbTeam;

    public static void addPlayerAsGhost(Player p) {
        sbMgr = Bukkit.getScoreboardManager();
        board = sbMgr.getNewScoreboard();
        if (board.getTeam("gteam") == null) {
            sbTeam = board.registerNewTeam("gteam");
        }
        sbTeam.setAllowFriendlyFire(true);
        sbTeam.setCanSeeFriendlyInvisibles(true);
        sbTeam.setDisplayName("Ghost");
        p.setScoreboard(board);
        sbTeam.addPlayer(p);
    }

    public static void removePlayerAsGhost(Player p) {
        sbMgr = Bukkit.getScoreboardManager();
        board = sbMgr.getNewScoreboard();
        sbTeam = board.getTeam("gteam");
        sbTeam.removePlayer(p);
    }
}
