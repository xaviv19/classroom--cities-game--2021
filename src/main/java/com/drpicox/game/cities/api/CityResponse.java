package com.drpicox.game.cities.api;

import com.drpicox.game.cities.City;
import com.drpicox.game.games.api.EntityResponse;

public class CityResponse extends EntityResponse {
    private String name;
    private String ownerName;

    public CityResponse(City city) {
        super(city.getId());
        this.name = city.getName();
        this.ownerName = city.getOwner().getPlayerName();
    }

    public boolean hasOwner(String playerName) {
        return this.ownerName.equals(playerName);
    }

    public String getName() {
        return this.name;
    }

    public boolean hasName(String cityName) {
        return this.name.equals(cityName);
    }
}
