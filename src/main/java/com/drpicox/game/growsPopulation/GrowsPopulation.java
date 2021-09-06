package com.drpicox.game.growsPopulation;

import com.drpicox.game.ecs.EcsComponent;
import com.drpicox.game.games.Game;

import javax.persistence.Entity;

@Entity
public class GrowsPopulation extends EcsComponent {
    public GrowsPopulation(String entityId, Game game) {
        super(entityId, game);
    }

    protected GrowsPopulation() {}
}
