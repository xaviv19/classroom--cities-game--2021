package com.drpicox.game.old.players;

import com.drpicox.game.old.games.Game;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class PlayerController {

    private final PlayerRepository playerRepository;

    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Optional<OldPlayer> findByGameAndName(Game game, String name) {
        return playerRepository.findByGameAndName(game, name).stream().findFirst();
    }

    public List<OldPlayer> findByGame(Game game) {
        return playerRepository.findByGame(game);
    }

    public OldPlayer create(Game game, String name) {
        var player = new OldPlayer(game, name);
        playerRepository.save(player);
        return player;
    }

    public void ready(Game game, String playerName) {
        findByGameAndName(game, playerName).ifPresent(player -> {
            player.readyRound(game.getRound());
            playerRepository.save(player);
        });
    }

    public boolean areAllPlayersReady(Game game) {
        var round = game.getRound();
        return findByGame(game).stream().allMatch(p -> p.hasReadyRound(round));
    }

    public void receivedCard(OldPlayer owner, int square, String type, String name) {
        if (owner == null) return;
        owner.receivedCard(square, type, name);
        playerRepository.save(owner);
    }
}
