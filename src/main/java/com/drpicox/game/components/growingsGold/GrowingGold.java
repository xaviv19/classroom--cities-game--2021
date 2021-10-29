package com.drpicox.game.components.growingsGold;

import com.drpicox.game.ecs.EcsComponent;
import com.drpicox.game.games.Game;

import javax.persistence.Entity;

@Entity
public class GrowingGold extends EcsComponent {
    public GrowingGold(String entityId, Game game) {
        super(entityId, game);
    }

    protected GrowingGold() {}

}
