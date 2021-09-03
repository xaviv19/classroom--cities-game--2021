package com.drpicox.game.cities.api;

import com.drpicox.game.cities.CityController;
import com.drpicox.game.games.Game;
import com.drpicox.game.games.api.GameResponder;
import com.drpicox.game.games.api.GameResponse;
import com.drpicox.game.games.api.GamesApi;
import com.drpicox.game.players.Player;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cities")
public class CitiesApi {

    private final CityController cityController;
    private final GamesApi gamesApi;

    public CitiesApi(CityController cityController, GamesApi gamesApi) {
        this.cityController = cityController;
        this.gamesApi = gamesApi;
    }

    @PostMapping("/{cityId}/name")
    public GameResponse changeCityName(@PathVariable Long cityId, @RequestParam String token, @RequestBody NewCityNameForm form) {
        cityController.changeCityName(cityId, form.getNewCityName());

        var city = cityController.findById(cityId).get();
        var game = city.getGame();
        return gamesApi.get(game.getGameName(), game.getCreator().getPlayerName(), token);
    }
}
