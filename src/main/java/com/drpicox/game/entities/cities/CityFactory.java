package com.drpicox.game.entities.cities;

import com.drpicox.game.components.docks.DocksController;
import com.drpicox.game.components.locateds.LocatedsController;
import com.drpicox.game.components.nameds.NamedsController;
import com.drpicox.game.components.owneds.OwnedsController;
import com.drpicox.game.components.resourceds.ResourceType;
import com.drpicox.game.components.resourceds.ResourcedsController;
import com.drpicox.game.components.typeds.TypedsController;
import com.drpicox.game.ecs.EntityIdGenerator;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

@Component
public class CityFactory {

    private final DocksController docksController;
    private final EntityIdGenerator entityIdGenerator;
    private final NamedsController namedsController;
    private final OwnedsController ownedsController;
    private final ResourcedsController resourcedsController;
    private final TypedsController typedsController;
    private final LocatedsController locatedsController;

    public CityFactory(DocksController docksController, EntityIdGenerator entityIdGenerator, NamedsController namedsController, OwnedsController ownedsController, ResourcedsController resourcedsController, TypedsController typedsController, LocatedsController locatedsController) {
        this.docksController = docksController;
        this.entityIdGenerator = entityIdGenerator;
        this.namedsController = namedsController;
        this.ownedsController = ownedsController;
        this.resourcedsController = resourcedsController;
        this.typedsController = typedsController;
        this.locatedsController = locatedsController;
    }

    public String buildCity(Player owner, String initialName, int initialPopulation) {
        var entityId = entityIdGenerator.nextEntityId("ciutat");
        int initialLocation = getInitialLocation();
        docksController.create(entityId);
        namedsController.create(entityId, initialName);
        ownedsController.create(entityId, owner);
        resourcedsController.create(entityId).withMaximums(5).with(ResourceType.POPULATION, 10, 20, 1);
        typedsController.create(entityId, "city");
        locatedsController.create(entityId, initialLocation);
        return entityId;
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
