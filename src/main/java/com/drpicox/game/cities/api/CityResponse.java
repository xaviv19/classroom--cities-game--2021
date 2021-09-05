package com.drpicox.game.cities.api;

import com.drpicox.game.cities.City;
import com.drpicox.game.games.api.EntityResponse;
import com.drpicox.game.ships.api.ShipResponse;

import java.util.ArrayList;
import java.util.List;

public class CityResponse extends EntityResponse {
    private int population;
    private List<EntityResponse> entityResponses = new ArrayList<>();

    public CityResponse(City city) {
        super(city.getId());
        this.population = city.getPopulation();
    }

    public  int getPopulation() {
        return this.population;
    }

    public List<EntityResponse> getEntities() {
        return entityResponses;
    }

    public void addEntity(EntityResponse entityResponse) {
        entityResponses.add(entityResponse);
    }
}
