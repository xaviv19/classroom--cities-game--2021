package com.drpicox.game.typeds.api;

import com.drpicox.game.games.Game;
import com.drpicox.game.games.api.GameResponder;
import com.drpicox.game.games.api.GameResponse;
import com.drpicox.game.players.Player;
import com.drpicox.game.typeds.TypedsController;
import org.springframework.stereotype.Component;

@Component
public class ZZZTypedsResponder implements GameResponder {

    private final TypedsController typedsController;

    public ZZZTypedsResponder(TypedsController typedsController) {
        this.typedsController = typedsController;
    }

    @Override
    public void respond(GameResponse response, Game game, Player playingPlayer) {
        var components = typedsController.findAllByGame(game);
        components.forEach(c -> response.addComponent(new TypedResponse(c)));
    }
}
