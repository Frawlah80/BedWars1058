package com.andrei1058.bedwars.arena.tasks;

import com.andrei1058.bedwars.api.arena.IArena;
import com.andrei1058.bedwars.arena.Arena;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import static com.andrei1058.bedwars.BedWars.debug;

public class RemoveMagicMilkOnDeathTask implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {

        Player p = e.getEntity();
        IArena arena = Arena.getArenaByPlayer(p);

        if (arena == null) return;

        Arena.magicMilk.remove(p.getUniqueId());
        debug("PlayerItemConsumeEvent player " + p.getName() + " was removed from magicMilk because they died.");

    }

}
