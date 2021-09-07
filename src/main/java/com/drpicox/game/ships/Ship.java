package com.drpicox.game.ships;

import com.drpicox.game.cities.City;
import com.drpicox.game.games.Game;

import javax.persistence.*;

@Entity
public class Ship {
    @Id private String id;
    @ManyToOne private Game game;

    public Ship(String id, Game game) {
        this.id = id;
        this.game = game;
    }

    protected Ship() {}

    public String getId() {
        return id;
    }

    public Game getGame() {
        return game;
    }
}
