package com.drpicox.game.rest.games.players;

import com.drpicox.game.forms.*;
import com.drpicox.game.games.GameController;
import com.drpicox.game.players.PlayerController;
import com.drpicox.game.round.RoundRulesRunner;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/games/{gameName}/players")
public class PlayersRestController {

    private final GameController gameController;
    private final PlayerController playerController;
    private final PlayGameBuilder playGameBuilder;
    private final VisibleGameBuilder responseBuilder;
    private final RoundRulesRunner roundRulesRunner;

    public PlayersRestController(GameController gameController, PlayerController playerController, PlayGameBuilder playGameBuilder, VisibleGameBuilder responseBuilder, RoundRulesRunner roundRulesRunner) {
        this.gameController = gameController;
        this.playerController = playerController;
        this.playGameBuilder = playGameBuilder;
        this.responseBuilder = responseBuilder;
        this.roundRulesRunner = roundRulesRunner;
    }

    @GetMapping("/{playerName}")
    public VisibleGameForm get(@PathVariable String gameName, @PathVariable String playerName) {
        return responseBuilder.build(gameName, playerName);
    }

    @PutMapping("/{playerName}/ready")
    public VisibleGameForm ready(@PathVariable String gameName, @PathVariable String playerName, @RequestBody Optional<PlayGameForm> playGameForm) {
        var game = gameController.find(gameName).get();

        playGameForm.ifPresent(f -> playGameBuilder.replace(game, playerName, f));
        playerController.ready(game, playerName);
        if (playerController.areAllPlayersReady(game)) {
            roundRulesRunner.run(game);
        }

        return responseBuilder.build(game, playerName);
    }
}
