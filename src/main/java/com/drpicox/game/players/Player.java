package com.drpicox.game.players;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Player {
    @Id private String playerName;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    protected Player() {}

    public String getPlayerName() {
        return playerName;
    }
}
