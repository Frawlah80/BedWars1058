package com.andrei1058.bedwars.listeners;

import com.andrei1058.bedwars.api.arena.GameState;
import com.andrei1058.bedwars.api.arena.IArena;
import com.andrei1058.bedwars.arena.Arena;

import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.scheduler.BukkitRunnable;

import static com.andrei1058.bedwars.BedWars.plugin;

public class SpongePlaceListener implements Listener {

    @EventHandler
    public void onSpongePlaceEvent(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        IArena a = Arena.getArenaByPlayer(p);

        if (a == null) return;
        if (a.getStatus() != GameState.playing) return;

        Block b = e.getBlock();

        if (b.getType() != Material.SPONGE) return;

        SpongePlaceAnimation(b.getLocation());

        removeSpongeTask(b);

    }

    private void SpongePlaceAnimation(Location loc) {
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    Location effectLoc = loc.clone().add(x, y, z);
                    PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(EnumParticle.CLOUD, true, (float) effectLoc.getX(), (float) effectLoc.getY(), (float) effectLoc.getZ(), 0.0F, 0.0F, 0.0F, 0.1F, 1);
                    effectLoc.getWorld().getPlayers().forEach(p -> ((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet));
                    loc.getWorld().playSound(effectLoc, Sound.SPLASH, 1F, 1F);
                }
            }
        }
    }

    private void removeSpongeTask(Block b) {
         new BukkitRunnable() {
            @Override
            public void run() {
                b.setType(Material.AIR);
            }
        }.runTaskLater(plugin, 40L);
    }

}
