package com.drpicox.game.components.loadables;

import com.drpicox.game.ecs.EcsComponent;

import javax.persistence.Entity;

@Entity
public class Loadable extends EcsComponent {
    public Loadable(String entityId) {
        super(entityId);
    }

    protected Loadable() {
    }
}


