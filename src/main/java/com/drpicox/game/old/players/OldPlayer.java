package com.drpicox.game.old.players;

import com.drpicox.game.old.games.Game;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class OldPlayer {

    @Id
    private String id;

    private String name;

    private int readyRound;
    
    private int totalReceivedFoodCounter;

    @ManyToOne
    private Game game;

    public OldPlayer(Game game, String name) {
        this.id = game.getName() + '#' + name;
        this.game = game;
        this.name = name;
    }

    // JPA required
    protected OldPlayer() {}

    public Game getGame() {
        return game;
    }

    public String getName() {
        return name;
    }

    public void readyRound(int round) {
        this.readyRound = round;
    }

    public boolean hasReadyRound(int round) {
        return this.readyRound == round;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OldPlayer oldPlayer = (OldPlayer) o;
        return Objects.equals(name, oldPlayer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }

    public int getTotalReceivedFoodCount() {
        return totalReceivedFoodCounter;
    }

    public void receivedCard(int square, String type, String name) {
        if (type.equals("food"))
            totalReceivedFoodCounter += 1;
    }
}
