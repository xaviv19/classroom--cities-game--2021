package com.drpicox.game.entities.houses;

import com.drpicox.game.components.locateds.LocatedsController;
import com.drpicox.game.components.owneds.OwnedsController;
import com.drpicox.game.components.quantity.QuantityController;
import com.drpicox.game.components.typeds.TypedsController;
import com.drpicox.game.games.Game;
import com.drpicox.game.games.GameJoiner;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

@Component
public class HouseGameJoiner implements GameJoiner {

    private final OwnedsController ownedsController;
    private final TypedsController typedsController;
    private final HouseFactory houseFactory;
    private final LocatedsController locatedsController;
    private final QuantityController quantityController;

    public HouseGameJoiner(QuantityController quantityController, OwnedsController ownedsController, TypedsController typedsController, HouseFactory houseFactory, LocatedsController locatedsController) {
        this.ownedsController = ownedsController;
        this.typedsController = typedsController;
        this.houseFactory = houseFactory;
        this.locatedsController = locatedsController;
        this.quantityController = quantityController;
    }

    @Override
    public void joinGame(Player owner, Game game) {
        houseFactory.buildHouse(game, owner);
    }

}
