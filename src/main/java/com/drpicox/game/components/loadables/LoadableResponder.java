package com.drpicox.game.components.loadables;

import com.drpicox.game.games.Game;
import com.drpicox.game.games.api.GameResponder;
import com.drpicox.game.games.api.GameResponse;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

@Component
public class LoadableResponder implements GameResponder {

    private final LoadablesRepository loadablesRepository;

    public LoadableResponder(LoadablesRepository loadablesRepository) {
        this.loadablesRepository = loadablesRepository;
    }

    @Override
    public void respond(GameResponse response, Game game, Player playingPlayer) {
        var components = loadablesRepository.findAllByGame(game);
        components.forEach(c -> {
            var entityId = c.getEntityId();
            var loadUnloadAmount = c.getLoadUnloadAmount();
            response.putEntityProperty(entityId, "loadUnloadAmount", Math.abs(loadUnloadAmount));
            response.putEntityProperty(entityId, "loadRequested", loadUnloadAmount > 0);
            response.putEntityProperty(entityId, "unloadRequested", loadUnloadAmount < 0);
        });
    }
}
