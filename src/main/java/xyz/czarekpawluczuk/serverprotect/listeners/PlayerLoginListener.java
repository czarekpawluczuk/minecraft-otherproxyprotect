package xyz.czarekpawluczuk.serverprotect.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import xyz.czarekpawluczuk.serverprotect.ServerProtectPlugin;
import xyz.czarekpawluczuk.serverprotect.helpers.ChatHelper;

public class PlayerLoginListener implements Listener {

    private ChatHelper chatHelper = new ChatHelper();
    private ServerProtectPlugin plugin;

    public PlayerLoginListener(ServerProtectPlugin plugin){
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void playerConnect(final PlayerLoginEvent event) {
        final String joinedAddress = event.getRealAddress().getHostAddress();
        if (!joinedAddress.equalsIgnoreCase(plugin.getConfig().getString("config.proxyAddress"))) {
            event.disallow(PlayerLoginEvent.Result.KICK_OTHER, chatHelper.color(plugin.getConfig().getString("config.kickMessage").replace("{n}", "\n")));
        }
    }
}
