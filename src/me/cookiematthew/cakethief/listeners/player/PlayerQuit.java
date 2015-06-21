package me.cookiematthew.cakethief.listeners.player;

import me.cookiematthew.cakethief.CakeThief;
import me.cookiematthew.cakethief.GameState;
import me.cookiematthew.cakethief.GameState;
import me.cookiematthew.cakethief.handlers.Game;
import me.cookiematthew.cakethief.listeners.CTListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit extends CTListener {

    public PlayerQuit(CakeThief pl) {
        super(pl);
    }

    public void onPlayerLeaveEvent(PlayerQuitEvent q) {
        Player p = q.getPlayer();
        q.setQuitMessage("");
        if (GameState.isState(GameState.IN_LOBBY)) {
        }
    }
}
