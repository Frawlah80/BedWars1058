package com.andrei1058.bedwars.configuration;

import com.andrei1058.bedwars.api.configuration.ConfigManager;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class PAGConfig extends ConfigManager {

    public PAGConfig(Plugin plugin, String name, String dir) {
        super(plugin, name, dir);

        YamlConfiguration yml = getYml();

        yml.options().copyDefaults(true);

        yml.options().header("Per Arena Generator Config.\n Please use Arena name and NOT Arena displayname.\nDelay is in seconds. \nAmount cannot be 0 (unless you wish to break something) \nPlease don't put anything other than natural numbers.");

        yml.addDefault("Arenas." + "Arena1" + ".iron.amount", 2);
        yml.addDefault("Arenas." + "Arena1" + ".iron.delay", 1);
        yml.addDefault("Arenas." + "Arena1" + ".iron.spawn-limit", 48);

        yml.addDefault("Arenas." + "Arena1" + ".gold.amount", 1);
        yml.addDefault("Arenas." + "Arena1" + ".gold.delay", 4);
        yml.addDefault("Arenas." + "Arena1" + ".gold.spawn-limit", 16);

        yml.addDefault("Arenas." + "Arena1" + ".iron-forge.iron.amount", 3);
        yml.addDefault("Arenas." + "Arena1" + ".iron-forge.iron.delay", 1);
        yml.addDefault("Arenas." + "Arena1" + ".iron-forge.iron.spawn-limit", 56);
        yml.addDefault("Arenas." + "Arena1" + ".iron-forge.gold.amount", 1);
        yml.addDefault("Arenas." + "Arena1" + ".iron-forge.gold.delay", 4);
        yml.addDefault("Arenas." + "Arena1" + ".iron-forge.gold.spawn-limit", 16);

        yml.addDefault("Arenas." + "Arena1" + ".gold-forge.iron.amount", 3);
        yml.addDefault("Arenas." + "Arena1" + ".gold-forge.iron.delay", 1);
        yml.addDefault("Arenas." + "Arena1" + ".gold-forge.iron.spawn-limit", 56);
        yml.addDefault("Arenas." + "Arena1" + ".gold-forge.gold.amount", 2);
        yml.addDefault("Arenas." + "Arena1" + ".gold-forge.gold.delay", 4);
        yml.addDefault("Arenas." + "Arena1" + ".gold-forge.gold.spawn-limit", 16);

        yml.addDefault("Arenas." + "Arena1" + ".emerald-forge.iron.amount", 3);
        yml.addDefault("Arenas." + "Arena1" + ".emerald-forge.iron.delay", 1);
        yml.addDefault("Arenas." + "Arena1" + ".emerald-forge.iron.spawn-limit", 56);
        yml.addDefault("Arenas." + "Arena1" + ".emerald-forge.gold.amount", 2);
        yml.addDefault("Arenas." + "Arena1" + ".emerald-forge.gold.delay", 4);
        yml.addDefault("Arenas." + "Arena1" + ".emerald-forge.gold.spawn-limit", 16);
        yml.addDefault("Arenas." + "Arena1" + ".emerald-forge.emerald.amount", 1);
        yml.addDefault("Arenas." + "Arena1" + ".emerald-forge.emerald.delay", 10);
        yml.addDefault("Arenas." + "Arena1" + ".emerald-forge.emerald.spawn-limit", 4);

        yml.addDefault("Arenas." + "Arena1" + ".molten-forge.iron.amount", 4);
        yml.addDefault("Arenas." + "Arena1" + ".molten-forge.iron.delay", 1);
        yml.addDefault("Arenas." + "Arena1" + ".molten-forge.iron.spawn-limit", 64);
        yml.addDefault("Arenas." + "Arena1" + ".molten-forge.gold.amount", 2);
        yml.addDefault("Arenas." + "Arena1" + ".molten-forge.gold.delay", 2);
        yml.addDefault("Arenas." + "Arena1" + ".molten-forge.gold.spawn-limit", 20);
        yml.addDefault("Arenas." + "Arena1" + ".molten-forge.emerald.amount", 1);
        yml.addDefault("Arenas." + "Arena1" + ".molten-forge.emerald.delay", 5);
        yml.addDefault("Arenas." + "Arena1" + ".molten-forge.emerald.spawn-limit", 4);

        save();

        }

    }
