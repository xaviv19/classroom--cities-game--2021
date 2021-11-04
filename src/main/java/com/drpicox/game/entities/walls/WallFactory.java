package com.drpicox.game.entities.walls;

import com.drpicox.game.components.owneds.OwnedsController;
import com.drpicox.game.components.quantity.QuantityController;
import com.drpicox.game.components.typeds.TypedsController;
import com.drpicox.game.ecs.EntityIdGenerator;
import com.drpicox.game.games.Game;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

@Component
public class WallFactory {
    private final OwnedsController ownedsController;
    private final TypedsController typedsController;
    private final EntityIdGenerator entityIdGenerator;
    private final QuantityController quantityControler;

    public WallFactory(QuantityController quantityControler, OwnedsController ownedsController, TypedsController typedsController, EntityIdGenerator entityIdGenerator) {
        this.ownedsController = ownedsController;
        this.typedsController = typedsController;
        this.entityIdGenerator = entityIdGenerator;
        this.quantityControler = quantityControler;
    }

    public void buildWall(Game game, Player owner) {
        var entityId = entityIdGenerator.nextEntityId("walls");
        ownedsController.create(entityId, game, owner);
        typedsController.create(entityId, game, "WALL");
        quantityControler.create(entityId, game, 0);
    }
}
