package com.drpicox.game.ships;

import com.drpicox.game.cities.City;
import com.drpicox.game.games.Game;
import com.drpicox.game.nameds.Named;
import com.drpicox.game.owneds.Owned;
import com.drpicox.game.players.Player;

import javax.persistence.*;

@Entity
public class Ship {
    @Id private String id;

    private int population;
    private int loadUnloadAmount;
    @ManyToOne private Game game;
    @ManyToOne private City city;
    @OneToOne private Named named;
    @OneToOne private Owned owned;

    public Ship(String id, City city, Game game, Named named, Owned owned) {
        this.id = id;
        this.game = game;
        this.city = city;
        this.named = named;
        this.owned = owned;
    }

    protected Ship() {}

    public String getId() {
        return id;
    }

    public Game getGame() {
        return game;
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
