package me.cookiematthew.cakethief.handlers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Game {

    private static boolean canStart = false;

    private static boolean hasStarted = false;

    public static List<Player> players = new ArrayList<Player>();

    public static Player thief;

    public static void start(){
        new Role("Thief");
        new Role("Innocent");
        for(Player p : Bukkit.getOnlinePlayers()){
            players.add(p);
        }
        thief = players.get(new Random().nextInt(players.size()));
        Role.getRole("Thief").add(thief);
        for(Player p : players){
            if(p != thief){
                Role.getRole("Innocent").add(p);
            }
        }
    }

    public static void stop(){
        hasStarted = false;
    }

    public static boolean canStart() {
        return false;
    }

    public static boolean hasStarted(){
        return hasStarted;
    }

    public static void setCanStart(boolean b){
        canStart = b;
    }

}
