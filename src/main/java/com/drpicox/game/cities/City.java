package com.drpicox.game.cities;

import com.drpicox.game.games.Game;
import com.drpicox.game.named.Named;
import com.drpicox.game.players.Player;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class City {
    @Id private String id;

    private int population;
    @ManyToOne private Player owner;
    @ManyToOne private Game game;
    @OneToOne private Named named;

    public City(String id, Player owner, Game game, Named named) {
        this.id = id;
        this.owner = owner;
        this.game = game;
        this.named = named;
        this.population = 10;
    }

    protected City() {}

    public String getId() {
        return id;
    }

    public String getName() {
        return named.getName();
    }

    public Player getOwner() {
        return owner;
    }

    public int getPopulation() {
        return population;
    }

    public void endRound() {
        population = Math.min(20, population + 1);
    }

    public void increasePopulation(int population) {
        this.population += population;
    }

    public void replaceNamed(Named named) {
        this.named = named;
    }
}
