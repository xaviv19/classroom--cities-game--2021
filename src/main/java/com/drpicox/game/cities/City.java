package com.drpicox.game.cities;

import com.drpicox.game.games.Game;
import com.drpicox.game.players.Player;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class City {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    @ManyToOne private Player owner;
    @ManyToOne private Game game;

    public City(String name, Player owner, Game game) {
        this.name = name;
        this.owner = owner;
        this.game = game;
    }

    protected City() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Player getOwner() {
        return owner;
    }

    public Game getGame() {
        return game;
    }

    public void changeCityName(String newCityName) {
        this.name = newCityName;
    }
}
