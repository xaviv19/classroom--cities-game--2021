package com.drpicox.game.ships;

import com.drpicox.game.cities.CityController;
import com.drpicox.game.dockables.Dockable;
import com.drpicox.game.dockables.DockablesController;
import com.drpicox.game.games.Game;
import com.drpicox.game.games.GameJoiner;
import com.drpicox.game.nameds.NamedsController;
import com.drpicox.game.owneds.OwnedsController;
import com.drpicox.game.players.Player;
import com.drpicox.game.populateds.PopulatedsController;
import com.drpicox.game.typeds.TypedsController;
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
    private final DockablesController dockablesController;

    public ShipGameJoiner(ShipRepository shipRepository, CityController cityController, NamedsController namedsController, OwnedsController ownedsController, PopulatedsController populatedsController, TypedsController typedsController, DockablesController dockablesController) {
        this.shipRepository = shipRepository;
        this.cityController = cityController;
        this.namedsController = namedsController;
        this.ownedsController = ownedsController;
        this.populatedsController = populatedsController;
        this.typedsController = typedsController;
        this.dockablesController = dockablesController;
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

        namedsController.create(entityId, game, "Beagle");
        ownedsController.create(entityId, game, owner);
        populatedsController.create(entityId, game, 0);
        typedsController.create(entityId, game, "ship");
        dockablesController.create(entityId, game, city.getId());

        var ship = new Ship(entityId, game);

        shipRepository.save(ship);
    }

}
