package com.drpicox.game.ships.api;

import com.drpicox.game.populateds.api.PopulatedResponse;
import com.drpicox.game.ships.Ship;
import com.drpicox.game.games.api.EntityResponse;
import com.drpicox.game.ships.api.ShipResponse;

import java.util.List;

public class ShipResponse extends EntityResponse {
    private String cityId;
    private int loadUnloadAmount;
    private boolean loadRequested;
    private boolean unloadRequested;

    public ShipResponse(Ship ship) {
        super(ship.getId());
        cityId = ship.getCity().getId();
        var loadUnloadAmount = ship.getLoadUnloadAmount();
        this.loadUnloadAmount = Math.abs(loadUnloadAmount);
        this.loadRequested = loadUnloadAmount > 0;
        this.unloadRequested = loadUnloadAmount < 0;
    }

    public String getCityId() {
        return cityId;
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