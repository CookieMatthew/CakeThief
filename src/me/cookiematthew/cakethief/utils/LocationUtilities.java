package me.cookiematthew.cakethief.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class LocationUtilities {

    private static Location lobby = new Location(Bukkit.getWorld("Sword"), 1619.5, 65, 827.5);

    public static void teleportToLobby(Player p){
        p.teleport(lobby);
    }

    public static void teleportToGame(Player p){

    }

}
