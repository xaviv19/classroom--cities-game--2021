package com.drpicox.game.loadable.api;

import com.drpicox.game.games.api.ComponentResponse;
import com.drpicox.game.loadable.Loadable;

public class LoadableResponse extends ComponentResponse {
    private int loadUnloadAmount;
    private boolean loadRequested;
    private boolean unloadRequested;

    public LoadableResponse(Loadable loadable) {
        super(loadable.getEntityId());
        var loadUnloadAmount = loadable.getLoadUnloadAmount();
        this.loadUnloadAmount = Math.abs(loadUnloadAmount);
        this.loadRequested = loadUnloadAmount > 0;
        this.unloadRequested = loadUnloadAmount < 0;
    }

    public int getLoadUnloadAmount() {
        return loadUnloadAmount;
    }

    public boolean isLoadRequested() {
        return loadRequested;
    }

    public boolean isUnloadRequested() {
        return unloadRequested;
    }
}
