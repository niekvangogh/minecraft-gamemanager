package com.nivyox.gamemanager.structure;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public abstract class Game {

    @Getter
    private GameSettings gameSettings;

    @Getter
    private List<GamePlayer> gamePlayers;

    @Getter
    private GameArena gameArena;

    public Game() {
        this(new GameSettings(), null);
    }


    public Game(GameArena gameArena) {
        this(new GameSettings(), gameArena);
    }

    public Game(GameSettings customSettings, GameArena arena) {
        this.gameSettings = customSettings;
        this.gamePlayers = new ArrayList<>();
        this.gameArena = arena;
    }
}