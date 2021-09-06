package com.drpicox.game.dockables.api;

import com.drpicox.game.games.Game;
import com.drpicox.game.games.api.GameResponder;
import com.drpicox.game.games.api.GameResponse;
import com.drpicox.game.players.Player;
import com.drpicox.game.dockables.DockablesController;
import org.springframework.stereotype.Component;

@Component
public class ZZZDockablesResponder implements GameResponder {

    private final DockablesController dockablesController;

    public ZZZDockablesResponder(DockablesController dockablesController) {
        this.dockablesController = dockablesController;
    }

    @Override
    public void respond(GameResponse response, Game game, Player playingPlayer) {
        var components = dockablesController.findAllByGame(game);
        components.forEach(c -> response.addComponent(new DockableResponse(c)));
    }
}
