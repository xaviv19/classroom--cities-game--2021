package com.drpicox.game.components.owneds;

import com.drpicox.game.games.Game;
import com.drpicox.game.games.api.GameResponder;
import com.drpicox.game.games.api.GameResponse;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

@Component
public class OwnedsResponder implements GameResponder {

    private final OwnedsController ownedsController;

    public OwnedsResponder(OwnedsController ownedsController) {
        this.ownedsController = ownedsController;
    }

    @Override
    public void respond(GameResponse response, Game game, Player playingPlayer) {
        var components = ownedsController.findAllByGame(game);
        components.forEach(c -> {
            var entityId = c.getEntityId();
            response.putEntityProperty(entityId, "isOwned", true);
            response.putEntityProperty(entityId, "ownerName", c.getOwner().getPlayerName());
        });
    }
}
