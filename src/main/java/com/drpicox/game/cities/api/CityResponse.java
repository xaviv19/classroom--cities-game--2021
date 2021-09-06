package com.drpicox.game.cities.api;

import com.drpicox.game.cities.City;
import com.drpicox.game.games.api.EntityResponse;
import com.drpicox.game.populateds.api.PopulatedResponse;
import com.drpicox.game.ships.api.ShipResponse;

import java.util.ArrayList;
import java.util.List;

public class CityResponse extends EntityResponse {
    private List<EntityResponse> entityResponses = new ArrayList<>();

    public CityResponse(City city) {
        super(city.getId());
    }

    public List<EntityResponse> getEntities() {
        return entityResponses;
    }

    public void addEntity(EntityResponse entityResponse) {
        entityResponses.add(entityResponse);
    }
}
