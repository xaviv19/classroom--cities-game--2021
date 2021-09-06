package com.drpicox.game.ships;

import com.drpicox.game.cities.City;
import com.drpicox.game.games.Game;
import com.drpicox.game.nameds.Named;
import com.drpicox.game.owneds.Owned;
import com.drpicox.game.players.Player;
import com.drpicox.game.populateds.Populated;

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
    @OneToOne private Populated populated;

    public Ship(String id, City city, Game game, Named named, Owned owned, Populated populated) {
        this.id = id;
        this.game = game;
        this.city = city;
        this.named = named;
        this.owned = owned;
        this.populated = populated;
    }

    protected Ship() {}

    public String getId() {
        return id;
    }

    public Game getGame() {
        return game;
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

    public void clearLoadUnloadAmount() {
        this.loadUnloadAmount = 0;
    }
}
