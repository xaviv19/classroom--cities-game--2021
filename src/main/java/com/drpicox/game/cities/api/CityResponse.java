package com.drpicox.game.cities.api;

import com.drpicox.game.cities.City;
import com.drpicox.game.games.api.EntityResponse;
import com.drpicox.game.ships.api.ShipResponse;

import java.util.ArrayList;
import java.util.List;

public class CityResponse extends EntityResponse {
    private String name;
    private String ownerName;
    private int population;
    private List<EntityResponse> entityResponses = new ArrayList<>();

    public CityResponse(City city) {
        super(city.getId());
        this.name = city.getName();
        this.ownerName = city.getOwner().getPlayerName();
        this.population = city.getPopulation();
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
