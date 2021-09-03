package com.drpicox.game.cities;

import com.drpicox.game.games.Game;
import com.drpicox.game.games.GameJoiner;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CityController implements GameJoiner {

    private final CityRepository cityRepository;

    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public void joinGame(Player owner, Game game) {
        var city = new City("Capital", owner, game);
        cityRepository.save(city);
    }

    public List<City> findAllByGame(Game game) {
        return cityRepository.findAllByGame(game);
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
}
