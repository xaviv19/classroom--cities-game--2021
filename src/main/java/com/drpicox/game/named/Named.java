package com.drpicox.game.named;

import com.drpicox.game.games.Game;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Named {
    @Id private String entityId;
    @ManyToOne private Game game;

    private String name;

    public Named(String entityId, Game game, String initialName) {
        this.entityId = entityId;
        this.game = game;
        this.name = initialName;
    }

    protected Named() {}

    public String getEntityId() {
        return entityId;
    }

    public Game getGame() {
        return game;
    }

    public String getName() {
        return name;
    }

    public void changeName(String newName) {
        this.name = newName;
    }
}
