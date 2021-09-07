package com.drpicox.game.typeds;

import com.drpicox.game.ecs.EcsComponent;
import com.drpicox.game.games.Game;

import javax.persistence.Entity;

@Entity
public class Typed extends EcsComponent {
    private String entityType;

    public Typed(String entityId, Game game, String entityType) {
        super(entityId, game);
        this.entityType = entityType;
    }

    protected Typed() {}

    public String getEntityType() {
        return entityType;
    }

    public void changeName(String newName) {
        this.entityType = newName;
    }

    public boolean isEntityType(String entityType) {
        return this.entityType.equals(entityType);
    }
}
