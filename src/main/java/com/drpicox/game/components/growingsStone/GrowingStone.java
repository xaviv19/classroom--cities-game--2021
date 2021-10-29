package com.drpicox.game.components.growingsStone;

import com.drpicox.game.ecs.EcsComponent;
import com.drpicox.game.games.Game;

import javax.persistence.Entity;

@Entity
public class GrowingStone extends EcsComponent {
    public GrowingStone(String entityId, Game game) {
        super(entityId, game);
    }

    protected GrowingStone() {}

}
