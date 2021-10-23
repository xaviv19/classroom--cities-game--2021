package com.drpicox.game.components.informeds;

import com.drpicox.game.ecs.EcsComponent;
import com.drpicox.game.games.Game;

import javax.persistence.Entity;

@Entity
public class Informed extends EcsComponent {
    public Informed(String entityId, Game game) {
        super(entityId, game);
    }

    protected Informed() {}
}
