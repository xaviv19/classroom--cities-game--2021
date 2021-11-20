package com.drpicox.game.entities.ships;

import com.drpicox.game.components.loadables.LoadablesController;
import com.drpicox.game.components.locateds.LocatedsController;
import com.drpicox.game.components.nameds.NamedsController;
import com.drpicox.game.components.owneds.OwnedsController;
import com.drpicox.game.components.populateds.PopulatedsController;
import com.drpicox.game.components.sails.SailsController;
import com.drpicox.game.components.typeds.TypedsController;
import com.drpicox.game.ecs.EntityIdGenerator;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

@Component
public class ShipFactory {

    private final NamedsController namedsController;
    private final OwnedsController ownedsController;
    private final PopulatedsController populatedsController;
    private final TypedsController typedsController;
    private final LoadablesController loadablesController;
    private final EntityIdGenerator entityIdGenerator;
    private final LocatedsController locatedsController;
    private final SailsController sailsController;

    public ShipFactory(NamedsController namedsController, OwnedsController ownedsController, PopulatedsController populatedsController, TypedsController typedsController, LoadablesController loadablesController, EntityIdGenerator entityIdGenerator, LocatedsController locatedsController, SailsController sailsController) {
        this.namedsController = namedsController;
        this.ownedsController = ownedsController;
        this.populatedsController = populatedsController;
        this.typedsController = typedsController;
        this.loadablesController = loadablesController;
        this.entityIdGenerator = entityIdGenerator;
        this.locatedsController = locatedsController;
        this.sailsController = sailsController;
    }

    public void buildShip(Player owner, String dockId, String shipName, int initialLocation) {
        var entityId = entityIdGenerator.nextEntityId("vaixell");

        namedsController.create(entityId, shipName);
        ownedsController.create(entityId, owner);
        populatedsController.create(entityId, 0);
        typedsController.create(entityId, "ship");
        loadablesController.create(entityId);
        locatedsController.create(entityId, initialLocation);
        sailsController.create(entityId);
    }

}
