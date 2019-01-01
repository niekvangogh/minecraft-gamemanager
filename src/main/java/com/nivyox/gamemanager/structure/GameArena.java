package com.nivyox.gamemanager.structure;

import lombok.Getter;
import org.bukkit.World;

public class GameArena {

    @Getter
    private World world;

    public GameArena(World world) {
        this.world = world;
    }
}