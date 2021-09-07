package com.drpicox.game.components.docks;

import com.drpicox.game.games.Game;
import com.drpicox.game.games.api.GameResponder;
import com.drpicox.game.games.api.GameResponse;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

@Component
public class DocksResponder implements GameResponder {

    private final DocksController docksController;

    public DocksResponder(DocksController docksController) {
        this.docksController = docksController;
    }

    @Override
    public void respond(GameResponse response, Game game, Player playingPlayer) {
        var components = docksController.findAllByGame(game);
        components.forEach(c -> response.addComponent(new DockResponse(c)));
    }
}
