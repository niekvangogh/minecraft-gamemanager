package com.nivyox.gamemanager.structure;

import com.nivyox.gamemanager.structure.arenas.GameArena;
import com.nivyox.gamemanager.structure.events.*;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public abstract class StandardGame {

    @Getter
    private GameSettings gameSettings;

    @Getter
    private List<Player> players;

    @Getter
    private GameArena gameArena;

    @Getter
    private GameState gameState;

    @Getter
    private GameTimer gameTimer;

    public StandardGame() {
        this(new GameSettings(), null);
    }

    public StandardGame(GameArena gameArena) {
        this(new GameSettings(), gameArena);
    }

    public StandardGame(GameSettings customSettings, GameArena arena) {
        this.players = new ArrayList<>();
        this.gameTimer = new GameTimer(this);
        this.gameSettings = customSettings;
        this.gameArena = arena;
        this.gameState = GameState.INACTIVE;
    }

    public boolean addPlayer(Player player) {
        GamePlayerAddEvent event = new GamePlayerAddEvent(this, player);
        Bukkit.getPluginManager().callEvent(event);
        if (event.isCancelled()) {
            return false;
        }
        this.players.add(player);
        return true;
    }

    public void removePlayer(Player player) {
        GamePlayerRemovedEvent event = new GamePlayerRemovedEvent(this, player);
        Bukkit.getPluginManager().callEvent(event);
        this.players.remove(player);
    }

    public void setGameState(GameState newGameState) {
        GameStateChangeEvent event = new GameStateChangeEvent(this, this.gameState, newGameState);
        Bukkit.getPluginManager().callEvent(event);
    }
}