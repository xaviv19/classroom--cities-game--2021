package com.drpicox.game.components.populatedsGrow;

import com.drpicox.game.ecs.EcsSystem;
import com.drpicox.game.components.populateds.PopulatedsController;
import org.springframework.stereotype.Component;

@Component
public class Sys900_GrowsPopulation implements EcsSystem {

    private final PopulatedGrowsRepository populatedGrowsRepository;
    private final PopulatedsController populatedsController;

    public Sys900_GrowsPopulation(PopulatedGrowsRepository populatedGrowsRepository, PopulatedsController populatedsController) {
        this.populatedGrowsRepository = populatedGrowsRepository;
        this.populatedsController = populatedsController;
    }

    @Override
    public void act() {
        var cities = populatedGrowsRepository.findAll();
        cities.forEach(growsPopulation -> {
            populatedsController.increasePopulation(growsPopulation.getEntityId(), 1);
        });
    }
}
