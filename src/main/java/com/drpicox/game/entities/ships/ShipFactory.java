package com.drpicox.game.entities.ships;

import com.drpicox.game.components.dockables.DockablesController;
import com.drpicox.game.ecs.EntityIdGenerator;
import com.drpicox.game.games.Game;
import com.drpicox.game.components.loadables.LoadablesController;
import com.drpicox.game.components.nameds.NamedsController;
import com.drpicox.game.components.owneds.OwnedsController;
import com.drpicox.game.players.Player;
import com.drpicox.game.components.populateds.PopulatedsController;
import com.drpicox.game.components.typeds.TypedsController;
import org.springframework.stereotype.Component;

@Component
public class ShipFactory {

    private final NamedsController namedsController;
    private final OwnedsController ownedsController;
    private final PopulatedsController populatedsController;
    private final TypedsController typedsController;
    private final DockablesController dockablesController;
    private final LoadablesController loadablesController;
    private final EntityIdGenerator entityIdGenerator;

    public ShipFactory(NamedsController namedsController, OwnedsController ownedsController, PopulatedsController populatedsController, TypedsController typedsController, DockablesController dockablesController, LoadablesController loadablesController, EntityIdGenerator entityIdGenerator) {
        this.namedsController = namedsController;
        this.ownedsController = ownedsController;
        this.populatedsController = populatedsController;
        this.typedsController = typedsController;
        this.dockablesController = dockablesController;
        this.loadablesController = loadablesController;
        this.entityIdGenerator = entityIdGenerator;
    }

    public void buildShip(Game game, Player owner, String dockId, String shipName) {
        var entityId = entityIdGenerator.nextEntityId();
        namedsController.create(entityId, game, shipName);
        ownedsController.create(entityId, game, owner);
        populatedsController.create(entityId, game, 0);
        typedsController.create(entityId, game, "ship");
        dockablesController.create(entityId, game, dockId);
        loadablesController.create(entityId, game);
    }

}
