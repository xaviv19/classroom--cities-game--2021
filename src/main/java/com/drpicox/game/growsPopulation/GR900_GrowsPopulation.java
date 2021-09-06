package com.drpicox.game.growsPopulation;

import com.drpicox.game.games.Game;
import com.drpicox.game.games.GameRounder;
import com.drpicox.game.populateds.PopulatedsController;
import org.springframework.stereotype.Component;

@Component
public class GR900_GrowsPopulation implements GameRounder {

    private final PopulatedsController populatedsController;
    private final GrowsPopulationsController growsPopulationController;

    public GR900_GrowsPopulation(PopulatedsController populatedsController, GrowsPopulationsController growsPopulationController) {
        this.populatedsController = populatedsController;
        this.growsPopulationController = growsPopulationController;
    }

    @Override
    public void endRound(Game game) {
        var cities = growsPopulationController.findAllByGame(game);
        cities.forEach(growsPopulation -> {
            populatedsController.increasePopulation(growsPopulation.getEntityId(), 1);
        });
    }
}
