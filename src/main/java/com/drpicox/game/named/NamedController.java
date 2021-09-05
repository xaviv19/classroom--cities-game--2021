package com.drpicox.game.named;

import com.drpicox.game.games.Game;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NamedController {

    private final NamedRepository namedRepository;

    public NamedController(NamedRepository namedRepository) {
        this.namedRepository = namedRepository;
    }

    public Named createNamed(String entityId, Game game, String initialName) {
        var named = new Named(entityId, game, initialName);
        namedRepository.save(named);
        return named;
    }

    public Named changeName(String entityId, String newName) {
        var named = namedRepository.findById(entityId).get();
        named.changeName(newName);
        namedRepository.save(named);
        return named;
    }

    public List<Named> findAllByGame(Game game) {
        return namedRepository.findAllByGame(game);
    }
}
