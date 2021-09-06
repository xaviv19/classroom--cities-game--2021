package com.drpicox.game.docks.api;

import com.drpicox.game.games.api.ComponentResponse;
import com.drpicox.game.docks.Dock;

public class DockResponse extends ComponentResponse {
    public DockResponse(Dock dock) {
        super(dock.getEntityId());
    }
}
