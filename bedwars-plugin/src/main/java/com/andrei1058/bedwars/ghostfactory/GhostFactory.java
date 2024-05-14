package com.andrei1058.bedwars.ghostfactory;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class GhostFactory {
    public static void addPlayerAsGhost(Player p) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Team team = board.registerNewTeam("Ghost");
        team.setAllowFriendlyFire(false);
        team.setCanSeeFriendlyInvisibles(true);
        team.setDisplayName("Ghost");
        p.setScoreboard(board);
        team.addEntry(p.getDisplayName());
    }

    public static void removePlayerAsGhost(Player p) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Team team = board.getTeam("Ghost");
        team.removeEntry(p.getDisplayName());
    }
}
