package com.drpicox.game.components.owneds;

import com.drpicox.game.games.Game;
import com.drpicox.game.games.api.GameResponder;
import com.drpicox.game.games.api.GameResponse;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

@Component
public class OwnedsResponder implements GameResponder {

    private final OwnedsRepository ownedsRepository;

    public OwnedsResponder(OwnedsRepository ownedsRepository) {
        this.ownedsRepository = ownedsRepository;
    }

    @Override
    public void respond(GameResponse response, Game game, Player playingPlayer) {
        var components = ownedsRepository.findAllByGame(game);
        components.forEach(c -> {
            var entityId = c.getEntityId();
            response.putEntityProperty(entityId, "isOwned", true);
            response.putEntityProperty(entityId, "owner", c.getOwner().getPlayerName());
        });
    }
}
