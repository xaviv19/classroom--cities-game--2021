package com.drpicox.game.games;

import com.drpicox.game.players.Player;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class GamesController {
    private final GameRepository gameRepository;

    public GamesController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Optional<Game> newGame(String gameName, Player player) {
        var id = player.getPlayerName() + "#" + gameName;
        if (gameRepository.findById(id).isPresent()) return Optional.empty();

        var game = new Game(id, gameName, player);
        gameRepository.save(game);

        return Optional.of(game);
    }

    public List<Game> findByPlayer(Player player) {
        return gameRepository.findByPlayer(player);
    }
}
