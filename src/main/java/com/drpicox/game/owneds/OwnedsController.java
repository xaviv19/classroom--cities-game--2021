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

    public Owned createOwned(String entityId, Game game, Player owner) {
        var owned = new Owned(entityId, game, owner);
        ownedsRepository.save(owned);
        return owned;
    }

    public List<Owned> findAllByGame(Game game) {
        return ownedsRepository.findAllByGame(game);
    }

    public List<Owned> findAllByGameAndOwner(Game game, Player owner) {
        return ownedsRepository.findAllByGameAndOwner(game, owner);
    }
}
