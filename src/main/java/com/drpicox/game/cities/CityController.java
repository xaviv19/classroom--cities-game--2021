package com.drpicox.game.cities;

import com.drpicox.game.games.Game;
import com.drpicox.game.named.NamedController;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CityController {

    private final NamedController namedController;
    private final CityRepository cityRepository;

    public CityController(NamedController namedController, CityRepository cityRepository) {
        this.namedController = namedController;
        this.cityRepository = cityRepository;
    }

    public List<City> findAllByGame(Game game) {
        return cityRepository.findAllByGame(game);
    }

    public List<City> findAllByGameAndOwner(Game game, Player owner) {
        return cityRepository.findAllByGameAndOwner(game, owner);
    }

    public void increasePopulation(City city, int population) {
        city.increasePopulation(population);
        cityRepository.save(city);
    }
}
