package com.drpicox.game.components.nameds;

import com.drpicox.game.games.Game;
import com.drpicox.game.games.api.GameResponder;
import com.drpicox.game.games.api.GameResponse;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

@Component
public class NamedsResponder implements GameResponder {

    private final NamedsRepository namedsRepository;

    public NamedsResponder(NamedsRepository namedsRepository) {
        this.namedsRepository = namedsRepository;
    }

    @Override
    public void respond(GameResponse response, Game game, Player playingPlayer) {
        var cities = namedsRepository.findAllByGame(game);
        cities.forEach(c -> {
            var entityId = c.getEntityId();
            response.putEntityProperty(entityId, "isNamed", true);
            response.putEntityProperty(entityId, "name", c.getName());
        });
    }
}
