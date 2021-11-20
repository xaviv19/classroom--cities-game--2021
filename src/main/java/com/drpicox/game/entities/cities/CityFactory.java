package com.drpicox.game.entities.cities;

import com.drpicox.game.components.docks.DocksController;
import com.drpicox.game.components.locateds.LocatedsController;
import com.drpicox.game.components.nameds.NamedsController;
import com.drpicox.game.components.owneds.OwnedsController;
import com.drpicox.game.components.populateds.PopulatedsController;
import com.drpicox.game.components.populatedsGrow.PopulatedGrowsController;
import com.drpicox.game.components.typeds.TypedsController;
import com.drpicox.game.ecs.EntityIdGenerator;
import com.drpicox.game.entities.ships.ShipFactory;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

@Component
public class CityFactory {

    private final DocksController docksController;
    private final EntityIdGenerator entityIdGenerator;
    private final NamedsController namedsController;
    private final OwnedsController ownedsController;
    private final PopulatedsController populatedsController;
    private final PopulatedGrowsController populatedGrowsController;
    private final TypedsController typedsController;
    private final LocatedsController locatedsController;
    private final ShipFactory shipFactory;

    public CityFactory(DocksController docksController, EntityIdGenerator entityIdGenerator, NamedsController namedsController, OwnedsController ownedsController, PopulatedsController populatedsController, PopulatedGrowsController populatedGrowsController, TypedsController typedsController, LocatedsController locatedsController, ShipFactory shipFactory) {
        this.docksController = docksController;
        this.entityIdGenerator = entityIdGenerator;
        this.namedsController = namedsController;
        this.ownedsController = ownedsController;
        this.populatedsController = populatedsController;
        this.populatedGrowsController = populatedGrowsController;
        this.typedsController = typedsController;
        this.locatedsController = locatedsController;
        this.shipFactory = shipFactory;
    }

    public void buildCity(Player owner, String initialName, int initialPopulation) {
        var entityId = entityIdGenerator.nextEntityId("ciutat");
        int initialLocation = getInitialLocation();
        docksController.create(entityId);
        namedsController.create(entityId, initialName);
        ownedsController.create(entityId, owner);
        populatedsController.create(entityId, initialPopulation);
        populatedGrowsController.create(entityId);
        typedsController.create(entityId, "city");
        locatedsController.create(entityId, initialLocation);

        shipFactory.buildShip(owner, entityId, "Beagle", initialLocation);
    }

    private int getInitialLocation() {
        var location = 0;
        var isBusy = checkIfLocationHasACity(location);
        while (isBusy) {
            location += 5;
            isBusy = checkIfLocationHasACity(location);
        }

        return location;
    }

    private boolean checkIfLocationHasACity(int location) {
        return locatedsController.findByLocation(location).stream()
                .anyMatch(c -> typedsController.isTyped(c.getEntityId(), "city"));
    }
}
