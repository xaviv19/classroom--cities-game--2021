package com.drpicox.game.cities;

import com.drpicox.game.games.Game;
import com.drpicox.game.nameds.NamedsController;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CityController {

    private final NamedsController namedsController;
    private final CityRepository cityRepository;

    public CityController(NamedsController namedsController, CityRepository cityRepository) {
        this.namedsController = namedsController;
        this.cityRepository = cityRepository;
    }

    public List<City> findAllByGame(Game game) {
        return cityRepository.findAllByGame(game);
    }

    public Optional<City> findById(String id) {
        return cityRepository.findById(id);
    }
}
