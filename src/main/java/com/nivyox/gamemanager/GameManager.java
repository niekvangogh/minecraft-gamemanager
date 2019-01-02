package com.nivyox.gamemanager;

import com.nivyox.gamemanager.structure.StandardGame;
import com.nivyox.gamemanager.structure.arenas.GameArena;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class GameManager<Game extends StandardGame> {

    @Getter
    private final List<Game> games;

    @Getter
    private final List<GameArena> gameArenas;

    @Getter
    private final JavaPlugin pluginInstance;

    public GameManager(JavaPlugin pluginInstance) {
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
        return this.games.stream().filter(game -> game.getGameSettings().getMaxPlayerCount() < game.getPlayers().size() + 1).findFirst().orElse(null);
    }

    public Game findPlayer(String name) {
        return this.findPlayer(Bukkit.getPlayer(name));
    }

    public Game findPlayer(Player player) {
        return this.games.stream().filter(game -> game.getPlayers().contains(player)).findFirst().orElse(null);
    }
}