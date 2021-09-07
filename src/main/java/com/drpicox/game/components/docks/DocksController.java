package com.drpicox.game.components.docks;

import com.drpicox.game.games.Game;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DocksController {

    private final DocksRepository docksRepository;

    public DocksController(DocksRepository docksRepository) {
        this.docksRepository = docksRepository;
    }

    public Dock create(String entityId, Game game) {
        var named = new Dock(entityId, game);
        docksRepository.save(named);
        return named;
    }

    public List<Dock> findAllByGame(Game game) {
        return docksRepository.findAllByGame(game);
    }
}
