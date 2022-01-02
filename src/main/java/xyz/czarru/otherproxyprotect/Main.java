package xyz.czarru.otherproxyprotect;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.czarru.otherproxyprotect.listeners.PlayerLoginListener;

public class Main extends JavaPlugin {

    public void onEnable(){
        getServer().getPluginManager().registerEvents(new PlayerLoginListener(), this);
    }
}
