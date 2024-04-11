package com.andrei1058.bedwars.commands.mapcmd;

import com.andrei1058.bedwars.api.arena.GameState;
import com.andrei1058.bedwars.api.arena.IArena;
import com.andrei1058.bedwars.api.language.Messages;
import com.andrei1058.bedwars.arena.Arena;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

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
        IArena arena = Arena.getArenaByPlayer(p);
        if (args.length == 0) {
            if (arena == null) {
                p.sendMessage(getMsg(p, Messages.COMMAND_MAP_NOT_IN_ARENA));
                return true;
            } else if (arena.getStatus() == GameState.playing || arena.getStatus() == GameState.waiting || arena.getStatus() == GameState.starting) {
                p.sendMessage(getMsg(p, Messages.COMMAND_MAP_ARENA_NAME)
                        .replace("{arenaDisplayName}", arena.getDisplayName())
                        .replace("{arenaName}", arena.getArenaName()));
                return true;
            } else {
                return false;
            }
        } return true;
    }

}
