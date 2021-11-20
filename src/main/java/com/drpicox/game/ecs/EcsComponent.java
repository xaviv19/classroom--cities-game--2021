package com.drpicox.game.ecs;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class EcsComponent {
    @Id private String entityId;

    public EcsComponent(String entityId) {
        this.entityId = entityId;
    }

    protected EcsComponent() {}

    public String getEntityId() {
        return entityId;
    }
}
