package com.nivyox.gamemanager.structure.events;

import com.nivyox.gamemanager.structure.StandardGame;
import com.nivyox.gamemanager.structure.GameState;
import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class GameStateChangeEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    @Getter
    private final StandardGame game;

    @Getter
    private final GameState currentState;

    @Getter
    private final GameState newState;

    public GameStateChangeEvent(StandardGame game, GameState currentState, GameState newState) {
        this.game = game;
        this.currentState = currentState;
        this.newState = newState;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
