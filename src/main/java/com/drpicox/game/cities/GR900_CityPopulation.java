package com.drpicox.game.cities;

import com.drpicox.game.cities.CityController;
import com.drpicox.game.cities.CityRepository;
import com.drpicox.game.games.Game;
import com.drpicox.game.games.GameRounder;
import org.springframework.stereotype.Component;

@Component
public class GR900_CityPopulation implements GameRounder {

    private final CityController cityController;
    private final CityRepository cityRepository;

    public GR900_CityPopulation(CityController cityController, CityRepository cityRepository) {
        this.cityController = cityController;
        this.cityRepository = cityRepository;
    }

    @Override
    public void endRound(Game game) {
        var cities = cityController.findAllByGame(game);
        cities.forEach(city -> {
            city.endRound();
            cityRepository.save(city);
        });

    }
}
