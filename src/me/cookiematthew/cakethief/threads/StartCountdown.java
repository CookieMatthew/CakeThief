package me.cookiematthew.cakethief.threads;

import me.cookiematthew.cakethief.CakeThief;
import me.cookiematthew.cakethief.GameState;
import me.cookiematthew.cakethief.handlers.Game;
import me.cookiematthew.cakethief.utils.ChatUtilities;
import org.bukkit.Bukkit;

public class StartCountdown implements Runnable {

    private static int timeUntilStart;

    public void run() {
        while (true) {
            if (GameState.isState(GameState.IN_LOBBY)) {
                if (Game.canStart()) {
                    ChatUtilities.broadcast("Minimum players reached! Countdown starting!");
                    timeUntilStart = 60;
                    for (; timeUntilStart >= 0; timeUntilStart--) {
                        if(!Game.canStart()){
                            ChatUtilities.broadcast("Not enough players! Countdown stopped!");
                            break;
                        }
                        if (timeUntilStart == 0) {
                            Game.start();
                            break;
                        }

                        if (timeUntilStart % 10 == 0 || timeUntilStart < 10) {
                            ChatUtilities.broadcast(timeUntilStart + " seconds until the game starts!");
                        }

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            Bukkit.shutdown();
                        }
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Bukkit.shutdown();
                }
            }
        }
    }
}
