package me.cookiematthew.cakethief.listeners.player;

import me.cookiematthew.cakethief.CakeThief;
import me.cookiematthew.cakethief.handlers.Game;
import me.cookiematthew.cakethief.listeners.CTListener;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent.Result;

public class AsyncPlayerPreLogin extends CTListener{

    public AsyncPlayerPreLogin(CakeThief pl) {
        super(pl);
    }

    @EventHandler
    public void playerPreLogin(AsyncPlayerPreLoginEvent e){
        if(Game.hasStarted())
            e.disallow(Result.KICK_OTHER, ChatColor.RED + "A game has already started!");
    }

}
