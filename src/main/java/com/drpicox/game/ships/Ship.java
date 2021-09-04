package com.drpicox.game.ships;

import com.drpicox.game.cities.City;
import com.drpicox.game.games.Game;
import com.drpicox.game.players.Player;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ship {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int population;
    private int loadUnloadAmount;
    @ManyToOne private Player owner;
    @ManyToOne private Game game;
    @ManyToOne private City city;

    public Ship(String name, Player owner, City city, Game game) {
        this.name = name;
        this.owner = owner;
        this.game = game;
        this.city = city;
    }

    protected Ship() {}

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

    public void changeShipName(String newShipName) {
        this.name = newShipName;
    }

    public int getPopulation() {
        return population;
    }

    public City getCity() {
        return this.city;
    }

    public int getLoadUnloadAmount() {
        return this.loadUnloadAmount;
    }

    public void changeLoadUnloadAmount(int newLoadUnloadAmount) {
        this.loadUnloadAmount = newLoadUnloadAmount;
    }

    public int increasePopulation(int loadUnloadAmount) {
        var prevPropulation = this.population;
        this.population = Math.min(20, Math.max(0, population + loadUnloadAmount));
        int unfit = prevPropulation + loadUnloadAmount - this.population;
        return unfit;
    }

    public void clearLoadUnloadAmount() {
        this.loadUnloadAmount = 0;
    }
}
