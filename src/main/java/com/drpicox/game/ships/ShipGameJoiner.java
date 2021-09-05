package com.drpicox.game.ships;

import com.drpicox.game.cities.CityController;
import com.drpicox.game.games.Game;
import com.drpicox.game.games.GameJoiner;
import com.drpicox.game.nameds.NamedsController;
import com.drpicox.game.owneds.OwnedsController;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ShipGameJoiner implements GameJoiner {

    private final ShipRepository shipRepository;
    private final CityController cityController;
    private final NamedsController namedsController;
    private final OwnedsController ownedsController;

    public ShipGameJoiner(ShipRepository shipRepository, CityController cityController, NamedsController namedsController, OwnedsController ownedsController) {
        this.shipRepository = shipRepository;
        this.cityController = cityController;
        this.namedsController = namedsController;
        this.ownedsController = ownedsController;
    }

    @Override
    public void joinGame(Player owner, Game game) {
        var id = UUID.randomUUID().toString();
        var owneds = ownedsController.findAllByGameAndOwner(game, owner);
        var city = owneds.stream()
                .map(o -> o.getEntityId())
                .map(i -> cityController.findById(i).orElse(null))
                .findFirst()
                .get();

        var named = namedsController.createNamed(id, game, "Beagle");
        var owned = ownedsController.createOwned(id, game, owner);

        var ship = new Ship(id, city, game, named, owned);

        shipRepository.save(ship);
    }

}
