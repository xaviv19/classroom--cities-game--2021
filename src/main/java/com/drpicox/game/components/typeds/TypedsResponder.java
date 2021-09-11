package com.drpicox.game.components.typeds;

import com.drpicox.game.games.Game;
import com.drpicox.game.games.api.GameResponder;
import com.drpicox.game.games.api.GameResponse;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

@Component
public class TypedsResponder implements GameResponder {

    private final TypedsRepository typedsRepository;

    public TypedsResponder(TypedsRepository typedsRepository) {
        this.typedsRepository = typedsRepository;
    }

    @Override
    public void respond(GameResponse response, Game game, Player playingPlayer) {
        var components = typedsRepository.findAllByGame(game);
        components.forEach(c -> {
            var entityId = c.getEntityId();
            response.putEntityProperty(entityId, "isTyped", true);
            response.putEntityProperty(entityId, "type", c.getEntityType());
        });
    }
}
