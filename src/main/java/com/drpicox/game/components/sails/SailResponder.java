package com.drpicox.game.components.sails;

import com.drpicox.game.games.Game;
import com.drpicox.game.games.api.GameResponder;
import com.drpicox.game.games.api.GameResponse;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

@Component
public class SailResponder implements GameResponder {

    private final SailsRepository sailsRepository;

    public SailResponder(SailsRepository sailsRepository) {
        this.sailsRepository = sailsRepository;
    }

    @Override
    public void respond(GameResponse response, Game game, Player playingPlayer) {
        var components = sailsRepository.findAllByGame(game);
        components.forEach(component -> {
            var entityId = component.getEntityId();
            response.putEntityProperty(entityId, "isSail", true);
            response.putEntityProperty(entityId, "destinationSail", component.isDestinationSail());
            response.putEntityProperty(entityId, "destinationLocation", component.getDestinationLocation());
        });
    }
}
