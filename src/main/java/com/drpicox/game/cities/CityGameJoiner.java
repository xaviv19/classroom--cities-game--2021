package com.drpicox.game.cities;

import com.drpicox.game.games.Game;
import com.drpicox.game.games.GameJoiner;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CityGameJoiner implements GameJoiner {

    private final CityRepository cityRepository;

    public CityGameJoiner(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public void joinGame(Player owner, Game game) {
        var city = new City("Capital", owner, game);
        cityRepository.save(city);
    }
}
