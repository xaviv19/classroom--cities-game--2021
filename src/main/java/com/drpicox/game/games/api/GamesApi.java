package com.drpicox.game.games.api;

import com.drpicox.game.common.api.GlobalRestException;
import com.drpicox.game.common.api.SuccessResponse;
import com.drpicox.game.games.GamesController;
import com.drpicox.game.players.PlayersController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/games")
public class GamesApi {
    private final GamesController gamesController;
    private final PlayersController playersController;

    public GamesApi(GamesController gamesController, PlayersController playersController) {
        this.gamesController = gamesController;
        this.playersController = playersController;
    }

    @PostMapping
    public SuccessResponse newGame(@RequestBody NewGameForm form) {
        form.verify();

        var gameName = form.getGameName();
        var token = form.getToken();

        var player = playersController.findPlayerByToken(token).orElseThrow();
        var newGame = gamesController.newGame(gameName, player);
        if (newGame.isEmpty())
            throw new GlobalRestException("The " + gameName + " game already exists");


        return new SuccessResponse("The " + gameName + " game has been created successfully");
    }

    @PostMapping("/byPlayer")
    public GamesListResponse listGamesByPlayer(@RequestBody ListGamesByPlayerForm form) {
        var token = form.getToken();
        var player = playersController.findPlayerByToken(token).orElseThrow();

        var result = new GamesListResponse();
        var games = gamesController.findByPlayer(player);
        games.forEach(game -> result.addGame(game));

        return result;
    }
}
