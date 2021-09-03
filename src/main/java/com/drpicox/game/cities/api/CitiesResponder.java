package com.drpicox.game.cities.api;

import com.drpicox.game.cities.CityController;
import com.drpicox.game.games.Game;
import com.drpicox.game.games.api.GameResponder;
import com.drpicox.game.games.api.GameResponse;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

@Component
public class CitiesResponder implements GameResponder {

    private final CityController cityController;

    public CitiesResponder(CityController cityController) {
        this.cityController = cityController;
    }

    @Override
    public void respond(GameResponse response, Game game, Player playingPlayer) {
        var cities = cityController.findAllByGame(game);
        cities.forEach(c -> response.addEntity(new CityResponse(c)));
    }
}
