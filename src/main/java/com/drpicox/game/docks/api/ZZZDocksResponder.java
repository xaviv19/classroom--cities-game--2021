package com.drpicox.game.docks.api;

import com.drpicox.game.games.Game;
import com.drpicox.game.games.api.GameResponder;
import com.drpicox.game.games.api.GameResponse;
import com.drpicox.game.docks.DocksController;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

@Component
public class ZZZDocksResponder implements GameResponder {

    private final DocksController docksController;

    public ZZZDocksResponder(DocksController docksController) {
        this.docksController = docksController;
    }

    @Override
    public void respond(GameResponse response, Game game, Player playingPlayer) {
        var components = docksController.findAllByGame(game);
        components.forEach(c -> response.addComponent(new DockResponse(c)));
    }
}
