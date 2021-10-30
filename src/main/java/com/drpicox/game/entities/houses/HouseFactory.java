package com.drpicox.game.entities.houses;

import com.drpicox.game.components.growingsPopulation.GrowingsPopulationsController;
import com.drpicox.game.components.owneds.OwnedsController;
import com.drpicox.game.components.quantity.QuantityController;
import com.drpicox.game.components.typeds.TypedsController;
import com.drpicox.game.ecs.EntityIdGenerator;
import com.drpicox.game.games.Game;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

@Component
public class HouseFactory {

    private final OwnedsController ownedsController;
    private final TypedsController typedsController;
    private final GrowingsPopulationsController growingsPopulationsController;
    private final EntityIdGenerator entityIdGenerator;
    private final QuantityController quantityControler;

    public HouseFactory(QuantityController quantityControler, OwnedsController ownedsController, GrowingsPopulationsController growingsPopulationsController, TypedsController typedsController, EntityIdGenerator entityIdGenerator) {
        this.ownedsController = ownedsController;
        this.growingsPopulationsController = growingsPopulationsController;
        this.typedsController = typedsController;
        this.entityIdGenerator = entityIdGenerator;
        this.quantityControler = quantityControler;
    }

    public void buildHouse(Game game, Player owner) {
        var entityId = entityIdGenerator.nextEntityId("casa");
        ownedsController.create(entityId, game, owner);
        typedsController.create(entityId, game, "HOUSE");
        quantityControler.create(entityId, game, 0);
        growingsPopulationsController.create(entityId, game);
    }

}
