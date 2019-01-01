package com.nivyox.gamemanager;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class GameManager<Game> {

    @Getter
    private final List<Game> games;

    public GameManager() {
        this.games = new ArrayList<>();
    }

    public Game findGame() {
        return null;
    }

    public Game createGame() {
        return null;
    }
}