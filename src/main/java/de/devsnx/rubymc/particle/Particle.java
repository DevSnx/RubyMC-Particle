package de.devsnx.rubymc.particle;

import com.github.fierioziy.particlenativeapi.api.ParticleNativeAPI;
import com.github.fierioziy.particlenativeapi.core.ParticleNativeCore;
import com.github.fierioziy.particlenativeapi.plugin.ParticleNativePlugin;
import de.devsnx.rubymc.particle.commands.CommandTest;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Level;

public final class Particle extends JavaPlugin {

    public static Particle instance;

    // loaded particle API
    private ParticleNativeAPI particleApi;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        // load API and store it for later use
        particleApi = ParticleNativeCore.loadAPI(this);

        // or get it from running plugin api instance
        // check if everything is fine with it

         if (ParticleNativePlugin.isValid()) {
             particleApi = ParticleNativePlugin.getAPI();
         }
         else {
             getLogger().log(Level.SEVERE, "Error occurred while loading dependency.");
             this.setEnabled(false);
             return;
         }

         getCommand("test").setExecutor(new CommandTest());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }

    public static Particle getInstance() {
        return instance;
    }

    public ParticleNativeAPI getParticleApi() {
        return particleApi;
    }
}
