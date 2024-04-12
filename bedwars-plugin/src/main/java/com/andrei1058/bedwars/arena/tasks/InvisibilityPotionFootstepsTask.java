package com.andrei1058.bedwars.arena.tasks;

import org.bukkit.Effect;
import org.bukkit.entity.Player;

public class InvisibilityPotionFootstepsTask implements Runnable {
    private final Player p;
    public InvisibilityPotionFootstepsTask(Player p) {
        this.p = p;
    }

    @Override
    public void run() {
        p.getWorld().playEffect(p.getLocation().add(0.0D, 0.005D, 0.0D), Effect.FOOTSTEP, 1);
    }
}

