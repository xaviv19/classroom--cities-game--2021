package com.drpicox.game.games;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Game {

    @Id
    private String name;

    private int round;

    public Game(String gameName) {
        this.name = gameName;
        this.round = 1;
    }

    // JPA required
    protected Game() {}

    public String getName() {
        return name;
    }

    public int getRound() {
        return round;
    }

    public void increaseRoundNumber() {
        round++;
    }
}
