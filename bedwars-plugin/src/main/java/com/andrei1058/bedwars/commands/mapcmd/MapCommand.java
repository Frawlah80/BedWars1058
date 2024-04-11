package com.andrei1058.bedwars.commands.mapcmd;

import com.andrei1058.bedwars.api.arena.GameState;
import com.andrei1058.bedwars.api.arena.IArena;
import com.andrei1058.bedwars.api.language.Messages;
import com.andrei1058.bedwars.arena.Arena;
import com.andrei1058.bedwars.support.papi.SupportPAPI;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static com.andrei1058.bedwars.api.language.Language.getMsg;

public class MapCommand extends BukkitCommand {
    public MapCommand(String name) {
        super(name);
    }

    @Override
    public boolean execute(CommandSender sender, String c, String[] args) {
        if (sender instanceof ConsoleCommandSender)  {
            sender.sendMessage("You need to be a player to execute this command!");
            return true;
        }
        Player p = (Player) sender;
        replaceArenaPlaceholders(p, getMsg(p, Messages.COMMAND_MAP_ARENA_NAME), true);
        IArena arena = Arena.getArenaByPlayer(p);
        if (args.length == 0) {
            if (arena == null) {
                p.sendMessage(getMsg(p, Messages.COMMAND_MAP_NOT_IN_ARENA));
                return true;
            } else if (arena.getStatus() == GameState.playing) {
                p.sendMessage(getMsg(p, Messages.COMMAND_MAP_ARENA_NAME));
                return true;
            } else if (arena.getStatus() == GameState.waiting) {
                p.sendMessage(getMsg(p, Messages.COMMAND_MAP_ARENA_NAME));
                return true;
            } else if (arena.getStatus() == GameState.starting) {
                p.sendMessage(getMsg(p, Messages.COMMAND_MAP_ARENA_NAME));
                return true;
            } else {
                return false;
            }
        } return true;
    }

    public static void replaceArenaPlaceholders(Player player, @NotNull String s, boolean papiReplacements) {
        IArena a = Arena.getArenaByPlayer(player);

        if (s.contains("{arenaDisplayName}")) s = s.replace("{arenaDisplayName}", a.getDisplayName());
        if (s.contains("{arenaName}")) s = s.replace("{arenaName}", a.getArenaName());

        if (papiReplacements) {
            SupportPAPI.getSupportPAPI().replace(player, s);
        }
    }
}
