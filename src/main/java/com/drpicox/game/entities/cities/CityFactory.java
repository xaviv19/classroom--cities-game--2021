package com.drpicox.game.entities.cities;

import com.drpicox.game.components.docks.DocksController;
import com.drpicox.game.components.growingsPopulation.GrowingsPopulationsController;
import com.drpicox.game.components.informeds.InformedsController;
import com.drpicox.game.components.locateds.LocatedsController;
import com.drpicox.game.components.nameds.NamedsController;
import com.drpicox.game.components.owneds.OwnedsController;
import com.drpicox.game.components.populateds.PopulatedsController;
import com.drpicox.game.components.typeds.TypedsController;
import com.drpicox.game.components.withBuildings.WithBuildingsController;
import com.drpicox.game.ecs.EntityIdGenerator;
import com.drpicox.game.games.Game;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

@Component
public class CityFactory {

    private final DocksController docksController;
    private final EntityIdGenerator entityIdGenerator;
    private final NamedsController namedsController;
    private final OwnedsController ownedsController;
    private final PopulatedsController populatedsController;
    private final GrowingsPopulationsController growingsPopulationsController;
    private final TypedsController typedsController;
    private final LocatedsController locatedsController;
    private final WithBuildingsController withBuildingsController;
    private final InformedsController informedsController;

    public CityFactory(DocksController docksController, EntityIdGenerator entityIdGenerator, NamedsController namedsController, OwnedsController ownedsController, PopulatedsController populatedsController, GrowingsPopulationsController growingsPopulationsController, TypedsController typedsController, LocatedsController locatedsController, WithBuildingsController withBuildingsController, InformedsController informedsController) {
        this.docksController = docksController;
        this.entityIdGenerator = entityIdGenerator;
        this.namedsController = namedsController;
        this.ownedsController = ownedsController;
        this.populatedsController = populatedsController;
        this.growingsPopulationsController = growingsPopulationsController;
        this.typedsController = typedsController;
        this.locatedsController = locatedsController;
        this.withBuildingsController = withBuildingsController;
        this.informedsController = informedsController;
    }

    public void buildCity(Game game, Player owner, String initialName, int initialPopulation) {
        var entityId = entityIdGenerator.nextEntityId("ciutat");
        int initialLocation = getInitialLocation(game);
        docksController.create(entityId, game);
        namedsController.create(entityId, game, initialName);
        ownedsController.create(entityId, game, owner);
        populatedsController.create(entityId, game, initialPopulation);
        growingsPopulationsController.create(entityId, game);
        typedsController.create(entityId, game, "city");
        locatedsController.create(entityId, game, initialLocation);
        withBuildingsController.create(entityId, game);
        informedsController.create(entityId, game);
    }

    private int getInitialLocation(Game game) {
        var location = 0;
        var isBusy = checkIfLocationHasACity(game, location);
        while (isBusy) {
            location += 5;
            isBusy = checkIfLocationHasACity(game, location);
        }

        return location;
    }

    private boolean checkIfLocationHasACity(Game game, int location) {
        return locatedsController.findByGameAndLocation(game, location).stream()
                .anyMatch(c -> typedsController.isTyped(c.getEntityId(), "city"));
    }
}
