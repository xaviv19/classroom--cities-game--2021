package com.drpicox.game.components.owneds;

import com.drpicox.game.ecs.ComponentResponse;
import com.drpicox.game.ecs.EntityResponse;

import java.util.function.Predicate;

public class OwnedResponse extends ComponentResponse {
    private String ownerName;

    public OwnedResponse(Owned owned) {
        super(owned.getEntityId());
        this.ownerName = owned.getOwner().getPlayerName();
    }

    public static Predicate<EntityResponse> byOwner(String ownerName) {
        return e -> e.getComponent(OwnedResponse.class).map(c -> c.hasOwner(ownerName)).orElse(false);
    }

    public String getOwnerName() {
        return ownerName;
    }

    public boolean hasOwner(String ownerName) {
        return this.ownerName.equals(ownerName);
    }
}
