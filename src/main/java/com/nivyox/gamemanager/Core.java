package com.nivyox.gamemanager;

import com.nivyox.gamemanager.structure.Game;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class Core extends JavaPlugin {

    @Getter
    private GameManager gameManager;

    public static Core getInstance() {
        return getPlugin(Core.class);
    }

    @Override
    public void onEnable() {
        this.gameManager = new GameManager<Game>();
    }

    @Override
    public void onDisable() {

    }
}
