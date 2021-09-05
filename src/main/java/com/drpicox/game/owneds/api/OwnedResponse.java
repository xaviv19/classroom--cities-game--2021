package com.drpicox.game.owneds.api;

import com.drpicox.game.games.api.ComponentResponse;
import com.drpicox.game.owneds.Owned;

public class OwnedResponse extends ComponentResponse {
    private String ownerName;

    public OwnedResponse(Owned owned) {
        super(owned.getEntityId());
        this.ownerName = owned.getOwner().getPlayerName();
    }

    public String getOwnerName() {
        return ownerName;
    }

    public boolean hasOwner(String ownerName) {
        return this.ownerName.equals(ownerName);
    }
}
