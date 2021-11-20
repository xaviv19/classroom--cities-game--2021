package com.drpicox.game.games;

import com.drpicox.game.ecs.EcsSystem;
import com.drpicox.game.players.Player;
import com.drpicox.game.players.PlayersController;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GamesController {
    private final GameRepository gameRepository;
    private final PlayersController playersController;
    private final List<GameJoiner> gameJoiners;
    private final List<EcsSystem> gameSystems;

    public GamesController(GameRepository gameRepository, PlayersController playersController, List<GameJoiner> gameJoiners, List<EcsSystem> gameSystems) {
        this.gameRepository = gameRepository;
        this.playersController = playersController;
        this.gameJoiners = gameJoiners;
        this.gameSystems = gameSystems;
        this.gameSystems.sort((a, b) -> {
            return a.getClass().getSimpleName().compareTo(b.getClass().getSimpleName());
        });
    }

    public Game getGame() {
        return gameRepository.findById("daGame").orElse(new Game("daGame"));
    }

    public Player joinPlayer(String playerName) {
        return playersController.findPlayer(playerName).orElseGet(() -> {
            var player = playersController.createPlayer(playerName);
            gameJoiners.forEach(j -> j.joinGame(player));
            return player;
        });
    }

    public void endRound() {
        var game = getGame();
        game.endRound();
        gameRepository.save(game);

        gameSystems.stream().forEach(gr -> gr.act());
    }

}
