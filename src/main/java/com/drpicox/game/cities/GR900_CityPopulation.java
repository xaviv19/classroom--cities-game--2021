package com.drpicox.game.cities;

import com.drpicox.game.games.Game;
import com.drpicox.game.games.GameRounder;
import com.drpicox.game.populateds.PopulatedsController;
import org.springframework.stereotype.Component;

@Component
public class GR900_CityPopulation implements GameRounder {

    private final PopulatedsController populatedsController;
    private final CityController cityController;

    public GR900_CityPopulation(PopulatedsController populatedsController, CityController cityController) {
        this.populatedsController = populatedsController;
        this.cityController = cityController;
    }

    @Override
    public void endRound(Game game) {
        var cities = cityController.findAllByGame(game);
        cities.forEach(city -> {
            populatedsController.increasePopulation(city.getId(), 1);
        });
    }
}
