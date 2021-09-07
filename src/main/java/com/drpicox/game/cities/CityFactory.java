package com.drpicox.game.cities;

import com.drpicox.game.dockables.DockablesController;
import com.drpicox.game.docks.DocksController;
import com.drpicox.game.ecs.EntityIdGenerator;
import com.drpicox.game.games.Game;
import com.drpicox.game.growsPopulation.GrowsPopulationsController;
import com.drpicox.game.loadable.LoadablesController;
import com.drpicox.game.nameds.NamedsController;
import com.drpicox.game.owneds.OwnedsController;
import com.drpicox.game.players.Player;
import com.drpicox.game.populateds.PopulatedsController;
import com.drpicox.game.typeds.TypedsController;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CityFactory {

    private final EntityIdGenerator entityIdGenerator;
    private final NamedsController namedsController;
    private final OwnedsController ownedsController;
    private final PopulatedsController populatedsController;
    private final GrowsPopulationsController growsPopulationsController;
    private final TypedsController typedsController;
    private final DocksController docksController;

    public CityFactory(EntityIdGenerator entityIdGenerator, NamedsController namedsController, OwnedsController ownedsController, PopulatedsController populatedsController, GrowsPopulationsController growsPopulationsController, TypedsController typedsController, DocksController docksController) {
        this.entityIdGenerator = entityIdGenerator;
        this.namedsController = namedsController;
        this.ownedsController = ownedsController;
        this.populatedsController = populatedsController;
        this.growsPopulationsController = growsPopulationsController;
        this.typedsController = typedsController;
        this.docksController = docksController;
    }

    public void buildCity(Game game, Player owner, String initialName, int initialPopulation) {
        var entityId = entityIdGenerator.nextEntityId();
        namedsController.create(entityId, game, initialName);
        ownedsController.create(entityId, game, owner);
        populatedsController.create(entityId, game, initialPopulation);
        growsPopulationsController.create(entityId, game);
        typedsController.create(entityId, game, "city");
        docksController.create(entityId, game);
    }
}
