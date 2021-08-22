package com.drpicox.game.games.api;

import com.drpicox.game.common.api.GlobalRestException;
import com.drpicox.game.common.api.SuccessResponse;
import com.drpicox.game.games.GamesController;
import com.drpicox.game.players.PlayersController;
import org.springframework.web.bind.annotation.*;

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
    public SuccessResponse createGame(@RequestBody CreateGameForm form) {
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
    public ListGamesResponse listGamesByCreator(@RequestBody ListGamesByCreatorForm form) {
        form.verify();

        var playerName = form.getPlayerName();
        var player = playersController.findPlayer(playerName).orElseThrow(() -> new GlobalRestException("The friend name should be an existing player"));

        var result = new ListGamesResponse();
        var games = gamesController.findByCreator(player);
        games.forEach(game -> result.addGame(game));

        return result;
    }

    @PostMapping("/byJoined")
    public ListGamesResponse listGamesByJoined(@RequestBody ListGamesByJoinedForm form) {
        var token = form.getToken();
        var player = playersController.findPlayerByToken(token).orElseThrow();

        var result = new ListGamesResponse();
        var games = gamesController.findByJoined(player);
        games.forEach(game -> result.addGame(game));

        return result;
    }

    @PostMapping("/join")
    public SuccessResponse join(@RequestBody JoinGameForm form) {
        var gameName = form.getGameName();
        var creatorName = form.getCreatorName();
        var token = form.getToken();

        var joiningPlayer = playersController.findPlayerByToken(token).orElseThrow();
        var creatorPlayer = playersController.findPlayer(creatorName).orElseThrow();

        var game = gamesController.join(gameName, creatorPlayer, joiningPlayer).orElseThrow(
                () -> new GlobalRestException("You should join games in which are you not joined")
        );

        return new SuccessResponse("You have joined " + game.getGameName() + " game from " + game.getCreator().getPlayerName() + " successfully");
    }

    @GetMapping("/{gameName}/by/{creatorName}")
    public GameResponse get(@PathVariable String gameName, @PathVariable String creatorName, @RequestParam String token) {
        var playingPlayer = playersController.findPlayerByToken(token).orElseThrow();
        var creatorPlayer = playersController.findPlayer(creatorName).orElseThrow();

        var game = gamesController.findGame(gameName, creatorPlayer).orElseThrow();
        if (!game.isPlayerJoined(playingPlayer))
            throw new GlobalRestException("You should play only games in which you are joined");

        return new GameResponse(gameName, creatorName);
    }
}
