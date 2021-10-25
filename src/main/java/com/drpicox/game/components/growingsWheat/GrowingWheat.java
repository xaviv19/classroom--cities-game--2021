package com.drpicox.game.components.growingsWheat;

import com.drpicox.game.ecs.EcsComponent;
import com.drpicox.game.games.Game;

import javax.persistence.Entity;

@Entity
public class GrowingWheat extends EcsComponent {
    public GrowingWheat(String entityId, Game game) {
        super(entityId, game);
    }

    protected GrowingWheat() {}

}
