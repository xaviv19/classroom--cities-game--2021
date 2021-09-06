package com.drpicox.game.typeds.api;

import com.drpicox.game.games.api.ComponentResponse;
import com.drpicox.game.typeds.Typed;

public class TypedResponse extends ComponentResponse {
    private String entityType;

    public TypedResponse(Typed typed) {
        super(typed.getEntityId());
        this.entityType = typed.getEntityType();
    }

    public boolean hasEntityType(String entityType) {
        return this.entityType.equals(entityType);
    }

    public String getEntityType() {
        return entityType;
    }
}
