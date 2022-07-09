package xyz.czarekpawluczuk.serverprotect;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.czarekpawluczuk.serverprotect.listeners.PlayerLoginListener;

public class ServerProtectPlugin extends JavaPlugin {

    public void onEnable(){
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new PlayerLoginListener(this), this);
    }
}
