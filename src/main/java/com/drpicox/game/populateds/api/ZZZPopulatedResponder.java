package com.drpicox.game.populateds.api;

import com.drpicox.game.games.Game;
import com.drpicox.game.games.api.GameResponder;
import com.drpicox.game.games.api.GameResponse;
import com.drpicox.game.populateds.PopulatedsController;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

@Component
public class ZZZPopulatedResponder implements GameResponder {

    private final PopulatedsController ownedsController;

    public ZZZPopulatedResponder(PopulatedsController ownedsController) {
        this.ownedsController = ownedsController;
    }

    @Override
    public void respond(GameResponse response, Game game, Player playingPlayer) {
        var components = ownedsController.findAllByGame(game);
        components.forEach(c -> response.addComponent(new PopulatedResponse(c)));
    }
}
