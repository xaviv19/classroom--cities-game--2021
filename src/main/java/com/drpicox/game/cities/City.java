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
    @ManyToOne private Game game;

    public City(String id, Game game) {
        this.id = id;
        this.game = game;
    }

    protected City() {}

    public String getId() {
        return id;
    }
}
