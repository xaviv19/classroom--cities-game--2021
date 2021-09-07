package com.drpicox.game.entities.cities;

import com.drpicox.game.components.docks.DocksController;
import com.drpicox.game.ecs.EntityIdGenerator;
import com.drpicox.game.games.Game;
import com.drpicox.game.components.growsPopulation.GrowsPopulationsController;
import com.drpicox.game.components.nameds.NamedsController;
import com.drpicox.game.components.owneds.OwnedsController;
import com.drpicox.game.players.Player;
import com.drpicox.game.components.populateds.PopulatedsController;
import com.drpicox.game.components.typeds.TypedsController;
import org.springframework.stereotype.Component;

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
