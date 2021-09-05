package com.drpicox.game.cities;

import com.drpicox.game.games.Game;
import com.drpicox.game.nameds.Named;
import com.drpicox.game.owneds.Owned;
import com.drpicox.game.players.Player;
import com.drpicox.game.populateds.Populated;

import javax.persistence.*;

@Entity
public class City {
    @Id private String id;

    private int population;
    @ManyToOne private Game game;
    @OneToOne private Named named;
    @OneToOne private Owned owned;
    @OneToOne private Populated populated;

    public City(String id, Game game, Named named, Owned owned, Populated populated) {
        this.id = id;
        this.game = game;
        this.named = named;
        this.owned = owned;
        this.populated = populated;
        this.population = 10;
    }

    protected City() {}

    public String getId() {
        return id;
    }

    public int getPopulation() {
        return populated.getPopulation();
    }
}
