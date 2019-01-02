package com.nivyox.gamemanager.structure.events;

import com.nivyox.gamemanager.structure.StandardGame;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class GamePlayerAddEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    @Getter
    @Setter
    private boolean cancelled;

    @Getter
    private StandardGame game;

    @Getter
    private Player player;

    public GamePlayerAddEvent(StandardGame game, Player player) {
        this.game = game;
        this.player = player;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}