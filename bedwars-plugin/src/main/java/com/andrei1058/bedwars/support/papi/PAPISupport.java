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

package com.andrei1058.bedwars.support.papi;

import com.andrei1058.bedwars.BedWars;
import com.andrei1058.bedwars.api.arena.GameState;
import com.andrei1058.bedwars.api.arena.IArena;
import com.andrei1058.bedwars.api.arena.team.ITeam;
import com.andrei1058.bedwars.api.language.Language;
import com.andrei1058.bedwars.api.language.Messages;
import com.andrei1058.bedwars.api.stats.IPlayerStats;
import com.andrei1058.bedwars.arena.Arena;
import com.andrei1058.bedwars.commands.shout.ShoutCommand;
import com.andrei1058.bedwars.support.nickapi.NameOrNick;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;

import static com.andrei1058.bedwars.api.language.Language.getMsg;

public class PAPISupport extends PlaceholderExpansion {

    @NotNull
    @Override
    public String getIdentifier() {
        return "bw1058";
    }

    @NotNull
    @Override
    public String getAuthor() {
        return "andrei1058";
    }

    @NotNull
    @Override
    public String getVersion() {
        return BedWars.plugin.getDescription().getVersion();
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public String onPlaceholderRequest(Player player, @NotNull String s) {

        /* Non-Player required placeholders */

        if (s.startsWith("arena_status_")) {
            IArena a = Arena.getArenaByName(s.replace("arena_status_", ""));
            if (a == null) {
                return player == null ? Language.getDefaultLanguage().m(Messages.ARENA_STATUS_RESTARTING_NAME) :
                        Language.getMsg(player, Messages.ARENA_STATUS_RESTARTING_NAME);
            }
            return a.getDisplayStatus(Language.getDefaultLanguage());
        }

        if (s.startsWith("arena_count_")) {
            int players = 0;

            String[] arenas = s.replace("arena_count_", "").split("\\+");
            IArena a;
            for (String arena : arenas) {
                a = Arena.getArenaByName(arena);
                if (a != null) {
                    players += a.getPlayers().size();
                }
            }

            return String.valueOf(players);
        }

        if (s.startsWith("group_count_")) {
            return String.valueOf(Arena.getPlayers(s.replace("group_count_", "")));
        }

        if (s.startsWith("arena_group_")) {
            String a = s.replace("arena_group_", "");
            IArena arena = Arena.getArenaByName(a);
            if (arena != null) {
                return arena.getGroup();
            }
            return "-";
        }


        /* Player required placeholders */
        if (player == null) return null;

        // stats placeholders
        if(s.startsWith("stats_")) {
            IArena a = Arena.getArenaByPlayer(player);
            String targetedStat = s.replaceFirst("stats_", "");
            if(targetedStat.isEmpty() || targetedStat.isBlank()) {
                return null;
            }
            IPlayerStats stats = BedWars.getStatsManager().getUnsafe(player.getUniqueId());
            if(stats == null) {
                return null;
            }
            switch (targetedStat) {
                // Overall stats
                case "firstplay":
                    Instant firstPlay = stats.getFirstPlay();
                    return new SimpleDateFormat(getMsg(player, Messages.FORMATTING_STATS_DATE_FORMAT)).format(firstPlay != null ? Timestamp.from(firstPlay) : null);
                case "lastplay":
                    Instant lastPlay = stats.getLastPlay();
                    return new SimpleDateFormat(getMsg(player, Messages.FORMATTING_STATS_DATE_FORMAT)).format(lastPlay != null ? Timestamp.from(lastPlay) : null);
                case "total_kills":
                    return String.valueOf(stats.getTotalKills());
                case "kills":
                    return String.valueOf(stats.getKills());
                case "kdr":
                    if (stats.getKills() == 0 && stats.getDeaths() == 0) {
                        return String.valueOf(0);
                    } else if (stats.getKills() == 0 && stats.getDeaths() != 0) {
                        return String.valueOf(0);
                    } else if (stats.getKills() != 0 && stats.getDeaths() == 0) {
                        return String.valueOf(stats.getKills());
                    } else {
                        double kdr = ((double) stats.getKills()) / ((double) stats.getDeaths());
                        DecimalFormat kdrDf = new DecimalFormat("#.##");
                        return String.valueOf(kdrDf.format(kdr));
                    }
                case "wins":
                    return String.valueOf(stats.getWins());
                case "finalkills":
                    return String.valueOf(stats.getFinalKills());
                case "deaths":
                    return String.valueOf(stats.getDeaths());
                case "losses":
                    return String.valueOf(stats.getLosses());
                case "finaldeaths":
                    return String.valueOf(stats.getFinalDeaths());
                case "fkdr":
                    if (stats.getFinalKills() == 0 && stats.getFinalDeaths() == 0) {
                        return String.valueOf(0);
                    } else if (stats.getFinalKills() == 0 && stats.getFinalDeaths() != 0) {
                        return String.valueOf(0);
                    } else if (stats.getFinalKills() != 0 && stats.getFinalDeaths() == 0) {
                        return String.valueOf(stats.getFinalKills());
                    } else {
                        double fkdr = ((double) stats.getFinalKills()) / ((double) stats.getFinalDeaths());
                        DecimalFormat fkdrDf = new DecimalFormat("#.##");
                        return String.valueOf(fkdrDf.format(fkdr));
                    }
                case "bedsdestroyed":
                    return String.valueOf(stats.getBedsDestroyed());
                case "bedslost":
                    return String.valueOf(stats.getBedsLost());
                case "bblr":
                    if (stats.getBedsDestroyed() == 0 && stats.getBedsLost() == 0) {
                        return String.valueOf(0);
                    } else if (stats.getBedsDestroyed() == 0 && stats.getBedsLost() != 0) {
                        return String.valueOf(0);
                    } else if (stats.getBedsDestroyed() != 0 && stats.getBedsLost() == 0) {
                        return String.valueOf(stats.getBedsDestroyed());
                    } else {
                        double bblr = ((double) stats.getBedsDestroyed()) / ((double) stats.getBedsLost());
                        DecimalFormat bblrDf = new DecimalFormat("#.##");
                        return String.valueOf(bblrDf.format(bblr));
                    }
                case "wlr":
                    if (stats.getWins() == 0 && stats.getLosses() == 0) {
                        return String.valueOf(0);
                    } else if (stats.getWins() == 0 && stats.getLosses() != 0) {
                        return String.valueOf(0);
                    } else if (stats.getWins() != 0 && stats.getLosses() == 0) {
                        return String.valueOf(stats.getWins());
                    } else {
                        double wlr = ((double) stats.getWins()) / ((double) stats.getLosses());
                        DecimalFormat wlrDf = new DecimalFormat("#.##");
                        return String.valueOf(wlrDf.format(wlr));
                    }
                case "winstreak":
                    return String.valueOf(stats.getWinStreak());
                case "highest_winstreak":
                    return String.valueOf(stats.getHighestWinStreak());
                case "gamesplayed":
                    return String.valueOf(stats.getGamesPlayed());

                // per game stats
                case "game_kills":
                    return String.valueOf(a.getPlayerKills(player, false));
                case "game_kills_total":
                    return String.valueOf(a.getPlayerKills(player, true) + a.getPlayerKills(player, false));
                case "game_finalkills":
                    return String.valueOf(a.getPlayerKills(player, true));
                case "game_deaths":
                    return String.valueOf(a.getPlayerDeaths(player, false));
                case "game_deaths_total":
                    return String.valueOf(a.getPlayerDeaths(player, true) + a.getPlayerDeaths(player, false));
                case "game_finaldeaths":
                    return String.valueOf(a.getPlayerDeaths(player, true));
                case "game_bedsdestroyed":
                    return String.valueOf(a.getPlayerBedsDestroyed(player));
                case "game_kdr":
                    if (a.getPlayerKills(player, false) == 0 && a.getPlayerDeaths(player, false) == 0) {
                        return String.valueOf(0);
                    } else if (a.getPlayerKills(player, false) == 0 && a.getPlayerDeaths(player, false) != 0) {
                        return String.valueOf(0);
                    } else if (a.getPlayerKills(player, false) != 0 && a.getPlayerDeaths(player, false) == 0) {
                        return String.valueOf(a.getPlayerKills(player, false));
                    } else {
                        double gamekdr = ((double) a.getPlayerKills(player, false)) / ((double) a.getPlayerDeaths(player, false));
                        DecimalFormat gameKdrDf = new DecimalFormat("#.##");
                        return String.valueOf(gameKdrDf.format(gamekdr));
                    }
                case "game_fkdr":
                    if (a.getPlayerKills(player, true) == 0 && a.getPlayerDeaths(player, true) == 0) {
                        return String.valueOf(0);
                    } else if (a.getPlayerKills(player, true) == 0 && a.getPlayerDeaths(player, true) != 0) {
                        return String.valueOf(0);
                    } else if (a.getPlayerKills(player, true) != 0 && a.getPlayerDeaths(player, true) == 0) {
                        return String.valueOf(a.getPlayerKills(player, true));
                    } else {
                        double gamefkdr = ((double) a.getPlayerKills(player, true)) / ((double) a.getPlayerDeaths(player, true));
                        DecimalFormat gameFkdrDf = new DecimalFormat("#.##");
                        return String.valueOf(gameFkdrDf.format(gamefkdr));
                    }
                case "overAll_winstreak":
                    return String.valueOf(stats.getOverAllWinStreak());
                case "overAll_highestWinstreak":
                    return String.valueOf(stats.getOverAllHighestWinStreak());
                case "core_winstreak":
                    return String.valueOf(stats.getCoreWinStreak());
                case "core_highestWinstreak":
                    return String.valueOf(stats.getCoreHighestWinStreak());
            }
        }

        // other placeholders
        String response = "";
        IArena a = Arena.getArenaByPlayer(player);
        switch (s) {
            case "current_online":
                response = String.valueOf(Arena.getArenaByPlayer().size());
                break;
            case "current_arenas":
                response = String.valueOf(Arena.getArenas().size());
                break;
            case "current_playing":
                if (a != null) {
                    response = String.valueOf(a.getPlayers().size());
                }
                break;
            case "player_team_color":
                if (a != null && a.isPlayer(player) && a.getStatus() == GameState.playing) {
                    ITeam team = a.getTeam(player);
                    if (team != null) {
                        response += String.valueOf(team.getColor().chat());
                    }
                }
                break;
            case "player_team":
                if (a != null) {
                    if (ShoutCommand.isShout(player)) {
                        response += Language.getMsg(player, Messages.FORMAT_PAPI_PLAYER_TEAM_SHOUT);
                    }
                    if (a.isPlayer(player)) {
                        if (a.getStatus() == GameState.playing) {
                            ITeam bwt = a.getTeam(player);
                            if (bwt != null) {
                                response += Language.getMsg(player, Messages.FORMAT_PAPI_PLAYER_TEAM_TEAM).replace("{TeamName}",
                                        bwt.getDisplayName(Language.getPlayerLanguage(player))).replace("{TeamColor}", String.valueOf(bwt.getColor().chat()));
                            }
                        }
                    } else {
                        response += Language.getMsg(player, Messages.FORMAT_PAPI_PLAYER_TEAM_SPECTATOR);
                    }
                }
                break;
            case "player_level":
                response = BedWars.getLevelSupport().getLevel(player);
                break;
            case "player_level_no_brackets":
                response = BedWars.getLevelSupport().getLevel(player)
                        .replaceAll(".*\\[", "")
                        .replaceAll("✫.*", "✫")
                        .replaceAll("✪.*", "✪")
                        .replaceAll("].*", "");
                // this will 99.9% fix any color code bug in scoreboard, the other 0.1% is when someone uses a different type of star. ugh
                break;
            case "player_level_raw":
                response = String.valueOf(BedWars.getLevelSupport().getPlayerLevel(player));
                break;
            case "player_progress":
                response = BedWars.getLevelSupport().getProgressBar(player);
                break;
            case "player_xp_formatted":
                response = BedWars.getLevelSupport().getCurrentXpFormatted(player);
                break;
            case "player_xp":
                response = String.valueOf(BedWars.getLevelSupport().getCurrentXp(player));
                break;
            case "player_req_xp_formatted":
                response = BedWars.getLevelSupport().getRequiredXpFormatted(player);
                break;
            case "player_req_xp":
                response = String.valueOf(BedWars.getLevelSupport().getRequiredXp(player));
                break;
            // player status required for tab condition
            case "player_status":
                if(a != null) {
                    switch (a.getStatus()) {
                        case waiting:
                        case starting:
                            response = "WAITING";
                            break;
                        case playing:
                            if(a.isPlayer(player)) {
                                response = "PLAYING";
                            } else if(a.isSpectator(player)) {
                                response = "SPECTATING";
                            } else {
                                response = "IN_GAME_BUT_NOT"; // this shouldnt happen
                            }
                            break;
                        case restarting:
                            response = "RESTARTING";
                            break;
                    }
                } else {
                    response = "NONE";
                }
                break;
            case "current_arena_group":
                if (a != null) {
                    response = a.getGroup();
                }
                break;
            case "elapsed_time":
                if (a != null) {
                    Instant startTime = a.getStartTime();
                    if (null != startTime){
                        Duration time = Duration.ofMillis(Instant.now().minusMillis(startTime.toEpochMilli()).toEpochMilli());
                        if (time.toHours() == 0){
                            response = String.format("%02d:%02d", time.toMinutes(), time.toSeconds());
                        } else {
                            response = String.format("%02d:%02d:%02d", time.toHours(), time.toMinutes(), time.toSeconds());
                        }
                    } else response = "";
                }
                break;
            case "arena_displayname":
                if (a != null) {
                    response = a.getDisplayName();
                }
                break;
            case "arena_name":
                if (a != null) {
                    response = a.getArenaName();
                }
                break;
            case "team_letter":
                ITeam bedwarsteam = a.getTeam(player);
                if (bedwarsteam != null) {
                    response = bedwarsteam.getName().substring(0,1).toUpperCase();
                }
                break;
            case "exteam_color":
                ITeam xTeam = a.getExTeam(player.getUniqueId());
                response = xTeam.getColor().chat().toString();
                break;
            case "nick_format":
                response = NameOrNick.getNickName(player);
                break;
        }
        return response;
    }
}
