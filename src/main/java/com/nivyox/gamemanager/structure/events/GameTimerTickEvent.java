package com.nivyox.gamemanager.structure.events;

import com.nivyox.gamemanager.structure.GameTimer;
import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class GameTimerTickEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    @Getter
    private final GameTimer gameTimer;

    @Getter
    private final long time;

    public GameTimerTickEvent(GameTimer gameTimer, long time) {
        this.gameTimer = gameTimer;
        this.time = time;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
