package com.drpicox.game.typed.api;

import com.drpicox.game.games.api.ComponentResponse;
import com.drpicox.game.typed.Typed;

public class TypedResponse extends ComponentResponse {
    private String entityType;

    public TypedResponse(Typed typed) {
        super(typed.getEntityId());
        this.entityType = typed.getEntityType();
    }

    public boolean hasEntityType(String entityType) {
        return this.entityType.equals(entityType);
    }
}
