package com.drpicox.game.games.api;

import com.drpicox.game.ecs.GameData;
import com.drpicox.game.ecs.GameDataGeneratorController;
import com.drpicox.game.games.GamesController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/games")
public class GamesApi {
    private final GamesController gamesController;
    private final GameDataGeneratorController gameDataGeneratorController;

    public GamesApi(GamesController gamesController, GameDataGeneratorController gameDataGeneratorController) {
        this.gamesController = gamesController;
        this.gameDataGeneratorController = gameDataGeneratorController;
    }

    @GetMapping("/play/{playerName}")
    public GameData play(@PathVariable String playerName) {
        var player = gamesController.joinPlayer(playerName);

        return gameDataGeneratorController.generate(player);
    }

    @PostMapping("/endRound")
    public GameData endRound(@RequestParam String playerName) {
        gamesController.endRound();

        return this.play(playerName);
    }
}
