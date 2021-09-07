package com.drpicox.game.loadable;

import com.drpicox.game.games.Game;
import com.drpicox.game.games.api.GameResponder;
import com.drpicox.game.games.api.GameResponse;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

@Component
public class LoadableResponder implements GameResponder {

    private final LoadablesController loadablesController;

    public LoadableResponder(LoadablesController loadablesController) {
        this.loadablesController = loadablesController;
    }

    @Override
    public void respond(GameResponse response, Game game, Player playingPlayer) {
        var components = loadablesController.findAllByGame(game);
        components.forEach(c -> response.addComponent(new LoadableResponse(c)));
    }
}
