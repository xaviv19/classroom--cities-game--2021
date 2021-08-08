package com.drpicox.game.old.games;

import com.drpicox.game.old.scenarios.Scenario;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Game {

    @Id
    private String name;

    private int round;

    private String message;

    @ManyToOne
    private Scenario scenario;

    public Game(String gameName, Scenario scenario) {
        this.name = gameName;
        this.scenario = scenario;
        this.round = 1;
    }

    public String getMessage() {
        return message;
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

    public Scenario getScenario() {
        return scenario;
    }

    public void sendMessageToAllPlayers(String message) {
        this.message = message;
    }
}
