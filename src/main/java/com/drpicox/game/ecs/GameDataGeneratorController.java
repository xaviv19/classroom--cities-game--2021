package com.drpicox.game.ecs;

import com.drpicox.game.games.GamesController;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameDataGeneratorController {

    private final GamesController gamesController;
    private final List<GameVisibleDataGenerator> gameVisibleDataGenerators;
    private final List<GameOwnDataGenerator> gameOwnDataGenerators;

    public GameDataGeneratorController(GamesController gamesController, List<GameVisibleDataGenerator> gameVisibleDataGenerators, List<GameOwnDataGenerator> gameOwnDataGenerators) {
        this.gamesController = gamesController;
        this.gameVisibleDataGenerators = gameVisibleDataGenerators;
        this.gameOwnDataGenerators = gameOwnDataGenerators;
    }

    public GameData generate(Player playingPlayer) {
        var roundNumber = gamesController.getGame().getRoundNumber();
        var data = new GameData(roundNumber, playingPlayer.getPlayerName());

        gameVisibleDataGenerators.stream().forEach(r -> r.generateVisibleData(data, playingPlayer));
        gameOwnDataGenerators.stream().forEach(r -> r.generateOwnData(data, playingPlayer));

        return data;
    }
}
