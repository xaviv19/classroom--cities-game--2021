package com.drpicox.game.components.dockables;

import com.drpicox.game.games.Game;
import com.drpicox.game.games.api.GameResponder;
import com.drpicox.game.games.api.GameResponse;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

@Component
public class DockablesResponder implements GameResponder {

    private final DockablesController dockablesController;

    public DockablesResponder(DockablesController dockablesController) {
        this.dockablesController = dockablesController;
    }

    @Override
    public void respond(GameResponse response, Game game, Player playingPlayer) {
        var components = dockablesController.findAllByGame(game);
        components.forEach(c -> {
            var entityId = c.getEntityId();
            response.putEntityProperty(entityId, "isDockable", true);
            response.putEntityProperty(entityId, "dockId", c.getDockId());
        });
    }
}
