package com.drpicox.game.games;

import com.drpicox.game.players.Player;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class GamesController {
    private final GameRepository gameRepository;
    private final List<GameJoiner> gameJoiners;

    public GamesController(GameRepository gameRepository, List<GameJoiner> gameJoiners) {
        this.gameRepository = gameRepository;
        this.gameJoiners = gameJoiners;
    }

    public Optional<Game> createGame(String gameName, Player player) {
        var id = computeId(gameName, player);
        if (gameRepository.findById(id).isPresent()) return Optional.empty();

        var game = new Game(id, gameName, player);
        joinGame(player, game);

        return Optional.of(game);
    }

    public Optional<Game> join(String gameName, Player creatorPlayer, Player joiningPlayer) {
        return findGame(gameName, creatorPlayer)
                .filter(game -> !game.isPlayerJoined(joiningPlayer))
                .map(game -> {
                    joinGame(joiningPlayer, game);
                    return game;
                });
    }

    private void joinGame(Player player, Game game) {
        game.joinPlayer(player);
        gameRepository.save(game);

        gameJoiners.stream().forEach(gj -> gj.joinGame(player, game));
   }

    public Optional<Game> findGame(String gameName, Player player) {
        return gameRepository.findById(computeId(gameName, player));
    }

    public List<Game> findByCreator(Player player) {
        return gameRepository.findByCreator(player);
    }

    public List<Game> findByJoined(Player player) {
        return gameRepository.findAll().stream()
                .filter(g -> g.isPlayerJoined(player))
                .collect(Collectors.toList());
    }

    private String computeId(String gameName, Player player) {
        return player.getPlayerName() + "#" + gameName;
    }
}
