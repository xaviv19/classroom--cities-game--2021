package com.drpicox.game.components.docks;

import com.drpicox.game.games.Game;
import com.drpicox.game.games.api.GameResponder;
import com.drpicox.game.games.api.GameResponse;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

@Component
public class DocksResponder implements GameResponder {

    private final DocksRepository docksRepository;

    public DocksResponder(DocksRepository docksRepository) {
        this.docksRepository = docksRepository;
    }

    @Override
    public void respond(GameResponse response, Game game, Player playingPlayer) {
        var components = docksRepository.findAllByGame(game);
        components.forEach(c -> {
            var entityId = c.getEntityId();
            response.putEntityProperty(entityId, "isDock", true);
        });
    }
}
