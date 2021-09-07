package com.drpicox.game.components.docks;

import com.drpicox.game.ecs.ComponentResponse;

public class DockResponse extends ComponentResponse {
    public DockResponse(Dock dock) {
        super(dock.getEntityId());
    }
}
