package com.drpicox.game.entities.ships;

import com.drpicox.game.games.Game;
import com.drpicox.game.games.GameJoiner;
import com.drpicox.game.components.owneds.OwnedsController;
import com.drpicox.game.players.Player;
import com.drpicox.game.components.typeds.TypedsController;
import org.springframework.stereotype.Component;

@Component
public class ShipGameJoiner implements GameJoiner {

    private final OwnedsController ownedsController;
    private final TypedsController typedsController;
    private final ShipFactory shipFactory;

    public ShipGameJoiner(OwnedsController ownedsController, TypedsController typedsController, ShipFactory shipFactory) {
        this.ownedsController = ownedsController;
        this.typedsController = typedsController;
        this.shipFactory = shipFactory;
    }

    @Override
    public void joinGame(Player owner, Game game) {
        var owneds = ownedsController.findAllByGameAndOwner(game, owner);
        var shipTypeds = owneds.stream()
                .filter(c -> typedsController.isTyped(c.getEntityId(), "city"));
        var dockId = shipTypeds.findFirst().get().getEntityId();

        shipFactory.buildShip(game, owner, dockId, "Beagle");
    }

}
