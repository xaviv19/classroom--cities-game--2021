package com.drpicox.game.ships;

import com.drpicox.game.cities.CityController;
import com.drpicox.game.games.Game;
import com.drpicox.game.games.GameJoiner;
import com.drpicox.game.named.NamedController;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ShipGameJoiner implements GameJoiner {

    private final ShipRepository shipRepository;
    private final CityController cityController;
    private final NamedController namedController;

    public ShipGameJoiner(ShipRepository shipRepository, CityController cityController, NamedController namedController) {
        this.shipRepository = shipRepository;
        this.cityController = cityController;
        this.namedController = namedController;
    }

    @Override
    public void joinGame(Player owner, Game game) {
        var id = UUID.randomUUID().toString();
        var named = namedController.createNamed(id, game, "Beagle");
        var city = cityController.findAllByGameAndOwner(game, owner).stream().findFirst().get();

        var ship = new Ship(id, "Beagle", owner, city, game, named);

        shipRepository.save(ship);
    }

}
