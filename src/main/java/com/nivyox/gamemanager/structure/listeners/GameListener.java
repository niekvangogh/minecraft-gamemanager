package com.nivyox.gamemanager.structure.listeners;

import com.nivyox.gamemanager.structure.StandardGame;
import com.nivyox.gamemanager.structure.events.GamePlayerAddEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class GameListener implements Listener {

    @EventHandler
    public void onGamePlayerAddEvent(GamePlayerAddEvent event) {
        StandardGame game = event.getGame();
    }
}