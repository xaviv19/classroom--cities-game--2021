package com.drpicox.game.ships;

import com.drpicox.game.cities.CityController;
import com.drpicox.game.games.Game;
import com.drpicox.game.games.GameJoiner;
import com.drpicox.game.nameds.NamedsController;
import com.drpicox.game.owneds.OwnedsController;
import com.drpicox.game.players.Player;
import com.drpicox.game.populateds.PopulatedsController;
import com.drpicox.game.typed.TypedsController;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ShipGameJoiner implements GameJoiner {

    private final ShipRepository shipRepository;
    private final CityController cityController;
    private final NamedsController namedsController;
    private final OwnedsController ownedsController;
    private final PopulatedsController populatedsController;
    private final TypedsController typedsController;

    public ShipGameJoiner(ShipRepository shipRepository, CityController cityController, NamedsController namedsController, OwnedsController ownedsController, PopulatedsController populatedsController, TypedsController typedsController) {
        this.shipRepository = shipRepository;
        this.cityController = cityController;
        this.namedsController = namedsController;
        this.ownedsController = ownedsController;
        this.populatedsController = populatedsController;
        this.typedsController = typedsController;
    }

    @Override
    public void joinGame(Player owner, Game game) {
        var entityId = UUID.randomUUID().toString();
        var owneds = ownedsController.findAllByGameAndOwner(game, owner);
        var city = owneds.stream()
                .map(o -> o.getEntityId())
                .map(i -> cityController.findById(i).orElse(null))
                .findFirst()
                .get();

        var named = namedsController.create(entityId, game, "Beagle");
        var owned = ownedsController.create(entityId, game, owner);
        var populated = populatedsController.create(entityId, game, 0);
        typedsController.create(entityId, game, "ship");

        var ship = new Ship(entityId, city, game, named, owned, populated);

        shipRepository.save(ship);
    }

}
