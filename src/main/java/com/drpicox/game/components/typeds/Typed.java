package com.drpicox.game.components.typeds;

import com.drpicox.game.ecs.EcsComponent;

import javax.persistence.Entity;

@Entity
public class Typed extends EcsComponent {
    private String type;

    public Typed(String entityId, String type) {
        super(entityId);
        this.type = type;
    }

    protected Typed() {}

    public String getType() {
        return type;
    }

    public boolean isType(String type) {
        return this.type.equals(type);
    }
}
