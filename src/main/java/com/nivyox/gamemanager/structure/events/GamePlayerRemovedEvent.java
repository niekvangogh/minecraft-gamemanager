package com.nivyox.gamemanager.structure.events;

import com.nivyox.gamemanager.structure.StandardGame;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class GamePlayerRemovedEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    @Getter
    private final StandardGame game;

    @Getter
    private final Player player;

    public GamePlayerRemovedEvent(StandardGame game, Player player) {
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