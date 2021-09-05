package com.drpicox.game.named.api;

import com.drpicox.game.named.NamedController;
import com.drpicox.game.games.Game;
import com.drpicox.game.games.api.GameResponder;
import com.drpicox.game.games.api.GameResponse;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

@Component
public class ZZZNamedsResponder implements GameResponder {

    private final NamedController namedController;

    public ZZZNamedsResponder(NamedController namedController) {
        this.namedController = namedController;
    }

    @Override
    public void respond(GameResponse response, Game game, Player playingPlayer) {
        var cities = namedController.findAllByGame(game);
        cities.forEach(c -> response.addComponent(new NamedResponse(c)));
    }
}
