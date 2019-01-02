package com.nivyox.gamemanager.structure;

import com.nivyox.gamemanager.structure.events.GameTimerTickEvent;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;

public abstract class GameTimer implements Runnable {

    @Getter
    @Setter
    private long time;

    @Getter
    private StandardGame game;

    public GameTimer(StandardGame game) {
        this.game = game;
        this.time = 0;
    }

    @Override
    public void run() {
        GameTimerTickEvent event = new GameTimerTickEvent(this, time);
        Bukkit.getPluginManager().callEvent(event);
    }
}
