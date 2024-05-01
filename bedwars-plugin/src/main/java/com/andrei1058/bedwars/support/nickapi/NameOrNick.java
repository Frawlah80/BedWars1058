package com.andrei1058.bedwars.support.nickapi;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import xyz.haoshoku.nick.api.NickAPI;

public class NameOrNick {
    public static String getNickName(Player p) {
        if (Bukkit.getServer().getPluginManager().getPlugin("NickAPI") != null) {
            if (NickAPI.isNicked(p)) {
                return NickAPI.getName(p);
            } else {
                return p.getDisplayName();
            }
        } else {
            return p.getDisplayName();
        }
    }
}
