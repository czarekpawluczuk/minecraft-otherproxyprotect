package xyz.czarru.otherproxyprotect.helpers;

import org.bukkit.ChatColor;

public class ColorHelper {

    public static String fix(String st){
        return ChatColor.translateAlternateColorCodes('&', st);
    }
}
