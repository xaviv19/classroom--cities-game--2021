package com.drpicox.game.components.docks;

import com.drpicox.game.ecs.EcsComponent;

import javax.persistence.Entity;

@Entity
public class Dock extends EcsComponent {
    public Dock(String entityId) {
        super(entityId);
    }

    protected Dock() {}
}
