package com.drpicox.game.ships;

import com.drpicox.game.cities.CityController;
import com.drpicox.game.games.Game;
import com.drpicox.game.games.GameJoiner;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ShipGameJoiner implements GameJoiner {

    private final ShipRepository shipRepository;
    private final CityController cityController;

    public ShipGameJoiner(ShipRepository shipRepository, CityController cityController) {
        this.shipRepository = shipRepository;
        this.cityController = cityController;
    }

    @Override
    public void joinGame(Player owner, Game game) {
        var city = cityController.findAllByGameAndOwner(game, owner).stream().findFirst().get();

        var ship = new Ship("Beagle", owner, city, game);

        shipRepository.save(ship);
    }

}
