package com.drpicox.game.components.locateds;

import com.drpicox.game.games.Game;
import com.drpicox.game.games.api.GameResponder;
import com.drpicox.game.games.api.GameResponse;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

@Component
public class LocatedResponder implements GameResponder {

    private final LocatedsController locatedsController;

    public LocatedResponder(LocatedsController locatedsController) {
        this.locatedsController = locatedsController;
    }

    @Override
    public void respond(GameResponse response, Game game, Player playingPlayer) {
        var components = locatedsController.findAllByGame(game);
        components.forEach(c -> {
            var entityId = c.getEntityId();
            response.putEntityProperty(entityId, "isLocated", true);
            response.putEntityProperty(entityId, "location", c.getLocation());
        });
    }
}
