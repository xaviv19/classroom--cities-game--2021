package com.drpicox.game.entities.cities;

import com.drpicox.game.games.GameJoiner;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

@Component
public class CityGameJoiner implements GameJoiner {

    private final CityFactory cityFactory;

    public CityGameJoiner(CityFactory cityFactory) {
        this.cityFactory = cityFactory;
    }

    @Override
    public void joinGame(Player owner) {
        var initialName = "Capital";
        int initialPopulation = 10;
        cityFactory.buildCity(owner, initialName, initialPopulation);
    }
}
