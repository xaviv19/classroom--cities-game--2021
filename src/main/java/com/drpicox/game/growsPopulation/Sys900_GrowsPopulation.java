package com.drpicox.game.growsPopulation;

import com.drpicox.game.ecs.EcsSystem;
import com.drpicox.game.games.Game;
import com.drpicox.game.populateds.PopulatedsController;
import org.springframework.stereotype.Component;

@Component
public class Sys900_GrowsPopulation implements EcsSystem {

    private final PopulatedsController populatedsController;
    private final GrowsPopulationsController growsPopulationController;

    public Sys900_GrowsPopulation(PopulatedsController populatedsController, GrowsPopulationsController growsPopulationController) {
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
