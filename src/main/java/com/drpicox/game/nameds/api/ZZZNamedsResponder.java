package com.drpicox.game.nameds.api;

import com.drpicox.game.nameds.NamedsController;
import com.drpicox.game.games.Game;
import com.drpicox.game.games.api.GameResponder;
import com.drpicox.game.games.api.GameResponse;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

@Component
public class ZZZNamedsResponder implements GameResponder {

    private final NamedsController namedsController;

    public ZZZNamedsResponder(NamedsController namedsController) {
        this.namedsController = namedsController;
    }

    @Override
    public void respond(GameResponse response, Game game, Player playingPlayer) {
        var cities = namedsController.findAllByGame(game);
        cities.forEach(c -> response.addComponent(new NamedResponse(c)));
    }
}
