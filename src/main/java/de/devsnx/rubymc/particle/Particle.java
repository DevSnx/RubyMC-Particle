package de.devsnx.rubymc.particle;

import com.github.fierioziy.particlenativeapi.api.ParticleNativeAPI;
import com.github.fierioziy.particlenativeapi.api.utils.ParticleException;
import com.github.fierioziy.particlenativeapi.core.ParticleNativeCore;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Particle extends JavaPlugin {

    public static Particle instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        if(getServer().getPluginManager().getPlugin("ParticleNativeAPI") != null){
            loadAPI();
        }
    }


    private void loadAPI(){
        Plugin plugin = this.getServer().getPluginManager().getPlugin("ParticleNativeAPI");
        if (plugin != null) {
            //if (!ParticleNativePlugin.isValid()) {
                // handle error
            //}
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }

    public static Particle getInstance() {
        return instance;
    }
}
