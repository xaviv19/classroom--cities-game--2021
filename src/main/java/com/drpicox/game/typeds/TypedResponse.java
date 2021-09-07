package com.drpicox.game.typeds;

import com.drpicox.game.ecs.ComponentResponse;
import com.drpicox.game.ecs.EntityResponse;

import java.util.function.Predicate;

public class TypedResponse extends ComponentResponse {
    private String entityType;

    public TypedResponse(Typed typed) {
        super(typed.getEntityId());
        this.entityType = typed.getEntityType();
    }

    public static Predicate<EntityResponse> byEntityType(String entityType) {
        return e -> e.getComponent(TypedResponse.class).map(c -> c.hasEntityType(entityType)).orElse(false);
    }

    public boolean hasEntityType(String entityType) {
        return this.entityType.equals(entityType);
    }

    public String getEntityType() {
        return entityType;
    }
}
