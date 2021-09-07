package com.drpicox.game.components.growsPopulation;

import com.drpicox.game.games.Game;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GrowsPopulationsController {

    private final GrowsPopulationsRepository growsPopulationsRepository;

    public GrowsPopulationsController(GrowsPopulationsRepository growsPopulationsRepository) {
        this.growsPopulationsRepository = growsPopulationsRepository;
    }

    public GrowsPopulation create(String entityId, Game game) {
        var component = new GrowsPopulation(entityId, game);
        growsPopulationsRepository.save(component);
        return component;
    }

    public List<GrowsPopulation> findAllByGame(Game game) {
        return growsPopulationsRepository.findAllByGame(game);
    }

}
