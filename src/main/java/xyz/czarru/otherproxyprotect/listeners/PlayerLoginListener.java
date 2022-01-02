package xyz.czarru.otherproxyprotect.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import xyz.czarru.otherproxyprotect.helpers.ColorHelper;

public class PlayerLoginListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerLogin(final PlayerLoginEvent event) {
        final String joinedAddress = event.getRealAddress().getHostAddress();
        final String bungeeCordAddress = "123.456.789.0"; //adres ip Twojego bungeecorda
        if (bungeeCordAddress.contains(";")) {
            for (final String address : bungeeCordAddress.split(";")) {
                if (joinedAddress.equalsIgnoreCase(address)) {
                    return;
                }
            }
        }
        if (joinedAddress.equalsIgnoreCase(bungeeCordAddress)) {
            return;
        }
        event.disallow(PlayerLoginEvent.Result.KICK_OTHER, ColorHelper.fix("&cPróba połączenia z odrębnego proxy."));
    }
}
