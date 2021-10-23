package com.drpicox.game.components.growingsMaterials;

import com.drpicox.game.ecs.EcsComponent;
import com.drpicox.game.games.Game;

import javax.persistence.Entity;

@Entity
public class GrowingWood extends EcsComponent {
    public GrowingWood(String entityId, Game game) {
        super(entityId, game);
    }

    protected GrowingWood() {}
}
