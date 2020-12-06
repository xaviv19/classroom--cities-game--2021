package com.drpicox.game.games;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Game {

    @Id
    private String name;
    private String scenarioName;

    private int round;

    public Game(String gameName, String scenarioName) {
        this.name = gameName;
        this.scenarioName = scenarioName;
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

    public String getScenarioName() {
        return scenarioName;
    }
}
