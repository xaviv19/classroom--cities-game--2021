package com.drpicox.game.games;

import com.drpicox.game.players.Player;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Game {
    @Id
    private String id;

    private String gameName;

    @ManyToOne
    private Player player;

    public Game(String id, String gameName, Player player) {
        this.id = id;
        this.gameName = gameName;
        this.player = player;
    }

    protected Game() {}

    public Player getPlayer() {
        return player;
    }

    public String getGameName() {
        return gameName;
    }
}
