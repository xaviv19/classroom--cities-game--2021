package com.drpicox.game.owneds;

import com.drpicox.game.games.Game;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OwnedsController {

    private final OwnedsRepository ownedsRepository;

    public OwnedsController(OwnedsRepository ownedsRepository) {
        this.ownedsRepository = ownedsRepository;
    }

    public void create(String entityId, Game game, Player owner) {
        var component = new Owned(entityId, game, owner);
        ownedsRepository.save(component);
    }

    public List<Owned> findAllByGame(Game game) {
        return ownedsRepository.findAllByGame(game);
    }

    public List<Owned> findAllByGameAndOwner(Game game, Player owner) {
        return ownedsRepository.findAllByGameAndOwner(game, owner);
    }
}
