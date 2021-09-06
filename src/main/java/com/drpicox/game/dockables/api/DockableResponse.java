package com.drpicox.game.dockables.api;

import com.drpicox.game.games.api.ComponentResponse;
import com.drpicox.game.dockables.Dockable;
import com.drpicox.game.games.api.EntityResponse;

import java.util.function.Predicate;

public class DockableResponse extends ComponentResponse {
    private String dockId;

    public DockableResponse(Dockable dockable) {
        super(dockable.getEntityId());
        this.dockId = dockable.getDockId();
    }

    public static Predicate<EntityResponse> byDockId(String dockId) {
        return e -> e.getComponent(DockableResponse.class).map(c -> c.getDockId().equals(dockId)).orElse(false);
    }

    public boolean hasEntityType(String entityType) {
        return this.dockId.equals(entityType);
    }

    public String getDockId() {
        return dockId;
    }
}
