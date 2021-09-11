package com.drpicox.game.components.populateds;

import com.drpicox.game.games.Game;
import com.drpicox.game.games.api.GameResponder;
import com.drpicox.game.games.api.GameResponse;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

@Component
public class PopulatedResponder implements GameResponder {

    private final PopulatedsRepository populatedsRepository;

    public PopulatedResponder(PopulatedsRepository populatedsRepository) {
        this.populatedsRepository = populatedsRepository;
    }

    @Override
    public void respond(GameResponse response, Game game, Player playingPlayer) {
        var components = populatedsRepository.findAllByGame(game);
        components.forEach(c -> {
            var entityId = c.getEntityId();
            response.putEntityProperty(entityId, "isPopulated", true);
            response.putEntityProperty(entityId, "population", c.getPopulation());
        });
    }
}
