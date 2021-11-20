package com.drpicox.game.games;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Game {
    @Id
    private String id;
    private int roundNumber = 1;

    public Game(String id) {
        this.id = id;
        this.roundNumber = 1;
    }

    protected Game() {}

    public void endRound() {
        this.roundNumber += 1;
    }

    public int getRoundNumber() {
        return this.roundNumber;
    }
}
