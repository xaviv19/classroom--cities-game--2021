package com.drpicox.game.ships.api;

import com.drpicox.game.ships.Ship;
import com.drpicox.game.ships.ShipController;
import com.drpicox.game.games.Game;
import com.drpicox.game.games.api.GameResponder;
import com.drpicox.game.games.api.GameResponse;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

@Component
public class ShipsResponder implements GameResponder {

    private final ShipController shipController;

    public ShipsResponder(ShipController shipController) {
        this.shipController = shipController;
    }

    @Override
    public void respond(GameResponse response, Game game, Player playingPlayer) {
        shipController.findAllByGame(game).forEach(ship -> {
            var shipResponse = new ShipResponse(ship);
            response.addEntity(shipResponse);
        });
    }
}
