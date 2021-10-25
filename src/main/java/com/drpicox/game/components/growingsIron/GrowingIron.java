package com.drpicox.game.components.growingsIron;
import com.drpicox.game.ecs.EcsComponent;
import com.drpicox.game.games.Game;

import javax.persistence.Entity;

@Entity
public class GrowingIron extends EcsComponent {
    public GrowingIron(String entityId, Game game) {
        super(entityId, game);
    }

    protected GrowingIron() {}

}
