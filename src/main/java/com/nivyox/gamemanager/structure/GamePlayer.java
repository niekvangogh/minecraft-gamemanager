package com.nivyox.gamemanager.structure;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class GamePlayer {

    @Getter
    private final Player player;

    public GamePlayer(Player player) {
        this.player = player;
    }

    public GamePlayer(UUID uuid) {
        this(Bukkit.getPlayer(uuid));
    }

    public GamePlayer(String username) {
        this(Bukkit.getPlayer(username));
    }
}