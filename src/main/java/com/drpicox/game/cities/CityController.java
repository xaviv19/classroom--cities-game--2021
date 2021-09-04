package com.drpicox.game.cities;

import com.drpicox.game.games.Game;
import com.drpicox.game.games.GameJoiner;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CityController {

    private final CityRepository cityRepository;

    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> findAllByGame(Game game) {
        return cityRepository.findAllByGame(game);
    }

    public List<City> findAllByGameAndOwner(Game game, Player owner) {
        return cityRepository.findAllByGameAndOwner(game, owner);
    }

    public Optional<City> findById(Long cityId) {
        return cityRepository.findById(cityId);
    }

    public void changeCityName(Long cityId, String newCityName) {
        findById(cityId).ifPresent(city -> {
            city.changeCityName(newCityName);
            cityRepository.save(city);
        });
    }

    public void increasePopulation(City city, int population) {
        city.increasePopulation(population);
        cityRepository.save(city);
    }
}
