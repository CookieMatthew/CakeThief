package me.cookiematthew.cakethief;

import me.cookiematthew.cakethief.listeners.player.AsyncPlayerPreLogin;
import me.cookiematthew.cakethief.listeners.player.PlayerJoin;
import me.cookiematthew.cakethief.listeners.player.PlayerQuit;
import me.cookiematthew.cakethief.threads.StartCountdown;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class CakeThief extends JavaPlugin{

    public void onEnable(){
        GameState.setState(GameState.IN_LOBBY);
        new Thread(new StartCountdown()).start();
    }

   public void registerListeners(){
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerJoin(this), this);
        pm.registerEvents(new PlayerQuit(this), this);
        pm.registerEvents(new AsyncPlayerPreLogin(this), this);
    }

}
