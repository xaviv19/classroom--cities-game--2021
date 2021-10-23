package com.drpicox.game.components.informeds;

import com.drpicox.game.games.Game;
import org.springframework.stereotype.Component;

@Component
public class InformedsController {

    private final InformedsRepository populatedsRepository;

    public InformedsController(InformedsRepository informedsRepository) {
        this.populatedsRepository = informedsRepository;
    }

    public void create(String entityId, Game game) {
        var component = new Informed(entityId, game);
        populatedsRepository.save(component);
    }
}
