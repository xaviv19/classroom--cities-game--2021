package com.drpicox.game.nameds;

import com.drpicox.game.games.Game;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NamedsController {

    private final NamedsRepository namedsRepository;

    public NamedsController(NamedsRepository namedsRepository) {
        this.namedsRepository = namedsRepository;
    }

    public Named createNamed(String entityId, Game game, String initialName) {
        var named = new Named(entityId, game, initialName);
        namedsRepository.save(named);
        return named;
    }

    public Named changeName(String entityId, String newName) {
        var named = namedsRepository.findById(entityId).get();
        named.changeName(newName);
        namedsRepository.save(named);
        return named;
    }

    public List<Named> findAllByGame(Game game) {
        return namedsRepository.findAllByGame(game);
    }
}
