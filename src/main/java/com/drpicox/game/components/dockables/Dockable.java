package com.drpicox.game.components.dockables;

import com.drpicox.game.ecs.EcsComponent;
import com.drpicox.game.games.Game;

import javax.persistence.Entity;

@Entity
public class Dockable extends EcsComponent {
    private String dockId;

    public Dockable(String entityId, Game game, String entityType) {
        super(entityId, game);
        this.dockId = entityType;
    }

    protected Dockable() {}

    public String getDockId() {
        return dockId;
    }
}
