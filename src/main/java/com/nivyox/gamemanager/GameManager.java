package com.nivyox.gamemanager;

import com.nivyox.gamemanager.structure.arenas.GameArena;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class GameManager<Game> {

    @Getter
    private final List<Game> games;

    @Getter
    private final List<GameArena> gameArenas;

    @Getter
    private final JavaPlugin pluginInstance;

    public <Game>GameManager(JavaPlugin pluginInstance) {
        this.pluginInstance = pluginInstance;
        GameManagerCore.getInstance().getGameManagers().add(this);

        this.games = new ArrayList<>();
        this.gameArenas = new ArrayList<>();
        this.loadArenas();
    }

    private void loadArenas() {
        List<String> arenaNames = this.pluginInstance.getConfig().getStringList("gamemanager.arenas.world_names");
        for (String arenaName : arenaNames) {
            World world = Bukkit.getServer().createWorld(new WorldCreator(arenaName));
            GameArena arena = new GameArena(world);
            this.gameArenas.add(arena);
        }
    }

    public Game findGame() {
        return null;
    }

    public Game createGame() {
        return null;
    }
}