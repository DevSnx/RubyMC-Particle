package de.devsnx.rubymc.particle.utils;

import com.github.fierioziy.particlenativeapi.api.ParticleNativeAPI;
import com.github.fierioziy.particlenativeapi.core.ParticleNativeCore;
import de.devsnx.rubymc.particle.Particle;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.function.Consumer;

/**
 * @author DevSnx
 * @since 22.02.2023
 */
public class Utils {

    public static void spawnCircle(Location location, Player player, int radius){
        for (int d = 0; d <= 90; d += 1) {
            Location particleLoc = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ());
            particleLoc.setX(location.getX() + Math.cos(d) * radius);
            particleLoc.setZ(location.getZ() + Math.sin(d) * radius);
            Particle.getInstance().getParticleApi().LIST_1_13.FLAME             // select particle from list
                    .packet(true, particleLoc)             // create particle packet
                    .sendInRadiusTo(player, 30D);  // send it to player if in 30 block radius
        }
    }

    public static void createSquare(Player player,Location center, double growthRate, int maxRadius) {
        Bukkit.getScheduler().runTaskTimer(Particle.getInstance(), new Consumer<BukkitTask>() {
            private int radius = 0;
            private final Location location = new Location(center.getWorld(), 0, center.getY(), 0);

            @Override
            public void accept(BukkitTask bukkitTask) {
                for (double x = center.getX() - radius; x <= center.getX() + radius; x++) {
                    for (double z = center.getZ() - radius; z <= center.getZ() + radius; z++) {
                        location.setX(x);
                        location.setZ(z);
                        Particle.getInstance().getParticleApi().LIST_1_13.FLAME             // select particle from list
                                .packet(true, location)             // create particle packet
                                .sendInRadiusTo(player, 30D);  // send it to player if in 30 block radius
                    }
                }
                radius += growthRate;
                if (radius > maxRadius) {
                    bukkitTask.cancel();
                }
            }
        }, 0L, 1L);
    }
}