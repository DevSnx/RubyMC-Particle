package de.devsnx.rubymc.particle;

import com.github.fierioziy.particlenativeapi.api.ParticleNativeAPI;
import com.github.fierioziy.particlenativeapi.api.utils.ParticleException;
import com.github.fierioziy.particlenativeapi.core.ParticleNativeCore;
import org.bukkit.plugin.java.JavaPlugin;

public final class Particle extends JavaPlugin {

    public static Particle instance;

    public static ParticleNativeAPI ParticleAPI;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        if(getServer().getPluginManager().getPlugin("ParticleNativeAPI") != null){
            loadAPI();
        }
    }


    private void loadAPI(){
        try {
            ParticleAPI = ParticleNativeCore.loadAPI(getInstance());
        } catch (ParticleException e) {// optional runtime exception catch
            // handle error
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }

    public static Particle getInstance() {
        return instance;
    }

    public static ParticleNativeAPI getApi() {
        return ParticleAPI;
    }
}
