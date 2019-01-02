package com.nivyox.gamemanager;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class GameManagerCore extends JavaPlugin {

    @Getter
    private List<GameManager> gameManagers;

    static GameManagerCore getInstance() {
        return getPlugin(GameManagerCore.class);
    }

    @Override
    public void onEnable() {
        this.gameManagers = new ArrayList<>();
    }

    @Override
    public void onDisable() {
    }
}