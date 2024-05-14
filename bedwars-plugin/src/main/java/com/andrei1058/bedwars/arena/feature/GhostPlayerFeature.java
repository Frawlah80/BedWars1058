package com.andrei1058.bedwars.arena.feature;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

@SuppressWarnings("deprecation")
public class GhostPlayerFeature {

    private static ScoreboardManager sbMgr;
    private static Scoreboard board;
    private static Team sbTeam;

    public static void addPlayerAsGhost(Player p) {
        sbMgr = Bukkit.getScoreboardManager();
        board = sbMgr.getMainScoreboard();
        sbTeam = board.getTeam("gteam");
        if (sbTeam == null) {
            sbTeam = board.registerNewTeam("gteam");
        }
        sbTeam.setAllowFriendlyFire(false);
        sbTeam.setCanSeeFriendlyInvisibles(true);
        sbTeam.addPlayer(p);
    }

    public static void removePlayerAsGhost(Player p) {
        sbMgr = Bukkit.getScoreboardManager();
        board = sbMgr.getMainScoreboard();
        sbTeam = board.getTeam("gteam");
        sbTeam.removePlayer(p);
    }
}
