package com.drpicox.game.games;

import com.drpicox.game.players.Player;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class GamesController {
    private final GameRepository gameRepository;

    public GamesController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Optional<Game> newGame(String gameName, Player player) {
        var id = computeId(gameName, player);
        if (gameRepository.findById(id).isPresent()) return Optional.empty();

        var game = new Game(id, gameName, player);
        game.joinPlayer(player);
        gameRepository.save(game);

        return Optional.of(game);
    }

    public List<Game> findByCreator(Player player) {
        return gameRepository.findByCreator(player);
    }

    public Optional<Game> join(String gameName, Player creatorPlayer, Player joiningPlayer) {
        return findGame(gameName, creatorPlayer)
                .filter(game -> !game.isPlayerJoined(joiningPlayer))
                .map(game -> {
                    game.joinPlayer(joiningPlayer);
                    gameRepository.save(game);
                    return game;
                });
    }

    private Optional<Game> findGame(String gameName, Player player) {
        return gameRepository.findById(computeId(gameName, player));
    }

    private String computeId(String gameName, Player player) {
        return player.getPlayerName() + "#" + gameName;
    }

    public List<Game> findByJoined(Player player) {
        return gameRepository.findAll().stream()
                .filter(g -> g.isPlayerJoined(player))
                .collect(Collectors.toList());
    }
}
