package com.andrei1058.bedwars.commands.leave;

import com.andrei1058.bedwars.api.configuration.ConfigPath;

import com.andrei1058.bedwars.api.language.Language;
import com.andrei1058.bedwars.api.language.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.UUID;

import static com.andrei1058.bedwars.BedWars.config;
import static com.andrei1058.bedwars.BedWars.plugin;

public class LeaveDelayCommand extends BukkitCommand {

    private BukkitTask task;
    private final HashMap<UUID, Boolean> onCooldown = new HashMap<>();

    public LeaveDelayCommand(String name) {
        super(name);
    }

    @Override
    public boolean execute(CommandSender s, String st, String[] args) {
        if (!(s instanceof Player)) return true;
        Player p = (Player) s;

        if (config.getBoolean(ConfigPath.GENERAL_CONFIGURATION_ENABLE_LEAVE_DELAY)) {

            if (!onCooldown.containsKey(p.getUniqueId())) {

                onCooldown.put(p.getUniqueId(), true);

                p.sendMessage(Language.getMsg(p, Messages.COMMAND_BED_LEAVE));

                task = new BukkitRunnable() {

                    public void run() {

                        Bukkit.dispatchCommand(p, "bw leave");
                        onCooldown.remove(p.getUniqueId());

                    }

                }.runTaskLater(plugin, config.getInt(ConfigPath.GENERAL_CONFIGURATION_LEAVE_DELAY_VALUE) * 20L);

            } else if (onCooldown.containsKey(p.getUniqueId())) {

                p.sendMessage(Language.getMsg(p, Messages.COMMAND_BED_LEAVE_CANCELLED));
                task.cancel();
                onCooldown.remove(p.getUniqueId());

            }

        } else {

            Bukkit.dispatchCommand(p, "bw leave");

        }

        return true;
    }
}
