package com.andrei1058.bedwars.listeners.chat;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class RankColorChat {
    public static String rankColorChat(Player p) {
        if (p.hasPermission("bw.chatcolor.donator")) {
            return ChatColor.WHITE.toString();
        } else {
            return ChatColor.GRAY.toString();
        }
    }
}
