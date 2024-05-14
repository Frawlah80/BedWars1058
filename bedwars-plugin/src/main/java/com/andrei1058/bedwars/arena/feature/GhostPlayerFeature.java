package com.andrei1058.bedwars.arena.feature;

import com.andrei1058.bedwars.BedWars;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class GhostPlayerFeature {

    public static void addPlayerAsGhost(Player p) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Team ghosts = board.getTeam("Ghost");
        ghosts.addEntry(p.getName());
        BedWars.debug("Added " + p.getDisplayName() + " is now added to team " + board.getEntryTeam(p.getName()));
    }

    public static void removePlayerAsGhost(Player p) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Team ghosts = board.getTeam("Ghost");
        ghosts.removeEntry(p.getName());
    }
}
