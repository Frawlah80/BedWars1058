package com.andrei1058.bedwars.configuration;

import com.andrei1058.bedwars.api.configuration.ConfigManager;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class PAGConfig extends ConfigManager {

    public PAGConfig(Plugin plugin, String name, String dir) {
        super(plugin, name, dir);

        YamlConfiguration yml = getYml();

        yml.options().copyDefaults(true);

        yml.options().header("Per Arena Generator Config.\n Please use Arena name and NOT Arena displayname.");

        yml.options().header("Delay is in seconds. Amount cannot be 0 (unless you wish to break something)");
        yml.options().header("Please don't put anything other than natural numbers.");

        yml.addDefault("Arenas." + "Arena1" + ".iron.amount", 2);
        yml.addDefault("Arenas." + "Arena1" + ".iron.delay", 1);
        yml.addDefault("Arenas." + "Arena1" + ".iron.spawn-limit", 48);

        yml.addDefault("Arenas." + "Arena1" + ".gold.amount", 1);
        yml.addDefault("Arenas." + "Arena1" + ".gold.delay", 4);
        yml.addDefault("Arenas." + "Arena1" + ".gold.spawn-limit", 16);

        save();

        }

    }
