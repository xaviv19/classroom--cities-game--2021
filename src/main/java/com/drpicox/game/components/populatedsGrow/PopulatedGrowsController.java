package com.drpicox.game.components.populatedsGrow;

import org.springframework.stereotype.Component;

@Component
public class PopulatedGrowsController {

    private final PopulatedGrowsRepository populatedGrowsRepository;

    public PopulatedGrowsController(PopulatedGrowsRepository populatedGrowsRepository) {
        this.populatedGrowsRepository = populatedGrowsRepository;
    }

    public PopulatedGrow create(String entityId) {
        var component = new PopulatedGrow(entityId);
        populatedGrowsRepository.save(component);
        return component;
    }

}
