package me.cookiematthew.cakethief.listeners.player;

import me.cookiematthew.cakethief.CakeThief;
import me.cookiematthew.cakethief.handlers.Game;
import me.cookiematthew.cakethief.listeners.CTListener;
import me.cookiematthew.cakethief.utils.ChatUtilities;
import me.cookiematthew.cakethief.utils.LocationUtilities;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffectType;

public class PlayerJoin extends CTListener{

    public PlayerJoin(CakeThief pl){
        super(pl);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoinEvent(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.setJoinMessage("");
        p.setHealth(20.0);
        p.setExp(0);
        ChatUtilities.broadcast(e.getPlayer().getDisplayName() + " has joined!");
        p.removePotionEffect(PotionEffectType.INVISIBILITY);
        p.setGameMode(GameMode.ADVENTURE);
        p.getInventory().clear();
        p.getInventory().setHelmet(null);
        p.sendMessage("You are now in spectator mode!");
        LocationUtilities.teleportToLobby(p);

    }

}

