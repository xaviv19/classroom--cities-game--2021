package com.drpicox.game.ecs;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.function.Function;

@MappedSuperclass
public class EcsComponent {
    public static Function<EcsComponent, String> toId() {
        return (c) -> c.getEntityId();
    }

    @Id private String entityId;

    public EcsComponent(String entityId) {
        this.entityId = entityId;
    }

    protected EcsComponent() {}

    public String getEntityId() {
        return entityId;
    }
}
