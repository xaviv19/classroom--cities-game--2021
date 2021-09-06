package com.drpicox.game.owneds.api;

import com.drpicox.game.games.api.ComponentResponse;
import com.drpicox.game.games.api.EntityResponse;
import com.drpicox.game.owneds.Owned;

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
