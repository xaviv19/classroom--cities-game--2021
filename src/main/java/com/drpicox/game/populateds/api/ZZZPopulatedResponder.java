package com.drpicox.game.populateds.api;

import com.drpicox.game.games.Game;
import com.drpicox.game.games.api.GameResponder;
import com.drpicox.game.games.api.GameResponse;
import com.drpicox.game.populateds.PopulatedsController;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

@Component
public class ZZZPopulatedResponder implements GameResponder {

    private final PopulatedsController populatedsController;

    public ZZZPopulatedResponder(PopulatedsController populatedsController) {
        this.populatedsController = populatedsController;
    }

    @Override
    public void respond(GameResponse response, Game game, Player playingPlayer) {
        var components = populatedsController.findAllByGame(game);
        components.forEach(c -> response.addComponent(new PopulatedResponse(c)));
    }
}
