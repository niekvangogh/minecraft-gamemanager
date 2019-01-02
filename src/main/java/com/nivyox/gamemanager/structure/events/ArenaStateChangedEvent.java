package com.nivyox.gamemanager.structure.events;

import com.nivyox.gamemanager.structure.arenas.ArenaState;
import com.nivyox.gamemanager.structure.arenas.GameArena;
import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ArenaStateChangedEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    @Getter
    private final GameArena gameArena;

    @Getter
    private final ArenaState currentState;

    @Getter
    private final ArenaState newState;

    public ArenaStateChangedEvent(GameArena gameArena, ArenaState currentState, ArenaState newState) {
        this.gameArena = gameArena;
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
