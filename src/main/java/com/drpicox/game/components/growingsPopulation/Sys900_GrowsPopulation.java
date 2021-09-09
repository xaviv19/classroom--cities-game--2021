package com.drpicox.game.components.growingsPopulation;

import com.drpicox.game.ecs.EcsSystem;
import com.drpicox.game.games.Game;
import com.drpicox.game.components.populateds.PopulatedsController;
import org.springframework.stereotype.Component;

@Component
public class Sys900_GrowsPopulation implements EcsSystem {

    private final PopulatedsController populatedsController;
    private final GrowingsPopulationsController growsPopulationController;

    public Sys900_GrowsPopulation(PopulatedsController populatedsController, GrowingsPopulationsController growsPopulationController) {
        this.populatedsController = populatedsController;
        this.growsPopulationController = growsPopulationController;
    }

    @Override
    public void act(Game game) {
        var cities = growsPopulationController.findAllByGame(game);
        cities.forEach(growsPopulation -> {
            populatedsController.increasePopulation(growsPopulation.getEntityId(), 1);
        });
    }
}
