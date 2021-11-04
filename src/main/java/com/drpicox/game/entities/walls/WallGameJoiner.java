package com.drpicox.game.entities.walls;

import com.drpicox.game.components.locateds.LocatedsController;
import com.drpicox.game.components.owneds.OwnedsController;
import com.drpicox.game.components.quantity.QuantityController;
import com.drpicox.game.components.typeds.TypedsController;
import com.drpicox.game.games.Game;
import com.drpicox.game.players.Player;
import com.drpicox.game.games.GameJoiner;
import org.springframework.stereotype.Component;

@Component
public class WallGameJoiner implements GameJoiner {

    private final OwnedsController ownedsController;
    private final TypedsController typedsController;
    private final WallFactory wallFactory;
    private final LocatedsController locatedsController;
    private final QuantityController quantityController;

    public WallGameJoiner(QuantityController quantityController, OwnedsController ownedsController, TypedsController typedsController, WallFactory wallFactory, LocatedsController locatedsController) {
        this.ownedsController = ownedsController;
        this.typedsController = typedsController;
        this.wallFactory = wallFactory;
        this.locatedsController = locatedsController;
        this.quantityController = quantityController;
    }

    @Override
    public void joinGame(Player owner, Game game) {
        wallFactory.buildWall(game, owner);
    }

}
