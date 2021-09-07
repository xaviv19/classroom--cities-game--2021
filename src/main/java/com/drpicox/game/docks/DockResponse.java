package com.drpicox.game.docks;

import com.drpicox.game.ecs.ComponentResponse;
import com.drpicox.game.docks.Dock;

public class DockResponse extends ComponentResponse {
    public DockResponse(Dock dock) {
        super(dock.getEntityId());
    }
}
