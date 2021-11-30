package com.drpicox.game.entities.ships;

import com.drpicox.game.components.loadables.LoadablesController;
import com.drpicox.game.components.locateds.LocatedsController;
import com.drpicox.game.components.nameds.NamedsController;
import com.drpicox.game.components.owneds.OwnedsController;
import com.drpicox.game.components.resourceds.ResourceType;
import com.drpicox.game.components.resourceds.ResourcedsController;
import com.drpicox.game.components.sails.SailsController;
import com.drpicox.game.components.typeds.TypedsController;
import com.drpicox.game.ecs.EntityIdGenerator;
import com.drpicox.game.entities.decks.DeckBuilderFactory;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

@Component
public class ShipFactory {

    private final EntityIdGenerator entityIdGenerator;
    private final LoadablesController loadablesController;
    private final LocatedsController locatedsController;
    private final NamedsController namedsController;
    private final OwnedsController ownedsController;
    private final ResourcedsController resourcedsController;
    private final TypedsController typedsController;
    private final SailsController sailsController;
    private final DeckBuilderFactory deckBuilderFactory;

    public ShipFactory(EntityIdGenerator entityIdGenerator, LoadablesController loadablesController, LocatedsController locatedsController, NamedsController namedsController, OwnedsController ownedsController, ResourcedsController resourcedsController, TypedsController typedsController, SailsController sailsController, DeckBuilderFactory deckBuilderFactory) {
        this.entityIdGenerator = entityIdGenerator;
        this.loadablesController = loadablesController;
        this.locatedsController = locatedsController;
        this.namedsController = namedsController;
        this.ownedsController = ownedsController;
        this.resourcedsController = resourcedsController;
        this.typedsController = typedsController;
        this.sailsController = sailsController;
        this.deckBuilderFactory = deckBuilderFactory;
    }

    public void buildShip(Player owner, String dockId, String shipName, int initialLocation) {
        var entityId = entityIdGenerator.nextEntityId("vaixell");

        namedsController.create(entityId, shipName);
        ownedsController.create(entityId, owner);
        resourcedsController.create(entityId).with(ResourceType.POPULATION, 0, 5, 0);
        typedsController.create(entityId, "ship");
        loadablesController.create(entityId);
        locatedsController.create(entityId, initialLocation);
        sailsController.create(entityId);

        deckBuilderFactory.buildBuildingBuilder(entityId);
    }

}
