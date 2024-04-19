package com.andrei1058.bedwars.configuration;

import com.andrei1058.bedwars.BedWars;
import com.andrei1058.bedwars.api.configuration.ConfigManager;

public class PAGConfig extends ConfigManager {

    public static PAGConfig pag;

    private PAGConfig() {
        super(BedWars.plugin, "per-arena-gen", BedWars.plugin.getDataFolder().toString());
    }

    public static void init() {

        pag = new PAGConfig();
        pag.getYml().options().copyDefaults(true);

        if (pag.isFirstTime()) {
            pag.getYml().options().header("Per Arena Generator Config.\n Please use Arena name and NOT Arena displayname.");

            pag.getYml().options().header("Delay is in seconds. Amount cannot be 0 (unless you wish to break something)");
            pag.getYml().options().header("Please don't put anything other than natural numbers.");

            pag.getYml().addDefault("Arenas." + "Arena1" + ".iron.amount", 2);
            pag.getYml().addDefault("Arenas." + "Arena1" + ".iron.delay", 1);
            pag.getYml().addDefault("Arenas." + "Arena1" + ".iron.spawn-limit", 48);

            pag.getYml().addDefault("Arenas." + "Arena1" + ".gold.amount", 1);
            pag.getYml().addDefault("Arenas." + "Arena1" + ".gold.delay", 4);
            pag.getYml().addDefault("Arenas." + "Arena1" + ".gold.spawn-limit", 16);

        }

    }

}
