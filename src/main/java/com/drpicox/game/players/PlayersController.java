package com.drpicox.game.players;

import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class PlayersController {
    private PlayerRepository playerRepository;

    public PlayersController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player createPlayer(String playerName) {
        var player = new Player(playerName);
        playerRepository.save(player);
        return player;
    }

    public Optional<Player> findPlayer(String playerName) {
        return playerRepository.findById(playerName);
    }
}
