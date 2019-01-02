package com.nivyox.gamemanager.structure.arenas;

import com.nivyox.gamemanager.structure.events.ArenaStateChangedEvent;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.World;

public class GameArena {

    @Getter
    private World world;

    @Getter
    private ArenaState arenaState;

    public GameArena(World world) {
        this.world = world;
        this.arenaState = ArenaState.IN_AVAILABLE;
    }

    public void setArenaState(ArenaState newState) {
        ArenaStateChangedEvent event = new ArenaStateChangedEvent(this, this.arenaState, newState);
        Bukkit.getPluginManager().callEvent(event);
    }


}