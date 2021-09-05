package com.drpicox.game.cities;

import com.drpicox.game.games.Game;
import com.drpicox.game.games.GameJoiner;
import com.drpicox.game.named.NamedController;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class CityGameJoiner implements GameJoiner {

    private final NamedController namedController;
    private final CityRepository cityRepository;

    public CityGameJoiner(NamedController namedController, CityRepository cityRepository) {
        this.namedController = namedController;
        this.cityRepository = cityRepository;
    }

    @Override
    public void joinGame(Player owner, Game game) {
        var entityId = UUID.randomUUID().toString();
        var named = namedController.createNamed(entityId, game, "Capital");
        var city = new City(entityId, owner, game, named);
        cityRepository.save(city);
    }
}
