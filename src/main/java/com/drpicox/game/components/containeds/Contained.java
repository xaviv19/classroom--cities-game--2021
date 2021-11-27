package com.drpicox.game.components.containeds;

import com.drpicox.game.ecs.EcsComponent;

import javax.persistence.Entity;

@Entity
public class Contained extends EcsComponent {
    private String containerId;

    public Contained(String entityId, String containerId) {
        super(entityId);
        this.containerId = containerId;
    }

    protected Contained() {}

    public String getContainerId() {
        return containerId;
    }
}
